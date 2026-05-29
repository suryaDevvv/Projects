package model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private int eventId;
    private String eventName;
    private int maxParticipants;
    private Club club;
    private List<Student> participants;

    public Event(int eventId,String eventName,int maxParticipants,Club club){
        this.eventId = eventId;
        this.eventName = eventName;
        this.maxParticipants = maxParticipants;
        this.club = club;
        participants = new ArrayList<>();
    }
}
