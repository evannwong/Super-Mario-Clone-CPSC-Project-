import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.image.Image;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;

public class Screens extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

// The root that shows the main menu
    Pane rootMenu = new Pane();

    Image mainMenu = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/background%20main%20menu%20blank.png");
    BackgroundImage mainMenuBackground = new BackgroundImage(mainMenu, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background mmBackground = new Background(mainMenuBackground);
    rootMenu.setBackground(mmBackground);

    Image levelsImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/levels.png");
    ImageView levelsImageView = new ImageView();
    levelsImageView.setImage(levelsImage);
    levelsImageView.setFitWidth(90.0);
//    Rectangle levelsRectangle = new Rectangle(100.0, 300.0, 228.0, 90.0);
//    Rectangle shopRectangle = new Rectangle(422.0, 300.0, 228.0, 90.0);
//    levelsRectangle.setOnMouseClicked(new EventHandler<MouseEvent>() {
//      @Override
//      public void handle(MouseEvent me) {
//        threeScreens.setRoot(rootLevels);
//      }
//    });
//    shopRectangle.setOnMouseClicked(new Eventhandler<MouseEvent>() {
//      @Override
//      public void handle(MouseEvent me) {
//        threeScreens.setRoot(rootShop);
//      }
//    });
    Scene threeScreens = new Scene(rootMenu, 750.0, 480.0);
    primaryStage.setTitle("Super Alejandro");
    primaryStage.setScene(threeScreens);
    primaryStage.show();
// The root that shows the level selection
//    Pane rootLevels = new Pane();

//    Image levels = new Image("url");
//    BackgroundImage levelsBackground = new BackgroundImage(levels, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.AUTO);
//    rootLevels.setBackground(levelsBackground);

//    Rectangle levelOne = new Rectangle
//  }
  }
}
