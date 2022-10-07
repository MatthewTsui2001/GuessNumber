import java.util.Scanner;
public class TrianglePerimeter{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double point1_x,
        point1_y,
        point2_x,
        point2_y,
        point3_x,
        point3_y,
        perimeter;
        String answer;
        boolean redo=true;
        
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
                
                //verifying if inputs are valid
                if(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)==false){
                    System.out.println("\n Error: Invalid input \n 1. x and y coordinates need to be positve values \n 2. x and y coordinates need too be smaller than 40 \n 3. Coordinates need to make a triangle (All three x or all three y coordinates can not be the same \n");
                }
            }while(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)==false); // continued until a valid input is inputted
            
            //printing out the traingles perimeter with the calculatePerimeter method
            perimeter=calculatePerimeter(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
            System.out.println("The perimeter is "+ perimeter);
            
            //asking user if they would like to repeat the program
            System.out.println("Would you like to repeat the program?");
            answer=input.next();
            
            //checking if answer is yes or no
            if(answer.equals("NO") || answer.equals("No") || answer.equals("no") || answer.equals("nO"))
                redo=false;
            else if(answer.equals("YES") || answer.equals("YEs") || answer.equals("Yes") || answer.equals("yes") || answer.equals("yES") || answer.equals("yeS") || answer.equals("yEs") || answer.equals("YeS"))
                redo=true;
        }
        System.out.println("End of the program");
    }
    
    public static double calculatePerimeter(double point1_x, double point1_y, double point2_x,double point2_y, double point3_x, double point3_y){
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
    
    public static boolean verify_input(double point1_x, double point1_y, double point2_x, double point2_y, double point3_x, double point3_y){
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
    
}
