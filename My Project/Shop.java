import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Pos;



public class Shop extends Application {
   @Override
   public void start(Stage stage) {
      //Instantiating the BorderPane class
      BorderPane bPane = new BorderPane();
      HBox balanceDisplay = new HBox();
      Button leftArrow = new Button();
      Button rightArrow = new Button();
      VBox characterSelect = new VBox();
      Button backArrow = new Button();

      balanceDisplay.setAlignment(Pos.TOP_RIGHT);
      leftArrow.setAlignment(Pos.CENTER_LEFT);
      rightArrow.setAlignment(Pos.CENTER_RIGHT);
      characterSelect.setAlignment(Pos.CENTER);
      backArrow.setAlignment(Pos.BOTTOM_LEFT);

      Button coin = new Button("");
      Label balance = new Label("100");
      balanceDisplay.getChildren().addAll(coin, balance);

      Button skin = new Button("");
      Button cost = new Button("");
      characterSelect.getChildren().addAll(skin, cost);


      bPane.setTop(balanceDisplay);
      bPane.setCenter(characterSelect);
      bPane.setBottom(backArrow);
      bPane.setLeft(leftArrow);
      bPane.setRight(rightArrow);


        //bPane.setBottom(btnWithdraw);




      //Creating a scene object
      Scene scene = new Scene(bPane);

      //Setting title to the Stage
      stage.setTitle("My Bank");

      //Adding scene to the stage
      stage.setScene(scene);

      //Displaying the contents of the stage
      stage.show();
   }
   public static void main(String args[]){
      launch(args);
   }
}
