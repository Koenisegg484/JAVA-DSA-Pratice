import java.util.HashMap;
import java.util.Map;

public class trieNode {

    Map<Character, trieNode> children;
    boolean endOfString;

    trieNode(){
        this.children = new HashMap<>();
        this.endOfString = false;
    }    
}
