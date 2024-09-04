package sortalgothirm;

public class Base {
    public static int[] genArrRandom(int arraySize){
        int[] arrResult =new int[arraySize];
        for (int i = 0; i < arrResult.length; i++) {
            arrResult[i]= (int)Math.round(Math.random()*10);
        }
        return arrResult;
    }
}
