package model;

import java.time.LocalDateTime;

public class MembershipAllocation {
    private Student student;
    private LocalDateTime applicationTime;

    public MembershipAllocation(Student student){
        this.student = student;
        this.applicationTime = applicationTime;
    }

    public Student getStudent(){
        return student;
    }
    public LocalDateTime getApplicationTime(){
        return applicationTime;
    }

}
