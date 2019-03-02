import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class BankAccountGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        GridPane root = new GridPane();

        Scene scene = new Scene(root, 400, 200);

        Label Labelbalance = new Label("Balance:"); 
        Label LabelbalanceAmount = new Label("<insert balance here>");
        Label LabelaccHold = new Label("Account Holder:");
        Label LabelaccName = new Label("<insert name here>"); //enter a variable in here of the name of the account holder
        Label Labelamount = new Label("Enter Amount:");
        TextField TFtypeAmount = new TextField();
        Button Buttondeposit = new Button("Deposit");
        Button Buttonwithdraw = new Button("Withdraw");

        TFtypeAmount.setPrefWidth(80); //sets width of textfield
        

        root.setPadding(new Insets(10, 10, 10, 10)); // Insets of 20
        root.setVgap(5); // Set a gap of pixels vertically and horizontally between elements
        root.setHgap(10);

        root.add(LabelaccHold,0,0); // Add the appropriate labels for the scene
        GridPane.setHalignment(LabelaccHold, javafx.geometry.HPos.CENTER); // center earned score label horizontally
        root.add(LabelbalanceAmount,1,1); // Add the appropriate labels for the scene
        GridPane.setHalignment(LabelbalanceAmount, javafx.geometry.HPos.CENTER); // center earned score label horizontally
        root.add(LabelaccName,0,1);
        GridPane.setHalignment(LabelaccName, javafx.geometry.HPos.CENTER); // center earned score label horizontally
        root.add(Labelbalance,1,0);
        GridPane.setHalignment(Labelbalance, javafx.geometry.HPos.CENTER);
        root.add(Labelamount,0,2);
        GridPane.setHalignment(Labelamount, javafx.geometry.HPos.CENTER);
        root.add(TFtypeAmount,1,2); // Text box to enter a specific amount
        GridPane.setHalignment(TFtypeAmount, javafx.geometry.HPos.CENTER); 
        root.add(Buttondeposit,0,5);  // Add a button that is horizontally right-aligned
        GridPane.setHalignment(Buttondeposit, javafx.geometry.HPos.CENTER); 
        root.add(Buttonwithdraw,1,5);  // Add a button that is horizontally right-aligned
        GridPane.setHalignment(Buttonwithdraw, javafx.geometry.HPos.CENTER);
        
        primaryStage.setTitle("Assignment 5"); // Add title for the scene
        //root.setGridLinesVisible(true); //Used to show gridlines for help with creating the output
        GridPane.setHalignment(root, javafx.geometry.HPos.CENTER);
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show(); 
}
}

//RM 2019/02/03