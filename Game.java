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
  protected ArrayList<Boolean> goombaTrue = new ArrayList<Boolean>(); // List of all goomba's direction.
  protected ArrayList<Point2D> goombaGravity = new ArrayList<Point2D>(); // List of all goomba's gravity vectors.

  public HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();

  protected boolean goombaLeft = true;
  protected Point2D goombaVelocity = new Point2D(0, 0);

  protected Pane appRoot = new Pane();
  protected Pane environmentRoot = new Pane();
  private Pane menuRoot = new Pane();

  protected int levelWidth = 0;
  protected int levelHeight = 0;
  String line = "";

  /**
  *Method for initializing the game window, and the environment.
  */
  public void initContent(int level, int skin){
    appRoot.setPrefSize(800, 640);
    environmentRoot.setPrefSize(800, 640);
    menuRoot.setPrefSize(800, 640);

    if (level == 1){
      levelWidth = Environment.LEVEL1[0].length() * 32;
      levelHeight = Environment.LEVEL1.length;
    }
    if (level == 2){
      levelWidth = Environment.LEVEL2[0].length() * 32;
      levelHeight = Environment.LEVEL2.length;
    }
    if (level == 3){
      levelWidth = Environment.LEVEL3[0].length() * 32;
      levelHeight = Environment.LEVEL3.length;
    }
    if (level == 4){
      levelWidth = Environment.LEVEL4[0].length() * 32;
      levelHeight = Environment.LEVEL4.length;
    }
    if (level == 5){
      levelWidth = Environment.LEVEL5[0].length() * 32;
      levelHeight = Environment.LEVEL5.length;
    }

    for (int i = 0; i < levelHeight; i++){
      System.out.println("Loading: " + i*5);
      if (level == 1){
        line = Environment.LEVEL1[i];
      }
      if (level == 2){
        line = Environment.LEVEL2[i];
      }
      if (level == 3){
        line = Environment.LEVEL3[i];
      }
      if (level == 4){
        line = Environment.LEVEL4[i];
      }
      if (level == 5){
        line = Environment.LEVEL5[i];
      }
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
          case 'G':
            Node Fground = graphics.createFinalGround(o*32, i*32, 32, 32);
            Node Fplatform = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(Fground);
            platforms.add(Fplatform);
            break;
          case '2':
            Node coin = graphics.createCoin(o*32, i*32, 32, 32);
            environmentRoot.getChildren().add(coin);
            coins.add(coin);
            break;
          case '3':
            Node back = graphics.createBack(0, 0, 3200, 640);
            environmentRoot.getChildren().add(back);
            break;
          case 'B':
            Node Fback = graphics.createFinalBack(0, 0, 3200, 640);
            environmentRoot.getChildren().add(Fback);
            break;
          case '4':
            Node brick = graphics.createBrick(o*32, i*32, 32, 32);
            Node platform2 = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(brick);
            platforms.add(platform2);
            break;
          case 'P':
            Node Fbrick = graphics.createFinalBrick(o*32, i*32, 32, 32);
            Node Fplatform2 = graphics.createEntity(o*32, i*32, 32, 32, Color.BROWN);
            environmentRoot.getChildren().add(Fbrick);
            platforms.add(Fplatform2);
            break;
          case '5':
            Node cloud = graphics.createCloud(o*32, i*32, 64, 32);
            environmentRoot.getChildren().add(cloud);
            break;
          case 'F':
            Node pole = graphics.createFlagPole(o*32, i*32, 32, 256);
            environmentRoot.getChildren().add(pole);
            coins.add(pole);
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
            Node goomba = graphics.createEnemy(o*32, i*32);
            environmentRoot.getChildren().add(goomba);
            goombas.add(goomba);
            goombaTrue.add(goombaLeft);
            goombaGravity.add(goombaVelocity);
            break;
        }
      }
    }

    if (skin == 1){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-1.png");
    }
    if (skin == 2){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-2.png");
    }
    if (skin == 3){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-3.png");
    }
    if (skin == 4){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-4.png");
    }
    if (skin == 5){
      graphics.player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-5.png");
    }
    graphics.player.setTranslateX(30);
    graphics.player.setTranslateY(500);
    graphics.player.setFitWidth(28);
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
