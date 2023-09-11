package genericsRestrictions;

public class Employee {
    String name;
    int salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
