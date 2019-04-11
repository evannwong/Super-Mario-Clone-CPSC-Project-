import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.*;
import javafx.animation.AnimationTimer;
import javafx.application.*;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.awt.*;
import java.awt.event.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class GameTest{
  @org.junit.Rule public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

  @Test
  public void playerDie() throws Exception{
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.die();
    assertEquals("Expected X coordinate to be 30.", 30, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void playerMoveLeft(){
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.movePlayerX(-5);
    assertEquals("Expected X coordinate to be -5.", -5, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void playerMoveRight(){
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.movePlayerX(5);
    assertEquals("Expected X coordinate to be 5.", 5, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void testGravity() throws Exception{
    Main main = new Main(1, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.die();
    temp2.jumpPlayer();
    for (int i = 0; i < 250; i++){
      temp2.applyMomentum();
    }
    assertEquals("Expected Y coordinate to be 547.", 547, main.game.graphics.player.getTranslateY(), 0.00001);
  }

  @Test
  public void testLeftBarrier() throws Exception{
    Main main = new Main(1, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    Alex game = (Alex) main.game;
    game.die();
    for (int i = 0; i < 50; i++){
      game.simulateAPressed();
    }
    assertEquals("Expected X coordinate to be 3.", 3, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void playerJump(){
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.die();
    temp2.jumpPlayer();
    assertEquals("Expected Y coordinate to be 500.", 500, main.game.graphics.player.getTranslateY(), 0.00001);
  }

  @Test
  public void countCoins() throws Exception{
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp.coinCounter = 1;
    temp2.endGame();
    FileReader file = new FileReader("info.txt");
    BufferedReader reader = new BufferedReader(file);
    assertEquals("Expected coin count to be 1.", 1, Integer.parseInt(reader.readLine()), 0.00001);
  }

  @Test
  public void testRightCollision() throws Exception{
    Main main = new Main(0, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    ((Alex) main.game).die();
    for (int i = 0; i < 200; i++){
      ((Alex) main.game).simulateDPressed();
    }
    assertEquals("Expected X coordinate to be 3.", 3, main.game.graphics.player.getTranslateX(), 0.00001);
  }
}
