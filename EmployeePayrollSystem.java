import java.util.Scanner;

public class EmployeePayrollSystem {
    private static final int MAX_EMPLOYEES = 100;
    private static String[] names = new String[MAX_EMPLOYEES];
    private static String[] idNumbers = new String[MAX_EMPLOYEES];
    private static String[] months = new String[MAX_EMPLOYEES];
    private static int[] workPeriods = new int[MAX_EMPLOYEES];
    private static String[] positions = new String[MAX_EMPLOYEES];
    private static int[] workDays = new int[MAX_EMPLOYEES];
    private static int[] overtimes = new int[MAX_EMPLOYEES];
    private static int[] salaryPerDays = new int[MAX_EMPLOYEES];
    private static int employeeCount = 0;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("              Employee Payroll              ");
        System.out.println("============================================");
    
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            
            // Validate input to ensure it's an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
            
            choice = scanner.nextInt();
    
            switch (choice) {
                case 1:

                    addEmployee(scanner);
                    break;

                case 2:

                    checkSalary();
                    break;

                case 3:

                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
    
        } while (choice != 3);
    
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nEmployee Payroll System Menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Check Salary");
        System.out.println("3. Exit");
    }

    private static void addEmployee(Scanner scanner) {
        if (employeeCount < MAX_EMPLOYEES) {
            System.out.print("\nEnter employee name: ");
            names[employeeCount] = scanner.next();

            System.out.print("Enter ID number: ");
            idNumbers[employeeCount] = scanner.next();

            System.out.print("Enter month: ");
            months[employeeCount] = scanner.next();

            System.out.print("Work period(year): ");
            workPeriods[employeeCount] = scanner.nextInt();

            scanner.nextLine();
            System.out.print("Position(Part timer/Full timer): ");
            positions[employeeCount] = scanner.nextLine();

            if (positions[employeeCount].equalsIgnoreCase("Part timer")) {
                System.out.print("Category(1/2): ");
                int category = scanner.nextInt();

                if (category == 1) {
                    salaryPerDays[employeeCount] = 50000;
                } else if (category == 2) {
                    salaryPerDays[employeeCount] = 60000;
                } else {
                    System.out.print("Invalid category");
                    return;
                }

            } else if (positions[employeeCount].equalsIgnoreCase("Full timer")) {
                System.out.print("Category(1/2/3): ");
                int category = scanner.nextInt();

                if (category == 1) {
                    salaryPerDays[employeeCount] = 75000;
                } else if (category == 2) {
                    salaryPerDays[employeeCount] = 85000;
                } else if (category == 3) {
                    salaryPerDays[employeeCount] = 100000;
                } else {
                    System.out.print("Invalid category");
                    return;
                }

            } else {
                System.out.print("Invalid position");
                return;
            }

            System.out.print("Work days: ");
            workDays[employeeCount] = scanner.nextInt();

            System.out.print("Overtime(hour): ");
            overtimes[employeeCount] = scanner.nextInt();

            employeeCount++;

            System.out.println("Employee added successfully!");

        } else {
            System.out.println("Maximum number of employees reached.");
        }
    }

    private static int findEmployeeIndex(String name, String idNumber, String month) {
        for (int i = 0; i < employeeCount; i++) {
            if (names[i].equalsIgnoreCase(name) && idNumbers[i].equalsIgnoreCase(idNumber) && months[i].equalsIgnoreCase(month)) {
                return i;
            }
        }
        return -1;
    }
    
    private static void checkSalary() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nCheck Salary Options:");
        System.out.println("1. Check salary for a specific month");
        System.out.println("2. Check salary for all months");
        System.out.print("Enter your choice: ");
    
        int option = scanner.nextInt();
    
        switch (option) {
            case 1:

                checkSalaryForSpecificMonth(scanner);
                break;
    
            case 2:

                checkSalaryForAllMonths();
                break;
    
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
    
    private static void checkSalaryForSpecificMonth(Scanner scanner) {
        System.out.print("\nEnter employee name: ");
        String name = scanner.next();
        System.out.print("Enter ID number: ");
        String idNumber = scanner.next();
        System.out.print("Enter month: ");
        String month = scanner.next();
    
        int index = findEmployeeIndex(name, idNumber, month);
        if (index != -1) {
            System.out.println("\nSalary Information:");
            System.out.println("-----------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n",
            "Month", "Basic Salary", "Bonus", "Allowance", "Salary", "Tax", "Net Salary");
            System.out.println("-----------------------------------------------------------------------------------------");
            displaySalaryInformation(index);
        } else {
            System.out.println("Employee not found/wrong ID number for the specified month.");
        }
    }
    
    private static void checkSalaryForAllMonths() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nEnter employee name: ");
        String name = scanner.next();
        System.out.print("Enter ID number: ");
        String idNumber = scanner.next();
    
        System.out.println("\nSalary Information for All Months:");
    
        boolean employeeFound = false;
    
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n",
            "Month", "Basic Salary", "Bonus", "Allowance", "Salary", "Tax", "Net Salary");
        System.out.println("-----------------------------------------------------------------------------------------");

        for (int i = 0; i < employeeCount; i++) {
            if (names[i].equalsIgnoreCase(name) && idNumbers[i].equalsIgnoreCase(idNumber)) {
                displaySalaryInformation(i);
                employeeFound = true;
            }
        }
    
        if (!employeeFound) {
            System.out.println("Employee not found/wrong ID number.");
        }
    }
    
    private static void displaySalaryInformation(int index) {
        int basicSalary = workDays[index] * salaryPerDays[index];
        int bonus = overtimes[index] * 10000;
        int allowances = 50000;
        int salary = basicSalary + bonus + allowances;
    
        double tax, netSalary;
        if (positions[index].equalsIgnoreCase("Part timer")) {
            if (basicSalary > 50000) {
                tax = salary * 0.02;
            } else {
                tax = 0;
            }
        } else if (positions[index].equalsIgnoreCase("Full timer")) {
            if (basicSalary > 75000) {
                tax = salary * 0.1;
            } else {
                tax = 0;
            }
        } else {
            System.out.println("Invalid position");
            return;
        }
    
        netSalary = salary - tax;
    
        System.out.printf("%-10s | %-10s   | %-10s | %-10s | %-10s | %-10s | %-10s%n",
            months[index], basicSalary, bonus, allowances, salary, tax, netSalary);
    }

}