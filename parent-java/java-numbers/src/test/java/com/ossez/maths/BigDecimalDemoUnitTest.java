package com.ossez.maths;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class BigDecimalDemoUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(BigDecimalDemoUnitTest.class);

    @Test
    public void whenBigDecimalCreated_thenValueMatches() {
        BigDecimal bdFromString = new BigDecimal("0.1");
        BigDecimal bdFromCharArray = new BigDecimal(
                new char[]{'3', '.', '1', '6', '1', '5'});
        BigDecimal bdlFromInt = new BigDecimal(42);
        BigDecimal bdFromLong = new BigDecimal(123412345678901L);
        BigInteger bigInteger = BigInteger.probablePrime(100, new Random());
        BigDecimal bdFromBigInteger = new BigDecimal(bigInteger);

        assertEquals("0.1", bdFromString.toString());
        assertEquals("3.1615", bdFromCharArray.toString());
        assertEquals("42", bdlFromInt.toString());
        assertEquals("123412345678901", bdFromLong.toString());
        assertEquals(bigInteger.toString(), bdFromBigInteger.toString());
    }

    @Test
    public void whenBigDecimalCreatedFromDouble_thenValueMayNotMatch() {
        BigDecimal bdFromDouble = new BigDecimal(0.1d);
        assertNotEquals("0.1", bdFromDouble.toString());
    }

    @Test
    public void whenBigDecimalCreatedUsingValueOf_thenValueMatches() {
        BigDecimal bdFromLong1 = BigDecimal.valueOf(123412345678901L);
        BigDecimal bdFromLong2 = BigDecimal.valueOf(123412345678901L, 2);
        BigDecimal bdFromDouble = BigDecimal.valueOf(0.1d);

        assertEquals("123412345678901", bdFromLong1.toString());
        assertEquals("1234123456789.01", bdFromLong2.toString());
        assertEquals("0.1", bdFromDouble.toString());
    }

    @Test
    public void whenEqualsCalled_thenSizeAndScaleMatched() {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");

        assertFalse(bd1.equals(bd2));
    }

    @Test
    public void whenComparingBigDecimals_thenExpectedResult() {
        BigDecimal bd1 = new BigDecimal("1.0");
        BigDecimal bd2 = new BigDecimal("1.00");
        BigDecimal bd3 = new BigDecimal("2.0");

        assertTrue(bd1.compareTo(bd3) < 0);
        assertTrue(bd3.compareTo(bd1) > 0);
        assertTrue(bd1.compareTo(bd2) == 0);
        assertTrue(bd1.compareTo(bd3) <= 0);
        assertTrue(bd1.compareTo(bd2) >= 0);
        assertTrue(bd1.compareTo(bd3) != 0);
    }

    @Test
    public void whenPerformingArithmetic_thenExpectedResult() {
        BigDecimal bd1 = new BigDecimal("4.0");
        BigDecimal bd2 = new BigDecimal("2.0");

        BigDecimal sum = bd1.add(bd2);
        BigDecimal difference = bd1.subtract(bd2);
        BigDecimal quotient = bd1.divide(bd2);
        BigDecimal product = bd1.multiply(bd2);

        assertTrue(sum.compareTo(new BigDecimal("6.0")) == 0);
        assertTrue(difference.compareTo(new BigDecimal("2.0")) == 0);
        assertTrue(quotient.compareTo(new BigDecimal("2.0")) == 0);
        assertTrue(product.compareTo(new BigDecimal("8.0")) == 0);
    }

    @Test
    public void whenGettingAttributes_thenExpectedResult() {
        BigDecimal bd = new BigDecimal("-12345.6789");

        assertEquals(9, bd.precision());
        assertEquals(4, bd.scale());
        assertEquals(-1, bd.signum());
    }

    @Test
    public void whenRoundingDecimal_thenExpectedResult() {
        BigDecimal bd = new BigDecimal("2.5");
        // Round to 1 digit using HALF_EVEN
        BigDecimal rounded = bd
                .round(new MathContext(1, RoundingMode.HALF_EVEN));

        assertEquals("2", rounded.toString());
    }

    @Test
    public void givenPurchaseTxn_whenCalculatingTotalAmount_thenExpectedResult() {
        BigDecimal quantity = new BigDecimal("4.5");
        BigDecimal unitPrice = new BigDecimal("2.69");
        BigDecimal discountRate = new BigDecimal("0.10");
        BigDecimal taxRate = new BigDecimal("0.0725");

        BigDecimal amountToBePaid = BigDecimalDemo
                .calculateTotalAmount(quantity, unitPrice, discountRate, taxRate);
        assertEquals("11.68", amountToBePaid.toString());
    }

    /**
     * To String without ScientificNotation
     */
    @Test
    public void bigDecimalWithoutScientificNotationTest() {
        String input = RandomStringUtils.randomNumeric(12)
                + "12345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4567890123456789"
                + "0123456789012345"
                + "6789012345678901"
                + "2345678901234567"
                + "8901234567890123"
                + "4554324324362432"
                + "7674637264783264"
                + "7832678463726478"
                + "3264736274673864"
                + "7364732463546354"
                + "6354632564532645"
                + "6325463546536453"
                + "6546325463546534"
                + "6325465345326456"
                + "4635463263453264";
        // Converting to BigDecimal
        BigDecimal bigNumber = new BigDecimal(input);

        // Apply toString() method
        String numberStr = bigNumber.toString();

        // Print the result
        logger.info("{}", numberStr);
    }

    /**
     * To String with ScientificNotation
     */
    @Test
    public void bigDecimalScientificNotation() {
        // Create a BigDecimal object
        BigDecimal bigNumber;

        // Create a String object
        String numberStr;

        // Set precision to 5
        MathContext mc = new MathContext(6);

        bigNumber = new BigDecimal(RandomStringUtils.randomNumeric(10) + "E5", mc);

        // apply toString() method
        logger.info("{}", bigNumber.toString());
        logger.info("{}", bigNumber.toEngineeringString());
        logger.info("{}", bigNumber.toPlainString());
    }

    /**
     * To StripTrailingZeros
     */
    @Test
    public void bigDecimalStripTrailingZerosTest() {
        BigDecimal bigNumber = new BigDecimal("2707000000000");

        // apply StripTrailingZeros function
        logger.info("{}", bigNumber.toString());
        logger.info("{}", bigNumber.stripTrailingZeros().toString());
        logger.info("{}", bigNumber.stripTrailingZeros().toPlainString());
    }
}
