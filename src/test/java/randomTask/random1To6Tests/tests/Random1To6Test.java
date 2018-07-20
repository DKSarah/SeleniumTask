package randomTask.random1To6Tests.tests;

import org.junit.Test;
import randomTask.random1To6Tests.AbstractRandom1To6Test;

/**
 * Created by sarahd on 20/07/2018.
 */
public class Random1To6Test extends AbstractRandom1To6Test{

    @Test
    public void random1To6Test(){

        initParams(rangeRandomizer)
        .randomizeAndCount(rangeRandomizer)
        .validateRandomization();
    }
}
