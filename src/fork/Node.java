package fork;

import java.util.Collection;

/**
 * @author Liudmila Udot
 * @since 2017.2
 */
public interface Node {
    Collection<Node> getChildren();

    long getValue();
}
