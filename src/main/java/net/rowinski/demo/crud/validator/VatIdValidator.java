package net.rowinski.demo.crud.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Map;

public class VatIdValidator implements ConstraintValidator<VatIdConstraint, String> {

    // based on https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s21.html
    private static final Map<String, String> regexByCountry = Map.of(
            "AT", "ATU[0-9]{8}",
            "DE", "DE[0-9]{9}",
            "DK", "DK[0-9]{8}",
            "FR", "FR[0-9A-Z]{2}[0-9]{9}",
            "GB", "GB([0-9]{9}([0-9]{3})?|[A-Z]{2}[0-9]{3})",
            "NL", "NL[0-9A-Z+*]{10}[0-9]{2}"
    );

    @Override
    public boolean isValid(String vatId, ConstraintValidatorContext constraintValidatorContext) {
        return vatId != null && vatId.length() > 3 && isValidVatId(vatId);
    }

    protected static boolean isValidVatId(String vatId) {
        String country = vatId.substring(0, 2).toUpperCase();

        if (!regexByCountry.containsKey(country)) {
            return false;
        }

        String regex = regexByCountry.get(country);

        return vatId.matches(regex);
    }
}
