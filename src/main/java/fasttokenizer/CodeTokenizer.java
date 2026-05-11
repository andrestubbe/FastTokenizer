package fasttokenizer;

import java.util.List;

/**
 * Interface for all language-specific tokenizers.
 */
public interface CodeTokenizer {
    /**
     * Tokenizes the given source text.
     */
    List<Token> tokenize(CharSequence source);
}
