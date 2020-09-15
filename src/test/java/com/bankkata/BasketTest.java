package com.bankkata;

import com.bankkata.domain.Article;
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
        BigDecimal total = BasketCalculator.calculate(new Article("SNICKERS","99.99"));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }

    @Test
    public void shouldCalculateBasketWhenHavingMoreThanOneArticle(){
        // GIVEN
        BigDecimal expected = new BigDecimal("40.50");
        Quantity quantity = new Quantity(2);
        // WHEN
        Article snickers = new Article("SNICKERS", "20.25",quantity);
        BigDecimal total = BasketCalculator.calculate(snickers);
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }
}
