package fasttokenizer;

/**
 * Interface for mapping tokens to colors and styles.
 * Temporary solution until FastTheme is fully integrated.
 */
public interface CodeTheme {
    /**
     * Returns the color (BGRA) for a given token type.
     */
    int getColor(TokenType type);
}
