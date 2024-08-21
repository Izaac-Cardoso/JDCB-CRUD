package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;
import utility.DataBaseConnection;

public class EmployeeDAO implements IDAO<Employee> {

    private Connection connection = DataBaseConnection.connect();
    PreparedStatement pstmt;

    @Override
    public void create(Employee employee) {
        try {
            pstmt = connection.prepareStatement("INSERT INTO id, name, salary VALUES (?, ?, ?)");
            pstmt.setInt(1, employee.getId());
            pstmt.setString(2, employee.getName());
            pstmt.setDouble(3, employee.getSalary());

            pstmt.executeUpdate();
            System.out.print("Element inserted successfully.");
        }
        catch(SQLException e) {
            System.out.print("Method failed to insert.");
            e.printStackTrace();
        }
    }

    @Override
    public void read() {
       try {
           pstmt = connection.prepareStatement("SELECT * FROM ");

           ResultSet result = pstmt.executeQuery();

           while(result.next()) {
              int idNum = result.getInt("id");
              String empName = result.getString("name");
              double wage = result.getDouble("salary");

           }
       }
       catch(SQLException e) {
           System.out.print("element was not found.");
           e.printStackTrace();
       }
    }

    @Override
    public void update(Employee employee) {
       try {
          pstmt = connection.prepareStatement("UPDATE name, salary WHERE id = ?");
          pstmt.setString(1, employee.getName());
          pstmt.setDouble(2, employee.getSalary());
          pstmt.setDouble(3, employee.getId());
          ResultSet result = pstmt.executeQuery();

          while(result.next()) {
              int idNum = result.getInt("id");
              String employeeName = result.getString("name");
              double wage = result.getDouble("salary");

              System.out.println("update success");
              System.out.println(idNum + "name: " + employeeName + "salary: $" + wage);
          }
       }
       catch(SQLException e) {
          System.out.print("failed to update.");
          e.printStackTrace();
       }
    }

    @Override
    public void delete(Employee employee) {
       try {
           pstmt = connection.prepareStatement("DELETE * FROM WHERE id = ?");
           pstmt.setInt(1, employee.getId());

           pstmt.executeUpdate();
           System.out.println("element deleted successfully.");
       }
       catch(SQLException e) {
           System.out.print("method failed to delete element.");
           e.printStackTrace();
       }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;
        try{
            pstmt = connection.prepareStatement("SELECT * FROM");
            ResultSet result = pstmt.executeQuery();

            while(result.next()) {
               int idNum = result.getInt("id");
               String employeeName = result.getString("name");
               double wage = result.getDouble("salary");

               employee = new Employee(idNum, employeeName, wage);
               employees.add(employee);
            }
        }
        catch(SQLException e) {
            System.out.print("method failed to delete element.");
            e.printStackTrace();
        }
        return employees;
    }

    public void closeDataBase() {
        DataBaseConnection.closeConnection();
        try {
           pstmt.close();
       }
        catch (SQLException e) {
            e.printStackTrace();
       }
    }
}