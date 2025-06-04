import java.util.Scanner;

public class ShapeCalculator {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Shape Calculator!");
        
        while (true) {
            displayMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    calculateCircle();
                    break;
                case 2:
                    calculateTriangle();
                    break;
                case 3:
                    calculateRectangle();
                    break;
                case 4:
                    calculateSquare();
                    break;
                case 5:
                    calculatePentagon();
                    break;
                case 6:
                    System.out.println("Thank you for using Shape Calculator. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            System.out.println(); // Add spacing between calculations
        }
    }
    
    private static void displayMenu() {
        System.out.println("========== Shape Calculator Menu ==========");
        System.out.println("1. Circle");
        System.out.println("2. Triangle");
        System.out.println("3. Rectangle");
        System.out.println("4. Square");
        System.out.println("5. Pentagon");
        System.out.println("6. Exit");
        System.out.println("==========================================");
        System.out.print("Enter your choice (1-6): ");
    }
    
    private static int getChoice() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); // Clear invalid input
            return -1; // Return invalid choice
        }
    }
    
    private static void calculateCircle() {
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        if (radius <= 0) {
            System.out.println("Radius must be positive!");
            return;
        }
        
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        
        System.out.printf("Circle with radius %.2f:\n", radius);
        System.out.printf("Area: %.2f square units\n", area);
        System.out.printf("Circumference: %.2f units\n", circumference);
    }
    
    private static void calculateTriangle() {
        System.out.println("Choose triangle calculation method:");
        System.out.println("1. Using base and height (for area)");
        System.out.println("2. Using all three sides (Heron's formula)");
        System.out.print("Enter choice (1 or 2): ");
        
        int method = scanner.nextInt();
        
        if (method == 1) {
            System.out.print("Enter the base of the triangle: ");
            double base = scanner.nextDouble();
            System.out.print("Enter the height of the triangle: ");
            double height = scanner.nextDouble();
            System.out.print("Enter side 1: ");
            double side1 = scanner.nextDouble();
            System.out.print("Enter side 2: ");
            double side2 = scanner.nextDouble();
            System.out.print("Enter side 3: ");
            double side3 = scanner.nextDouble();
            
            if (base <= 0 || height <= 0 || side1 <= 0 || side2 <= 0 || side3 <= 0) {
                System.out.println("All measurements must be positive!");
                return;
            }
            
            double area = 0.5 * base * height;
            double perimeter = side1 + side2 + side3;
            
            System.out.printf("Triangle with base %.2f and height %.2f:\n", base, height);
            System.out.printf("Area: %.2f square units\n", area);
            System.out.printf("Perimeter: %.2f units\n", perimeter);
            
        } else if (method == 2) {
            System.out.print("Enter side 1: ");
            double a = scanner.nextDouble();
            System.out.print("Enter side 2: ");
            double b = scanner.nextDouble();
            System.out.print("Enter side 3: ");
            double c = scanner.nextDouble();
            
            if (a <= 0 || b <= 0 || c <= 0) {
                System.out.println("All sides must be positive!");
                return;
            }
            
            // Check if triangle is valid
            if (a + b <= c || a + c <= b || b + c <= a) {
                System.out.println("Invalid triangle! Sum of any two sides must be greater than the third side.");
                return;
            }
            
            double s = (a + b + c) / 2; // Semi-perimeter
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            double perimeter = a + b + c;
            
            System.out.printf("Triangle with sides %.2f, %.2f, %.2f:\n", a, b, c);
            System.out.printf("Area: %.2f square units\n", area);
            System.out.printf("Perimeter: %.2f units\n", perimeter);
        } else {
            System.out.println("Invalid choice!");
        }
    }
    
    private static void calculateRectangle() {
        System.out.print("Enter the length of the rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter the width of the rectangle: ");
        double width = scanner.nextDouble();
        
        if (length <= 0 || width <= 0) {
            System.out.println("Length and width must be positive!");
            return;
        }
        
        double area = length * width;
        double perimeter = 2 * (length + width);
        
        System.out.printf("Rectangle with length %.2f and width %.2f:\n", length, width);
        System.out.printf("Area: %.2f square units\n", area);
        System.out.printf("Perimeter: %.2f units\n", perimeter);
    }
    
    private static void calculateSquare() {
        System.out.print("Enter the side length of the square: ");
        double side = scanner.nextDouble();
        
        if (side <= 0) {
            System.out.println("Side length must be positive!");
            return;
        }
        
        double area = side * side;
        double perimeter = 4 * side;
        
        System.out.printf("Square with side length %.2f:\n", side);
        System.out.printf("Area: %.2f square units\n", area);
        System.out.printf("Perimeter: %.2f units\n", perimeter);
    }
    
    private static void calculatePentagon() {
        System.out.println("Choose pentagon type:");
        System.out.println("1. Regular pentagon (all sides equal)");
        System.out.println("2. Pentagon with known area and perimeter");
        System.out.print("Enter choice (1 or 2): ");
        
        int type = scanner.nextInt();
        
        if (type == 1) {
            System.out.print("Enter the side length of the regular pentagon: ");
            double side = scanner.nextDouble();
            
            if (side <= 0) {
                System.out.println("Side length must be positive!");
                return;
            }
            
            // Formula for regular pentagon
            double area = (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * side * side;
            double perimeter = 5 * side;
            
            System.out.printf("Regular pentagon with side length %.2f:\n", side);
            System.out.printf("Area: %.2f square units\n", area);
            System.out.printf("Perimeter: %.2f units\n", perimeter);
            
        } else if (type == 2) {
            System.out.print("Enter the area of the pentagon: ");
            double area = scanner.nextDouble();
            System.out.print("Enter the perimeter of the pentagon: ");
            double perimeter = scanner.nextDouble();
            
            if (area <= 0 || perimeter <= 0) {
                System.out.println("Area and perimeter must be positive!");
                return;
            }
            
            System.out.printf("Pentagon with given measurements:\n");
            System.out.printf("Area: %.2f square units\n", area);
            System.out.printf("Perimeter: %.2f units\n", perimeter);
        } else {
            System.out.println("Invalid choice!");
        }
    }
}