package Lambda;

public class AddTest {
    public static void main(String[] args){

        Add addF = (x,y)-> x+y;
        System.out.println(addF.add(2, 3));
    }
}
