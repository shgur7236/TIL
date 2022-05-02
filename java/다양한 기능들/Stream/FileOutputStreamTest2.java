package Stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {
    public static void main(String[] args) throws FileNotFoundException {

        FileOutputStream fos = new FileOutputStream("output3.txt", true);

        try(fos){

            byte[] bs = new byte[26];

            byte data = 65;
            for(int i = 0; i<bs.length; i++) {
                bs[i] = data++;
            }

            fos.write(bs, 2 ,10);

        }catch(IOException e){
            System.out.println(e);
        }
        System.out.println("end");
    }

}

