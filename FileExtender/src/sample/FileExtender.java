/**
 * Name: Dewan Fathima
 * Class: CSIT 501 Java
 * Project: FileExtender.java
 * Description: The program it will take a file and read it into the console. also will add some execptions if the file is empty or missing
 */
package sample;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class FileExtender {
    public static void main(String[] args){
        try {
            // This is creating FileReader instance to read the text file
            FileReader reader = new FileReader("testfile2.txt");
            // Here is creating the data variable to read a file
            int data = reader.read();


            // If the file is empty it will output the message and will check using the byte size
            if (data == -1) {
                reader.close();
                throw new EmptyFile("File is Empty");
            }
            // If the file is not empty, then it will read and print out the file's content by using the byte size
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();

            // This execption is created if  the file is not found and output a message
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found!");
            // This execption is created if the file is empty and output a message
        } catch (EmptyFile e) {
            System.err.println("Error: " + e.getMessage());
            // This execption is to operate the io to read the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
