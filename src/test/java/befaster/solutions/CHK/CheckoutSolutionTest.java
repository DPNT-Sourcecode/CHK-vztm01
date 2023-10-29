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
}