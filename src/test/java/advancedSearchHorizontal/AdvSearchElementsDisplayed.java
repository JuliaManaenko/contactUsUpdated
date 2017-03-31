package advancedSearchHorizontal;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Julia on 20.03.2017.
 */
public class AdvSearchElementsDisplayed extends AdvSearchTestBase2 {

    @Test
    public void advSearchHorizTitleDisplayed() {
        Assert.assertTrue(searchesPage.isWidgetTitleExists());
    }

    @Test
    public void advSearchHorizMakeLabelDisplayed() {
        Assert.assertTrue(searchesPage.isMakeSelectLabelExists());
    }

    @Test
    public void advSearchHorizModelLabelDisplayed() {
        Assert.assertTrue(searchesPage.isModelSelectLabelExists());
    }

    @Test
    public void advSearchHorizStyleLabelDisplayed() {
        Assert.assertTrue(searchesPage.isStyleSelectLabelExists());
    }

    @Test
    public void advSearchHorizMakeSelectDisplayed() {
        Assert.assertTrue(searchesPage.isMakeSelectExists());
    }

    @Test
    public void advSearchHorizModelSelectDisplayed() {
        Assert.assertTrue(searchesPage.isModelSelectExists());
    }

    @Test
    public void advSearchHorizStyleSelectDisplayed() {
        Assert.assertTrue(searchesPage.isStyleSelectExists());
    }

    @Test
    public void advSearchHorizYearSlideFromDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideFromValueExists());
    }

    @Test
    public void advSearchHorizYearSlideToDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideToValueExists());
    }

    @Test
    public void advSearchHorizYearSlideGridDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideGridExists());
    }

    @Test
    public void advSearchHorizYearSlideLabelDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideLabelExists());
    }

    @Test
    public void advSearchHorizYearSlideLineProgressDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideLineProgressExists());
    }

    @Test
    public void advSearchHorizYearSlideMaxValueDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideMaxValueExists());
    }

    @Test
    public void advSearchHorizYearSlideMinValuedDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideMinValueExists());
    }

    @Test
    public void advSearchHorizYearSlideProgressBarDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideProgressBarExists());
    }

    @Test
    public void advSearchHorizYearSlideSingleValueDisplayed() {
        Assert.assertTrue(searchesPage.isYearSlideSingleValueExists());
    }

    @Test
    public void advSearchHorizOdometerSlideFromDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideFromValueExists());
    }

    @Test
    public void advSearchHorizOdometerSlideToDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideToValueExists());
    }

    @Test
    public void advSearchHorizOdometerSlideGridDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideGridExists());
    }

    @Test
    public void advSearchHorizOdometerSlideLabelDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideLabelExists());
    }

    @Test
    public void advSearchHorizOdometerSlideLineProgressDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideLineProgressExists());
    }

    @Test
    public void advSearchHorizOdometerSlideMaxValueDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideMaxValueExists());
    }

    @Test
    public void advSearchHorizOdometerSlideMinValuedDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideMinValueExists());
    }

    @Test
    public void advSearchHorizOdometerSlideProgressBarDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideProgressBarExists());
    }

    @Test
    public void advSearchHorizOdometerSlideSingleValueDisplayed() {
        Assert.assertTrue(searchesPage.isOdometerSlideSingleValueExists());
    }

    @Test
    public void advSearchHorizPriceSlideFromDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideFromValueExists());
    }

    @Test
    public void advSearchHorizPriceSlideToDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideToValueExists());
    }

    @Test
    public void advSearchHorizPriceSlideGridDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideGridExists());
    }

    @Test
    public void advSearchHorizPriceSlideLabelDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideLabelExists());
    }

    @Test
    public void advSearchHorizPriceSlideLineProgressDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideLineProgressExists());
    }

    @Test
    public void advSearchHorizPriceSlideMaxValueDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideMaxValueExists());
    }

    @Test
    public void advSearchHorizPriceSlideMinValuedDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideMinValueExists());
    }

    @Test
    public void advSearchHorizPriceSlideProgressBarDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideProgressBarExists());
    }

    @Test
    public void advSearchHorizPriceSlideSingleValueDisplayed() {
        Assert.assertTrue(searchesPage.isPriceSlideSingleValueExists());
    }

    @Test
    public void advSearchHorizSearchButtonDisplayed() {
        Assert.assertTrue(searchesPage.isSearchButtonExists());
    }

    @Test
    public void advSearchHorizSearchButtonIconDisplayed() {
        Assert.assertTrue(searchesPage.isSearchButtonIconExists());
    }

    @Test
    public void advSearchHorizResetButtonDisplayed() {
        Assert.assertTrue(searchesPage.isResetFiltersButtonExists());
    }

    @Test
    public void advSearchHorizResetButtonIconDisplayed() {
        Assert.assertTrue(searchesPage.isResetFiltersButtonIconExists());
    }

}
