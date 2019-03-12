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
import javafx.scene.image.ImageView;

public class Game{
  Graphics graphics = new Graphics();

  private ArrayList<Node> platforms = new ArrayList<Node>(); //List of all platforms in the environment.
  private ArrayList<Node> coins = new ArrayList<Node>(); //List of all coins in the environment.


  public HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

  public Pane appRoot = new Pane();
  private Pane environmentRoot = new Pane();
  private Pane menuRoot = new Pane();

  private Point2D playerVelocity = new Point2D(0, 0); // X and Y momentum
  private boolean canJump = true;

  private int levelWidth;

  /**
  *Method for initializing the game window, and the environment.
  */
  public void initContent(){
    appRoot.setPrefSize(800, 320);
    environmentRoot.setPrefSize(800, 320);
    menuRoot.setPrefSize(800, 320);
    

    levelWidth = Environment.LEVEL1[0].length() * 32; // Checks the array in Environment.java and for each number, adds a different graphic.

    for (int i = 0; i < Environment.LEVEL1.length; i++){
      String line = Environment.LEVEL1[i];
      for (int o = 0; o < line.length(); o++){
        switch(line.charAt(o)){
          case '0':
            break;
          case '1':
            Node ground = graphics.createGround(o*32, i*32, 32, 32);
            Node platform = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(ground);
            platforms.add(platform);
            break;
          case '2':
            Node coin = graphics.createCoin(o*32, i*32, 32, 32);
            environmentRoot.getChildren().add(coin);
            coins.add(coin);
            break;
          case '3':
            Node back = graphics.createBack(0, 0, 3200, 320);
            environmentRoot.getChildren().add(back);
            break;
          case '4':
            Node brick = graphics.createBrick(o*32, i*32, 32, 32);
            Node platform2 = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(brick);
            platforms.add(platform2);
            break;
          case '5':
            Node cloud = graphics.createCloud(o*32, i*32, 64, 32);
            environmentRoot.getChildren().add(cloud);
            platforms.add(cloud);
            break;
          case '6':
            Node pipeMain = graphics.createPipeMain(o*32, i*32, 32, 32);
            Node platform3 = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(pipeMain);
            platforms.add(platform3);
            break;
          case '7':
            Node pipeTop = graphics.createPipeTop(o*32, i*32, 32, 32);
            Node platform4 = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(pipeTop);
            platforms.add(platform4);
            break;
        }
      }
    }

    graphics.player.setTranslateX(30);
    graphics.player.setTranslateY(100);
    graphics.player.setFitWidth(32);
    graphics.player.setFitHeight(30);
    environmentRoot.getChildren().add(graphics.player);

    graphics.player.translateXProperty().addListener((obs, old, newValue) -> {
      int offset = newValue.intValue();

      if (offset > 400 && offset < levelWidth - 400){
        environmentRoot.setLayoutX(-(offset - 400));
      }
    });

    appRoot.getChildren().addAll(environmentRoot, menuRoot); // Adding the environment and the menu (not done yet) to the appRoot (window).
  }

  /**
  *Function that continuously checks for keypresses, and applies velocities such as X momentum and gravity.
  */
  public void update(){
    if (isPressed(KeyCode.W)){
      jumpPlayer();
    }

    if (isPressed(KeyCode.SHIFT) && isPressed(KeyCode.D) && playerVelocity.getX() <= 4 && graphics.player.getTranslateX() + 32 <= levelWidth - 5){
      playerVelocity = playerVelocity.add(0.65, 0);
    }

    if (isPressed(KeyCode.SHIFT) && isPressed(KeyCode.A) && playerVelocity.getX() >= -4 && graphics.player.getTranslateX() >= 5){
      playerVelocity = playerVelocity.add(-0.65, 0);
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
    movePlayerY((int) playerVelocity.getY());

    if (playerVelocity.getX() < 0){
      playerVelocity = playerVelocity.add(0.25, 0);
    }

    if (playerVelocity.getX() > 0){
      playerVelocity = playerVelocity.add(-0.25, 0);
    }
    movePlayerX((int) playerVelocity.getX());
  }
  
  /**
  *Moves the player by an int in the X axis, and checks for collisions with pixel-precision.
  *Checks for collisions with coins.
  */
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

  /**
  *Moves the player by an int in the Y axis, and checks for collisions with pixel-precision.
  *Checks for collision with coin.
  */
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

  /**
  *Checks if canJump is true, and if it is, adds upwards momentum and moves the player by that amount.
  */
  private void jumpPlayer(){
    if (canJump){
      if (playerVelocity.getY() == 10){
      playerVelocity = playerVelocity.add(0, -31);
      }
      canJump = false;
    }
  }

  /**
  *Checks if any key is pressed, and returns either the key itself if it is true, or false otherwise.
  */
  private boolean isPressed(KeyCode key){
    return keys.getOrDefault(key, false);
  }
}
