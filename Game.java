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

public abstract class Game{
  Graphics graphics = new Graphics();

  protected ArrayList<Node> platforms = new ArrayList<Node>(); //List of all platforms in the environment.
  protected ArrayList<Node> coins = new ArrayList<Node>(); //List of all coins in the environment.
  protected ArrayList<Node> goombas = new ArrayList<Node>(); // List of all goombas.
  protected ArrayList<Boolean> goombaLeft = new ArrayList<Boolean>(); // List of all goomba's direction.

  public HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();


  protected Pane appRoot = new Pane();
  private Pane environmentRoot = new Pane();
  private Pane menuRoot = new Pane();

  protected int levelWidth;

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
          case '8':
            break;
        }
      }
    }

    graphics.player.setTranslateX(30);
    graphics.player.setTranslateY(100);
    graphics.player.setFitWidth(32);
    graphics.player.setFitHeight(60);
    environmentRoot.getChildren().add(graphics.player);

    graphics.player.translateXProperty().addListener((obs, old, newValue) -> {
      int offset = newValue.intValue();

      if (offset > 400 && offset < levelWidth - 400){ //Scrolling feature
        environmentRoot.setLayoutX(-(offset - 400));
      }
    });

    appRoot.getChildren().addAll(environmentRoot, menuRoot); // Adding the environment and the menu (not done yet) to the appRoot (window).
  }

  public abstract void update();
}
