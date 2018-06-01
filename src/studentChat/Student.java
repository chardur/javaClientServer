package studentChat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
// charles durfee CS3230 sum 18
public class Student {

    private String fName;
    private String lName;
    private double score;
    private List<String> responses;

    private List<String> greetings = Arrays.asList("Hello", "Hi", "Hola", "Greetings human", "I come in peace");
    private List<String> secondResp = Arrays.asList("Where am I?", "What year is it?", "Are you high?", "What do you want?", "Take me to your leader");
    private List<String> thirdResp = Arrays.asList("Your crazy maaan", "Are you ok?", "That's not what I wanted", "Are you human?", "Im so high right now...");
    private List<String> fourthResp = Arrays.asList("This is strange", "I cant see anything!", "Im typing with my feet", "How do I get to Mars from here?", "Whats that smell?");
    private List<String> endings = Arrays.asList("Bye", "Adios", "Cya", "Later", "I'm Out!");

    public Student (String fName, String lName, double score) {

        this.fName = fName;
        this.lName = lName;
        this.score = score;

        Collections.shuffle(greetings);
        Collections.shuffle(secondResp);
        Collections.shuffle(thirdResp);
        Collections.shuffle(fourthResp);
        Collections.shuffle(endings);

        responses = Arrays.asList(greetings.get(0), secondResp.get(0), thirdResp.get(0), fourthResp.get(0), endings.get(0));

    }

    public String getfName() {

        return fName;
    }

    public void setfName(String fName) {

        this.fName = fName;
    }

    public String getlName() {

        return lName;
    }

    public void setlName(String lName) {

        this.lName = lName;
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
}
