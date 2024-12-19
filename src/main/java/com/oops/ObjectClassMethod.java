package com.oops;

class ObjectClassMethod {
    int id;
    String name;

    public ObjectClassMethod(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ObjectClassMethod student = (ObjectClassMethod) obj;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return ObjectClassMethod.hash(id, name);
    }

    public static int hash(int id, String name) {
        return 0;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }

    public static void main(String[] args) {
        ObjectClassMethod s1 = new ObjectClassMethod(1, "Bswa");
        ObjectClassMethod s2 = new ObjectClassMethod(1, "jit");
        ObjectClassMethod s3 = new ObjectClassMethod(2, "jena");

        System.out.println("s1 equals s2: " + s1.equals(s2)); // true
        System.out.println("s1 hashCode: " + s1.hashCode());
        System.out.println("s2 hashCode: " + s2.hashCode());
        System.out.println("s1 toString: " + s1.toString());
    }
}
