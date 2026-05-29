package service;

import model.Club;
import model.MembershipAllocation;
import model.Student;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClubService {
    Map<Integer, Club> clubs = new HashMap<>();

    public void addClub(Club club){
        clubs.put(club.getClubId(), club);
    }
    public Club getClub(int clubId) {
        return clubs.get(clubId);
    }
    public void applyMembership(Club club,Student student){
        for(Student s:club.getMembers()){
            if(s.getStudentId()==student.getStudentId()){
                System.out.println("Already a Member!");
                return;
            }
        }
        if(!club.isFull()){
            club.getMembers().add(student);
            System.out.println("Membership Approved!");
        }
        else{
            MembershipAllocation application = new MembershipAllocation(student);
            club.getWaitlist().offer(application);
            System.out.println("Club full. Added to the waitlist");
        }

    }
    public void cancelMembership(Club club,int studentId){
        Iterator<Student> iterator = club.getMembers().iterator();
        while(iterator.hasNext()){
            Student s = iterator.next();
            if(s.getStudentId()==studentId){
                iterator.remove();
                System.out.println("Membership Cancelled");
                backfillMembership(club);
                return;
            }
        }
        System.out.println("Student not found");
    }

    private void backfillMembership(Club club) {

        if (!club.getWaitlist().isEmpty()) {

            MembershipAllocation application =
                    club.getWaitlist().peek();

            club.getMembers().add(application.getStudent());

            System.out.println(
                    application.getStudent().getName()
                            + " promoted from waitlist.");
        }
    }
    public void viewMembers(Club club) {

        System.out.println("\n===== MEMBERS =====");

        if (club.getMembers().isEmpty()) {

            System.out.println("No Members.");
            return;
        }

        for (Student s : club.getMembers()) {
            System.out.println(s);
        }
    }

    public void viewWaitlist(Club club) {

        System.out.println("\n===== WAITLIST =====");

        if (club.getWaitlist().isEmpty()) {

            System.out.println("Waitlist Empty.");
            return;
        }

        for (MembershipAllocation app :
                club.getWaitlist()) {

            System.out.println(app.getStudent());
        }
    }
    public void viewAllClubs() {

        System.out.println("\n===== CLUBS =====");

        if (clubs.isEmpty()) {

            System.out.println("No clubs added.");
            return;
        }

        for (Club c : clubs.values()) {

            System.out.println(
                    c.getClubId()
                            + " | "
                            + c.getClubName()
                            + " | Capacity: "
                            + c.getMembers().size()
                            + "/"
                            + c.getMaxMembers()
            );
        }
    }
}
