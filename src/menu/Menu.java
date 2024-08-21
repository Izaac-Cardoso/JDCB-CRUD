package menu;

import dao.EmployeeDAO;
import entities.Employee;

import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    EmployeeDAO employeeDAO;

    public Menu() {
        EmployeeDAO employeeDAO = new EmployeeDAO();
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
                    employeeDAO.read();
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
        System.out.print("Inform the name: ");
        String name = input.nextLine();
        System.out.print("Inform the salary: ");
        double salary = input.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employeeDAO.create(employee);
    }

    public void update() {
        System.out.print("Inform the id to update: ");
        int id = input.nextInt();
        System.out.print("Inform a new name: ");
        String name = input.nextLine();
        System.out.print("Inform the new salary: ");
        double salary = input.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employeeDAO.update(employee);
    }

    public void delete() {
        System.out.print("Inform the id: ");
        int id = input.nextInt();
        System.out.print("Inform the name: ");
        String name = input.nextLine();
        System.out.print("Inform the salary: ");
        double salary = input.nextDouble();

        Employee employee = new Employee(id, name, salary);
        employeeDAO.delete(employee);
    }
}
