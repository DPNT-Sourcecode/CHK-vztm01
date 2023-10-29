package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15};
    public Integer checkout(String skus) {
        String[] units = skus.split(",");
        int[] count = {0, 0, 0, 0};
        for(String unit: units)
            count[unit.charAt(0)-'A']++;
        return 0;
    }
}
