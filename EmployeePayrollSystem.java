import java.util.Scanner;

public class EmployeePayrollSystem {
  public static void main(String args[]){ 
    Scanner sc = new Scanner(System.in);
    System.out.println("              Employee Payroll              ");
    System.out.println("============================================");
     
    String name, payMethod, position;
    int workPeriod, category = 0, workDays, salaryPerDay = 0, basicSalary = 0, overtime,  tip = 10000, bonus, salary, allowance = 50000;
     
    System.out.print("Name: ");
    name = sc.nextLine();
    System.out.print("Work Period: ");
    workPeriod = sc.nextInt();
    sc.nextLine();
    if(workPeriod <= 2){
        System.out.println("Your Position is Part Timer");
    }else{
        System.out.println("Your Position is Full TImer ");
    }

    System.out.print("Position (Part Timer/Full Timer): ");
    position = sc.nextLine();  
    System.out.print("Work Days: ");
    workDays = sc.nextInt();

    if (position.equalsIgnoreCase("Part Timer")) {
        System.out.print("Category (1, 2): ");
        category = sc.nextInt();

        if (category == 1) {
            salaryPerDay = 50000;
        } else if (category == 2) {
            salaryPerDay = 60000;
        } else {
            System.out.println("Invalid Category");
            return;
        }
    } else if (position.equalsIgnoreCase("Full Timer")) {
        System.out.print("Category (1, 2, 3 ):");
        category = sc.nextInt();

        if (category == 1) {
            salaryPerDay = 75000;
        } else if (category == 2) {
            salaryPerDay = 85000;
        } else if (category == 3) {
            salaryPerDay = 100000;
        } else {
            System.out.println("Invalid Category");
            return;
        }
    } else {
        System.out.println("Invalid Work Period");
        return;
    }

    basicSalary = workDays * salaryPerDay;


    System.out.print("Overtime: ");
    overtime = sc.nextInt();
    bonus = overtime*tip;
    salary = basicSalary + bonus + allowance;

            System.out.println("============================================");
            System.out.println("Salary Information:");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n", "Basic Salary", "Bonus",
                    "Allowance", "Salary", "Tax", "Net Salary");
            System.out.println("-------------------------------------------------------------------------------");

            System.out.printf("%-10s   | %-10s | %-10s | %-10s | %-10s | %-10s%n", salaryInfo[0][1], salaryInfo[1][1],
                    salaryInfo[2][1], salaryInfo[3][1], salaryInfo[4][1], salaryInfo[5][1]);

            // for (String[] info : salaryInfo) {
            // System.out.println(info[0] + ": " + info[1]);
            // }
        }

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
