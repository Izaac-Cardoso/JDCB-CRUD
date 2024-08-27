package menu;

import dao.EmployeeDAO;
import entities.Employee;

import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    EmployeeDAO employeeDAO;

    public Menu() {
        employeeDAO = new EmployeeDAO();
    }

    public void init() {
        boolean exit = false;
        while(!exit) {
            menuDisplay();
            int answer = input.nextInt();
            switch(answer) {
                case 1:
                    create();
                break;
                case 2:
                    read();
                break;
                case 3:
                    update();
                break;
                case 4:
                    delete();
                break;
                case 5:
                    employeeDAO.getAll();
                break;
                case 0:
                    exit = true;
                break;
            }
        }
    }

    private void menuDisplay() {
        System.out.println();
        System.out.println("""
                    +--------------------------------+
                    |       Welcome to C.R.U.D       |
                    +--------------------------------+
                    | 1. Register a new staff member |
                    | 2. Show employee's info        |
                    | 3. Update registration data    |
                    | 4. Delete                      |
                    | 5. Display all staff members   |
                    | 0. Exit                        |
                    +--------------------------------+
                    """);
    }

    public void create() {
        System.out.print("Inform the id: ");
        int id = input.nextInt();
        input.nextLine();                     //needed to consume the new line inserted from nextInt
        System.out.print("Inform the name: ");
        String name = input.nextLine();
        System.out.print("Inform the salary: ");
        double salary = input.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employeeDAO.create(employee);
    }

    public void read() {
        System.out.print("Inform the id: ");
        int id = input.nextInt();
        var emp = employeeDAO.read(id);
        System.out.println(emp);
    }

    public void update() {
        System.out.print("Inform the id: ");
        int id = input.nextInt();
        input.nextLine();
        Employee emp = employeeDAO.read(id);

        System.out.print("Inform a new name: ");
        emp.setName(input.nextLine());

        System.out.print("Inform a new salary $: ");
        emp.setSalary(input.nextDouble());

        employeeDAO.update(emp);
    }
    
    public void delete() {
        System.out.print("Inform the id: ");
        int id = input.nextInt();
        employeeDAO.delete(id);
    }
}
