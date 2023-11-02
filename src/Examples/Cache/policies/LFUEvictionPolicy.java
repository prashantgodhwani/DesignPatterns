package Examples.Cache.policies;

import Examples.Cache.algorithms.DoublyLinkedList;
import Examples.Cache.algorithms.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LFUEvictionPolicy<Key> implements EvictionPolicy<Key>{

    private Map<Integer, DoublyLinkedList<Key>> countMap;
    private Map<Key, DoublyLinkedListNode<Key>> keyToNodeMap;

    private int minFreq;

    public LFUEvictionPolicy(){
        countMap = new HashMap<>();
        keyToNodeMap = new HashMap<>();
        minFreq = 0;
    }

    @Override
    public void keyAccessed(Key key) {
        if(keyToNodeMap.containsKey(key)){
            DoublyLinkedListNode<Key> node = keyToNodeMap.get(key);
            int count = node.getAccessCount();
            countMap.get(count).detach(node);
            node.incrementAccessCount();
            if(!countMap.containsKey(count + 1)) countMap.put(count + 1, new DoublyLinkedList<>());
            countMap.get(count + 1).add(node);

            if(minFreq == count && countMap.get(minFreq).getSize() == 0){
                minFreq = minFreq + 1;
            }
        }else{
            if(!countMap.containsKey(1)) countMap.put(1, new DoublyLinkedList<>());
            DoublyLinkedListNode<Key> node = countMap.get(1).add(key);
            keyToNodeMap.put(key, node);
            minFreq = 1;
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> node = countMap.get(minFreq).getFirstNode();
        if (node == null) return null;
        else return node.getElement();
    }
}
