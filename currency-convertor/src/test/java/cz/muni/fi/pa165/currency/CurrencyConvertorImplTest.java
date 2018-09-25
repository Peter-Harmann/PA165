package cz.muni.fi.pa165.currency;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConvertorImplTest {

    @Test
    public void testConvert() {
	CurrencyConvertorImpl testObj;

	Currency czk = Currency.getInstance("CZK");
	Currency eur = Currency.getInstance("Eur");

	BigDecimal amount("100.0");

	testObj.convert(eur, czk, amount)
	

        // Don't forget to test border values and proper rounding.
        //fail("Test is not implemented yet.");
    }

    @Test
    public void testConvertWithNullSourceCurrency() {
        fail("Test is not implemented yet.");
    }

    @Test
    public void testConvertWithNullTargetCurrency() {
        fail("Test is not implemented yet.");
    }

    @Test
    public void testConvertWithNullSourceAmount() {
        fail("Test is not implemented yet.");
    }

    @Test
    public void testConvertWithUnknownCurrency() {
        fail("Test is not implemented yet.");
    }

    @Test
    public void testConvertWithExternalServiceFailure() {
        fail("Test is not implemented yet.");
    }

}
