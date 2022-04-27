package InnerClass;

class OutClass {

    private int num = 10;
    private static int sNum = 20;
    private Inclass inClass;

    public OutClass() {
        inClass = new Inclass(); // 내부 클래스 생성
    }

    class Inclass {
        int inNum = 100;
        //static int sInNum = 200;    //에러 남

        void inTest() {
            System.out.println("OutClass num = " + num + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass sNum = " + inNum + "(내부 클래스의 스태틱 변수)");
        }

        //static void sTest(){

        //}
    }

    public void usingClass() {
        inClass.inTest(); //내부 클래스 변수를 사용하여 메서드 호출하기기
    }

    static class InStaticClass {

        int inNum = 100;
        static int sInNum = 200;

        void inTest() { //정적 클래스의 일반 메서드
            System.out.println("OutClass num = " + inNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 인스턴스 변수)");
        }
        static void sTest() { //정적 클래스의 일반 메서드
            //System.out.println("OutClass num = " + inNum + "(외부 클래스의 인스턴스 변수)");
            System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
            System.out.println("InClass inNum = " + sInNum + "(내부 클래스의 인스턴스 변수)");
        }
    }
}

    public class InnerTest {
        public static void main(String[] args) {

            /*OutClass outClass = new OutClass();
            outClass.usingClass();

            OutClass.Inclass inner = outClass.new Inclass();
            inner.inTest();*/

            OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
            sInClass.inTest();

            System.out.println();

            OutClass.InStaticClass.sTest();
        }
    }
