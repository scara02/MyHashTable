public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> node = new HashNode<>(key, value);

        if (chainArray[index] == null) {
            chainArray[index] = node;
        }
        else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null)
                current = current.next;
            current.next = node;
        }
        size++;
    }

    public V get(K key) throws Exception {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        if (current == null) throw new Exception("Key does not exist!");

        while (current.next != null && !current.key.equals(key)) {
            current = current.next;
        }

        return current.value;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null && !current.key.equals(key)){
            prev = current;
            current = current.next;
        }

        if (prev == null) {
            chainArray[index] = current.next;
        }
        else{
            prev.next = current.next;
        }

        size--;
        return current.value;
    }

    public boolean contains(V value) {
        if (value == null) throw new NullPointerException();

        return getKey(value) != null;
    }

    public K getKey(V value) {
        if (value == null) throw new NullPointerException();

        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                if (current.value.equals(value))
                    return current.key;
                current = current.next;
            }
        }

        return null;
    }

    public int size() {
        return M;
    }

    public int[] sizeOfBuckets(){
        int[] sizes = new int[M];

        for (int i = 0; i < M; i++){
            HashNode<K, V> current = chainArray[i];
            int length = 0;

            while (current != null){
                current = current.next;
                length++;
            }

            sizes[i] = length;
        }

        return sizes;
    }

}
