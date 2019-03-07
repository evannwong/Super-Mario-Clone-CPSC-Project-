import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.FileInputStream; 
import javafx.scene.Group;

public class backgroundIntersects extends Application  {


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Background Testing");
        FileInputStream brick = new FileInputStream("C:\\Users\\Robert\\OneDrive\\CPSC\\Java\\TeamProjectGroup14\\Images\\envi"); 
        Image image = new Image(brick); 
        ImageView imageView = new ImageView(image); 

        //Setting the position of the image 
        imageView.setX(50); 
        imageView.setY(25); 
      
        //setting the fit height and width of the image view 
        imageView.setFitHeight(455); 
        imageView.setFitWidth(500); 
      
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
      
        //Creating a Group object  
        Group root = new Group(imageView);  
      
        //Creating a scene object 
        Scene scene = new Scene(root, 600, 500);  
      
        //Setting title to the Stage 
        primaryStage.setTitle("Loading an image");  
      
        //Adding scene to the stage 
        primaryStage.setScene(scene);
      
        //Displaying the contents of the stage 
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
