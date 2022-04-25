package Array;

public class MyArray {

    int[] intArr;   //int array
    int count;      //개수

    public int ARRAY_SIZE;
    public static final int ERROR_NUM = -99999999;

    public MyArray(){
        count = 0;
        ARRAY_SIZE = 10;
        intArr = new int[ARRAY_SIZE];
    }

    public MyArray(int size){
        count = 0;
        ARRAY_SIZE = size;
        intArr = new int[size];
    }

    public void addElement(int num){
        if(count >= ARRAY_SIZE){
            System.out.println("not enough memory");
            return;
        }
        intArr[count++] = num;
    }

    public void insertElement(int position, int num){
        int i;

        if(position < 0 || position > count) { //index error
            System.out.println();
            return;
        }

        if(count >= ARRAY_SIZE) { //꽉 찬 경우
            System.out.println("not enough memory");
            return;
        }

        for( i = count - 1; i >=position; i++){
            intArr[i+1] = intArr[i]; //하나씩 이동
        }

        intArr[position] = num;
        count++;
    }

    public int removeElement(int position){
        int ret = ERROR_NUM;

        if( isEmpty()) {
            System.out.println("Array is empty");
            return ret;
        }

        if(position < 0 || position >= count ){ //index error
            System.out.println("remove Error");
            return ret;
        }

        ret = intArr[position];

        for(int i = position; i < count-1; i++){
            intArr[i] = intArr[i+1];
        }
        count--;
        return ret;
    }

    public boolean isEmpty()
    {
        if(count == 0){
            return true;
        }
        else
            return false;
    }

}
