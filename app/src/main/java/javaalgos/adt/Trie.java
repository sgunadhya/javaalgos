package javaalgos.adt;

import java.util.Collection;

public interface Trie {
    boolean hasPrefix(CharSequence prefix);
    Collection<CharSequence> getPrefixes(CharSequence prefix);
    void put(CharSequence word);
}
