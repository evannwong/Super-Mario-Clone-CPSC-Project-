import javafx.application.*;
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
  @Override
  public void start(Stage menu) throws Exception {
    Platform.setImplicitExit(false);

// The root that shows the main menu
    Pane rootMenu = new Pane();
    Pane rootLevels = new Pane();
    Pane rootShop = new Pane();
    Pane rootLoad = new Pane();
    Scene menuScreen = new Scene(rootMenu, 750.0, 480.0);
    Scene levelsScreen = new Scene(rootLevels, 750.0, 480.0);
    Scene shopScreen = new Scene(rootShop, 750.0, 480.0);
    Scene loadingScreen = new Scene(rootLoad, 750.0, 480.0);

//Backgrounds
    Image mainMenu = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/background%20main%20menu%20blank.png");
    BackgroundImage mainMenuBackground = new BackgroundImage(mainMenu, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background mmBackground = new Background(mainMenuBackground);
    rootMenu.setBackground(mmBackground);

    Image levels = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/sample%20level%20select%20blank.png");
    BackgroundImage levelsBackground = new BackgroundImage(levels, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background lBackground = new Background(levelsBackground);
    rootLevels.setBackground(lBackground);

    Image shop = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/sample%20skins%20selection%20blank.png");
    BackgroundImage shopBackground = new BackgroundImage(shop, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background sBackground = new Background(shopBackground);
    rootShop.setBackground(sBackground);

    Image load = new Image("https://static.giantbomb.com/uploads/scale_small/0/1978/427550-now_loading_2.jpg");
    BackgroundImage loadBackground = new BackgroundImage(load, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background loBackground = new Background(loadBackground);
    rootLoad.setBackground(loBackground);


//Main Menu screen
    Image levelsImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/levels.png");
    ImageView levelsButton = new ImageView();
    levelsButton.setImage(levelsImage);
    levelsButton.setFitWidth(152.0);
    levelsButton.setFitHeight(60.0);
    levelsButton.setX(173);
    levelsButton.setY(307);
    rootMenu.getChildren().add(levelsButton);

    levelsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(levelsScreen);
        menu.show();
      }
    });

    Image shopImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/skins.png");
    ImageView shopButton = new ImageView();
    shopButton.setImage(shopImage);
    shopButton.setFitWidth(152.0);
    shopButton.setFitHeight(60.0);
    shopButton.setX(425);
    shopButton.setY(307);
    rootMenu.getChildren().add(shopButton);

    shopButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(shopScreen);
        menu.show();
      }
    });




//Levels screen
    Image imageLvl1 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/button-1.png");
    Image imageLvl2 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/button-2.png");
    Image imageLvl3 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/button-3.png");
    Image imageLvl4 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/button-4.png");
    Image imageLvl5 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/button-5.png");

    ImageView lvl1 = new ImageView();
    lvl1.setImage(imageLvl1);

    lvl1.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(loadingScreen);
        menu.show();
        try{
          Stage primaryStage = new Stage();
          Main main = new Main();
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });

    ImageView lvl2 = new ImageView();
    lvl2.setImage(imageLvl2);
    ImageView lvl3 = new ImageView();
    lvl3.setImage(imageLvl3);
    ImageView lvl4 = new ImageView();
    lvl4.setImage(imageLvl4);
    ImageView lvl5 = new ImageView();
    lvl5.setImage(imageLvl5);

    lvl1.setFitWidth(90.0);
    lvl1.setFitHeight(90.0);
    lvl2.setFitWidth(90.0);
    lvl2.setFitHeight(90.0);
    lvl3.setFitWidth(90.0);
    lvl3.setFitHeight(90.0);
    lvl4.setFitWidth(90.0);
    lvl4.setFitHeight(90.0);
    lvl5.setFitWidth(90.0);
    lvl5.setFitHeight(90.0);

    lvl1.setX(120);
    lvl2.setX(225);
    lvl3.setX(330);
    lvl4.setX(435);
    lvl5.setX(540);
    lvl1.setY(300);
    lvl2.setY(300);
    lvl3.setY(300);
    lvl4.setY(300);
    lvl5.setY(300);

    rootLevels.getChildren().add(lvl1);
    rootLevels.getChildren().add(lvl2);
    rootLevels.getChildren().add(lvl3);
    rootLevels.getChildren().add(lvl4);
    rootLevels.getChildren().add(lvl5);

    Image backButton = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/backButton.png");
    ImageView bButton = new ImageView();
    bButton.setImage(backButton);
    bButton.setFitWidth(87.0);
    bButton.setFitHeight(45.0);
    bButton.setY(435);
    bButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(menuScreen);
        menu.show();
      }
    });

    rootLevels.getChildren().add(bButton);





//Shop screen
    Image backButton2 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/backButton.png");
    ImageView bButton2 = new ImageView();
    bButton2.setImage(backButton2);
    bButton2.setFitWidth(87.0);
    bButton2.setFitHeight(45.0);
    bButton2.setY(435);
    bButton2.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(menuScreen);
        menu.show();
      }
    });

    Image imageSkin1 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-1.png");
    ImageView skin1 = new ImageView();
    skin1.setImage(imageSkin1);
    Image imageSkin2 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-2.png");
    ImageView skin2 = new ImageView();
    skin2.setImage(imageSkin2);
    Image imageSkin3 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-3.png");
    ImageView skin3 = new ImageView();
    skin3.setImage(imageSkin3);
    Image imageSkin4 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-4.png");
    ImageView skin4 = new ImageView();
    skin4.setImage(imageSkin4);
    Image imageSkin5 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-5.png");
    ImageView skin5 = new ImageView();
    skin5.setImage(imageSkin5);

    skin1.setFitWidth(96.0);
    skin1.setFitHeight(186.0);
    skin2.setFitWidth(96.0);
    skin2.setFitHeight(186.0);
    skin3.setFitWidth(96.0);
    skin3.setFitHeight(186.0);
    skin4.setFitWidth(96.0);
    skin4.setFitHeight(186.0);
    skin5.setFitWidth(96.0);
    skin5.setFitHeight(186.0);

    skin1.setY(220);
    skin2.setY(220);
    skin3.setY(220);
    skin4.setY(220);
    skin5.setY(220);
    skin1.setX(95);
    skin2.setX(211);
    skin3.setX(327);
    skin4.setX(443);
    skin5.setX(559);

    rootShop.getChildren().add(skin1);
    rootShop.getChildren().add(skin2);
    rootShop.getChildren().add(skin3);
    rootShop.getChildren().add(skin4);
    rootShop.getChildren().add(skin5);
    rootShop.getChildren().add(bButton2);

    menu.setTitle("Super Alejandro");
    menu.setScene(menuScreen);
    menu.show();
// The root that shows the level selection
//    Pane rootLevels = new Pane();

//    Image levels = new Image("url");
//    BackgroundImage levelsBackground = new BackgroundImage(levels, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.AUTO);
//    rootLevels.setBackground(levelsBackground);
//  }
  }
}
