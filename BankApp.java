import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class BankApp extends Application {

    public BankAccount bankAcc = new BankAccount();
    public TextField enteredAmount;
    public Label displayedAmount;

    public BankApp(){

    }

    public static void main(String[] args) {
        launch(args);
    }

    //need to add a bankkaccountgui constructor with the instance variables i have
    //need to add two methods to get the inputs and outputs, using event thing

    @Override
    public void start(Stage primaryStage) throws Exception {


      GridPane root = new GridPane();

      Scene scene = new Scene(root, 400, 200);

      Label Labelbalance = new Label("Balance:");
      Label LabelbalanceAmount = new Label(String.valueOf(bankAcc.getBalance()));
      Label LabelaccHold = new Label("Account Holder:");
      Label LabelaccName = new Label("Customer");
      Label Labelamount = new Label("Enter Amount:");
      TextField TFtypeAmount = new TextField();
      Button Buttondeposit = new Button("Deposit");
      Buttondeposit.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
          bankAcc.deposit(Double.parseDouble(TFtypeAmount.getText()));
          double finalAmount = bankAcc.getBalance();
          LabelbalanceAmount.setText(Double.toString(finalAmount));
        }
      });

      Button Buttonwithdraw = new Button("Withdraw");
      Buttonwithdraw.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
          bankAcc.withdraw(Double.parseDouble(TFtypeAmount.getText()));
          double finalAmount = bankAcc.getBalance();
          LabelbalanceAmount.setText(Double.toString(finalAmount));
        }
      });

      TFtypeAmount.setPrefWidth(80); //sets width of textfield


      root.setPadding(new Insets(10, 10, 10, 10)); // Insets of 10
      root.setVgap(5); // Set a gap of pixels vertically and horizontally between elements
      root.setHgap(10);

      root.add(LabelaccHold,0,0);
      GridPane.setHalignment(LabelaccHold, javafx.geometry.HPos.CENTER);

      root.add(LabelbalanceAmount,1,1);
      GridPane.setHalignment(LabelbalanceAmount, javafx.geometry.HPos.CENTER);

      root.add(LabelaccName,0,1);
      GridPane.setHalignment(LabelaccName, javafx.geometry.HPos.CENTER);

      root.add(Labelbalance,1,0);
      GridPane.setHalignment(Labelbalance, javafx.geometry.HPos.CENTER);

      root.add(Labelamount,0,4);
      GridPane.setHalignment(Labelamount, javafx.geometry.HPos.CENTER);

      root.add(TFtypeAmount,1,4);
      GridPane.setHalignment(TFtypeAmount, javafx.geometry.HPos.CENTER);

      root.add(Buttondeposit,0,6);
      GridPane.setHalignment(Buttondeposit, javafx.geometry.HPos.CENTER);

      root.add(Buttonwithdraw,1,6);
      GridPane.setHalignment(Buttonwithdraw, javafx.geometry.HPos.CENTER);

      primaryStage.setTitle("Assignment 5"); // Add title for the scene
      //root.setGridLinesVisible(true); //Used to show gridlines for help with creating the output
      GridPane.setHalignment(root, javafx.geometry.HPos.CENTER);
      root.setAlignment(Pos.CENTER);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
