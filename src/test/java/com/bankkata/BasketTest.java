package com.bankkata;

import com.bankkata.domain.Article;
import com.bankkata.domain.Price;
import com.bankkata.domain.Quantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
}
