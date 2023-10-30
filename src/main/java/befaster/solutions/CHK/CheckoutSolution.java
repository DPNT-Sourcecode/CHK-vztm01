package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import static java.lang.Integer.min;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15, 40, 10, 20, 10, 35, 60, 70, 90, 15, 40, 10, 50, 30, 50, 20, 20, 40, 50, 20, 17, 20, 21};

    public Integer checkout(String skus) {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int final_price = 0;

        for(int i = 0; i < skus.length(); i++) {
            int current = skus.charAt(i)-'A';
            if(current > prices.length-1 || current < 0 )
                return -1;
            count[skus.charAt(i) - 'A']++;
        }

        int number_of_free_b = min(count[4]/2, count[1]);
        count[1] -= number_of_free_b;

        int number_of_free_m = min(count[13]/3,count[12]);
        count[12] -= number_of_free_m;

        int number_of_free_q = min(count[17]/3, count[16]);
        count[16] -= number_of_free_q;

        // S,T,X,Y,Z => 18, 19, 23, 24, 25
        if(count[18] + count[19] + count[23] + count[24] + count[25] >= 3) {
            int temp_sum = (count[18] + count[19] + count[23] + count[24] + count[25])/3;
            final_price += temp_sum*45;

            while(temp_sum*3 > 0) {
                if(count[25] > 0)
                    count[25]--;
                else if(count[24] > 0)
                    count[24]--;
                else if(count[19] > 0)
                    count[19]--;
                else if(count[18] > 0)
                    count[18]--;
                else
                    count[23]--;

                temp_sum--;
            }

            System.out.println("Price here is " + final_price);
        }

        for(int i = 0; i < count.length; i++) {
            if(i == 0) {
                int first_offer_units = count[i] / 5;
                count[i] -= (first_offer_units*5);
                final_price += (first_offer_units * 200);

                int second_offer_units = count[i] / 3;
                count[i] -= (second_offer_units*3);
                final_price += (second_offer_units * 130);
            }
            else if(i==1) {
                int offer_units = count[i] / 2;
                count[i] -= (offer_units*2);
                final_price += (offer_units * 45);
            }
            else if(i==5) {
                if(count[i] >=3)
                    count[i] -= count[i]/3;
            }
            else if(i==7) {
                int first_offer_units = count[i] / 10;
                count[i] -= (first_offer_units*10);
                final_price += (first_offer_units * 80);

                int second_offer_units = count[i] / 5;
                count[i] -= (second_offer_units*5);
                final_price += (second_offer_units * 45);
            }
            else if(i==10) {
                int first_offer_units = count[i] / 2;
                count[i] -= (first_offer_units*2);
                final_price += (first_offer_units * 120);
            }
            else if(i==15){
                int first_offer_units = count[i] / 5;
                count[i] -= (first_offer_units*5);
                final_price += (first_offer_units * 200);
            }
            else if(i==16){
                int first_offer_units = count[i] / 3;
                count[i] -= (first_offer_units*3);
                final_price += (first_offer_units * 80);
            }
            else if(i==20){
                if(count[i] >=4)
                    count[i] -= count[i]/4;
            }
            else if(i==21){
                int first_offer_units = count[i] / 3;
                count[i] -= (first_offer_units*3);
                final_price += (first_offer_units * 130);

                int second_offer_units = count[i] / 2;
                count[i] -= (second_offer_units*2);
                final_price += (second_offer_units * 90);
            }

            final_price += (count[i] * prices[i]);
            System.out.println("Price for " + (char) (i+'A') + " here is " + final_price);
        }

        return final_price;
    }
}




