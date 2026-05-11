package fasttokenizer;

/**
 * Default color scheme for source code.
 */
public class DefaultCodeTheme implements CodeTheme {
    @Override
    public int getColor(TokenType type) {
        return switch (type) {
            case KEYWORD -> 0xFFD7BA7D;   // Yellowish
            case STRING -> 0xFFCE9178;    // Orange-ish
            case COMMENT -> 0xFF6A9955;   // Greenish
            case NUMBER -> 0xFFB5CEA8;    // Light Green
            case ANNOTATION -> 0xFFC586C0; // Pinkish
            case IDENTIFIER -> 0xFF9CDCFE; // Light Blue
            case OPERATOR -> 0xFFD4D4D4;   // Light Gray
            default -> 0xFFD4D4D4;
        };
    }
}
