package com.bankkata;

import com.bankkata.domain.Article;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BasketTest {

    @Test
    public void shouldCalculateTotalBasketWhenHavingOneArticle() {
        // GIVEN
        BigDecimal expected = new BigDecimal(99.99);
        // WHEN
        BigDecimal total = BasketCalculator.calculate(new Article("SNICKERS",99.99));
        // THEN
        Assertions.assertThat(expected).isEqualTo(total);
    }
}
