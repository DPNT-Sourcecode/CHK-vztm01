package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {

    int[] prices = {50, 30, 20, 15};

    public String[] parseSkus(String skus) {
        return skus.split(",");
    }
    public Integer checkout(String skus) {
//        String[] units = parseSkus(skus);
//        int[] count = {0, 0, 0, 0};
//        int final_price = 0;
//
//        for(String unit: units) {
//            int current = unit.charAt(0)-'A';
//            if(current > 3 || current < 0 )
//                return -1;
//            count[unit.charAt(0) - 'A']++;
//        }
//
//        for(int i = 0; i < count.length; i++) {
//            if(i == 0) {
//                int offer_units = count[i] / 3;
//                count[i] -= (offer_units*3);
//                final_price += (count[i] * prices[i]);
//                final_price += (offer_units * 130);
//            }
//            else if(i==1) {
//                int offer_units = count[i] / 2;
//                count[i] -= (offer_units*2);
//                final_price += (count[i] * prices[i]);
//                final_price += (offer_units * 45);
//            }
//            else
//                final_price += (count[i] * prices[i]);
//        }
//
//        return final_price;
        System.out.println(skus);
        return 0;
    }
}

