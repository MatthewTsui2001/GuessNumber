import java.util.Scanner;
public class Main{
    public static void Triangle Perimeter(String[] args) {
        Scanner input = new Scanner(System.in);
        double point1_x,
        point1_y,
        point2_x,
        point2_y,
        point3_x,
        point3_y,
        perimeter;
        //String answer;
        boolean redo=true,
        valid = true;
        while(redo==true){
            do{
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
                if(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y)==false){
                    valid = false;
                    System.out.println("Error: Invalid input \n 1. x and y coordinates need to be positve values \n 2. x and y coordinates need too be smaller than 40 \n 3. Coordinates need to make a triangle (All three x or all three y coordinates can not be the same");
                }
            }while(valid=true);
            System.out.println(verify_input(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y));
            
            perimeter=calculatePerimeter(point1_x, point1_y, point2_x, point2_y, point3_x, point3_y);
            System.out.println("The perimeter is "+ perimeter);
            System.out.println("Would you like to repeat the program?");
            String answer=input.next();
            
            if(answer.equals("NO") || answer.equals("No") || answer.equals("no") || answer.equals("nO"))
                redo=false;
            else if(answer.equals("YES") || answer.equals("YEs") || answer.equals("Yes") || answer.equals("yes"))
                redo=true;
        }
        System.out.println("End of the program");
    }
    public static double calculatePerimeter(double point1_x, double point1_y, double point2_x,double point2_y, double point3_x, double point3_y){
        double ab,
        bc,
        ca,
        perimeter;
        ab=Math.sqrt(Math.pow((point2_x-point1_x),2)+ Math.pow((point2_y-point1_y),2));
        bc=Math.sqrt(Math.pow((point3_x-point2_x),2)+ Math.pow((point3_y-point2_y),2));
        ca=Math.sqrt(Math.pow((point3_x-point1_x),2)+ Math.pow((point3_y-point1_y),2));
        perimeter=ab+bc+ca;
        return perimeter;
    }
    public static boolean verify_input(double point1_x, double point1_y, double point2_x, double point2_y, double point3_x, double point3_y){
        if(point1_x<0 || point1_y<0|| point2_x<0 || point2_y<0 || point3_x<0 || point3_y<0)
            return false;
        else if(point1_x>40 || point1_y>40|| point2_x>40 || point2_y>40 || point3_x>40 || point3_y>40)
            return false;
        else if(point1_x == point2_x && point1_x == point3_x)
            return false;
        else if(point1_y == point2_y && point1_y == point3_y)
            return false;
        else 
        return true;
            
    }
    
}