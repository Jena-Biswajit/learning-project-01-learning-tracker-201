package com.collections;

import java.util.HashMap;

public class EmployeeClassAsKeyInHashMap {
    public static void main(String[] args) {
        HashMap<Employee1, String> employeeMap = new HashMap<>();

        Employee1 e1 = new Employee1(1, "Biswajit");
        Employee1 e2 = new Employee1(2, "jit");
        Employee1 e3 = new Employee1(1, "Biswajit"); // Duplicate key

        employeeMap.put(e1, "Engineering");
        employeeMap.put(e2, "HR");
        employeeMap.put(e3, "Engineering"); // Will overwrite e1's value

        // Should print two entries, with e1 and e3 considered the same key
        System.out.println("Employees in HashMap:");
        employeeMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
