import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class TestMain {
    public static void main(String[] args) {

        TrimesterData trim1 = new TrimesterData();
        TrimesterData trim2 = new TrimesterData();
        TrimesterRun t1C1= new TrimesterRun("T001", 3, "CS100");

        Set<Integer> allStudentList = new TreeSet<>();
        Student stu1 = new Student(120, "Ali");
        allStudentList.add(stu1.getSId());

        int profile = 0;
        int option;
        String course;
        Integer student;
        String lecturer;
        int credit;
        boolean exitProgram = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Course Manager");
        do {
            System.out.println("Select your profile:");
            System.out.println("1. Admin");
            System.out.println("2. Student");
            System.out.println("3. Lecturer");
            System.out.println("4. TrimesterSummary");
            System.out.println("5. EXIT PROGRAM");
            System.out.print("Enter your choice (1~5): ");

            if (sc.hasNextInt()) {
                profile = sc.nextInt();
                sc.nextLine();

                switch (profile) {
                    case 1: // ADMIN
                        System.out.print("Please Enter Password: ");
                        String password = sc.nextLine();
                        if (password.equals("12345")) {
                            System.out.println("Welcome, Admin");
                            boolean exitAdminMenu = false;
                            String confirmation;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.Add Courses");
                                System.out.println("2.Add Student");
                                System.out.println("3.Add Lecturer");
                                System.out.println("4.Assign Courses");
                                System.out.println("5.Logout");
                                System.out.print("Enter your choice (1/2/3/4/5): ");
                                option = sc.nextInt();
                                sc.nextLine(); // Consume the newline

                                switch (option) {
                                    case 1:
                                        do {
                                            int trimester =  chooseTrimester();
                                            Courses newCourse;
                                            System.out.println("Please Enter Course Credit: ");
                                            credit = sc.nextInt();
                                            System.out.println("Please Enter Course ID: ");
                                            course = sc.nextLine();
                                            boolean checkError = false;
                                            do {
                                                System.out.println("Do course have PreRequire? (Y/N)");
                                                String select = sc.nextLine();
                                                String preCourse1;
                                                String preCourse2;
                                                if (select.toLowerCase() == "y") {
                                                    System.out.println("How many PreRequire? ");
                                                    int number = sc.nextInt();
                                                    if (number == 1) {
                                                        preCourse1 = sc.nextLine();
                                                        newCourse = new Courses(credit, course,preCourse1);
                                                    } else if (number == 2) {
                                                        preCourse1 = sc.nextLine();
                                                        preCourse2 = sc.nextLine();
                                                        newCourse = new Courses(credit, course,preCourse1,preCourse2);
                                                    }
                                                }else if (select.toLowerCase() == "n") {
                                                    newCourse = new Courses(credit, course);
                                                }else {
                                                    System.out.println("Error input");
                                                    checkError = true;
                                                }
                                            }while (checkError == true);
                                            
                                            
                                            if (trimester == 1)
                                                trim1.addData(newCourse.getCode());
                                            else if (trimester == 2) 
                                                trim2.addData(newCourse.getCode());
                                            System.out.println(course + " has been successfully added");
                                            System.out.println("Do you still want to add? (Y/N)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 2:
                                        do {
                                            Student newStudent;
                                            System.out.println("Please Enter Student ID");
                                            student = sc.nextInt();
                                            newStudent = new Student(student);
                                            System.out.println("Please Enter Student Name");
                                            String name = sc.nextLine();
                                            newStudent.setName(name);
                                            System.out.println(student + " has been successfully added");
                                            System.out.println("Do you still want to add? (Y/N)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 3:
                                        do {
                                            Lecturer newLecturer;
                                            System.out.println("Please Enter Lecturer ID and Name ");
                                            lecturer = sc.nextLine();
                                            newLecturer = new Lecturer(lecturer);
                                            System.out.println("Please Enter Lecturer Name");
                                            String name = sc.nextLine();
                                            newLecturer.setName(name);
                                            System.out.println(lecturer + " has been successfully added");
                                            System.out.println("Do you still want to add? (Y/N)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("Y"));
                                        break;
                                    case 4:
                                        do {
                                            // ASSIGN COURSES TO LECTURER
                                            int trimester =  chooseTrimester();
                                            TrimesterRun selectCourse;
                                            System.out.println("Please Enter Course ID ");
                                            course = sc.nextLine();
                                            
                                            System.out.println("Please Enter Lecturer ID");
                                            lecturer = sc.nextLine();
                                            if (trimester == 1) {
                                                if (trim1.getCourseList().contains(course)) {
                                                    selectCourse = new 
                                                }
                                            }
                                            System.out.println(course + " has successfully been assigned to " + lecturer);
                                            System.out.println("Do you still want to assign (yes/no)");
                                            confirmation = sc.nextLine();
                                            System.out.println("Do you still want to assign (yes/no)");
                                            confirmation = sc.nextLine();
                                        } while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 5:
                                        exitAdminMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option, Please Select Again");
                                }
                            } while (!exitAdminMenu);

                        } else
                            System.out.println("Password Incorrect, Access Denied");
                        break;

                    case 2: // STUDENT

                        System.out.print("Please enter you Student ID: ");
                        Integer SID = sc.nextInt();
                        boolean foundStudent = searchStudentID(allStudentList, SID);
                        
                        if (foundStudent) {
                            System.out.println("Welcome, Student " + SID);
                            boolean exitStudentMenu = false;
                            String confirmation;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses");
                                System.out.println("2.Enroll Courses");
                                System.out.println("3.Drop Courses");
                                System.out.println("4.Logout");
                                System.out.print("Enter your choice (1/2/3/4): ");
                                option = sc.nextInt();
                                sc.nextLine();
                                switch (option) {
                                    case 1://VIEW ENROLLED COURSES
                                        System.out.println("These are the courses you have enrolled for each Trimester");
                                        System.out.println("Trimester I: " + CourseTrimesterI);
                                        System.out.println("Trimester II: "+ CourseTrimesterII);
                                        System.out.println("Trimester III: "+ CourseTrimesterIII);
                                        break;

                                    case 2://ENROLL COURSE
                                        do{
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
                                        int trimester = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Please key in course ID");                                         
                                            switch(trimester){
                                                case 1:
                                                    courseID1 = sc.nextLine();
                                                    CourseTrimesterI.add(courseID1);
                                                    if (courseID1 == "CS101") 
                                                        StudentCoListA.add(SID);
                                                    else
                                                        StudentCoListB.add(SID);
                                                    System.out.println("You have enrolled for course: " + courseID1 + " in Trimester " + trimester);
                                                    break;
                                                case 2:
                                                    courseID2 = sc.nextLine();
                                                    CourseTrimesterII.add(courseID2);
                                                    if (courseID2 == "CS101") 
                                                        StudentCoListA.add(SID);
                                                    else
                                                        StudentCoListB.add(SID);
                                                    System.out.println("You have enrolled for course: " + courseID2 + " in Trimester " + trimester);
                                                    break;
                                                case 3:
                                                    courseID3 = sc.nextLine();
                                                    CourseTrimesterIII.add(courseID3);
                                                    if (courseID3 == "CS101") 
                                                        StudentCoListA.add(SID);
                                                    else
                                                        StudentCoListB.add(SID);
                                                    System.out.println("You have enrolled for course: " + courseID3 + " in Trimester " + trimester);
                                                    break;
                                            }
                                        System.out.println("Would you like to enroll more courses? (yes/no)");
                                        confirmation = sc.nextLine();
                                        }while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 3://DROPOUT COURSE
                                        do{
                                        System.out.println("Select your trimester");
                                        System.out.println("Trimester I = 1, Trimester II = 2, Trimester III = 3");
                                        int trimester = sc.nextInt();
                                        sc.nextLine();
                                        System.out.println("Please key in course ID");
                                        switch(trimester){
                                                case 1:
                                                    courseID1 = sc.nextLine();
                                                    CourseTrimesterI.remove(courseID1);
                                                    if (courseID1 == "CS101") 
                                                        StudentCoListA.remove(SID);
                                                    else
                                                        StudentCoListB.remove(SID);
                                                    System.out.println("You have dropped course: " + courseID1 + " in Trimester " + trimester);
                                                    break;
                                                case 2:
                                                    courseID2 = sc.nextLine();
                                                    CourseTrimesterII.remove(courseID2);
                                                    if (courseID2 == "CS101") 
                                                        StudentCoListA.remove(SID);
                                                    else
                                                        StudentCoListB.remove(SID);
                                                    System.out.println("You have dropped course: " + courseID2 + " in Trimester " + trimester);
                                                    break;
                                                case 3:
                                                    courseID3 = sc.nextLine();
                                                    CourseTrimesterIII.remove(courseID3);
                                                    if (courseID3 == "CS101") 
                                                        StudentCoListA.remove(SID);
                                                    else
                                                        StudentCoListB.remove(SID);
                                                    System.out.println("You have dropped course: " + courseID3 + " in Trimester " + trimester);
                                                    break;
                                            }
                                        System.out.println("Would you like to drop more courses? (yes/no)");
                                        confirmation = sc.nextLine();
                                        }while (confirmation.equalsIgnoreCase("yes"));
                                        break;
                                    case 4:
                                        exitStudentMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                    }
                                } while (!exitStudentMenu);
                            } else
                            System.out.println("ID not found, You are not registered as a student");
                        break;

                    case 3: // LECTURER
                        System.out.print("Please enter you Lecturer ID: ");
                        String LID = sc.nextLine();
                        boolean foundLecturer = searchLecturerID(LecturerList, LID);
                        if (foundLecturer) {
                            System.out.println("Welcome Lecturer " + LID);
                            boolean exitLecturerMenu = false;
                            do {

                                System.out.println("Select OPTION");
                                System.out.println("1.View Courses Assigned");
                                System.out.println("2.View Students in Courses");
                                System.out.println("3.Logout");
                                System.out.print("Enter your choice (1/2/3/): ");
                                option = sc.nextInt();

                                sc.nextLine();

                                switch (option) {
                                    case 1: // print the course teach
                                        System.out.println("You have assigned the following class: ");
                                        for (int i = 0; i < LeTeachList.size(); i++) {
                                            System.out.print(LeTeachList.get(i) +", ");
                                        }
                                        System.out.println("");
                                        break;
                                    case 2:
                                        System.out.println("Type the course you want to check: ");
                                        String checkCourse = sc.nextLine();
                                        System.out.println("The students in course: ");
                                        if (checkCourse.equals("CS101")) {  // decide course
                                            for (int i = 0; i < StudentCoListA.size(); i++) {
                                            System.out.println( (i+1) +".  " + StudentCoListA.get(i));
                                            }
                                            System.out.println("");
                                        }
                                        else {
                                            for (int i = 0; i < StudentCoListB.size(); i++) {
                                            System.out.println( (i+1) +".  " + StudentCoListB.get(i));
                                            }
                                            System.out.println("");
                                        }
                                        break;
                                    case 3:
                                        exitLecturerMenu = true;
                                        break;
                                    default:
                                        System.out.println("Invalid option");
                                }

                            } while (!exitLecturerMenu);
                        } else
                            System.out.println("ID not found, You are not registered as a lecturer");
                        break;
                    case 4:
                        System.out.println(trim1);
                        System.out.println(trim2);
                    case 5:
                        exitProgram = true;
                        break;
                    default:
                        System.out.println("Invalid profile, Please Select Again");
                        break;

                }
            } else {
                System.out.println("Please enter an integer");
                sc.nextLine(); // Consume the invalid input
            }
        } while (!exitProgram);

    }

    // Method to identify Student
    public static boolean searchStudentID(Set<Integer> StudentList, Integer SID) {
        if (StudentList.contains(SID)) 
            return true;
        else
            return false;
    }
    // Select Trimester
    public static int chooseTrimester() {
        Scanner sc = new Scanner(System.in);
        int trimester = 0;
        boolean check = false;
        do {
            System.out.println("Please select the Trimester you choose: ");
            trimester = sc.nextInt();
            sc.nextLine();
            sc.close();
            if (trimester != 1 || trimester != 2 || trimester != 3) {
                System.out.print("Error input!!");
                check = true;
            }
        } while (check == true);

        return trimester;
    }
}
