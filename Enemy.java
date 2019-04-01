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

public class Enemy extends Alex{

  @Override
  public void update(){
    super.update();
    for (int numG = 0; numG < goombas.size(); numG++){
      if (goombaGravity.get(numG).getY() < 1){
        goombaGravity.set(numG, goombaGravity.get(numG).add(0, 1));
      }
      moveGoombaY();
      goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() + goombaGravity.get(numG).getY());
      if (goombas.get(numG).getBoundsInParent().intersects(graphics.player.getBoundsInParent())){
        if (goombas.get(numG).getTranslateY() - 35 >= graphics.player.getTranslateY()){
          goombas.get(numG).setVisible(false);
          goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() + 100);
        }
      }
      if (goombas.get(numG).getTranslateX() >= 1 && goombaTrue.get(numG) == true){
        for (int i = 0; i < 1; i++){
          for (Node platform : platforms){
            if (goombas.get(numG).getBoundsInParent().intersects(platform.getBoundsInParent())){
              if (goombaTrue.get(numG) == true){
                if (goombas.get(numG).getTranslateX() == platform.getTranslateX() + 28){
                  goombaTrue.set(numG, false);
                  goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() + 1);
                  return;
                }
              }
            }
          }
          for (int numP = 0; numP < goombas.size(); numP++){
            if (goombas.get(numP).getBoundsInParent().intersects(goombas.get(numG).getBoundsInParent())){
              if (goombaTrue.get(numP) == true){
                if (goombas.get(numP).getTranslateX() == goombas.get(numG).getTranslateX() + 28){
                  goombaTrue.set(numP, false);
                  goombas.get(numP).setTranslateX(goombas.get(numP).getTranslateX() + 1);
                  return;
                }
              }
            }
          }
          goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() - 1);
        }
      }
      if (goombas.get(numG).getTranslateX() <= 1){
        goombaTrue.set(numG, false);
      }
      if (goombas.get(numG).getTranslateX() + 28 >= levelWidth - 5){
        goombaTrue.set(numG, true);
      }
      if (goombaTrue.get(numG) == false){
        for (int i = 0; i < 1; i++){
          for (Node platform : platforms){
            if (goombas.get(numG).getBoundsInParent().intersects(platform.getBoundsInParent())){
              if (goombaTrue.get(numG) == false){
                if (goombas.get(numG).getTranslateX() + 28 == platform.getTranslateX()){
                  goombaTrue.set(numG, true);
                  goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() - 1);
                  return;
                }
              }
            }
          }
          for (int numP = 0; numP < goombas.size(); numP++){
            if (goombas.get(numP).getBoundsInParent().intersects(goombas.get(numG).getBoundsInParent())){
              if (goombaTrue.get(numP) == false){
                if (goombas.get(numP).getTranslateX() + 28 == goombas.get(numG).getTranslateX()){
                  goombaTrue.set(numP, true);
                  goombas.get(numP).setTranslateX(goombas.get(numP).getTranslateX() - 1);
                  return;
                }
              }
            }
          }
          goombas.get(numG).setTranslateX(goombas.get(numG).getTranslateX() + 1);
        }
      }
    }
  }

  public void moveGoombaY(){
    for (int numG = 0; numG < goombas.size(); numG++){
      for (Node platform : platforms){
        if (goombas.get(numG).getBoundsInParent().intersects(platform.getBoundsInParent())){
          if (goombas.get(numG).getTranslateY() + 30 == platform.getTranslateY()){
            goombas.get(numG).setTranslateY(goombas.get(numG).getTranslateY() - 2);
            return;
          }
        }
      }
    }
  }
}
