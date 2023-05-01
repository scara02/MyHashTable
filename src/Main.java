import java.util.Random;

public class Main {

    private static void testMyHashTable(MyHashTable<Student, String> hashTable) throws Exception{
        int[] sizes = hashTable.sizeOfBuckets();
        for (int i = 0; i < hashTable.size(); i++) {
            System.out.println("Size of " + i + " bucket: " + sizes[i]);
        }
        System.out.println();

        Student chuuya = new Student("Chuuya", 4);
        hashTable.put(chuuya, "Graduate");

        Student dazai = new Student("Dazai", 4);
        hashTable.put(dazai, "Dropped out");

        System.out.println("Key by the value of student Dazai: " + hashTable.getKey("Dropped out"));
        System.out.println("Value by the key of student Dazai: " + hashTable.get(dazai) + '\n');

        System.out.println("Removing student by the key Dazai...\n");
        hashTable.remove(dazai);

        System.out.println("Check if Chuuya is in table: " + hashTable.contains("Graduate"));
        System.out.println("Check if Dazai is in table: " + hashTable.contains("Dropped out"));
    }

    public static void main(String[] args) throws Exception {
        MyHashTable<Student, String> hashTable = new MyHashTable<>();

        for(int i = 0; i < 10000; i++) {
            hashTable.put(new Student(generateString(), generateDouble()), generateString());
        }

        testMyHashTable(hashTable);

    }

    private static String generateString() {
        Random random = new Random();
        String st = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        StringBuilder sb = new StringBuilder();
        int len = random.nextInt(3,13);
        for (int i = 0; i < len; i++) {
            sb.append(st.charAt(random.nextInt(st.length())));
        }

        return sb.toString();
    }

    private static double generateDouble() {
        Random random = new Random();

        return random.nextDouble(4.0);
    }
}