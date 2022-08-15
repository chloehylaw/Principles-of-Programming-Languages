public class Rectangle implements Shape{

    private double length;  // rectangle length
    private double width;   // rectangle width

    public Rectangle(){};

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // parse method to return Rectangle object based on String input
    public static Rectangle parse(String input){
        Rectangle rectangle = null; // initialize rectangle to return null
        double length = 0.0;    // initialize length to 0
        double width = 0.0;     // initialize width to 0

        String[] param = input.split(",");  // split input at "," and return an array of String

        // If array of String has length < 3, String is invalid
        if(param.length < 3){
            System.out.println("Invalid String input.");
            return rectangle;
        }

        // If first element in array is not Rectangle, String is invalid
        if(!param[0].equals("Rectangle")){
            System.out.println("Invalid String input.");
            return rectangle;
        }

        // If second and third elements in array is not length and width, String is invalid
        try{
            length = Double.parseDouble(param[1]);
            width = Double.parseDouble(param[2]);
            rectangle = new Rectangle(length, width);

        }catch (NumberFormatException e){
            System.out.println("Invalid String input.");
            return rectangle;
        }

        return rectangle;
    }

    // toString method to print rectangle attributes
    @Override
    public String toString() {
        return this.getShapeName() + ", " + this.length + ", " + this.width;
    }

    // Overridden getShapeName method to get the name of the shape
    @Override
    public String getShapeName() {
        return getClass().getName().toUpperCase();
    }

    // Overridden getShapePerimeter method to get the perimeter of the shape
    @Override
    public double getShapePerimeter() {
        return Math.round((2 * (this.length + this.width))*100.00)/100.00;
    }

    // Overridden getShapeArea method to get the area of the shape
    @Override
    public double getShapeArea() {
        return Math.round((this.length * this.width)*100.0)/100.0;
    }
}
