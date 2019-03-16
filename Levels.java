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



public class Levels extends Application {
   @Override
   public void start(Stage stage) {
      //Instantiating the BorderPane class
      BorderPane bPane = new BorderPane();
      HBox levels = new HBox();
      Button backArrow = new Button("back");
      HBox balanceDisplay = new HBox();

      levels.setAlignment(Pos.CENTER);
      levels.setSpacing(20.0);
      backArrow.setAlignment(Pos.BOTTOM_LEFT);
      balanceDisplay.setAlignment(Pos.TOP_RIGHT);

      Button level1 = new Button("Level 1");
      Button level2 = new Button("Level 2");
      Button level3 = new Button("Level 3");
      Button level4 = new Button("Level 4");
      Button level5 = new Button("Level 5");
      levels.getChildren().addAll(level1, level2, level3, level4, level5);

      Button coin = new Button("coin");
      Label balance = new Label("100");
      balanceDisplay.getChildren().addAll(coin, balance);

      bPane.setCenter(levels);
      bPane.setBottom(backArrow);
      bPane.setTop(balanceDisplay);

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
