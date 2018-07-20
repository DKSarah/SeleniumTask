package randomTask;

import java.util.Random;

/**
 * Created by sarahd on 20/07/2018.
 */
public class RangeRandomizer {

    private int min;
    private int max;
    private int rangeSize;

    public RangeRandomizer(int min, int max){
        this.min = min;
        this.max = max;
        this.rangeSize = max - min + 1;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getRangeSize() {
        return rangeSize;
    }

    public void setRangeSize(int rangeSize) {
        this.rangeSize = rangeSize;
    }

    public int rangeRandom(){

        return min + new Random().nextInt(rangeSize);
    }
}
