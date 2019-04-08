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
import java.io.*;

public class Alex extends Game{
  protected static Point2D playerVelocity = new Point2D(0, 0); // X and Y momentum
  private boolean canJump = true;

  /**
  *  Checks if any key is pressed, and returns either the key itself if it is true, or false otherwise.
  */
  private boolean isPressed(KeyCode key){
    return keys.getOrDefault(key, false);
  }

  /**
  *  Function that continuously checks for keypresses, and applies velocities such as X momentum and gravity.
  */
  @Override
  public void update(){
    coinCount.setText(coinCounter + "");
    if (graphics.player.getTranslateY() > 650){
      die();
    }
    if (isPressed(KeyCode.W)){
      jumpPlayer();
    }

    if (isPressed(KeyCode.SHIFT) && isPressed(KeyCode.D) && playerVelocity.getX() <= 4 && graphics.player.getTranslateX() + 28 <= levelWidth - 5){
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
      // add something to change character image to look left
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandroTest.png");
      graphics.player.setTranslateX(graphics.player.getTranslateX());
      graphics.player.setTranslateY(graphics.player.getTranslateY());
      graphics.player.setFitWidth(28);
      graphics.player.setFitHeight(60);
      environmentRoot.getChildren().add(graphics.player);
      movePlayerX(-3);
    }

    if (isPressed(KeyCode.D) && graphics.player.getTranslateX() + 28 <= levelWidth - 5){
      // add something to change character image to look right
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandroTest.png");
      graphics.player.setTranslateX(graphics.player.getTranslateX());
      graphics.player.setTranslateY(graphics.player.getTranslateY());
      graphics.player.setFitWidth(28);
      graphics.player.setFitHeight(60);
      environmentRoot.getChildren().add(graphics.player);
      movePlayerX(3);
    }

    if (!isPressed(KeyCode.A) && !isPressed(KeyCode.D)){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-1.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
      graphics.player.setTranslateX(graphics.player.getTranslateX());
      graphics.player.setTranslateY(graphics.player.getTranslateY());
      graphics.player.setFitWidth(28);
      graphics.player.setFitHeight(60);
      environmentRoot.getChildren().add(graphics.player);
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
  *  Checks if canJump is true, and if it is, adds upwards momentum and moves the player by that amount.
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
  *  Moves the player by an int in the X direction, and checks for collisions with pixel-precision.
  *  Checks for collisions with coins.
  */
  private void movePlayerX(int value){
    boolean movingRight = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (movingRight){
            if (graphics.player.getTranslateX() + 28 == platform.getTranslateX()){
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
      for (Node platform2 : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform2.getBoundsInParent())){
          if (movingRight){
            if (graphics.player.getTranslateX() + 28 == platform2.getTranslateX()){
              graphics.player.setTranslateX(graphics.player.getTranslateX() - 1);
              return;
            }
          } else{
            if (graphics.player.getTranslateX() == platform2.getTranslateX() + 28){
              graphics.player.setTranslateX(graphics.player.getTranslateX() + 1);
              return;
            }
          }
        }
      }
      for (Node coin : coins){
        if (graphics.player.getBoundsInParent().intersects(coin.getBoundsInParent())){
          coin.setVisible(false);
          coin.setTranslateY(900);
          coinCounter += 1;
          System.out.println("\nCoins collected: " + coinCounter);
        }
      }
      for (Node pole : poles){
       if (graphics.player.getBoundsInParent().intersects(pole.getBoundsInParent())){
         //edit to make the game close and re-open java Screens
         System.out.println("\nYou completed the level!\nPlease wait 5 seconds for the game to re-load.");
         try{
          File file = new File("info.txt");
          PrintWriter writer = new PrintWriter(file);
          writer.println(coinCounter);
          writer.close();
        } catch(IOException ioe){}
         try {
          //save the amount of coins from the level to txt file
          Runtime.getRuntime().exec("java Screens");
          Thread.sleep(5000); 
          System.exit(0);
        } catch (Exception e) {}
       }
     }
      graphics.player.setTranslateX(graphics.player.getTranslateX() + (movingRight ? 1 : -1));
    }
  }

  /**
  *  Moves the player by an int in the Y direction, and checks for collisions with pixel-precision.
  *  Checks for collision with coin.
  */
  private void movePlayerY(int value){
    boolean movingDown = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (movingDown){
            if (graphics.player.getTranslateY() + 60 == platform.getTranslateY()){
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
      for (Node platform2 : platforms){
        if (graphics.player.getBoundsInParent().intersects(platform2.getBoundsInParent())){
          if (movingDown){
            if (graphics.player.getTranslateY() + 60 == platform2.getTranslateY()){
              graphics.player.setTranslateY(graphics.player.getTranslateY() - 1);
              canJump = true;
              return;
            }
          } else{
            if (graphics.player.getTranslateY() == platform2.getTranslateY() + 30){
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
          coin.setTranslateY(900);
          coinCounter += 1;
          System.out.println("\nCoins collected: " + coinCounter);
        }
      }
      for (Node pole : poles){
        if (graphics.player.getBoundsInParent().intersects(pole.getBoundsInParent())){
          //edit to make the game close and re-open java Screens
          System.out.println("\nYou completed the level!\nPlease wait 5 seconds for the game to re-load.");
          try{
            File file = new File("info.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.println(coinCounter);
            writer.close();
          } catch(IOException ioe){}
          try {
            //save the amount of coins from the level to txt file
            Runtime.getRuntime().exec("java Screens");
            Thread.sleep(5000); 
            System.exit(0);
          } catch (Exception e) {}
        }
      }
      for (int numG = 0; numG < goombas.size(); numG++){
        if (goombas.get(numG).getBoundsInParent().intersects(graphics.player.getBoundsInParent())){
          if (goombas.get(numG).getTranslateY() - 35 >= graphics.player.getTranslateY()){
            if (playerVelocity.getY() < -7){
              playerVelocity = playerVelocity.add(0, 4);
            } else{
              playerVelocity = new Point2D(0, 0);
              playerVelocity = playerVelocity.add(0, -4);
            }
          }
          if (graphics.player.getTranslateX() == goombas.get(numG).getTranslateX() + 28){
            die();
            System.out.println("\nOOF, looks like you're not good enough...");
          } else if (graphics.player.getTranslateX() + 28 == goombas.get(numG).getTranslateX()){
            die();
            System.out.println("\nOOF, looks like you're not good enough...");
          }
        }
      }
      graphics.player.setTranslateY(graphics.player.getTranslateY() + (movingDown ? 1 : -1));
    }
  }

  public void die(){
    graphics.player.setTranslateX(30);
    graphics.player.setTranslateY(500);
    environmentRoot.setLayoutX(0);
  }
}
