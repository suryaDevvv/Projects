// =========================
// FILE: Main.java
// =========================

import model.Club;
import model.Student;
import service.ClubService;
import util.Comparators;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ClubService clubService =
                new ClubService();

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" CLUB MANAGEMENT SYSTEM ");
            System.out.println("==============================");

            System.out.println("1. Add Club");
            System.out.println("2. Apply Membership");
            System.out.println("3. Cancel Membership");
            System.out.println("4. View Members");
            System.out.println("5. View Waitlist");
            System.out.println("6. View All Clubs");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Club ID: ");
                    int clubId = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Club Name: ");
                    String clubName = sc.nextLine();

                    System.out.print("Enter Max Members: ");
                    int maxMembers = sc.nextInt();

                    Club club = new Club(
                            clubId,
                            clubName,
                            maxMembers,
                            Comparators.membershipComparator
                    );

                    clubService.addClub(club);

                    System.out.println("Club Added Successfully!");

                    break;

                case 2:

                    System.out.print("Enter Club ID: ");
                    int cid = sc.nextInt();

                    Club selectedClub =
                            clubService.getClub(cid);

                    if (selectedClub == null) {

                        System.out.println("Club Not Found!");
                        break;
                    }

                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student student =
                            new Student(sid, sname, cgpa);

                    clubService.applyMembership(
                            selectedClub,
                            student
                    );

                    break;

                case 3:

                    System.out.print("Enter Club ID: ");
                    int cancelClubId = sc.nextInt();

                    Club cancelClub =
                            clubService.getClub(cancelClubId);

                    if (cancelClub == null) {

                        System.out.println("Club Not Found!");
                        break;
                    }

                    System.out.print("Enter Student ID to Cancel: ");
                    int cancelStudentId = sc.nextInt();

                    clubService.cancelMembership(
                            cancelClub,
                            cancelStudentId
                    );

                    break;

                case 4:

                    System.out.print("Enter Club ID: ");
                    int memberClubId = sc.nextInt();

                    Club memberClub =
                            clubService.getClub(memberClubId);

                    if (memberClub == null) {

                        System.out.println("Club Not Found!");
                        break;
                    }

                    clubService.viewMembers(memberClub);

                    break;

                case 5:

                    System.out.print("Enter Club ID: ");
                    int waitClubId = sc.nextInt();

                    Club waitClub =
                            clubService.getClub(waitClubId);

                    if (waitClub == null) {

                        System.out.println("Club Not Found!");
                        break;
                    }

                    clubService.viewWaitlist(waitClub);

                    break;

                case 6:

                    clubService.viewAllClubs();

                    break;

                case 7:

                    System.out.println("Exiting...");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}