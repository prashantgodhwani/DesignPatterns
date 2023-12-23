package Examples.HashMap.models;

import java.util.Map;
import java.util.Objects;

public class Node<Key, Value> implements Map.Entry<Key, Value>{
    private Key key;

    private Value value;

    public Node(Key key, Value value){
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public Value setValue(Value value) {
        this.value = value;
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Node))
            return false;

        Node node = (Node) o;
        return key.equals(node.key) && value.equals(node.value);
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
}
