package Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FIleInputStreamTest2 {

    public static void main(String[] args){

        int i;
        try (FileInputStream fis = new FileInputStream("input.txt")){
            while( (i = fis.read()) != -1){
                System.out.println((char)i);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
