import java.util.Set;

public class Courses {
    private int Credit;
    private String Code;
    private Set<String> PreReq;
    
    public Courses(int Credit, String Code){
        this.Credit = Credit;
        this.Code = Code;
    }
    public Courses(int Credit, String code,String pre1){
        this.Credit = Credit;
        this.Code = Code;
        PreReq.add(pre1);
    }
    public Courses(int Credit, String code,String pre1,String pre2){
        this.Credit = Credit;
        this.Code = Code;
        PreReq.add(pre1);
        PreReq.add(pre2);
    }
    
    public int getCredit(){
        return Credit;
    }
    public String getCode(){
        return Code;
    }
    public Set<String> getPreReq(){
        return PreReq;
    }
    public void setPrerequire(String course) {
        PreReq.add(course);
    }
    public void setCredit(int credit) {
        this.Credit = credit;
    }
    public void setCode(String code) {
        this.Code = code;
    }

    public String toString() {
        return "CourseID: " + Code ;
    }
}

