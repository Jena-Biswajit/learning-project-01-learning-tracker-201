### Case-by-Case Explanation
***Case 1: equals() always returns true, hashCode() always returns 1***

***Example:***
- The school assigns Locker 1 to all students.
- Every student recognizes (equals=true) any other student.
- If a new student arrives, they replace the existing student in Locker 1.
- Final result:
- Only 1 student’s bag remains in Locker 1 (all previous students were replaced).Due to collision .
-  HashSet size = 1

```
package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj1){
         return true;
    }

    @Override
    public int hashCode(){
       return 1;
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}

o/p:employee details is [Employee{id=1, name='biswa'}]
```

***Case 2: equals() always returns false, hashCode() always returns 1***

***Example:***

- The school assigns Locker 1 to all students.
- But this time, students do not recognize each other (equals=false).
- So, they all keep their bags in the same locker, even if it gets crowded.
- Final result:
- All 3 students' bags remain inside Locker 1(same bucket index).
- HashSet size = size of hashSet (no one is replaced).

```
package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj1){
         return false;
    }

    @Override
    public int hashCode(){
       return 1;
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}

o/p:employee details is [Employee{id=1, name='biswa'}, Employee{id=2, name='bisw'}, Employee{id=3, name='bis'}, Employee{id=1, name='biswaa'}, Employee{id=4, name='biswa'}, Employee{id=1, name='biswa'}, Employee{id=2, name='biswq'}]
```

***Case 3: equals() always returns true, hashCode() is random***

***Example:***

- The school assigns a different locker to each student (random hashCode()).
- All student will get different locker(different bucket index) .
- No collision 
- size - size of hashSet

```
package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj1){
         return true;
    }

    @Override
    public int hashCode(){
       return new Random().nextInt();
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}

0/p :employee details is [Employee{id=1, name='biswaa'}, Employee{id=2, name='bisw'}, Employee{id=4, name='biswa'}, Employee{id=3, name='bis'}, Employee{id=1, name='biswa'}, Employee{id=2, name='biswq'}, Employee{id=1, name='biswa'}]
```

***Case 4: equals() always returns false, hashCode() is random***

***Example:***

- The school assigns a different locker to each student (random hashCode()).
- Students don’t recognize each other (equals=false), so they keep their bags without replacing anyone.
- Final result:
- Each student gets their own locker and keeps their bag.
- HashSet size = 3

```
package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj1){
         return false ;
    }

    @Override
    public int hashCode(){
       return new Random().nextInt();
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}

0/p:employee details is [Employee{id=1, name='biswa'}, Employee{id=1, name='biswa'}, Employee{id=4, name='biswa'}, Employee{id=3, name='bis'}, Employee{id=2, name='biswq'}, Employee{id=2, name='bisw'}, Employee{id=1, name='biswaa'}]
```

***Case 5: Proper equals() and hashCode()***

***Example:***

- The school assigns lockers based on student ID (consistent hashCode()).
- If a student with the same ID comes again, they replace the old bag.
- If a student with a different ID comes, they get a new locker.
- Final result:
- Only unique students have their bags in lockers.
- HashSet size = Number of unique students.

```
package com.collections;
import java.util.*;

class Employee1 {
    int id;
    String name;
    public Employee1(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj1){
        if(this == obj1){
            return true ;
        }
        if ((obj1== null) || (getClass()!= obj1.getClass())){
            return false;
        }
        Employee1 employee = (Employee1) obj1;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name);
    }
    @Override
    public String toString(){
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

}
public class EmployeeClassExampleRevise {
    public static void main(String[] args) {
        HashSet<Employee1> employees = new HashSet<>();
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"bisw"));
        employees.add(new Employee1(3,"bis"));
        employees.add(new Employee1(1,"biswaa"));
        employees.add(new Employee1(4,"biswa"));
        employees.add(new Employee1(1,"biswa"));
        employees.add(new Employee1(2,"biswq"));

        System.out.println("employee details is "+employees);
    }
}

O/p:employee details is [Employee{id=1, name='biswa'}, Employee{id=1, name='biswaa'}, Employee{id=2, name='biswq'}, Employee{id=2, name='bisw'}, Employee{id=4, name='biswa'}, Employee{id=3, name='bis'}]
```

***Key Takeaways***
- If equals() is always true, only one object remains (replaces old ones).
- If equals() is always false, all objects stay in the HashSet.
- If hashCode() is always the same, all objects go into the same bucket (locker).
- If hashCode() is random, each object gets a different bucket (locker).
- A proper equals() and hashCode() ensures only unique elements are stored.
