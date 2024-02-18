import java.util.ArrayList;

public class TrimesterData  {
    ArrayList<Courses> TriCourseList = new ArrayList<>();
    ArrayList<Lecturer> TriLecList = new ArrayList<>();
    ArrayList<Student> TriStuList = new ArrayList<>();

    public void addData(Courses course,Lecturer LID) {
        TriCourseList.add(course);
        TriLecList.add(LID);
    }
    public void addData(Courses course) {
        TriCourseList.add(course);
    }
    public void addLec(Lecturer LID) {
        TriLecList.add(LID);
    }
    public void addStu(Student SID) {
        TriStuList.add(SID);
    }

    public ArrayList<Courses> getCourseList() {
        return TriCourseList;
    }
    public ArrayList<Lecturer> getLecList() {
        return TriLecList;
    }
    public ArrayList<Student> getStuList() {
        return TriStuList;
    }

    public Courses searchCourses(String CID, ArrayList<Courses> searchArray) {
        for(int i = 0; i < TriCourseList.size(); i++) {
            if (searchArray.get(i).getCode().equals(CID)) {
                return searchArray.get(i);
            }
        }
    }
    public Lecturer searchLecturer(String LID, ArrayList<Lecturer> searchArray) {
        for(int i = 0; i < TriLecList.size(); i++) {
            if (searchArray.get(i).getLID().equals(LID)) {
                return searchArray.get(i);
            }
        }
    }
    public Student searchStudent(String SID, ArrayList<Student> searchArray) {
        for(int i = 0; i < TriStuList.size(); i++) {
            if (searchArray.get(i).getSId().equals(SID)) {
                return searchArray.get(i);
            }
        }
    }
    public void printSemester() {
        System.out.println();
        for(int i = 0; i < TriCourseList.size(); i++)
            System.out.print("CourseList: " + TriCourseList.get(i));
        for(int i = 0; i < TriLecList.size(); i++)
            System.out.println("Lecturer : " + TriLecList.get(i));
        for(int i = 0; i < TriStuList.size(); i++)
        System.out.println("StudentList: " + TriStuList.get(i));
    }
}
