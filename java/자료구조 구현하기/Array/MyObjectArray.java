package Array;

public class MyObjectArray {

    private int count;
    private Object[] array;
    public int ARRAY_SIZE;

    public MyObjectArray(){
        ARRAY_SIZE = 10;
        array = new Object[ARRAY_SIZE];
    }

    public MyObjectArray(int size){
        ARRAY_SIZE = size;
        array = new Object[ARRAY_SIZE];
    }

}
