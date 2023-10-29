package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15};

    public Integer checkout(String skus) {
        int[] count = {0, 0, 0, 0};
        int final_price = 0;

        for(int i = 0; i < skus.length(); i++) {
            int current = skus.charAt(i)-'A';
            if(current > 3 || current < 0 )
                return -1;
            count[skus.charAt(i) - 'A']++;
        }

        for(int i = 0; i < count.length; i++) {
            if(i == 0) {
                int offer_units = count[i] / 3;
                count[i] -= (offer_units*3);
                final_price += (count[i] * prices[i]);
                final_price += (offer_units * 130);
            }
            else if(i==1) {
                int offer_units = count[i] / 2;
                count[i] -= (offer_units*2);
                final_price += (count[i] * prices[i]);
                final_price += (offer_units * 45);
            }
            else
                final_price += (count[i] * prices[i]);
        }

        return final_price;
    }
}

