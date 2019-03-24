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

public class Enemy extends Game{
  private Point2D enemyVelocity = new Point2D(0, 0);
  protected Node entity;
  private boolean directionR = true;
  private ImageView pic = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/brick.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");

  public Enemy(int x, int y){
    this.pic.setX(x);
    this.pic.setY(y);
    this.pic.setFitHeight(30);
    this.pic.setFitWidth(32);
    this.entity = this.pic;
    this.directionR = true;
  }

  public void moveEnemyX(int value){
    boolean movingRight = value > 0;
    for (int i = 0; i < Math.abs(value); i++){
      for (Node platform : platforms){
        if (movingRight){
          if (this.entity.getBoundsInParent().intersects(platform.getBoundsInParent())){
            if (this.entity.getTranslateX() + 32 == platform.getTranslateX()){
              this.entity.setTranslateX(this.entity.getTranslateX() - 1);
              this.directionR = false;
              System.out.println("here");
            }
          }
        }
        if (!movingRight){
          if (this.entity.getBoundsInParent().intersects(platform.getBoundsInParent())){
            if (this.entity.getTranslateX() == platform.getTranslateX() + 32){
              this.entity.setTranslateX(this.entity.getTranslateX() + 1);
              this.directionR = true;
              System.out.println(1);
            }
          }
        }
      }
      this.entity.setTranslateX(this.entity.getTranslateX() + (movingRight ? 1 : -1));
    }
  }

  public void update(){
    if (this.directionR){
      this.moveEnemyX(1);
    }
    if (!this.directionR){
      this.moveEnemyX(-1);
    }
  }
}
