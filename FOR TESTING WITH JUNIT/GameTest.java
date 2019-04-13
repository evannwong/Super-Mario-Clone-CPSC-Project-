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
  public void playerDieXCoordinate() throws Exception{
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.die();
    assertEquals("Expected X coordinate to be 30.", 30, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void playerDieYCoordinate() throws Exception{
    Main main = new Main(1, 1);
    Game temp = main.game;
    Alex temp2 = (Alex) temp;
    temp2.die();
    assertEquals("Expected X coordinate to be 500.", 500, main.game.graphics.player.getTranslateY(), 0.00001);
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
    Main main = new Main(0, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    Alex game = (Alex) main.game;
    game.die();
    for (int i = 0; i < 50; i++){
      game.simulateAPressed();
    }
    assertEquals("Expected X coordinate to be 3 (beginning of the level).", 3, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void testRightBarrier() throws Exception{
    Main main = new Main(0, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    Alex game = (Alex) main.game;
    game.die();
    for (int i = 0; i < 10000; i++){
      game.simulateDPressed();
    }
    assertEquals("Expected X coordinate to be 768 (end of the level).", 768, main.game.graphics.player.getTranslateX(), 0.00001);
  }

  @Test
  public void testCorrectSkin() throws Exception{
    Main main = new Main(0, 4);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    assertEquals("Expected skin to be the default skin, with the corresponding integer 4", 4, ((Alex) main.game).skinValue, 0.00001);
  }

  @Test
  public void testCorrectLevel() throws Exception{
    Main main = new Main(4, 1);
    Stage primaryStage = new Stage();
    main.start(primaryStage);
    assertEquals("Level selected should be level 4", 4, main.game.levelSelected, 0.00001);
  }
}
