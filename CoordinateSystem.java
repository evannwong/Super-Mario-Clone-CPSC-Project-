import java.util.Scanner;

public class CoordinateSystem{
    public static void main(String[] args){
        int xcoord = 0;
        int ycoord = 0;
        System.out.println("***************************************************");
        System.out.println("Try to reach x-coordinate = 10 and y-coordinate = 0");
        System.out.println("***************************************************");
        //Using xcoord < 10 because we want to imagine that the end of the level occurs at x value 10
        while (xcoord < 10) {
            Scanner input = new Scanner(System.in);
            //prompts the user for an input
            System.out.println("");
    	    System.out.println("Enter a key input (w, a, s, or d): ");
            String key = input.next();
            //checks to see which key input was pressed and updates the coordinates accordingly
            //if the input tries to update the coordinate in the negative, it will not update
            if (key.equals("w") && ycoord < 10){
                ycoord += 1;
            }
            if (key.equals("a") && xcoord > 0){
                xcoord -= 1;
            }
            if (key.equals("s") && ycoord > 0){
                ycoord -= 1;
            }
            if (key.equals("d") && xcoord < 10){
                if (ycoord == 0 && xcoord == 5 || ycoord == 1 && xcoord == 5){
                    xcoord += 0;
                    System.out.println("YOU HIT A WALL!!!");
                } else {
                    xcoord += 1;
                }
            } else {
                //if a key other then w, a, s, or d is pressed, nothing will occur
                xcoord += 0;
                ycoord += 0;
            }
            //output to show update coordinate
            System.out.println("You're updated coordinate is: (" + xcoord + ", " + ycoord + ")" );
        }
        System.out.println("");
        System.out.println("*****************************************");
        System.out.println("Congratulations you made it to the end!!!");
        System.out.println("*****************************************");
    }
}