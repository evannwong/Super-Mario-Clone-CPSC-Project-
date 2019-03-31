import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.stage.WindowEvent;

public class Main extends Application{

  Game enemy = new Enemy();
  protected int level = 0;
  protected int skin = 0;

  public Main(){

  }

  public Main(int aLevel, int aSkin){
    level = aLevel;
    skin = aSkin;
  }

  /** Sets the window for which the game is run. Also keeps track of user input */
  public void start(Stage primaryStage) throws Exception{
    enemy.initContent(level, skin);
    Platform.setImplicitExit(false);

    Scene scene = new Scene(enemy.appRoot);
    scene.setOnKeyPressed(event -> enemy.keys.put(event.getCode(), true));
    scene.setOnKeyReleased(event -> enemy.keys.put(event.getCode(), false));
    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
          public void handle(WindowEvent we) {
              Platform.exit();
          }
      });
    primaryStage.setTitle("Super Alejandro");
    primaryStage.setScene(scene);
    primaryStage.show();

    /** A timer that keeps the game updated */
    AnimationTimer timer = new AnimationTimer(){
      @Override
      public void handle(long now){
        enemy.update();
      }
    };
    timer.start();
  }

  /** Command used to run the game */
  public static void main(String[] args){
    launch(args);
  }
}
