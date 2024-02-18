import java.util.Set;
import java.util.TreeSet;

public class Lecturer {
    private String IDLecture;
    private String name;
    private Set<String> IDCourse = new TreeSet<>();

    public Lecturer(String ID){
        this.IDLecture = ID;
        this.name = null;
    }
    public Lecturer(String ID, String name) {
        this.IDLecture = ID;
        this.name = name;
    }
    public String getLID () {
        return IDLecture;
    }
    public String getName () {
        return name;
    }
    public Set<String> getCourse () {
        return IDCourse;
    }
    public void setLID(String id) {
        this.IDLecture = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    void addCourse(String courseToAdd) {
        IDCourse.add(courseToAdd);
    }
    void dropCourse(String courseToDrop) {
        IDCourse.remove(courseToDrop);
    }
    public String printLec() {
        return "ID = " + IDLecture + "Name = " + name ;
    }
    public String toString() {
        return "ID = " + IDLecture + "Name = " + name +"\nCourse: " + IDCourse ;
    }
    
    public boolean searchCourse (String course) {
        if (IDCourse.contains(course)) 
            return true;
        else 
            return false;
            
    }
}

class TestLecturer {
    public static void main(String[] args) {
        Lecturer l = new Lecturer("T001","Lee");
        l.addCourse("TMA2201");
        l.addCourse("TCP2010");
        System.out.println(l.toString());
        System.out.println(l.searchCourse("TMA2201"));
        
    }
}
