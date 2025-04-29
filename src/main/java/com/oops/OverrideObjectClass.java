package com.oops;

public class OverrideObjectClass {
    private int id;
    private String name;

    public OverrideObjectClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OverrideObjectClass employee = (OverrideObjectClass) obj;
        return id == employee.id && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

    public static void main(String[] args) {
        OverrideObjectClass emp1 = new OverrideObjectClass(1, "Biswajit");
        OverrideObjectClass emp2 = new OverrideObjectClass(1, "Biswa");

        System.out.println("Equals: " + emp1.equals(emp2));
        System.out.println("HashCode emp1: " + emp1.hashCode());
        System.out.println("HashCode emp2: " + emp2.hashCode());
        System.out.println("ToString: " + emp1.toString());
    }
}
