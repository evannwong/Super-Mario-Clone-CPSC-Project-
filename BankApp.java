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
  private static boolean hasAName = false;

  public BankApp(){

  }

  public static void main(String[] args) throws FileNotFoundException{
    launch(args);
  }

    @Override
    public void start(Stage primaryStage) throws Exception{
      try{
        FileReader fr = new FileReader("accountinfo.txt");
        BufferedReader reader = new BufferedReader(fr);
        bankAcc = new SavingsAccount(reader);
        reader.close();
        hasAName = true;
      } catch (IOException ioe){
        hasAName = false;
        bankAcc = new SavingsAccount(new Customer("Temp", 0000), 0);
      }

      GridPane root1 = new GridPane();

      GridPane root2 = new GridPane();

      Scene scene = new Scene(root1, 500, 250);

      Scene noName = new Scene(root2, 500, 250);

      root1.setStyle("-fx-background-image: url('https://image.shutterstock.com/image-photo/piggy-bank-on-blue-background-260nw-472360912.jpg')");
      root2.setStyle("-fx-background-image: url('https://image.shutterstock.com/image-photo/piggy-bank-on-blue-background-260nw-472360912.jpg')");

      Label Labelbalance = new Label("Balance:");
      Label LabelNoName = new Label("No account information found." + "\n" + " To start a new account, please enter your name: ");
      Label Labelwarning = new Label("");
      Label LabelbalanceAmount = new Label(String.valueOf(bankAcc.getBalance()));
      Label LabelaccHold = new Label("Account Holder:");
      Label LabelaccName = new Label(bankAcc.getAccountHolder().getName());
      Label Labelamount = new Label("Enter Amount:");
      TextField TFtypeAmount = new TextField();
      TextField TFtypeName = new TextField();
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

      Button enterButton = new Button("Enter");
      enterButton.setOnAction(new EventHandler<ActionEvent>(){
        public void handle(ActionEvent e){
          try{
            thisName = TFtypeName.getText();
            Random rand = new Random();
            FileOutputStream fos = new FileOutputStream("accountinfo.txt");
            thisCustomerID = rand.nextInt(9999) + 1;
            thisBalance = 0.0;
            Customer customer = new Customer(thisName, thisCustomerID);
            bankAcc = new SavingsAccount(customer, thisBalance, thisIntRate);
            LabelaccName.setText(bankAcc.getAccountHolder().getName());
            root1.setPadding(new Insets(10, 10, 10, 10)); // Insets of 10
            root1.setVgap(5); // Set a gap of pixels vertically and horizontally between elements
            root1.setHgap(10);

            root1.add(LabelaccHold,0,0);
            GridPane.setHalignment(LabelaccHold, javafx.geometry.HPos.CENTER);

            root1.add(LabelbalanceAmount,1,1);
            GridPane.setHalignment(LabelbalanceAmount, javafx.geometry.HPos.CENTER);

            root1.add(LabelaccName,0,1);
            GridPane.setHalignment(LabelaccName, javafx.geometry.HPos.CENTER);

            root1.add(Labelbalance,1,0);
            GridPane.setHalignment(Labelbalance, javafx.geometry.HPos.CENTER);

            root1.add(Labelamount,0,4);
            GridPane.setHalignment(Labelamount, javafx.geometry.HPos.CENTER);

            root1.add(TFtypeAmount,1,4);
            GridPane.setHalignment(TFtypeAmount, javafx.geometry.HPos.CENTER);

            root1.add(Buttondeposit,0,6);
            GridPane.setHalignment(Buttondeposit, javafx.geometry.HPos.CENTER);

            root1.add(Buttonwithdraw,1,6);
            GridPane.setHalignment(Buttonwithdraw, javafx.geometry.HPos.CENTER);

            root1.add(Labelwarning, 3, 6);
            GridPane.setHalignment(Labelwarning, javafx.geometry.HPos.CENTER);
            primaryStage.setScene(scene);
            primaryStage.show();
          } catch (Exception exc){}
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

      if (hasAName == true){
        root1.setPadding(new Insets(10, 10, 10, 10)); // Insets of 10
        root1.setVgap(5); // Set a gap of pixels vertically and horizontally between elements
        root1.setHgap(10);

        root1.add(LabelaccHold,0,0);
        GridPane.setHalignment(LabelaccHold, javafx.geometry.HPos.CENTER);

        root1.add(LabelbalanceAmount,1,1);
        GridPane.setHalignment(LabelbalanceAmount, javafx.geometry.HPos.CENTER);

        root1.add(LabelaccName,0,1);
        GridPane.setHalignment(LabelaccName, javafx.geometry.HPos.CENTER);

        root1.add(Labelbalance,1,0);
        GridPane.setHalignment(Labelbalance, javafx.geometry.HPos.CENTER);

        root1.add(Labelamount,0,4);
        GridPane.setHalignment(Labelamount, javafx.geometry.HPos.CENTER);

        root1.add(TFtypeAmount,1,4);
        GridPane.setHalignment(TFtypeAmount, javafx.geometry.HPos.CENTER);

        root1.add(Buttondeposit,0,6);
        GridPane.setHalignment(Buttondeposit, javafx.geometry.HPos.CENTER);

        root1.add(Buttonwithdraw,1,6);
        GridPane.setHalignment(Buttonwithdraw, javafx.geometry.HPos.CENTER);

        root1.add(Labelwarning, 3, 6);
        GridPane.setHalignment(Labelwarning, javafx.geometry.HPos.CENTER);
      }

      root2.add(TFtypeName,0,6);
      GridPane.setHalignment(TFtypeName, javafx.geometry.HPos.CENTER);

      root2.add(enterButton, 1, 6);
      GridPane.setHalignment(enterButton, javafx.geometry.HPos.CENTER);

      root2.add(LabelNoName, 0, 5);
      GridPane.setHalignment(LabelNoName, javafx.geometry.HPos.CENTER);

      GridPane.setHalignment(root2, javafx.geometry.HPos.CENTER);
      root2.setAlignment(Pos.CENTER);

      primaryStage.setTitle("Bank App"); // Add title for the scene
      GridPane.setHalignment(root1, javafx.geometry.HPos.CENTER);
      root1.setAlignment(Pos.CENTER);
      if (hasAName == true){
        primaryStage.setScene(scene);
      } else{
        primaryStage.setScene(noName);
      }
      primaryStage.show();
    }
}
