package java_project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Attendee {
    private String name;
    private String email;

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Attendee: " + name + ", Email: " + email;
    }
}

class Event {
    private String name;
    private String date;
    private String venue;
    private ArrayList<Attendee> attendees;

    public Event(String name, String date, String venue) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.attendees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }

    public void registerAttendee(Attendee attendee) {
        attendees.add(attendee);
        System.out.println("Attendee registered successfully for the event!");
    }

    public void displayAttendees() {
        if (attendees.isEmpty()) {
            System.out.println("No attendees registered for this event.");
        } else {
            for (Attendee attendee : attendees) {
                System.out.println(attendee);
            }
        }
    }

    @Override
    public String toString() {
        return "Event: " + name + ", Date: " + date + ", Venue: " + venue;
    }
}

class EventManager {
    private Map<String, Event> events;

    public EventManager() {
        this.events = new HashMap<>();
    }

    public void addEvent(Event event) {
        events.put(event.getName(), event);
        System.out.println("Event added successfully!");
    }

    public void registerAttendee(String eventName, Attendee attendee) {
        Event event = events.get(eventName);
        if (event != null) {
            event.registerAttendee(attendee);
        } else {
            System.out.println("Event not found. Please check the event name and try again.");
        }
    }

    public void displayEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            for (Event event : events.values()) {
                System.out.println(event);
            }
        }
    }

    public void displayAttendees(String eventName) {
        Event event = events.get(eventName);
        if (event != null) {
            event.displayAttendees();
        } else {
            System.out.println("Event not found. Please check the event name and try again.");
        }
    }
}

public class MainEventManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Event");
            System.out.println("2. Register Attendee");
            System.out.println("3. Display Events");
            System.out.println("4. Display Attendees for an Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter event name: ");
                    String eventName = scanner.nextLine();
                    System.out.print("Enter event date: ");
                    String eventDate = scanner.nextLine();
                    System.out.print("Enter event venue: ");
                    String eventVenue = scanner.nextLine();

                    Event newEvent = new Event(eventName, eventDate, eventVenue);
                    eventManager.addEvent(newEvent);
                    break;

                case 2:
                    System.out.print("Enter event name to register attendee: ");
                    String registerEventName = scanner.nextLine();
                    System.out.print("Enter attendee name: ");
                    String attendeeName = scanner.nextLine();
                    System.out.print("Enter attendee email: ");
                    String attendeeEmail = scanner.nextLine();

                    Attendee newAttendee = new Attendee(attendeeName, attendeeEmail);
                    eventManager.registerAttendee(registerEventName, newAttendee);
                    break;

                case 3:
                    eventManager.displayEvents();
                    break;
                case 4:
                    System.out.print("Enter event name to display attendees: ");
                    String displayEventName = scanner.nextLine();
                    eventManager.displayAttendees(displayEventName);
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
