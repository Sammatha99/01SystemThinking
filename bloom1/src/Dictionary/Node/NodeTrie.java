package Dictionary.Node;

import java.util.HashMap;

public class NodeTrie implements Node {
    private Character content;
    private HashMap<Character, NodeTrie> children = new HashMap<>();
    private Boolean isWord = false;

    @Override
    public NodeTrie getChildren(Character l) {
        return children.get(l);
    }

    @Override
    public NodeTrie computeNewNode(Character l) {
        NodeTrie c = new NodeTrie();
        children.put(l, c);
        return c;
    }

    public void setEndofWord(boolean b) {
        isWord = b;
    }

    public boolean isEndOfWord() {
        return isWord;
    }

    public void getWord(String data){
        if (isWord == true){
            System.out.println(data);
        }
        for( Character  c:  children.keySet()){
            NodeTrie node = children.get(c);
            String ndata = data + c;
            node.getWord(ndata);
        }
    }
}
