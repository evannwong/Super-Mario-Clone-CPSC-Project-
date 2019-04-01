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
  int skinSelected = 0;

  @Override
  public void start(Stage menu) throws Exception {
    Platform.setImplicitExit(false);

// The root that shows the main menu
    Pane rootMenu = new Pane();
    Pane rootLevels = new Pane();
    Pane rootSkin = new Pane();
    Pane rootLoad = new Pane();
    Scene menuScreen = new Scene(rootMenu, 750.0, 480.0);
    Scene levelsScreen = new Scene(rootLevels, 750.0, 480.0);
    Scene skinScreen = new Scene(rootSkin, 750.0, 480.0);
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

    Image skin = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/sample%20skins%20selection%20blank.png");
    BackgroundImage skinBackground = new BackgroundImage(skin, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
    Background sBackground = new Background(skinBackground);
    rootSkin.setBackground(sBackground);

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

    Image skinImage = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/skins.png");
    ImageView skinButton = new ImageView();
    skinButton.setImage(skinImage);
    skinButton.setFitWidth(152.0);
    skinButton.setFitHeight(60.0);
    skinButton.setX(425);
    skinButton.setY(307);
    rootMenu.getChildren().add(skinButton);

    skinButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        menu.setScene(skinScreen);
        menu.show();
      }
    });

    levelsButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        levelsButton.setOpacity(0.5);
        menu.show();
      }
    });

    levelsButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        levelsButton.setOpacity(1.0);
        menu.show();
      }
    });

    skinButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        skinButton.setOpacity(0.5);
        menu.show();
      }
    });

    skinButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        skinButton.setOpacity(1.0);
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
        try{
          Stage primaryStage = new Stage();
          Main main = new Main(1, skinSelected);
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });

    ImageView lvl2 = new ImageView();
    lvl2.setImage(imageLvl2);

    lvl2.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          Stage primaryStage = new Stage();
          Main main = new Main(2, skinSelected);
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });
    ImageView lvl3 = new ImageView();
    lvl3.setImage(imageLvl3);

    lvl3.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          Stage primaryStage = new Stage();
          Main main = new Main(3, skinSelected);
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });
    ImageView lvl4 = new ImageView();
    lvl4.setImage(imageLvl4);

    lvl4.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          Stage primaryStage = new Stage();
          Main main = new Main(4, skinSelected);
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });
    ImageView lvl5 = new ImageView();
    lvl5.setImage(imageLvl5);

    lvl5.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          Stage primaryStage = new Stage();
          Main main = new Main(5, skinSelected);
          main.start(primaryStage);
          menu.close();
        } catch(Exception e){}
      }
    });

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

    lvl1.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl2.setOpacity(0.5);
        lvl3.setOpacity(0.5);
        lvl4.setOpacity(0.5);
        lvl5.setOpacity(0.5);
        menu.show();
      }
    });

    lvl1.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl2.setOpacity(1.0);
        lvl3.setOpacity(1.0);
        lvl4.setOpacity(1.0);
        lvl5.setOpacity(1.0);
        menu.show();
      }
    });

    lvl2.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(0.5);
        lvl3.setOpacity(0.5);
        lvl4.setOpacity(0.5);
        lvl5.setOpacity(0.5);
        menu.show();
      }
    });

    lvl2.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(1.0);
        lvl3.setOpacity(1.0);
        lvl4.setOpacity(1.0);
        lvl5.setOpacity(1.0);
        menu.show();
      }
    });

    lvl3.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(0.5);
        lvl2.setOpacity(0.5);
        lvl4.setOpacity(0.5);
        lvl5.setOpacity(0.5);
        menu.show();
      }
    });

    lvl3.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(1.0);
        lvl2.setOpacity(1.0);
        lvl4.setOpacity(1.0);
        lvl5.setOpacity(1.0);
        menu.show();
      }
    });

    lvl4.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(0.5);
        lvl2.setOpacity(0.5);
        lvl3.setOpacity(0.5);
        lvl5.setOpacity(0.5);
        menu.show();
      }
    });

    lvl4.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(1.0);
        lvl2.setOpacity(1.0);
        lvl3.setOpacity(1.0);
        lvl5.setOpacity(1.0);
        menu.show();
      }
    });

    lvl5.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(0.5);
        lvl2.setOpacity(0.5);
        lvl3.setOpacity(0.5);
        lvl4.setOpacity(0.5);
        menu.show();
      }
    });

    lvl5.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        lvl1.setOpacity(1.0);
        lvl2.setOpacity(1.0);
        lvl3.setOpacity(1.0);
        lvl4.setOpacity(1.0);
        menu.show();
      }
    });

    bButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        bButton.setOpacity(0.5);
        menu.show();
      }
    });

    bButton.setOnMouseExited(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        bButton.setOpacity(1.0);
        menu.show();
      }
    });






//Skin screen
    Image border = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/borderSelection.png");
    ImageView borderS = new ImageView();
    borderS.setFitWidth(100.0);
    borderS.setFitHeight(225.0);

    boolean pressed = false;

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
    skin1.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          boolean pressed = true;
          skinSelected = 1;
          if (pressed == true){
            borderS.setY(200);
            borderS.setX(102);
            borderS.setImage(border);
          }
        } catch(Exception e){}
      }
    });
    Image imageSkin2 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-2.png");
    ImageView skin2 = new ImageView();
    skin2.setImage(imageSkin2);
    skin2.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          boolean pressed = true;
          skinSelected = 2;
          if (pressed == true){
            borderS.setY(200);
            borderS.setX(218);
            borderS.setImage(border);
          }
        } catch(Exception e){}
      }
    });

    Image imageSkin3 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-3.png");
    ImageView skin3 = new ImageView();
    skin3.setImage(imageSkin3);
    skin3.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          boolean pressed = true;
          skinSelected = 3;
          if (pressed == true){
            borderS.setY(200);
            borderS.setX(334);
            borderS.setImage(border);
          }
        } catch(Exception e){}
      }
    });

    Image imageSkin4 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-4.png");
    ImageView skin4 = new ImageView();
    skin4.setImage(imageSkin4);
    skin4.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          boolean pressed = true;
          skinSelected = 4;
          if (pressed == true){
            borderS.setY(200);
            borderS.setX(450);
            borderS.setImage(border);
          }
        } catch(Exception e){}
      }
    });

    Image imageSkin5 = new Image("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/alejandro-5.png");
    ImageView skin5 = new ImageView();
    skin5.setImage(imageSkin5);
    skin5.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent me) {
        try{
          boolean pressed = true;
          skinSelected = 5;
          if (pressed == true){
            borderS.setY(200);
            borderS.setX(566);
            borderS.setImage(border);
          }
        } catch(Exception e){}
      }
    });

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

    rootSkin.getChildren().add(skin1);
    rootSkin.getChildren().add(skin2);
    rootSkin.getChildren().add(skin3);
    rootSkin.getChildren().add(skin4);
    rootSkin.getChildren().add(skin5);
    rootSkin.getChildren().add(bButton2);
    rootSkin.getChildren().add(borderS);

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
