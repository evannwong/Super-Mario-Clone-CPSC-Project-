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

  public HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

  public Pane appRoot = new Pane();
  private Pane environmentRoot = new Pane();
  private Pane menuRoot = new Pane();

  private Point2D playerVelocity = new Point2D(0, 0);
  private boolean canJump = true;

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
            Node platform = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(platform);
            platforms.add(platform);
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
    if (isPressed(KeyCode.W) && graphics.player.getTranslateY() >= 5){
      jumpPlayer();
    }

    if (isPressed(KeyCode.A) && graphics.player.getTranslateX() >= 5){
      movePlayerX(-5);
    }

    if (isPressed(KeyCode.D) && graphics.player.getTranslateX() + 16 <= levelWidth - 5){
      movePlayerX(5);
    }

    if (playerVelocity.getY() < 10){
      playerVelocity = playerVelocity.add(0, 1);
    }

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
      graphics.player.setTranslateX(graphics.player.getTranslateX() + (movingRight ? 1 : -1));
    }
  }

  private void movePlayerY(int value){
    boolean movingDown = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (movingDown){
            if (graphics.player.getTranslateY() + 64 == platform.getTranslateY()){
              graphics.player.setTranslateY(graphics.player.getTranslateY() - 1);
              canJump = true;
              return;
            }
          } else{
            if (graphics.player.getTranslateY() == platform.getTranslateY() + 64){
              return;
            }
          }
        } else{
          canJump = false;
        }
      }
      graphics.player.setTranslateY(graphics.player.getTranslateY() + (movingDown ? 1 : -1));
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
