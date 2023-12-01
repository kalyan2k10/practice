package srinadh;

public class MyHashMap<K,V> {
    public static int INITIAL_CAPACITY = 1<<2;
    public static int MAXIMUM_CAPACITY = 1<<30;

    class Node<K,V> {
        K key;
        V value;
        Node next;
        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }
    Node<K,V>[] slots;
    public MyHashMap() {
        slots = new Node[INITIAL_CAPACITY];
    }
    public MyHashMap(int capacity) {
        slots = new Node[getCapacity(capacity)];
    }

    private int getCapacity(int capacity) {
        int n = capacity - 1;
        n |= (n >>> 1);
        n |= (n >>> 2);
        n |= (n >>> 4);
        n |= (n >>> 8);
        n |= (n >>> 16);
        return n<0? 1 : (n >= MAXIMUM_CAPACITY)? MAXIMUM_CAPACITY : n+1;
    }

    public void put(K key, V value) {
        int slotNo = key.hashCode() % slots.length;
        Node start = slots[slotNo];
        Node node = new Node(key, value);
        if(start == null) {
            slots[slotNo] = node;
        } else {
            Node prev = null;
            while(start !=null) {
                if(start.value == value)
                    return;
                prev = start;
                start = start.next;
            }
            prev.next = node;
        }
    }
    public Node get(K key) {
        int slotNo = key.hashCode() % slots.length;
        Node start = slots[slotNo];
        if(start == null) return null;
        while(start!=null){
            if(start.key == key)
                return start;
            start = start.next;
        }
        return null;
    }
    public Node delete(K key) {
        int slotNo = key.hashCode() % slots.length;
        Node start = slots[slotNo];
        Node prev = null;
        if(start == null) return null;
        while(start!=null){
            if(start.key == key) {
                prev.next = start.next;
                return start;
            }
            prev = start;
            start = start.next;
        }
        return null;
    }
    public static void main(String[] args) {
        MyHashMap<Integer,String> hm = new MyHashMap<>();
        hm.put(1,"hi");
        hm.put(2,"how");
        hm.put(3,"are");
        hm.put(4,"you");
        hm.put(5,"I");
        hm.put(9,"am");

        System.out.println(hm.get(1).value);
        System.out.println(hm.get(5).value);
        System.out.println(hm.delete(9).value);
    }
}
