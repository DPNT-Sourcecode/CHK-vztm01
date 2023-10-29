package befaster.solutions.CHK;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutSolutionTest {

    CheckoutSolution checkoutSolution = new CheckoutSolution();
    int[] prices = {50, 30, 20, 15};

    @Test
    void shouldReturnCostForSingleUnit() {
        String skus = "A";
        assert(checkoutSolution.checkout(skus).equals(prices[skus.charAt(0)-'A']));
    }

    @Test
    void shouldReturnCostForMultipleSingleUnits() {
        String skus = "A,B,C,D";
        int total = 0;
        for(int price : prices)
            total += price;

        assert(checkoutSolution.checkout(skus).equals(total));
    }

    @Test
    void shouldApplyOfferWhenApplicable() {
        String skus = "A,A,A";
        assert(checkoutSolution.checkout(skus).equals(130));
    }
}