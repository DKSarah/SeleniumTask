package randomTask.random1To6Tests.validations;

import randomTask.random1To6Tests.Random1To6TestsConstants;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by sarahd on 20/07/2018.
 */
public class Random1To6Validations {

    public static void validateRandomizationBalance(int[] counters) {

        int expectedNumberCounter = Random1To6TestsConstants.maxIterations / counters.length;
        int permittedDeviation = (int) (expectedNumberCounter * Random1To6TestsConstants.deviationPercentage);
        System.out.println("Expected Number Counter: " + expectedNumberCounter +
                "\nPermitted Gap From Expected Number Counter: " + permittedDeviation);
        int i;
        for (i = 0; i < counters.length; i++) {
            String info = "Number: " + (Random1To6TestsConstants.min + i) + ", Counter: " + counters[i];
            assertTrue("Randomization is not balanced - " + info,
                    counters[i] > expectedNumberCounter - permittedDeviation &&
                            counters[i] < expectedNumberCounter + permittedDeviation);
            System.out.println(info);
        }
    }
}
