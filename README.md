# MyHashTable

methods:
- int hash(K key) - maps object data to representative integer value
- void put(K key, V value) - inserts key-value pair in a HashTable
- V get(K key) - return value of the key specified in the parameter
- V remove(K key) - removes a specified key from the HashTable
- boolean contains(V value) - checks if the specified value is mapped to any key
- K getKey(V value) - returns the key of specified value
- int size() - returns the number of buckets
- int[] sizeOfBuckets() - returns the array containing size of each bucket
