package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Club {
    private int clubId;
    private String clubName;
    private int maxMembers;

    private List<Student> members;
    private PriorityQueue<MembershipAllocation> waitlist;

    public Club(int clubId, String clubName, int maxMembers, Comparator<MembershipAllocation>comparator){
        this.clubId = clubId;
        this.clubName = clubName;
        this.maxMembers = maxMembers;

        members = new ArrayList<>();
        waitlist = new PriorityQueue<>(comparator);

    }

    public int getClubId(){
        return clubId;
    }
    public String getClubName(){
        return clubName;

    }
    public int getMaxMembers(){
        return maxMembers;
    }
    public List<Student> getMembers(){
        return members;
    }
    public PriorityQueue<MembershipAllocation> getWaitlist(){
        return waitlist;
    }

    public boolean isFull(){
        return members.size() >= maxMembers;
    }

}
