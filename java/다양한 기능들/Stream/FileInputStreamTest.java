package Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args){

        FileInputStream fis = null;
            try {
                fis = new FileInputStream("input.txt");
                System.out.println((char)fis.read());
                System.out.println((char)fis.read());
                System.out.println((char)fis.read());

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e2){
                    System.out.println(e2);
                }
            }
        System.out.println("end");
    }
}
