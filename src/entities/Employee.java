package entities;

public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee() {}

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        String resume =  "Id: " + getId() + ", \n"
                       + "Name: " + getName() + ", \n"
                       + "Salary: $" + getSalary();
        return resume;
    }
}
