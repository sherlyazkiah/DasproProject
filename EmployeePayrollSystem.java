import java.util.Scanner;
   
public class EmployeePayrollSystem {
  public static void main(String args[]){ 
            
    Scanner sc = new Scanner(System.in);
    System.out.println("              Employee Payroll              ");
    System.out.println("============================================");
     
    String name;
    int category;
    int salaryPerHour;
    int workHours, basicSalary, overtime,  tip = 20000, bonus, salary;
     
    System.out.print("Name: ");
    name = sc.nextLine();
    System.out.print("Category: ");
    category = sc.nextInt();
    System.out.print("Work Hours: ");
    workHours = sc.nextInt();
    System.out.print("Salary Per Hour: ");
    salaryPerHour = sc.nextInt();
    System.out.print("Overtime: ");
    overtime = sc.nextInt();

    basicSalary = workHours*salaryPerHour;
    bonus = overtime*tip;
    salary = basicSalary + bonus;

    System.out.println("============================================");
    System.out.println("Basic Salary: " + basicSalary);
    System.out.println("Bonus: " + bonus);
    System.out.println("Salary: " + salary);

  }
}
