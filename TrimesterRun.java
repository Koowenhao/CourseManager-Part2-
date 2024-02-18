import java.util.Map;

public class TrimesterRun {
    private Courses course;
    private Lecturer lecturer;
    private Map<Integer,String> StudentList;

    public TrimesterRun(String IDLecture,int Credit, String code){
        lecturer.setLID(IDLecture);
        lecturer.addCourse(code);
        course.setCredit(Credit);
        course.setCode(code);
    }
    public TrimesterRun(String IDLecture,int Credit, String code,String pre1){
        lecturer.setLID(IDLecture);
        lecturer.addCourse(code);
        course.setCredit(Credit);
        course.setCode(code);
        course.setPrerequire(pre1);
    }
    public TrimesterRun(String IDLecture,int Credit, String code,String pre1,String pre2){
        lecturer.setLID(IDLecture);
        lecturer.addCourse(code);
        course.setCredit(Credit);
        course.setCode(code);
        course.setPrerequire(pre1);
        course.setPrerequire(pre2);
    }
    public TrimesterRun(String IDLecture,Courses course) {
        lecturer.setLID(IDLecture);
        lecturer.addCourse(course.getCode());
        this.course = course;
    }
    public void addStudent(Integer id) {
        StudentList.put(id, null);
    }
    public void addStudent(Integer id,String name) {
        StudentList.put(id, name);
    }
    public Courses getCourse() {
        return course;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }
    public Map<Integer,String> getStudentList() {
        return StudentList;
    }
}
