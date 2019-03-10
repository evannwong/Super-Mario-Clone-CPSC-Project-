import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Game{
  Graphics graphics = new Graphics();

  private ArrayList<Node> platforms = new ArrayList<Node>();
  private ArrayList<Node> coins = new ArrayList<Node>();
  private ArrayList<Node> goombas = new ArrayList<Node>();
  private ArrayList<Boolean> goombaTrue = new ArrayList<Boolean>();


  public HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

  public Pane appRoot = new Pane();
  private Pane environmentRoot = new Pane();
  private Pane menuRoot = new Pane();

  private Point2D playerVelocity = new Point2D(0, 0);
  private Point2D goombaVelocity = new Point2D(0, 0);
  private boolean canJump = true;
  private boolean goombaLeft = true;

  private int levelWidth;

  public void initContent(){
    Rectangle background = new Rectangle(800, 640);

    levelWidth = Environment.LEVEL1[0].length() * 32;

    for (int i = 0; i < Environment.LEVEL1.length; i++){
      String line = Environment.LEVEL1[i];
      for (int o = 0; o < line.length(); o++){
        switch(line.charAt(o)){
          case '0':
            break;
          case '1':
            Node platform = graphics.createEntity(o*32, i*32, 32, 32, Color.GREEN);
            environmentRoot.getChildren().add(platform);
            platforms.add(platform);
            break;
          case '2':
            Node coin = graphics.createEntity(o*32, i*32, 32, 32, Color.YELLOW);
            environmentRoot.getChildren().add(coin);
            coins.add(coin);
            break;
          case '3':
            Node goomba = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(goomba);
            goombas.add(goomba);
            goombaTrue.add(goombaLeft);
            break;
        }
      }
    }

    environmentRoot.getChildren().add(graphics.player);

    graphics.player.translateXProperty().addListener((obs, old, newValue) -> {
      int offset = newValue.intValue();

      if (offset > 400 && offset < levelWidth - 400){
        environmentRoot.setLayoutX(-(offset - 400));
      }
    });

    appRoot.getChildren().addAll(background, environmentRoot, menuRoot);
  }

  public void update(){
    for (int g = 0; g < goombaTrue.size(); g++){
      for (int numG = 0; numG < goombas.size(); numG++){
        if (goombas.get(numG).getTranslateX() >= 1 && goombaTrue.get(g) == true){
          moveGoombaX(-1);
        }
        if (goombas.get(numG).getTranslateX() <= 1){
          goombaTrue.set(g, false);
        }
        if (goombas.get(numG).getTranslateX() + 32 >= levelWidth - 5 && goombaTrue.get(g) == false){
          goombaTrue.set(g, true);
        }
        if (goombaTrue.get(g) == false){
          moveGoombaX(1);
        }
      }
    }

    if (isPressed(KeyCode.W)){
      jumpPlayer();
    }

    if (!isPressed(KeyCode.W)){
      if (playerVelocity.getY() < -7){
        playerVelocity = playerVelocity.add(0, 4);
      }
    }

    if (isPressed(KeyCode.A) && graphics.player.getTranslateX() >= 5){
      movePlayerX(-3);
    }

    if (isPressed(KeyCode.D) && graphics.player.getTranslateX() + 32 <= levelWidth - 5){
      movePlayerX(3);
    }

    if (playerVelocity.getY() < 10){
      playerVelocity = playerVelocity.add(0, 1);
    }

    if (goombaVelocity.getY() < 10){
      goombaVelocity = goombaVelocity.add(0, 1);
    }
    moveGoombaY((int) goombaVelocity.getY());
    movePlayerY((int) playerVelocity.getY());
  }

  private void movePlayerX(int value){
    boolean movingRight = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (movingRight){
            if (graphics.player.getTranslateX() + 32 == platform.getTranslateX()){
              graphics.player.setTranslateX(graphics.player.getTranslateX() - 1);
              return;
            }
          } else{
            if (graphics.player.getTranslateX() == platform.getTranslateX() + 32){
              graphics.player.setTranslateX(graphics.player.getTranslateX() + 1);
              return;
            }
          }
        }
      }
      for (Node coin : coins){
        if (graphics.player.getBoundsInParent().intersects(coin.getBoundsInParent())){
          coin.setVisible(false);
        }
      }
      graphics.player.setTranslateX(graphics.player.getTranslateX() + (movingRight ? 1 : -1));
    }
  }

  private void movePlayerY(int value){
    boolean movingDown = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (movingDown){
            if (graphics.player.getTranslateY() + 30 == platform.getTranslateY()){
              graphics.player.setTranslateY(graphics.player.getTranslateY() - 1);
              canJump = true;
              return;
            }
          } else{
            if (graphics.player.getTranslateY() == platform.getTranslateY() + 30){
              graphics.player.setTranslateY(graphics.player.getTranslateY() + 1);
              playerVelocity = playerVelocity.add(0, 4);
              return;
            }
          }
        } else{
          canJump = false;
        }
      }
      for (Node coin : coins){
        if (graphics.player.getBoundsInParent().intersects(coin.getBoundsInParent())){
          coin.setVisible(false);
        }
      }
      graphics.player.setTranslateY(graphics.player.getTranslateY() + (movingDown ? 1 : -1));
    }
  }

  private void moveGoombaY(int value){
    boolean movingDown = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (int numG = 0; numG < goombas.size(); numG++){
        if (goombas.get(numG).getBoundsInParent().intersects(graphics.player.getBoundsInParent())){
          if (goombas.get(numG).getTranslateY() - 20 >= graphics.player.getTranslateY()){
            playerVelocity = playerVelocity.add(0, -32);
            goombas.get(numG).setVisible(false);
            goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() + 100);
          }
        }
        for (Node platform : platforms){
          if (goombas.get(numG).getBoundsInParent().intersects(platform.getBoundsInParent())){
            if (movingDown){
              if (goombas.get(numG).getTranslateY() + 32 == platform.getTranslateY()){
                goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() - 1);
                return;
              }
            } else{
              if (goombas.get(numG).getTranslateY() == platform.getTranslateY() + 32){
                goombaVelocity = goombaVelocity.add(0, 4);
                return;
              }
            }
          }
        }
        goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() + (movingDown ? 1 : -1));
      }
    }
  }

  private void moveGoombaX(int value){
    for (int i = 0; i < Math.abs(value); i++){
      for (int g = 0; g < goombaTrue.size(); g++){
        for (int numG = 0; numG < goombas.size(); numG++){
          for (Node platform : platforms){
            if (goombas.get(numG).getBoundsInParent().intersects(platform.getBoundsInParent())){
              if (value > 0){
                if (goombas.get(numG).getTranslateX() + 32 == platform.getTranslateX()){
                  goombaTrue.set(g, true);
                  goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() - 1);
                  return;
                }
              } else{
                if (goombas.get(numG).getTranslateX() == platform.getTranslateX() + 32){
                  goombaTrue.set(g, false);
                  goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() + 1);
                  return;
                }
              }
            }
          }
          goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() + (goombaTrue.get(g) ? -1 : 1));
          System.out.println(goombaTrue);
        }
      }
    }
  }

  private void jumpPlayer(){
    if (canJump){
      if (playerVelocity.getY() == 10){
      playerVelocity = playerVelocity.add(0, -31);
      }
      canJump = false;
    }
  }

  private boolean isPressed(KeyCode key){
    return keys.getOrDefault(key, false);
  }
}
