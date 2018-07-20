package randomTask.random1To6Tests;

import randomTask.RangeRandomizer;
import randomTask.random1To6Tests.validations.Random1To6Validations;

import java.util.Arrays;

/**
 * Created by sarahd on 20/07/2018.
 */
public class AbstractRandom1To6Test extends FunctionalRandom1To6Test{


    private int[] counters;


    protected AbstractRandom1To6Test initParams(RangeRandomizer rangeRandomizer){

        counters = new int[rangeRandomizer.getRangeSize()];
        Arrays.fill(counters, 0);

        return this;
    }

    public AbstractRandom1To6Test randomizeAndCount(RangeRandomizer rangeRandomizer){

        int i;
        for(i = 0; i < maxIterations; i++){
            int random = rangeRandomizer.rangeRandom();
            counters[random % rangeRandomizer.getRangeSize()]++;
        }

        return this;
    }

    public void validateRandomization(){
        Random1To6Validations.validateRandomizationBalance(counters);
    }
}
