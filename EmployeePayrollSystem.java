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
    private static String[][] employeeHistory = new String[MAX_EMPLOYEES][8]; // 2D array to store employee data
    private static int historyCount = 0;
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
            
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
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
                    checkHighestSalary();
                    break;
                case 4:
                    displayEmployeeHistory();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nEmployee Payroll System Menu:");
        System.out.println("1. Add Employee");
        System.out.println("2. Check Salary");
        System.out.println("3. Check Highest Salary");
        System.out.println("4. History");
        System.out.println("5. Exit");
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

            employeeHistory[historyCount][0] = names[employeeCount];
            employeeHistory[historyCount][1] = idNumbers[employeeCount];
            employeeHistory[historyCount][2] = months[employeeCount];
            employeeHistory[historyCount][3] = String.valueOf(workPeriods[employeeCount]);
            employeeHistory[historyCount][4] = positions[employeeCount];
            employeeHistory[historyCount][5] = String.valueOf(workDays[employeeCount]);
            employeeHistory[historyCount][6] = String.valueOf(overtimes[employeeCount]);
            employeeHistory[historyCount][7] = String.valueOf(salaryPerDays[employeeCount]);

            historyCount++;
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
        String name = scanner.nextLine();
        System.out.print("Enter ID number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter month: ");
        String month = scanner.nextLine();
    
        int index = findEmployeeIndex(name, idNumber, month);
        if (index != -1) {
            System.out.println("\nSalary Information:");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n",
            "Month", "Basic Salary", "Bonus", "Allowance", "Salary", "Tax", "Net Salary");
            System.out.println("------------------------------------------------------------------------------------------");
            displaySalaryInformation(index);
        } else {
            System.out.println("Employee not found/wrong ID number for the specified month.");
        }
    }
    
    private static void checkSalaryForAllMonths() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nEnter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID number: ");
        String idNumber = scanner.nextLine();
    
        System.out.println("\nSalary Information for All Months:");
    
        boolean employeeFound = false;

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n",
            "Month", "Basic Salary", "Bonus", "Allowance", "Salary", "Tax", "Net Salary");
        System.out.println("------------------------------------------------------------------------------------------");
    
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

    private static void checkHighestSalary() {
        if (employeeCount > 0) {
            int highestSalary = 0;
            int highestSalaryIndex = 0;

            for (int i = 0; i < employeeCount; i++) {
                int basicSalary = workDays[i]*salaryPerDays[i];
                int bonus = overtimes[i]*10000;
                int allowances = 50000;
                int salary = basicSalary + bonus + allowances;

                if (salary > highestSalary) {
                    highestSalary = salary;
                    highestSalaryIndex = i;
                }
            }
        
            System.out.println("\nEmployee with the Highest Salary: ");
            System.out.println("Name: " +names[highestSalaryIndex]);
            System.out.println("ID Number: " + idNumbers[highestSalaryIndex]);
            System.out.println("Month: " +months[highestSalaryIndex]);
            System.out.println("Salary: " +highestSalary);
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayEmployeeHistory() {
        if (historyCount > 0) {
            System.out.println("\nEmployee Data History:");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s%n" ,
                    "Name", "ID Number", "Month", "Work Period", "Position", "Work Days", "Overtime", "Salary Per Day");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            for (int i = 0; i < historyCount; i++) {
                System.out.printf("%-10s | %-10s | %-10s | %-10s  | %-10s | %-10s | %-10s | %-10s%n",
                        employeeHistory[i][0], employeeHistory[i][1], employeeHistory[i][2],
                        employeeHistory[i][3], employeeHistory[i][4], employeeHistory[i][5],
                        employeeHistory[i][6], employeeHistory[i][7]);
            }
        } else {
            System.out.println("No employee data in the history.");
        }
    }

}