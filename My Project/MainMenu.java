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



public class MainMenu extends Application {
   @Override
   public void start(Stage stage) {
      //Instantiating the BorderPane class
      BorderPane bPane = new BorderPane();
      VBox options = new VBox();
      HBox balanceDisplay = new HBox();

      options.setAlignment(Pos.CENTER);
      options.setSpacing(20.0);
      balanceDisplay.setAlignment(Pos.TOP_RIGHT);

      Button levels = new Button("Levels");
      Button shop = new Button("Shop");
      options.getChildren().addAll(levels, shop);

      Button coin = new Button("coin");
      Label balance = new Label("100");
      balanceDisplay.getChildren().addAll(coin, balance);

      bPane.setCenter(options);
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
