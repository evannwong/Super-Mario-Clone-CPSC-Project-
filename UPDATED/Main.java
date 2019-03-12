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

public class Main extends Application{

  Game game = new Game();
  
  /** Sets the window for which the game is run. Also keeps track of user input */
  public void start(Stage primaryStage) throws Exception{
    game.initContent();

    Scene scene = new Scene(game.appRoot);
    scene.setOnKeyPressed(event -> game.keys.put(event.getCode(), true));
    scene.setOnKeyReleased(event -> game.keys.put(event.getCode(), false));
    primaryStage.setTitle("Mario");
    primaryStage.setScene(scene);
    primaryStage.show();
    
    /** A timer that keeps the game updated */
    AnimationTimer timer = new AnimationTimer(){
      @Override
      public void handle(long now){
        game.update();
      }
    };
    timer.start();
  }

  /** Command used to run the game */
  public static void main(String[] args){
    launch(args);
  }
}
