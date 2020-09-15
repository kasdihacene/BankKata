package com.bankkata;

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

    private BasketTest() {
    }

    public static BasketTest factory() {
        return new BasketTest();
    }

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
        Quantity quantity = new Quantity.Builder().withQuantity(2).build();
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
        Quantity quantity = new Quantity.Builder().withQuantity(2).build();
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
    public void shouldReturnZeroWhenNoArticlePresentInTheList(){
        // GIVEN
        BigDecimal expected = new BigDecimal("0");
        // WHEN
        BigDecimal total = BasketCalculator.instance().calculate();
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateAddedArticles(){
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

}
