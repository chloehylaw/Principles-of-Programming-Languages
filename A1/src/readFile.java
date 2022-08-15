import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class readFile {
    public static void main(String[] args){
        System.out.println("\n\n1. Read text file containing shapes.");
        System.out.print("Input file name: ");
        Scanner kb = new Scanner(System.in);
        //String fileName = kb.next();
        String fileName = "shapes.txt";
        System.out.println("Contents of the file:");
        readFile(fileName);

        System.out.println("\n\n2.Sorted shapes by shape name and area.");
        sortNameAndArea(fileName);
    }

    // Reads file containing shapes
    private static void readFile(String fileName){
        Stream<String> shapesStream = null;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String reference;
            while((reference = bufferedReader.readLine()) != null){
                String[] shapesListArray = reference.split("\n");
                shapesStream = Arrays.stream(shapesListArray);
                shapesStream.forEach(s -> System.out.println(s + " "));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found.");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Sorts and display shapes by shape name and area
    private static void sortNameAndArea(String fileName){

        try {
            InputStream inputStream = new FileInputStream(fileName);
            String fileData = new String(inputStream.readAllBytes());
            Stream<String> lines = Arrays.stream(fileData.split("\n"));

            lines.forEach(shape -> {
                if(shape.startsWith("Circle")){
                    Circle c = new Circle();
                    //c.setRadius(); reading file numbers
                    System.out.println("");
                } else if(shape.startsWith("Rectangle")){

                } else{

                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
