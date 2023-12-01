package kalyan.java;
import java.util.HashMap;

public class MyHashMap<K,V> {
    private static final int  INITIAL_SIZE = 1<<4; //16
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    Node[] hashTable;
    MyHashMap(){
        hashTable= new Node[INITIAL_SIZE];
    }
    MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Node[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    class Node<K,V>{
        K key;
        V value;
        Node next;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Node node = hashTable[hashCode];

        if(node == null) {
            Node newNode = new Node(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Node previousNode = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Node newNode = new Node(key,value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Node node = hashTable[hashCode];

        while(node != null) {
            if(node.key.equals(key)) {
                return (V)node.value;
            }
            node = node.next;
        }
        return null;
    }

    public static void main(String args[]) {
        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Shrayansh");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(17, "?");
        map.remove(9);

        String value = map.get(8);
        System.out.println(value);
    }

    private void remove(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Node node = hashTable[hashCode];

        Node previousNode = null;
        while(node != null) {
            if(node.key.equals(key)) {
                previousNode.next = node.next;
                break;
            }
            previousNode = node;
            node = node.next;
        }

    }
}
