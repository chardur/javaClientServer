package studentChat;

import java.util.Arrays;
import java.util.List;

/**
 *  @author Charles Durfee
 *  @since  CS 3230 Summer 2018
 */

public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private double score;
    private List<String> responses;

    public Student (String firstName, String lastName, double score) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
        List<String> greetings = Arrays.asList("Hello", "Hi", "Hola", "Greetings human", "I come in peace");
        List<String> secondResp = Arrays.asList("Where am I?", "What year is it?", "Are you high?", "What do you want?", "Take me to your leader");
        List<String> thirdResp = Arrays.asList("Your crazy maaan", "Are you ok?", "That's not what I wanted", "Are you human?", "Im so high right now...");
        List<String> fourthResp = Arrays.asList("This is strange", "I cant see anything!", "Im typing with my feet", "How do I get to Mars from here?", "Whats that smell?");
        List<String> endings = Arrays.asList("Bye", "Adios", "Cya", "Later", "I'm Out!");
        responses = Arrays.asList(greetings.get(0), secondResp.get(0), thirdResp.get(0), fourthResp.get(0), endings.get(0));

    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public double getScore() {

        return score;
    }

    public void setScore(double score) {

        this.score = score;
    }

    public List<String> getResponses() {

        return this.responses;
    }

    public String getChatMessage(int n){
        return getFirstName() + " " + getLastName() + ": " +getResponses().get(n);
    }

    @Override
    public int compareTo(Student student) {

        int compareValue = this.getFirstName().compareTo(student.getFirstName());
        if (compareValue == 0) {
            compareValue = this.getLastName().compareTo(student.getLastName());
        }
        return compareValue;
    }
}
