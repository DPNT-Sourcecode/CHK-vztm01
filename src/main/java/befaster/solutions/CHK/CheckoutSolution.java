package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15};

    public String[] parseSkus(String skus) {
        return skus.split(",");
    }
    public Integer checkout(String skus) {
        String[] units = parseSkus(skus);
        int[] count = {0, 0, 0, 0};
        int final_price = 0;

        for(String unit: units)
            count[unit.charAt(0)-'A']++;

        for(int i = 0; i < count.length; i++)
            final_price += (count[i] * prices[i]);

        return final_price;
    }
}
