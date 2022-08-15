public class TestShape {
    public static void main(String[] args) {


        System.out.println("Test create rectangle with length 20 and width 25 and toString method: ");
        Rectangle r1 = new Rectangle(20, 25);

        System.out.println(r1);

        System.out.println("\nTest create  Circle with radius 5 and toString method: ");
        Circle c1 = new Circle(5);

        System.out.println(c1);

        System.out.println("\nTest getShapeName for rectangle: ");
        System.out.println("Shape name: " + r1.getShapeName());

        System.out.println("\nTest getShapeName for circle: ");
        System.out.println("Shape name: " + c1.getShapeName());


        System.out.println("\nTest getPerimeter for rectangle: ");
        System.out.println("Perimeter of rectangle: " + r1.getShapePerimeter());

        System.out.println("\nTest getPerimeter for circle: ");
        System.out.println("Perimeter of circle: " + c1.getShapePerimeter());


        System.out.println("\nTest getArea for rectangle: ");
        System.out.println("Area of rectangle: " + r1.getShapeArea());

        System.out.println("\nTest getArea for circle: ");
        System.out.println("Area of circle: " + c1.getShapeArea());



        System.out.println("\nTest parse method for rectangle: ");
        Rectangle r2 = Rectangle.parse("Rectangle,2,3.5");
        System.out.println("Rectangle created after using parse static method: ");
        System.out.println(r2);


        System.out.println("\nTest parse method for circle: ");
        Circle c2 = Circle.parse("Circle,1");
        System.out.println("Circle created after using parse static method: ");
        System.out.println(c2);
    }
}