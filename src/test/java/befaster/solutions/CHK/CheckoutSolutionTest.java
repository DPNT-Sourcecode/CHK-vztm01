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
        String skus = "ABCD";
        int total = 0;
        for(int price : prices)
            total += price;

        assert(checkoutSolution.checkout(skus).equals(total));
    }

    @Test
    void shouldApplyOfferWhenApplicable() {
        String skus = "AAA";
        assert(checkoutSolution.checkout(skus).equals(130));
    }

    @Test
    void shouldApplyMultipleOfferWhenApplicable() {
        String skus = "AAABBC";
        assert(checkoutSolution.checkout(skus).equals(130+45+20));
    }

    @Test
    void shouldReturnNegativeOneIfInvalidInput(){
        String skus = "Ax";
        assert(checkoutSolution.checkout(skus).equals(-1));
    }

    @Test
    void shouldApplyDifferentOffersOnADependingOnNumberOfUnits(){
        String skus = "AAAAAAAA";
        assert(checkoutSolution.checkout(skus).equals(330));
    }

    @Test
    void shouldApplyCrossUnitOffersCorrectly(){
        String skus = "BEE";
        assert(checkoutSolution.checkout(skus).equals(2*40));
    }

    @Test
    void shouldApplyCrossUnitOffersCorrectlyIfUnitsPurchasedIsLessThanApplicableOffer(){
        String skus = "BEEEE";
        assert(checkoutSolution.checkout(skus).equals(4*40));
    }
}