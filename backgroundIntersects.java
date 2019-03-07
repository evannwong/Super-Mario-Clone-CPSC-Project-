import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileInputStream;
import javafx.scene.Group;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class backgroundIntersects extends Application  {

  boolean running, up, down, right, left;

  private Image mario;
  private Node hero;

  private static final double W = 800, H = 600;

  @Override
  public void start(Stage primaryStage) throws Exception {

    primaryStage.setTitle("Background Testing");
    FileInputStream brick = new FileInputStream("C:\\Users\\wonge\\Downloads\\DOWNLOADS\\bricks.png");
    Image image = new Image(brick);
    ImageView imageView = new ImageView(image);
    FileInputStream character = new FileInputStream("C:\\Users\\wonge\\Downloads\\DOWNLOADS\\mario.png");
    Image mario = new Image(character);
    hero = new ImageView(mario);

    //Setting the position of the image
    imageView.setX(50);
    imageView.setY(568);

    moveCharacterTo(50, 536);

    //setting the fit height and width of the image view
    imageView.setFitHeight(32);
    imageView.setFitWidth(32);

    //Setting the preserve ratio of the image view
    imageView.setPreserveRatio(true);

    //Creating a Group object
    Group root = new Group(imageView, hero);

    //Creating a scene object
    Scene scene = new Scene(root, W, H);

    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        switch (event.getCode()) {
          case UP:    up = true; break;
          case DOWN:  down = true; break;
          case LEFT:  left  = true; break;
          case RIGHT: right  = true; break;
          case SHIFT: running = true; break;
        }
      }
    });

    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
      @Override
      public void handle(KeyEvent event) {
        switch (event.getCode()) {
          case UP:    up = false; break;
          case DOWN:  down = false; break;
          case LEFT:  left  = false; break;
          case RIGHT: right  = false; break;
          case SHIFT: running = false; break;
        }
      }
    });

    //Setting title to the Stage
    primaryStage.setTitle("Base");

    //Adding scene to the stage
    primaryStage.setScene(scene);

    //Displaying the contents of the stage
    primaryStage.show();

    AnimationTimer timer = new AnimationTimer() {
      @Override
      public void handle(long now) {
        int dx = 0;
        int dy = 0;

        if (up) dy -= 1;
        if (down) dy += 1;
        if (right)  dx += 1;
        if (left)  dx -= 1;
        if (running) { dx *= 3; dy *= 3; }
        moveCharacterBy(dx, dy);
      }
    };
    timer.start();
  }

  private void moveCharacterBy(int dx, int dy) {
    if (dx == 0 && dy == 0) return;

    final double cx = hero.getBoundsInLocal().getWidth()  / 2;
    final double cy = hero.getBoundsInLocal().getHeight() / 2;

    double x = cx + hero.getLayoutX() + dx;
    double y = cy + hero.getLayoutY() + dy;

    moveCharacterTo(x, y);
  }

  private void moveCharacterTo(double x, double y) {
    final double cx = hero.getBoundsInLocal().getWidth()  / 2;
    final double cy = hero.getBoundsInLocal().getHeight() / 2;

    if (x - cx >= 0 && x + cx <= W && y - cy >= 0 && y + cy <= H) {
      hero.relocate(x - cx, y - cy);
    }
  }

  public static void main(String[] args) {
    Application.launch(args);
  }
}
