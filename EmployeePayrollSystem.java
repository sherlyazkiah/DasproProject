import java.util.Scanner;

public class EmployeePayrollSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("              Employee Payroll              ");
        System.out.println("============================================");

        String[] name = { "Aqilla", "Nadia", "Sherly" };
        String[] idNumber = { "20068", "20239", "20241" };
        boolean loggedIn = false;
        String payMethod, position;
        int workPeriod, category, workDays, overtime, bonus, salary;
        int salaryPerDay = 0, basicSalary = 0, tip = 10000, allowance = 50000;
        String inputName, inputID;

        System.out.print("Name: ");
        inputName = sc.nextLine();
        System.out.print("ID Number: ");
        inputID = sc.nextLine();

        for (int i = 0; i < idNumber.length; i++) {
            if (inputName.equals(name[i]) && inputID.equals(idNumber[i])) {
                loggedIn = true;
                break;
            }
        }

        while (!loggedIn) {
            System.out.print("Name: ");
            inputName = sc.nextLine();
            System.out.print("ID Number: ");
            inputID = sc.nextLine();

            for (int i = 0; i < idNumber.length; i++) {
                if (inputName.equals(name[i]) && inputID.equals(idNumber[i])) {
                    loggedIn = true;
                    break;
                }
            }
        }

        if (loggedIn) {
            System.out.print("Work Period(year): ");
            workPeriod = sc.nextInt();
            sc.nextLine();
            System.out.print("Position(Part Timer/Full Timer): ");
            position = sc.nextLine();
            if (position.equalsIgnoreCase("Part Timer")) {
                System.out.print("Category(1/2): ");
                category = sc.nextInt();

                if (category == 1) {
                    salaryPerDay = 50000;
                } else if (category == 2) {
                    salaryPerDay = 60000;
                } else {
                    System.out.print("Invalid category");
                    return;
                }

            } else if (position.equalsIgnoreCase("Full Timer")) {
                System.out.print("Category(1/2/3): ");
                category = sc.nextInt();

                if (category == 1) {
                    salaryPerDay = 75000;
                } else if (category == 2) {
                    salaryPerDay = 85000;
                } else if (category == 3) {
                    salaryPerDay = 100000;
                } else {
                    System.out.print("Invalid category");
                    return;
                }

            } else {
                System.out.print("Invalid Position");
                return;
            }

            System.out.print("Work Days: ");
            workDays = sc.nextInt();
            System.out.print("Overtime(hour): ");
            overtime = sc.nextInt();

            basicSalary = workDays * salaryPerDay;
            bonus = overtime * tip;
            salary = basicSalary + bonus + allowance;

            System.out.println("============================================");
            System.out.println("Basic Salary: " + basicSalary);
            System.out.println("Bonus: " + bonus);
            System.out.println("Allowance: " + allowance);
            System.out.println("Salary: " + salary);
            System.out.println("");

            double tax, netSalary;
            if (position.equalsIgnoreCase("Part Timer")) {

                if (category == 1) {
                    if (salary > 50000) {
                        tax = salary * 0.02;
                    } else {
                        tax = 0;
                    }
                } else if (category == 2) {
                    if (salary > 60000) {
                        tax = salary * 0.05;
                    } else {
                        tax = 0;
                    }

                } else {
                    System.out.println("Category is invalid");
                    return;
                }
                netSalary = salary - tax;
                System.out.println("Employee salary: " + salary);
                System.out.println("Tax:" + tax);
                System.out.println("Net salary: " + netSalary);

            } else if (position.equalsIgnoreCase("Full Timer")) {
                if (category == 1) {
                    if (salary > 75000) {
                        tax = salary * 0.1;
                    } else {
                        tax = 0;
                    }
                } else if (category == 2) {
                    if (salary > 85000) {
                        tax = salary * 0.15;
                    } else {
                        tax = 0;
                    }
                } else if (category == 3) {
                    if (salary > 100000) {
                        tax = salary * 0.2;
                    } else {
                        tax = 0;
                    }
                } else {
                    System.out.println("Category is invalid");
                    return;
                }
                netSalary = salary - tax;
                System.out.println("Employee salary: " + salary);
                System.out.println("Tax:" + tax);
                System.out.println("Net salary: " + netSalary);
            }

            sc.nextLine();

            System.out.print("Payment Method(BNI/BRI/Bank Jatim/Mandiri/BCA): ");
            payMethod = sc.nextLine();

            switch (payMethod) {

                case "BNI":
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
