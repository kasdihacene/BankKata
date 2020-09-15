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

    @Test
    public void shouldCalculateTotalBasketWhenHavingOneArticle() {
        // GIVEN
        BigDecimal expected = new BigDecimal("99.99");
        // WHEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        BigDecimal total = BasketCalculator.calculate(new Article("SNICKERS", priceValue));
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
        BigDecimal total = BasketCalculator.calculate(snickers);
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
        BigDecimal total = BasketCalculator.calculate(articles);
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateTotalWhenHavingOnlyOneArticleInTheList() {
        // GIVEN
        BigDecimal expected = new BigDecimal("99.99");
        // WHEN
        Price priceValue = new Price.Builder().withPrice("99.99").build();
        Article snickers = new Article("SNICKERS", priceValue);
        BigDecimal total = BasketCalculator.calculate(Collections.singletonList(snickers));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }
}
