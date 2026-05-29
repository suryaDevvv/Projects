package util;

import model.MembershipAllocation;

import java.util.Comparator;

public class Comparators {
    public static Comparator<MembershipAllocation> membershipComparator =
            (a,b) -> {
                   if(Double.compare(b.getStudent().getCgpa(),a.getStudent().getCgpa())!=0){
                       return Double.compare(b.getStudent().getCgpa(),a.getStudent().getCgpa());
                   }
                   return a.getApplicationTime().compareTo(b.getApplicationTime());
            };
}
