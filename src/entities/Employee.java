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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        String resume =  "Id: " + getId() + ", \n"
                       + "Name: " + getName() + ", \n"
                       + "Salary: $" + getSalary();
        return resume;
    }
}
