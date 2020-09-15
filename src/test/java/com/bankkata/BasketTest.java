package com.bankkata;

import com.bankkata.context.FoundResult;
import com.bankkata.context.NotFoundResult;
import com.bankkata.context.Result;
import com.bankkata.domain.Article;
import com.bankkata.domain.Price;
import com.bankkata.domain.Quantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasketTest {

    @Test
    public void shouldCalculateTotalBasketWhenHavingOneArticle() {
        // GIVEN
        BigDecimal expected = new BigDecimal("99.99");
        // WHEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        final Article snickers = new Article("SNICKERS", priceValue);
        BigDecimal total = BasketCalculator.instance().calculate(Collections.singletonList(snickers));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateBasketWhenHavingMoreThanOneArticle() {
        // GIVEN
        BigDecimal expected = new BigDecimal("40.50");
        Quantity quantity = Quantity.builder().withQuantity(2).build();
        // WHEN
        Price priceValue = new Price.Builder().withPrice("20.25").build();
        Article snickers = new Article("SNICKERS", priceValue, quantity);
        BigDecimal total = BasketCalculator.instance().calculate(Collections.singletonList(snickers));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateBasketWhenHavingManyArticlesAndManyQuantities() {
        // GIVEN
        BigDecimal expected = new BigDecimal("81.00");
        Quantity quantity = Quantity.builder().withQuantity(2).build();
        // WHEN
        Price priceValue = new Price.Builder().withPrice("20.25").build();
        Article snickers = new Article("SNICKERS", priceValue, quantity);
        Article shoes = new Article("SHOES", priceValue, quantity);
        List<Article> articles = Arrays.asList(snickers, shoes);
        BigDecimal total = BasketCalculator.instance().calculate(articles);
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateTotalWhenHavingOnlyOneArticleInTheList() {
        // GIVEN
        BigDecimal expected = new BigDecimal("99.99");
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        Article snickers = new Article("SNICKERS", priceValue);
        // WHEN
        BigDecimal total = BasketCalculator.instance().calculate(Collections.singletonList(snickers));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldReturnZeroWhenNoArticlePresentInTheList() {
        // GIVEN
        BigDecimal expected = new BigDecimal("0");
        // WHEN
        BigDecimal total = BasketCalculator.instance().calculate();
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateAddedArticles() {
        // GIVEN
        BigDecimal expected = new BigDecimal("99.99");
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        Article snickers = new Article("SNICKERS", priceValue);
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(snickers);
        BigDecimal total = basketCalculator.calculate();
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldReturnPriceWhenSearchArticleByName() {
        // GIVEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        Result foundResult = new FoundResult(new Price.Builder().withPrice("99.99").build());
        String articleName = "SNICKERS";
        Article snickers = new Article(articleName, priceValue);
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(snickers);
        Result result = basketCalculator.fetch(articleName);
        // THEN
        Assertions.assertThat(foundResult).isEqualTo(result);
    }

    @Test
    public void shouldReturnNullWhenNoArticleWithGivenNameFound() {
        // GIVEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        Result notFoundResult = new NotFoundResult("UNKNOWN");
        String articleName = "SNICKERS";
        Article snickers = new Article(articleName, priceValue);
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(snickers);
        Result found = basketCalculator.fetch("UNKNOWN");
        // THEN
        Assertions.assertThat(notFoundResult).isEqualTo(found);
    }

    @Test
    public void shouldRemoveArticleWhenHavingTheArticleNameInTheList() {
        // GIVEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        String articleName = "SNICKERS";
        Article snickers = new Article(articleName, priceValue);
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(snickers);
        basketCalculator.remove("SNICKERS");
        BigDecimal calculate = basketCalculator.calculate();
        // THEN
        Assertions.assertThat(calculate).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    public void shouldRemoveOneItemArticleWhenHavingTheArticleNameInTheListWithMoreThanOneQuantity() {
        // GIVEN
        BigDecimal expectedTotal = BigDecimal.valueOf(40);
        Price priceValue = new Price.Builder().withPrice("20").build();
        String articleName = "SNICKERS";
        Article snickers = new Article(articleName, priceValue, Quantity.builder().withQuantity(3).build());
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(snickers);
        basketCalculator.remove("SNICKERS");
        BigDecimal calculate = basketCalculator.calculate();
        // THEN
        Assertions.assertThat(calculate).isEqualTo(expectedTotal);
    }

    @Test
    public void shouldRemoveOneItemArticleWhenHavingTheArticleNameInTheListWithFourQuantities() {
        // GIVEN
        BigDecimal expectedTotal = BigDecimal.valueOf(66);
        Price priceValue = new Price.Builder().withPrice("22").build();
        String articleName = "BOTS";
        Article bots = new Article(articleName, priceValue, Quantity.builder().withQuantity(4).build());
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(bots);
        basketCalculator.remove("BOTS");
        BigDecimal calculate = basketCalculator.calculate();
        // THEN
        Assertions.assertThat(calculate).isEqualTo(expectedTotal);
    }

    @Test
    public void shouldReturnZeroWhenCalculatingEmptyListArticlesAfterAllRemoving() {
        // GIVEN
        BigDecimal expectedTotal = BigDecimal.valueOf(0);
        Price priceValue = new Price.Builder().withPrice("22").build();
        String articleName = "BOTS";
        Article bots = new Article(articleName, priceValue, Quantity.builder().withQuantity(2).build());
        BasketCalculator basketCalculator = BasketCalculator.instance();
        // WHEN
        basketCalculator.add(bots);
        basketCalculator.remove("BOTS");
        basketCalculator.remove("BOTS");
        basketCalculator.remove("BOTS");
        BigDecimal calculate = basketCalculator.calculate();
        // THEN
        Assertions.assertThat(calculate).isEqualTo(expectedTotal);
    }

}
