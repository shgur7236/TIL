package OOPvsLambda;

interface PrintString{

    void showString(String str);
}
public class LambdaTest {
    public static void main(String[] args){
        PrintString lambdaStr = s -> System.out.println(s); //람다식을 변수에 대입
        lambdaStr.showString("hello lambda_1");

        showMyString(lambdaStr);

        PrintString reStr = returnString();

        reStr.showString("hello");
    }

    private static PrintString returnString() { //반환 값으로 사용
        return s -> System.out.println(s+"ladmbda_3");
    }

    private static void showMyString(PrintString p) {
        p.showString("hello lambda_2");
    }
}
