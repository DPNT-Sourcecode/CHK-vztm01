package befaster.solutions.CHK;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CheckoutSolutionTest {

    CheckoutSolution checkoutSolution = new CheckoutSolution();
    int[] prices = {50, 30, 20, 15, 40, 10, 20, 10, 35, 60, 80, 90, 15};

    @Nested
    class GeneralCases {
        @Test
        void shouldReturnCostForSingleUnit() {
            String skus = "A";
            assert(checkoutSolution.checkout(skus).equals(prices[skus.charAt(0)-'A']));
        }

        @Test
        void shouldReturnCostForMultipleSingleUnits() {
            String skus = "ABCD";
            assert(checkoutSolution.checkout(skus).equals(50+30+20+15));
        }

        @Test
        void shouldReturnNegativeOneIfInvalidInput(){
            String skus = "Ax";
            assert(checkoutSolution.checkout(skus).equals(-1));
        }
    }

    @Nested
    class OfferOnA {
        @Test
        void shouldApplyOfferOnThree() {
            String skus = "AAA";
            assert(checkoutSolution.checkout(skus).equals(130));
        }

        @Test
        void shouldApplyOfferOnFiveAndThree(){
            String skus = "AAAAAAAA";
            assert(checkoutSolution.checkout(skus).equals(330));
        }
    }

    @Nested
    class OfferOnB {
        @Test
        void shouldApplyMultipleOfferWhenApplicable() {
            String skus = "AAABBC";
            assert(checkoutSolution.checkout(skus).equals(130+45+20));
        }
    }

    @Nested
    class OfferOnE {
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

        @Test
        void shouldApplyCrossUnitOffersInFavourOftheCustomer(){
            String skus = "BEBEEE";
            assert(checkoutSolution.checkout(skus).equals(160));
        }
    }

    @Nested
    class OfferOnF {
        @Test
        void shouldApplyDiscountForFWhenThereAre3Units(){
            String skus = "FFFFF";
            assert(checkoutSolution.checkout(skus).equals(40));
        }

        @Test
        void shouldNotApplyDiscountForFWhenThereAreLessThan3Units(){
            String skus = "FF";
            assert(checkoutSolution.checkout(skus).equals(20));
        }
    }

    @Nested
    class OfferOnH {
        @Test
        void shouldApplyOfferOnFive(){
            String skus = "HHHHHHH";
            assert(checkoutSolution.checkout(skus).equals(65));
        }

        @Test
        void shouldApplyOfferOnTen(){
            String skus = "HHHHHHHHHHH";
            assert(checkoutSolution.checkout(skus).equals(90));
        }
    }

    @Nested
    class OfferOnK {
        @Test
        void shouldApplyOfferOnTwo(){
            String skus = "KKKKK";
            assert(checkoutSolution.checkout(skus).equals(380));
        }
    }

    @Nested
    class OfferOnMAndN {
        @Test
        void shouldApplyOfferOnMForThreeN(){
            String skus = "NNNNMM";
            assert(checkoutSolution.checkout(skus).equals(160+15));
        }
    }

    @Nested
    class OfferOnP {
        @Test
        void shouldApplyOfferOn5P(){
            String skus = "PPPPPP";
            assert(checkoutSolution.checkout(skus).equals(200+50));
        }
    }

    @Nested
    class OfferOnQ {
        @Test
        void shouldApplyOfferOn3Q(){
            String skus = "QQQQ";
            assert(checkoutSolution.checkout(skus).equals(80+30));
        }
    }

    @Nested
    class OfferOnRAndQ {
        @Test
        void shouldApplyOfferOn3Q(){
            String skus = "RRRQQQQ";
            assert(checkoutSolution.checkout(skus).equals(150+80));
        }
    }

    @Nested
    class OfferOnU {
        @Test
        void shouldApplyOfferOn3U() {
            String skus = "UUUUU";
            assert(checkoutSolution.checkout(skus).equals(160));
        }
    }

    @Nested
    class OfferOnV {
        @Test
        void shouldApplyOfferOnTwoVs() {
            String skus = "VV";
            assert(checkoutSolution.checkout(skus).equals(90));
        }

        @Test
        void shouldApplyOfferOnThreeVs() {
            String skus = "VVVVV";
            assert(checkoutSolution.checkout(skus).equals(90+130));
        }
    }
}
