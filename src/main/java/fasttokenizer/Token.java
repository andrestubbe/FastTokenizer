package fasttokenizer;

/**
 * Represents a single token in the source code.
 * Uses CharSequence to avoid unnecessary String allocations.
 */
public final class Token {
    private final TokenType type;
    private final CharSequence text;
    private final int startOffset;
    private final int endOffset;

    public Token(TokenType type, CharSequence text, int startOffset, int endOffset) {
        this.type = type;
        this.text = text;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
    }

    public TokenType getType() {
        return type;
    }

    public CharSequence getText() {
        return text;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public int getEndOffset() {
        return endOffset;
    }
}
