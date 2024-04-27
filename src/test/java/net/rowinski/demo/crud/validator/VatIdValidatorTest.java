package net.rowinski.demo.crud.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static net.rowinski.demo.crud.validator.VatIdValidator.isValidVatId;
import static org.assertj.core.api.Assertions.assertThat;

public class VatIdValidatorTest {

    @ParameterizedTest
    @CsvSource({
            "ATU99999999",
            "DE999999999",
            "FR12999999999",
            "FRXX999999999",
            "FR1X999999999",
            "FRX1999999999",
            "GB999999999",
            "GB999999999999",
            "GBGD999",
            "GBHA999",
            "DK99999999",
            "NLXXXXXXXXXX99",
            "NLXXXX2XXXXX99",
            "NLXXXX+XXXXX99",
            "NLXXXX+XXX*X99"
    })
    void shouldValidate(String vatId) {
        assertThat(isValidVatId(vatId)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "ATX99999999",
            "ATU9999999",
            "ATU9999999999",
            "DE99999999",
            "DEU99999999",
            "DE9999999999",
            "FR999999999",
            "FR+A999999999",
            "GB9999999999",
            "GB99999999999",
            "GBGD99",
            "GBHA9999",
            "DKA9999999",
            "DK9999999",
            "NLXXXXXXXXXXX9",
            "NLXXXX2XXXXX9X",
    })
    void shouldNotValidate(String vatId) {
        assertThat(isValidVatId(vatId)).isFalse();
    }

}
