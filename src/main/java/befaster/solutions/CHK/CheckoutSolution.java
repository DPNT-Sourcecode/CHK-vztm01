package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import static java.lang.Integer.min;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15, 40};

    public Integer checkout(String skus) {
        int[] count = {0, 0, 0, 0, 0};
        int final_price = 0;

        for(int i = 0; i < skus.length(); i++) {
            int current = skus.charAt(i)-'A';
            if(current > prices.length-1 || current < 0 )
                return -1;
            count[skus.charAt(i) - 'A']++;
        }

        int number_of_free_b = min(count[4]/2, count[1]);
        count[1] -= number_of_free_b;

        for(int i = 0; i < count.length; i++) {
            if(i == 0) {
                int first_offer_units = count[i] / 5;
                count[i] -= (first_offer_units*5);
                final_price += (first_offer_units * 200);

                int second_offer_units = count[i] / 3;
                count[i] -= (second_offer_units*3);
                final_price += (second_offer_units * 130);

                final_price += (count[i] * 50);
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

