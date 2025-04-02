package com.file;

import java.io.*;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    transient int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Custom serialization
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();  // Serialize non-transient fields normally
        out.writeInt(salary * 2);  // Custom transformation
    }

    // Custom deserialization
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();  // Deserialize non-transient fields normally
        salary = in.readInt() / 2;  // Revert transformation
    }
}

public class CustomSerialization {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 5000);

        // Serialize
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(emp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee deserializedEmp = (Employee) in.readObject();
            System.out.println("Name: " + deserializedEmp.name + ", Salary: " + deserializedEmp.salary);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
