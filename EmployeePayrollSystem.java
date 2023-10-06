import java.util.Scanner;
   
public class EmployeePayrollSystem {
  public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    System.out.println("              Employee Payroll              ");
    System.out.println("============================================");
     
    String name, payMethod;
    int workPeriod, category, workHours, salaryPerHour, basicSalary, overtime,  tip = 10000, bonus, salary, allowance = 50000;
     
    System.out.print("Name: ");
    name = sc.nextLine();
    System.out.print("Work Period: ");
    workPeriod = sc.nextInt();
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
    salary = basicSalary + bonus + allowance;

    System.out.println("============================================");
    System.out.println("Basic Salary: " + basicSalary);
    System.out.println("Bonus: " + bonus);
    System.out.println("Allowance: " + allowance);
    System.out.println("Salary: " + salary);
    System.out.println("");

    sc.nextLine();

    System.out.print("Payment Method(BNI/BRI/Bank Jatim/Mandiri/BCA): ");
    payMethod = sc.nextLine();

    switch(payMethod) {
      case "BNI" :
          System.out.print("Input BNI account number(009): ");
          int BNI = sc.nextInt();
          System.out.println("Salary is currently being processed for transfer to the account...");
          break;
      case "BRI":
          System.out.print("Input BRI account number(002): ");
          int BRI = sc.nextInt();
          System.out.println("Salary is currently being processed for transfer to the account...");
          break;
      case "Bank Jatim":
          System.out.print("Input Bank Jatim account number(114): ");
          int bankJatim = sc.nextInt();
          System.out.println("Salary is currently being processed for transfer to the account...");
          break;
      case "Mandiri":
          System.out.print("Input Mandiri account number(008): ");
          int mandiri = sc.nextInt();
          System.out.println("Salary is currently being processed for transfer to the account...");
          break;
      case "BCA":
          System.out.print("Input BCA account number(014): ");
          int BCA = sc.nextInt();
          System.out.println("Salary is currently being processed for transfer to the account...");
          break;
      default:
          System.out.println("Input invalid");
    }
  }
}