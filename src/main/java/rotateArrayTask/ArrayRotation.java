package rotateArrayTask;

/**
 * Created by sarahd on 19/07/2018.
 */
public class ArrayRotation {

    private static int[] solution(int[] a, int k){

        int i, length = a.length;
        int[] b = new int[length];
        for (i = 0; i < length; i++){
            int j = (i + k) % length;
            b[j] = a[i];
        }

        return b;
    }
}
