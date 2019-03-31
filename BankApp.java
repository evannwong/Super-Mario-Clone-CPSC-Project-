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
import javafx.stage.WindowEvent;
import java.util.*;
import java.io.*;
import java.lang.Thread;
import javafx.scene.image.ImageView;

public class BankApp extends Application {

  public static BankAccount bankAcc;
  public TextField enteredAmount;
  public Label displayedAmount;
  public static String thisName;
  public static int thisCustomerID;
  public static double thisBalance;
  public static double thisIntRate;

  public BankApp(){

  }

  public static void main(String[] args) throws FileNotFoundException{
    try{
      FileReader fr = new FileReader("accountinfo.txt");
      BufferedReader reader = new BufferedReader(fr);
      bankAcc = new SavingsAccount(reader);
      reader.close();
    } catch (IOException ioe){
      Random rand = new Random();
      FileOutputStream fos = new FileOutputStream("accountinfo.txt");
      Scanner scanner = new Scanner(System.in);
      System.out.print("No account information found. To start a new account, please enter your name: ");
      thisName = scanner.nextLine();
      thisCustomerID = rand.nextInt(9999) + 1;
      thisBalance = 0.0;
      Customer customer = new Customer(thisName, thisCustomerID);
      bankAcc = new SavingsAccount(customer, thisBalance, thisIntRate);
    }
    launch(args);
  }

    //need to add a bankkaccountgui constructor with the instance variables i have
    //need to add two methods to get the inputs and outputs, using event thing

    @Override
    public void start(Stage primaryStage) throws Exception {


      GridPane root = new GridPane();

      Scene scene = new Scene(root, 500, 250);

      root.setStyle("-fx-background-image: url('https://image.shutterstock.com/image-photo/piggy-bank-on-blue-background-260nw-472360912.jpg')");
      Label Labelbalance = new Label("Balance:");
      Label Labelwarning = new Label("");
      Label LabelbalanceAmount = new Label(String.valueOf(bankAcc.getBalance()));
      Label LabelaccHold = new Label("Account Holder:");
      Label LabelaccName = new Label(bankAcc.getAccountHolder().getName());
      Label Labelamount = new Label("Enter Amount:");
      TextField TFtypeAmount = new TextField();
      Button Buttondeposit = new Button("Deposit");
      Buttondeposit.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
          try{
            Labelwarning.setText("");
            double d1 = Double.parseDouble(TFtypeAmount.getText());
            bankAcc.deposit(d1);
            if (d1 < 0.0){
              Labelwarning.setText("Cannot deposit a negative amount!");
            }
            double finalAmount = bankAcc.getBalance();
            LabelbalanceAmount.setText(Double.toString(finalAmount));
          } catch (NumberFormatException nfe){
            Labelwarning.setText("Not a number!");
          }
        }
      });

      Button Buttonwithdraw = new Button("Withdraw");
      Buttonwithdraw.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
          try{
            Labelwarning.setText("");
            double d1 = Double.parseDouble(TFtypeAmount.getText());
            if (d1 > bankAcc.getBalance()){
              Labelwarning.setText("Cannot withdraw an amount" + "\n" + "greater than your balance!");
            }
            bankAcc.withdraw(d1);
            if (d1 < 0.0){
              Labelwarning.setText("Cannot withdraw a negative amount!");
            }
            double finalAmount = bankAcc.getBalance();
            LabelbalanceAmount.setText(Double.toString(finalAmount));
          } catch (NumberFormatException nfe){
            Labelwarning.setText("Not a number!");
          }
        }
      });

      TFtypeAmount.setPrefWidth(80); //sets width of textfield

      primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
          public void handle(WindowEvent we) {
            try{
              bankAcc.saveToTextFile("accountinfo.txt");
            } catch (IOException e) {}
          }
      });

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

      root.add(Labelwarning, 3, 6);
      GridPane.setHalignment(Labelwarning, javafx.geometry.HPos.CENTER);

      primaryStage.setTitle("Bank App"); // Add title for the scene
      GridPane.setHalignment(root, javafx.geometry.HPos.CENTER);
      root.setAlignment(Pos.CENTER);
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
