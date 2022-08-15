import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class read1 {

    private static Object Rectangle;

    public static void main(String[] args) {

        String fileName = "shapes.txt";
        System.out.println("\n===== Read the text file and display contents =====");
        int numFile = readFile(fileName);
        Shape[] shapes = sortFile(fileName);
        System.out.println("\n============== Sort by name and area ===============\nName\tArea");
        double area = sortName_Area(shapes);
        System.out.println("\n=============== Sort by perimeter ================\nPerimeter");
        double perimeter = sortPerimeter(shapes);
        System.out.println("\n================= Average area ==================");
        System.out.println(Math.round((area/numFile)*100.0)/100.0);
        System.out.println("\n=============== Average perimeter ===============");
        System.out.println(Math.round((perimeter/numFile)*100.0)/100.0);
        System.out.println("\n=============== Number of shapes ================");
        System.out.println(numFile);
        shapeData(shapes);
    }

    // Reads file containing shapes
    private static int readFile(String fileName){
        Stream<String> shapesStream = null;
        int count = 0;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String reference;
            while((reference = bufferedReader.readLine()) != null){
                String[] shapesListArray = reference.split("\n");
                shapesStream = Arrays.stream(shapesListArray);
                shapesStream.forEach(s -> System.out.println(s + " "));
                count++;
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return count;
    }

    private static Shape[] sortFile(String fileName){
        Shape[] shapes = new Shape[10];
        int numRec = 0;
        int numCir = 0;
        try{
            File file = new File(fileName);
            Scanner input = new Scanner(file).useDelimiter(",|\\R");
            String nextValue;
            int line = 0;
            int i = 0;
            for(Shape s: shapes) {
                while (input.hasNext()) {
                    line++;
                    nextValue = input.next();
                    String name = nextValue;
                    if (name.equals("Circle")) {
                        nextValue = input.next();
                        double radius = Double.parseDouble(nextValue);
                        shapes[i++] = new Circle(radius);
                        numCir++;

                    }
                    if(name.equals("Rectangle")){
                        nextValue = input.next();
                        double length = Double.parseDouble(nextValue);
                        nextValue = input.next();
                        double width = Double.parseDouble(nextValue);
                        shapes[i++] = new Rectangle(length, width);
                        numRec++;
                    }
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found.");
            System.exit(0);
        }

        return shapes;
    }

    /// sort based on name then area
    private static double sortName_Area(Shape[] shapes){
        double area = 0;
        Arrays.sort(shapes, Comparator.comparing((Shape a) -> "" + a.getShapeName()).thenComparingDouble(Shape::getShapeArea));
        for(Shape shape: shapes){
            System.out.println(shape.getShapeName() + "\t" + shape.getShapeArea());
            area += shape.getShapeArea();
        }
        return area;
    }

    // sort based on perimeter
    private static double sortPerimeter(Shape[] shapes){
        double perimeter = 0;
        Arrays.sort(shapes, (a, b) -> (int) (a.getShapePerimeter() - b.getShapePerimeter()));
        for(Shape shape: shapes){
            System.out.println(shape.getShapePerimeter());
            perimeter += shape.getShapePerimeter();
        }
        return perimeter;
    }

    private static void shapeData(Shape[] shapes) {
        double recArea = 0;
        double recPeri = 0;
        double cirArea = 0;
        double cirPeri = 0;
        int numRec = 0;
        int numCir = 0;
        for (Shape shape : shapes) {
            if (shape.getShapeName().equals("RECTANGLE")) {
                recArea = recArea + shape.getShapeArea();
                recPeri = recPeri + shape.getShapePerimeter();
                numRec++;
            }
            if (shape.getShapeName().equals("CIRCLE")) {
                cirArea += shape.getShapeArea();
                cirPeri += shape.getShapePerimeter();
                numCir++;
            }
        }
        System.out.println("\n============= Number of Rectangles =============");
        System.out.println(numRec);
        System.out.println("\n============== Number of Circles ===============");
        System.out.println(numCir);
        System.out.println("\n========== Average area of Rectangles ===========");
        System.out.println(Math.round((recArea / numRec) * 100.0) / 100.0);
        System.out.println("\n=========== Average area of Circles =============");
        System.out.println(Math.round((cirArea / numCir) * 100.0) / 100.0);
        System.out.println("\n======== Average perimeter of Rectangles =========");
        System.out.println(Math.round((recPeri / numRec) * 100.0) / 100.0);
        System.out.println("\n========== Average perimeter of Circles ==========");
        System.out.println(Math.round((cirPeri / numCir) * 100.0) / 100.0);
    }

}
