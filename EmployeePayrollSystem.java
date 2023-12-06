import java.util.Scanner;

public class EmployeePayrollSystem {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("              Employee Payroll              ");
        System.out.println("============================================");

        String[][] employees = {
                { "Aqilla", "20068" },
                { "Nadia", "20239" },
                { "Sherly", "20241" }
        };

        boolean loggedIn = false;
        String payMethod, position;
        int workPeriod, category, workDays, overtime, bonus, salary;
        int salaryPerDay = 0, basicSalary = 0, tip = 10000, allowance = 50000;
        String inputName, inputID;

        System.out.print("Name: ");
        inputName = sc.nextLine();
        System.out.print("ID Number: ");
        inputID = sc.nextLine();

        for (String[] employee : employees) {
            if (inputName.equals(employee[0]) && inputID.equals(employee[1])) {
                loggedIn = true;
                break;
            }
        }

        while (!loggedIn) {
            System.out.print("Name: ");
            inputName = sc.nextLine();
            System.out.print("ID Number: ");
            inputID = sc.nextLine();

            for (String[] employee : employees) {
                if (inputName.equals(employee[0]) && inputID.equals(employee[1])) {
                    loggedIn = true;
                    break;
                }
            }
        }

        if (loggedIn) {
            System.out.print("Work Period(year): ");
            workPeriod = sc.nextInt();
            sc.nextLine();
            System.out.print("Position(Part timer/Full timer): ");
            position = sc.nextLine();

            if (position.equalsIgnoreCase("Part timer")) {
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

            } else if (position.equalsIgnoreCase("Full timer")) {
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
                System.out.print("Invalid position");
                return;
            }

            System.out.print("Work Days: ");
            workDays = sc.nextInt();
            System.out.print("Overtime(hour): ");
            overtime = sc.nextInt();

            basicSalary = workDays * salaryPerDay;
            bonus = overtime * tip;
            salary = basicSalary + bonus + allowance;

            double tax, netSalary;
            if (position.equalsIgnoreCase("Part timer")) {

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
                    System.out.println("Invalid category");
                    return;
                }
                netSalary = salary - tax;

            } else if (position.equalsIgnoreCase("Full timer")) {
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
                    System.out.println("Invalid category");
                    return;
                }
                netSalary = salary - tax;

            } else {
                System.out.println("Invalid position");
                return;
            }

            String[][] salaryInfo = {
                    { "Basic Salary", String.valueOf(basicSalary) },
                    { "Bonus", String.valueOf(bonus) },
                    { "Allowance", String.valueOf(allowance) },
                    { "Salary", String.valueOf(salary) },
                    { "Tax", String.valueOf(tax) },
                    { "Net Salary", String.valueOf(netSalary) }
            };

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

        int accountNumber = 0;

        while (true) {
            System.out.print("Payment Method(BNI/BRI/Bank Jatim/Mandiri/BCA): ");
            payMethod = sc.nextLine();

            switch (payMethod) {

                case "BNI":

                    System.out.print("Input BNI account number(009): ");
                    accountNumber = sc.nextInt();
                    System.out.println("Salary is currently being processed for transfer to the account");

                    break;

                case "BRI":

                    System.out.print("Input BRI account number(002): ");
                    accountNumber = sc.nextInt();
                    System.out.println("Salary is currently being processed for transfer to the account");

                    break;

                case "Bank Jatim":

                    System.out.print("Input Bank Jatim account number(114): ");
                    accountNumber = sc.nextInt();
                    System.out.println("Salary is currently being processed for transfer to the account");

                    break;

                case "Mandiri":

                    System.out.print("Input Mandiri account number(008): ");
                    accountNumber = sc.nextInt();
                    System.out.println("Salary is currently being processed for transfer to the account");

                    break;

                case "BCA":

                    System.out.print("Input BCA account number(014): ");
                    accountNumber = sc.nextInt();
                    System.out.println("Salary is currently being processed for transfer to the account");

                    break;

                default:

                    System.out.println("Input invalid. Please try again.");

                    continue;
            }

            break;
        }

        sc.close();
    }
}
