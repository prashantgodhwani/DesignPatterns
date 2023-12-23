package Examples.HashMap.models;

import Examples.Cache.Exceptions.KeyNotFoundException;

import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

public class Bucket<Key, Value> {

    private LinkedList<Node<Key, Value>> container;

    public Bucket(){
        this.container = new LinkedList<>();
    }

    public LinkedList<Node<Key, Value>> getContainer() {
        return container;
    }

    public boolean insert(Node<Key, Value> newNode){
        boolean isUpdated = false;

        for(Node<Key, Value> node : this.container){
            if(node.getKey().equals(newNode.getKey())){
                node.setValue(newNode.getValue());
                isUpdated = true;
                break;
            }
        }

        if(!isUpdated){
            this.container.addLast(newNode);
            return true;
        }
        return false;
    }

    public void remove(Key key){
        Node<Key, Value> toBeRemovedNode = null;
        for(Node<Key, Value> node : this.container){
            if(node.getKey().equals(key)){
                toBeRemovedNode = node;
                break;
            }
        }

        if(toBeRemovedNode != null) this.container.remove(toBeRemovedNode);
        else throw new KeyNotFoundException("Key " + key + " is not present in map");
    }

    public Value get(Key key){
        for(Node<Key, Value> node : this.container){
            if(node.getKey().equals(key)){
                return node.getValue();
            }
        }
        throw new KeyNotFoundException("Key " + key + " is not present in map");
    }

}
