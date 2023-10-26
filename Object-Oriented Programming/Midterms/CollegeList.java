import java.util.Scanner;

public class CollegeList {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option = chooseOption();
        String infoStr = "name, contact number, salary, and department";
        boolean isRegular = false, isStudent = false;
        switch (option) {
            case "E":
                System.out.printf("Type the employee's %s\n", infoStr);
                break;
            case "F":
                isRegular = promptFaculty();
                System.out.printf("Type the faculty member's %s\n", infoStr);
                break;
            case "S":
                isStudent = true;
                System.out.println("Type the student's name, contact number, program, and year level");
        }
        System.out.println("Press Enter after every input.");

        String name = sc.nextLine();
        String contactNum = sc.nextLine();
        if (isStudent) {
            String program = sc.nextLine();
            int yearLevel = chooseSchoolYear();
            Student student = new Student();
            student.setName(name);
            student.setContactNum(contactNum);
            student.setProgram(program);
            student.setYearLevel(yearLevel);
            displayStudent(student);
        } else {
            double salary = sc.nextDouble();
            String department = sc.next();
            if (option.equals("E")) {
                Employee employee = new Employee();
                employee.setName(name);
                employee.setContactNum(contactNum);
                employee.setDepartment(department);
                employee.setSalary(salary);
                displayEmployee(employee);
            } else {
                Faculty faculty = new Faculty();
                faculty.setStatus(isRegular);
                faculty.setName(name);
                faculty.setContactNum(contactNum);
                faculty.setDepartment(department);
                faculty.setSalary(salary);
                displayFaculty(faculty);
            }
        }
    }

    private static void displayPerson(Person person) {
        System.out.println("-----------------------------");
        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Contact Number: %s\n", person.getContactNum());
    }

    private static void displayStudent(Student student) {
        displayPerson(student);
        System.out.printf("Program: %s\n", student.getProgram());
        System.out.printf("Year Level: %s\n", student.getYearLevel());
    }

    private static void displayEmployee(Employee employee) {
        displayPerson(employee);
        System.out.printf("Salary: %s\n", employee.getSalary());
        System.out.printf("Department: %s\n", employee.getDepartment());
    }

    private static void displayFaculty(Faculty faculty) {
        displayEmployee(faculty);
        System.out.printf("Regular/Tenured: %s\n", faculty.isRegular());
    }

    private static int chooseSchoolYear() {
        try {
            int schoolYear = sc.nextInt();
            if (schoolYear >= 1 && schoolYear <= 4) {
                return schoolYear;
            }
            System.out.println("Only enter school years between 1 to 4!");
            return chooseSchoolYear();
        } catch (Exception error) {
            return chooseSchoolYear();
        }
    }

    private static boolean promptFaculty() {
        String output = input("Is the faculty member regular/tenured? (Y/N)");
        if (output.equalsIgnoreCase("Y") || output.equalsIgnoreCase("N")) {
            return output.equalsIgnoreCase("Y");
        }
        return promptFaculty();
    }

    private static String chooseOption() {
        String option = input("Press E for Employee, F for Faculty, or S for Student");
        if (option.equalsIgnoreCase("E") ||
                option.equalsIgnoreCase("F") ||
                option.equalsIgnoreCase("S")) {
            return option.toUpperCase();
        }
        return chooseOption();
    }

    private static String input(String prompt) {
        System.out.printf("%s: ", prompt);
        return sc.nextLine();
    }
}

class Person {
    private String name;
    private String contactNum;

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }

    public void setContactNum(String c) {
        this.contactNum = c;
    }

    public String getContactNum() {
        return this.contactNum;
    }
}

class Student extends Person {
    private String program;
    private int yearLevel;

    public void setProgram(String p) {
        this.program = p;
    }

    public String getProgram() {
        return this.program;
    }

    public void setYearLevel(int y) {
        this.yearLevel = y;
    }

    public int getYearLevel() {
        return this.yearLevel;
    }
}

class Employee extends Person {
    private double salary;
    private String department;

    public void setSalary(double s) {
        this.salary = s;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setDepartment(String d) {
        this.department = d;
    }

    public String getDepartment() {
        return department;
    }
}

class Faculty extends Employee {
    private boolean status;

    public void setStatus(boolean s) {
        this.status = s;
    }

    public boolean isRegular() {
        return this.status;
    }
}
