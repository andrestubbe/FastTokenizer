package fasttokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A minimalist, deterministic tokenizer for Java-like languages.
 */
public class SimpleJavaTokenizer implements CodeTokenizer {

    private static final Set<String> KEYWORDS = Set.of(
        "public", "private", "protected", "class", "interface", "enum",
        "if", "else", "for", "while", "do", "switch", "case", "default",
        "return", "new", "static", "final", "void", "int", "long", "double",
        "float", "boolean", "char", "byte", "short", "extends", "implements",
        "try", "catch", "finally", "throw", "throws", "this", "super"
    );

    @Override
    public List<Token> tokenize(CharSequence source) {
        List<Token> result = new ArrayList<>();
        int len = source.length();
        int i = 0;

        while (i < len) {
            char c = source.charAt(i);

            // WHITESPACE
            if (Character.isWhitespace(c)) {
                int start = i++;
                while (i < len && Character.isWhitespace(source.charAt(i))) i++;
                result.add(new Token(TokenType.WHITESPACE, source.subSequence(start, i), start, i));
                continue;
            }

            // COMMENT
            if (c == '/' && i + 1 < len) {
                char n = source.charAt(i + 1);
                if (n == '/') {
                    int start = i;
                    i += 2;
                    while (i < len && source.charAt(i) != '\n') i++;
                    result.add(new Token(TokenType.COMMENT, source.subSequence(start, i), start, i));
                    continue;
                } else if (n == '*') {
                    int start = i;
                    i += 2;
                    while (i + 1 < len && !(source.charAt(i) == '*' && source.charAt(i + 1) == '/')) i++;
                    i = Math.min(i + 2, len);
                    result.add(new Token(TokenType.COMMENT, source.subSequence(start, i), start, i));
                    continue;
                }
            }

            // STRING
            if (c == '"') {
                int start = i++;
                while (i < len) {
                    char ch = source.charAt(i);
                    if (ch == '\\') i += 2;
                    else if (ch == '"') { i++; break; }
                    else i++;
                }
                result.add(new Token(TokenType.STRING, source.subSequence(start, i), start, i));
                continue;
            }

            // NUMBER
            if (Character.isDigit(c)) {
                int start = i++;
                while (i < len) {
                    char ch = source.charAt(i);
                    if (Character.isDigit(ch) || ch == '.' || ch == '_' || ch == 'x' || ch == 'X') i++;
                    else break;
                }
                result.add(new Token(TokenType.NUMBER, source.subSequence(start, i), start, i));
                continue;
            }

            // IDENTIFIER / KEYWORD / ANNOTATION
            if (Character.isJavaIdentifierStart(c) || c == '@') {
                int start = i++;
                while (i < len && Character.isJavaIdentifierPart(source.charAt(i))) i++;
                CharSequence text = source.subSequence(start, i);
                String s = text.toString();

                TokenType type = (c == '@') ? TokenType.ANNOTATION :
                                KEYWORDS.contains(s) ? TokenType.KEYWORD : TokenType.IDENTIFIER;
                result.add(new Token(type, text, start, i));
                continue;
            }

            // OPERATOR
            if ("+-*/=%!&|^<>?:".indexOf(c) >= 0) {
                int start = i++;
                result.add(new Token(TokenType.OPERATOR, source.subSequence(start, i), start, i));
                continue;
            }

            // PUNCTUATION
            int start = i++;
            result.add(new Token(TokenType.PUNCTUATION, source.subSequence(start, i), start, i));
        }
        return result;
    }
}
