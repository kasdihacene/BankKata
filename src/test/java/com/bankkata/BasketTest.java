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
        String price = "99.99";
        Price priceValue = new Price(price);
                BigDecimal total = BasketCalculator.calculate(new Article("SNICKERS", priceValue));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateBasketWhenHavingMoreThanOneArticle() {
        // GIVEN
        BigDecimal expected = new BigDecimal("40.50");
        Quantity quantity = new Quantity(2);
        // WHEN
        String price = "20.25";
        Price priceValue = new Price(price);
        Article snickers = new Article("SNICKERS", priceValue, quantity);
        BigDecimal total = BasketCalculator.calculate(snickers);
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }
}
