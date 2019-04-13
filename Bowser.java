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
import javafx.scene.image.Image;
import java.io.*;
import javafx.scene.media.*;
import java.nio.file.*;

public class Bowser extends Enemy{
  protected boolean moveLeft = true;
  public void update(){
    super.update();
    if (bowserHitCounter >= 28){
      for (ImageView bowser : bowsers){
        bowser.setTranslateY(999);
      }
    }
    moveBowserX();
  }

  public void moveBowserX(){
    for (ImageView bowser : bowsers){
      for (Node Fplatform : platforms){
        if (bowser.getBoundsInParent().intersects(Fplatform.getBoundsInParent())){
          if (bowser.getTranslateX() + 252 == Fplatform.getTranslateX()){
            moveLeft = true;
          } else if (bowser.getTranslateX() == Fplatform.getTranslateX() + 32){
            moveLeft = false;
          }
        }
      }
      if (bowser.getTranslateX() >= levelWidth - 252){
        moveLeft = true;
      } else if (bowser.getTranslateX() <= 5){
        moveLeft = false;
      }
      if (moveLeft){
        bowser.setTranslateX(bowser.getTranslateX() - 1);
      } else if (!moveLeft){
        bowser.setTranslateX(bowser.getTranslateX() + 1);
      }
    }
  }
}
