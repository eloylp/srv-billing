package billing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BillingSequenceTest {

    @ParameterizedTest(name = "{index} Must accept and adapt sequence: {0} {1} {2}")
    @CsvSource({
            "pre,suffix,-, PRE,SUFFIX,-",
            "pre-,-suffix,-, PRE-,-SUFFIX,-",
            "-pre,suffix-,-, -PRE,SUFFIX-,-",
            "pr e,suf fix,-, PRE,SUFFIX,-",
            "PRE,SUFFIX,-, PRE,SUFFIX,-",
            "PRE,SUFFIX,/, PRE,SUFFIX,/",
    })
    void testSequence(ArgumentsAccessor aP) {

        var prefix = aP.getString(0);
        var suffix = aP.getString(1);
        var delimiter = aP.getString(2);

        var expectedPrefix = aP.getString(3);
        var expectedSuffix = aP.getString(4);
        var expectedDelimiter = aP.getString(5);

        var sequence = new BillingSequence(prefix, suffix, delimiter);

        assertEquals(sequence.getPrefix(), expectedPrefix);
        assertEquals(sequence.getSuffix(), expectedSuffix);
        assertEquals(sequence.getDelimiter(), expectedDelimiter);
        assertEquals(sequence.getNumber(), new AutoIncrement("1"));

        var expectedResult = String.join(expectedDelimiter, expectedPrefix, "1", expectedSuffix);
        assertEquals(expectedResult, sequence.toString());
    }

    @Test
    void testTrimmingOfElements() {
        var sequence = new BillingSequence("  PRE    ", "  SUFFIX  ", "  -   ");
        var expectedPrefix = "PRE";
        var expectedSuffix = "SUFFIX";
        var expectedDelimiter = "-";

        assertEquals(sequence.getPrefix(), expectedPrefix);
        assertEquals(sequence.getSuffix(), expectedSuffix);
        assertEquals(sequence.getDelimiter(), expectedDelimiter);
        assertEquals(sequence.getNumber(), new AutoIncrement("1"));

        var expectedResult = String.join(expectedDelimiter, expectedPrefix, "1", expectedSuffix);
        assertEquals(expectedResult, sequence.toString());
    }

}