package fasttokenizer;

/**
 * Fundamental token types for code analysis.
 * Minimalist set to keep FastPreview and FastTheme logic clean.
 */
public enum TokenType {
    KEYWORD,
    IDENTIFIER,
    STRING,
    NUMBER,
    COMMENT,
    OPERATOR,
    PUNCTUATION,
    WHITESPACE,
    ANNOTATION,
    UNKNOWN
}
