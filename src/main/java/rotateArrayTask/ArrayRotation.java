package rotateArrayTask;

/**
 * Created by sarahd on 19/07/2018.
 */
public class ArrayRotation {

    private static Integer[] solution(Integer[] a, Integer k){

        int i, length = a.length;
        Integer[] b = new Integer[length];
        for (i=0; i < length; i++){
            int j = (i + k) % length;
            b[j] = a[i];
        }
        return b;
    }

    public static void main(String[] args){

        Integer[] a = {7, 3, 2, 1};
        a = solution(a, 3);
        for(Integer integer: a){
            System.out.print(integer + ", ");
        }

        a = solution(a, 17);
        for(Integer integer: a){
            System.out.print(integer + ", ");
        }

        a = solution(a, 4);
        for(Integer integer: a){
            System.out.print(integer + ", ");
        }

        a = solution(a, 0);
        for(Integer integer: a){
            System.out.print(integer + ", ");
        }
    }
}
