public class Circle implements Shape{

    private double radius;  // circle's radius
    private final double PI = 3.141592; // PI constant

    public Circle(){};

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // parse method to return Circle object based on String input
    public static Circle parse(String input){
        Circle circle = null;   // initialize circle to return null
        double radius = 0.0;    // initialize radius to 0

        String[] param = input.split(",");  // split input at "," and return an array of String

        // If array of String has length < 2, String is invalid
        if(param.length < 2){
            System.out.println("Invalid String input.");
            return circle;
        }

        // If first element in array is not Circle, String is invalid
        if(!param[0].equals("Circle")){
            System.out.println("Invalid String input.");
            return circle;
        }

        // If second element in array is not radius, String is invalid
        try{
            radius = Double.parseDouble(param[1]);
            circle = new Circle(radius);

        }catch (NumberFormatException e){
            System.out.println("Invalid String input.");
            return circle;
        }

        return circle;
    }

    // toString method to print circle attributes
    @Override
    public String toString() {
        return this.getShapeName() + ", " + this.radius;
    }

    // overridden getShapeName method to get the name of the shape
    @Override
    public String getShapeName() {
        return getClass().getName().toUpperCase();
    }

    // overridden getShapePerimeter method to get the perimeter of the shape
    @Override
    public double getShapePerimeter() {
        return Math.round((2 * PI * this.radius)*100.0)/100.0;
    }

    // overridden getShapeArea method to get the area of the shape
    @Override
    public double getShapeArea() {
        return Math.round((PI * this.radius * this.radius)*100.0)/100.0;
    }
}
