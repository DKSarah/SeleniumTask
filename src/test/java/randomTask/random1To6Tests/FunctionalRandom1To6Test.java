package randomTask.random1To6Tests;

import org.junit.BeforeClass;
import randomTask.RangeRandomizer;

/**
 * Created by sarahd on 20/07/2018.
 */
public class FunctionalRandom1To6Test extends Random1To6TestsConstants{

    protected static RangeRandomizer rangeRandomizer;

    @BeforeClass
    public static void setUp(){
        rangeRandomizer = new RangeRandomizer(Random1To6TestsConstants.min, Random1To6TestsConstants.max);
    }
}
