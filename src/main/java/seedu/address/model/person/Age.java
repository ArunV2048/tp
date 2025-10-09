package seedu.address.model.person;

public class Age {
    public static final String MESSAGE_CONSTRAINTS = "Age must be a whole number between 1 and 120.";
    public final int value;
    public Age(int input) {
        if (input < 1 || input > 120) throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        value = input;
    }
    public static boolean isValidAge(String s) {
        try {
            int val = Integer.parseInt(s.trim());
            return val >= 1 && val <= 120;
        } catch (NumberFormatException e) { return false; }
    }
    @Override
    public String toString() { return String.valueOf(value); }
    @Override
    public boolean equals(Object o) { return o instanceof Age && value == ((Age)o).value; }
    @Override
    public int hashCode() { return value; }
}
