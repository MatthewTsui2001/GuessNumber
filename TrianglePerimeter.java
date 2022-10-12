/**
**Program Name: TrianglePerimeter
**Author: Matthew Tsui
**Date: October 12th, 2022
**Course: CPSC1150
*/
import java.util.Scanner;
public class PrintTrianglePerimeter{
   /**
      **The program prints out the perimeter of a triangle
       */
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      //points of the triangle
      int point1_x,
      point1_y,
      point2_x,
      point2_y,
      point3_x,
      point3_y;
      double perimeter;

      //to ask if user wants to redo the program
      String answer;
      boolean redo=true,
      
      //to check if user input is correct
      validity = false;
      System.out.println("This program calculates the perimeter of a Triangle. \n");
      
      //program will loop until user no longer wishes to continue
      while(redo==true){
         do{
            //asking user to input the coordinates of the triangle
            System.out.print("Please enter the x-coordinate of point1:");
            point1_x=input.nextInt();
            System.out.print("Please enter the y-coordinate of point1:");
            point1_y=input.nextInt();
            System.out.print("Please enter the x-coordinate of point2:");
            point2_x=input.nextInt();
            System.out.print("Please enter the y-coordinate of point2:");
            point2_y=input.nextInt();
            System.out.print("Please enter the x-coordinate of point3:");
            point3_x=input.nextInt();
            System.out.print("Please enter the y-coordinate of point3:");
            point3_y=input.nextInt();
            
            
            //Printing out potential error messsages for invalid inputs
            if(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)==false){
               System.out.println("\n" + errorMessage(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y) + "\n");
            }
         }while(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)==false); // continued until a valid input is inputted
            
         //printing out the traingles perimeter with the calculatePerimeter method
         perimeter=calculatePerimeter(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
         System.out.println("\nThe perimeter of a Triangle with point1 (" + point1_x + ", " + point1_y + "), point2 (" + point2_x + ", " + point2_y + ") and point3 (" + point3_x + ", " + point3_y + ") is " + perimeter);
         
         //making sure that the user enters only yes or no with 
         do{
            //asking user if they would like to repeat the program
            System.out.println("\nWould you like to repeat the program?");
            answer=input.next();
            
            //checking if answer is yes or no
            if(answer.equalsIgnoreCase("NO")){
               redo=false;
               validity=true;
            }
            else if(answer.equalsIgnoreCase("YES")){
               validity=true;
               redo=true;
            }
            if(validity==false)
               System.out.println("\nInvalid input: Please enter only yes or no \n");
         }while(validity==false);
         validity=false;
      }
      System.out.println("End of the program");
   }
    
   /**
      ** CPSC1150
      ** @param point1_x the x_coordinate of point 1, point1_y the y-coordinate of point 1, point2_x the x-coordinate of point 2, point2_y the y-coordinate of point 2, point3_x the x-coordinate of point 3, point3_y the y-coordinate of point 3.
      ** @return perimeter.
      ** precondition: point1_x, point1_y, point2_x, point2_y, point3_x, point3_y is declared in the calling function.
      ** postcondition: perimeter will need a double variable to be assigned to.
      */
   public static double calculatePerimeter(int point1_x, int point1_y, int point2_x,int point2_y, int point3_x, int point3_y){
      double side_1and2,
      side_2and3,
      side_3and1,
      perimeter;
        
      //computing the length of the sides of the triangle
      side_1and2=Math.sqrt(Math.pow((point2_x-point1_x),2)+ Math.pow((point2_y-point1_y),2));
      side_2and3=Math.sqrt(Math.pow((point3_x-point2_x),2)+ Math.pow((point3_y-point2_y),2));
      side_3and1=Math.sqrt(Math.pow((point3_x-point1_x),2)+ Math.pow((point3_y-point1_y),2));
        
      //calculating the perimeter and returning the value
      perimeter=side_1and2+side_2and3+side_3and1;
      return perimeter;
   }
    
   /**
      ** CPSC1150
      ** @param point1_x the x_coordinate of point 1, point1_y the y-coordinate of point 1, point2_x the x-coordinate of point 2, point2_y the y-coordinate of point 2, point3_x the x-coordinate of point 3, point3_y the y-coordinate of point 3.
      ** @return true or false.
      ** precondition: point1_x, point1_y, point2_x, point2_y, point3_x, point3_y is declared in the calling function.
      ** postcondition: true or false will need a boolean variable to be stored in.
      */
   public static boolean verify_input(int point1_x, int point1_y, int point2_x, int point2_y, int point3_x, int point3_y){
      //checking if a negative number was inputted
      if(point1_x<0 || point1_y<0|| point2_x<0 || point2_y<0 || point3_x<0 || point3_y<0)
         return false;
        
      //checking if the coordinates are larger than 40
      else if(point1_x>40 || point1_y>40|| point2_x>40 || point2_y>40 || point3_x>40 || point3_y>40)
         return false;
        
      //checking if the x coordinates are the same for all three points
      else if(point1_x == point2_x && point1_x == point3_x)
         return false;
        
      //checking if the y coordinates are the same for all three points
      else if(point1_y == point2_y && point1_y == point3_y)
         return false;
      //otherwise its a valid input
      else 
         return true;
            
   }
    
   /**
      ** CPSC1150
      ** @param point1_x the x_coordinate of point 1, point1_y the y-coordinate of point 1, point2_x the x-coordinate of point 2, point2_y the y-coordinate of point 2, point3_x the x-coordinate of point 3, point3_y the y-coordinate of point 3.
      ** @return error message.
      ** precondition: point1_x, point1_y, point2_x, point2_y, point3_x, point3_y is declared in the calling function.
      ** postcondition: The type of error will be displayed on the screen.
      */
   public static String errorMessage(int point1_x, int point1_y, int point2_x, int point2_y, int point3_x, int point3_y){
      //checking if a negative number was inputted
      if(point1_x<0 || point1_y<0|| point2_x<0 || point2_y<0 || point3_x<0 || point3_y<0)
         return "Error: points can not be a negative";
        
      //checking if the coordinates are larger than 40
      else if(point1_x>40 || point1_y>40|| point2_x>40 || point2_y>40 || point3_x>40 || point3_y>40)
         return "Error: points can not be larger than 40";
        
      //checking if the x coordinates are the same for all three points
      else if(point1_x == point2_x && point1_x == point3_x)
         return "Error: The points do not make a triangle (all three x-coordinates were the same making a vertical line)";
        
      //checking if the y coordinates are the same for all three points
      else if(point1_y == point2_y && point1_y == point3_y)
         return "Error: The points do not make a triangle (all three y-coordinates were the same making a horizontal line)";
      else
         return "";
   }
    
}
