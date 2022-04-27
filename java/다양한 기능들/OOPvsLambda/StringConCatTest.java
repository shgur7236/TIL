package OOPvsLambda;

public class StringConCatTest {
    public static void main(String[] args){

        String s1= "hello";
        String s2 = "world";

        StringConCatImpl strImpl = new StringConCatImpl();
        strImpl.makeString(s1, s2);

        StringConCat concat = (s,v) -> System.out.println(s + "," + v);
        concat.makeString(s1,s2);

        StringConCat concat2 = new StringConCat() {
            @Override
            public void makeString(String s1, String s2) {
                System.out.println(s1 + "....." + s2);
            }
        };

        concat2.makeString(s1,s2);
    }
}
