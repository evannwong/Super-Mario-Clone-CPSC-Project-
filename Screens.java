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
import javafx.scene.image.ImageView;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;


public class Screens extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

// The root that shows the main menu
    Pane rootMenu = new Pane();
    Pane rootLevels = new Pane();
    Pane rootShop = new Pane();
    Scene menuScreen = new Scene(rootMenu, 750.0, 480.0);

//Backgrounds
    Image mainMenu = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/background%20main%20menu%20blank.png");
    BackgroundImage mainMenuBackground = new BackgroundImage(mainMenu, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background mmBackground = new Background(mainMenuBackground);
    rootMenu.setBackground(mmBackground);

    Image levels = new Image("");
    BackgroundImage levelsBackground = new BackgroundImage(levels, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background lBackground = new Background(levelsBackground);
    rootLevels.setBackground(lBackground);

    Image shop = new Image("");
    BackgroundImage shopBackground = new BackgroundImage(shop, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background sBackground = new Background(shopBackground);
    rootShop.setBackground(sBackground);





//Main Menu screen
    Image levelsImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/levels.png");
    ImageView levelsButton = new ImageView();
    levelsButton.setImage(levelsImage);
    levelsButton.setFitWidth(90.0);
    rootMenu.getChildren().add(levelsButton);

    levelsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menuScreen.setRoot(rootLevels);
        primaryStage.show();
      }
    });

    Image shopImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/background%20main%20menu%20blank.png");
    ImageView shopButton = new ImageView();
    shopButton.setImage(shopImage);
    shopButton.setFitWidth(90.0);
    rootMenu.getChildren().add(shopButton);




//Levels screen
    Image imageLvl1 = new Image("");
    Image imageLvl2 = new Image("");
    Image imageLvl3 = new Image("");
    Image imageLvl4 = new Image("");
    Image imageLvl5 = new Image("");

    ImageView lvl1 = new ImageView();
    lvl1.setImage(imageLvl1);
    ImageView lvl2 = new ImageView();
    lvl2.setImage(imageLvl2);
    ImageView lvl3 = new ImageView();
    lvl3.setImage(imageLvl3);
    ImageView lvl4 = new ImageView();
    lvl4.setImage(imageLvl4);
    ImageView lvl5 = new ImageView();
    lvl5.setImage(imageLvl5);
    //Handle setOnMouseClicked

    Image backButton = new Image("");
    ImageView bButton = new ImageView();
    bButton.setImage(backButton);




//Shop screen


    primaryStage.setTitle("Super Alejandro");
    primaryStage.setScene(menuScreen);
    primaryStage.show();
  }
}
