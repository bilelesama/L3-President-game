/**
 * An enum that represend the possible cards value from a deck
 */
public enum CardValue {
    /* reversing the card order according to the President game rules */
    ACE("1", 2),
    TWO("2", 1),
    THREE("3", 13),
    FOUR("4", 12),
    FIVE("5", 11),
    SIX("6", 10),
    SEVEN("7", 9),
    EIGHT("8", 8),
    NINE("9", 7),
    TEN("10", 6),
    JACK("J", 5),
    QUEEN("Q", 4),
    KING("K", 3);

    private final String stringRepresentation;
    private final int rank;

    CardValue(String stringRepresentation, int value) {
        this.stringRepresentation = stringRepresentation;
        this.rank = value;
    }

    /**
     * From a string representation, return the cad
     *
     * @param str
     * @return the corresponding card
     * @throws RuntimeException if the representation is invalid
     */
    public static CardValue valueOfStr(String str) {
        for (CardValue value : CardValue.values()) {
            if (str.equals(value.getStringRepresentation())) {
                return value;
            }
        }
        throw new IllegalArgumentException("failed to parse value");

    }
    public String getStringRepresentation() {
        return stringRepresentation;
    }
    /**
     * the rank of the card for comparison purpose. The higher the rank, the better the card
     *
     * @return
     */
    public int getRank() {
        return rank;
    }
}
