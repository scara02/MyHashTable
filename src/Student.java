public class Student {
    private int id;
    private String name;
    private double gpa;
    private static int id_gen = 1;

    public Student() {
        this.id = id_gen++;
    }

    public Student(String name, double gpa) {
        this();
        this.name = name;
        this.gpa = gpa;
    }

    public int hashCode() {
        int hash = 1;
        char[] t = name.toCharArray();
        for (char c: t) {
            hash = hash * 31 + c;
        }
        hash = hash * 17 + id;
        hash = hash * 19 + (int) gpa;

        return hash;
    }

    public boolean equals(Object o) {
        return this == o;
    }

}
