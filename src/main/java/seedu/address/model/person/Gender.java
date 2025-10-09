package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

public class Gender {
    public static final String MESSAGE_CONSTRAINTS =
            "Gender must be one of: male, female, other, non-binary, prefer not to say (or m/f/o/nb/pns).";
    private static final String[] FULL = {"male", "female", "other", "non-binary", "prefer not to say"};
    private static final String[] ABBREV = {"m", "f", "o", "nb", "pns"};

    public final String value;
    public Gender(String input) {
        requireNonNull(input);
        String cleaned = input.trim().toLowerCase();
        for (int i = 0; i < FULL.length; i++) {
            if (cleaned.equals(FULL[i]) || cleaned.equals(ABBREV[i])) {
                value = FULL[i].substring(0,1).toUpperCase() + FULL[i].substring(1); // Capitalize
                return;
            }
        }
        throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
    }
    public static boolean isValidGender(String test) {
        String t = test.trim().toLowerCase();
        for (int i = 0; i < FULL.length; i++) {
            if (t.equals(FULL[i]) || t.equals(ABBREV[i])) return true;
        }
        return false;
    }
    @Override
    public String toString() { return value; }
    @Override
    public boolean equals(Object other) { return other instanceof Gender && value.equals(((Gender)other).value); }
    @Override
    public int hashCode() { return value.hashCode(); }
}
