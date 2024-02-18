import java.util.Set;
import java.util.TreeSet;

class Student { 
    public Integer id;
    public String name;
    private Set<String> Trimester1 = new TreeSet<>();
    private Set<String> Trimester2 = new TreeSet<>();
    private Set<String> Trimester3 = new TreeSet<>();

    public Student(int sid) {
        this.id = sid;
        this.name = null;
    }
    public Student (int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "StudentID: " + id + ", StudentName: " + name + "\nTrimester1: " + Trimester1 + "\nTrimester2: " + Trimester2  + "\nTrimester3: " + Trimester3;
    }

    public String getName() {
        return name;
    }

    public Integer getSId() {
        return id;
    }

    public boolean searchT1Course(String SCourse) {
        if (Trimester1.contains(SCourse)) 
            return true;
        else 
            return false;
    }
    public boolean searchT2Course(String SCourse) {
        if (Trimester2.contains(SCourse)) 
            return true;
        else 
            return false;
    }
    public boolean searchT3Course(String SCourse) {
        if (Trimester3.contains(SCourse)) 
            return true;
        else 
            return false;
    }

    public void addCoursesToT1(String course){
        Trimester1.add(course);
    }
    public void addCoursesToT2(String course){
        Trimester2.add(course);
    }
    public void addCoursesToT3(String course){
        Trimester3.add(course);
    }
    public void clearClass() {
        Trimester1 = null;
        Trimester2 = null;
        Trimester3 = null;
    }
}

class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student(120, "Ali");
        student1.addCoursesToT1("CS100");
        student1.addCoursesToT2("CS200");
        student1.addCoursesToT3("CS300");
        System.out.println(student1.toString());
        student1.clearClass();
        System.out.println(student1.toString());
    }
}
