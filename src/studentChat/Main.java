package studentChat;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

   /**
    *  @author Charles Durfee
    *  @since  CS 3230 Summer 2018
    */

public class Main {

    public static void main(String[] args) {

        String [] firstNames =
                {"Gracie", "Charles", "Michael", "Michael", "Patrick", "Jonathan", "Clifford", "Jacob", "Margaret", "Randal", "Joshua", "Bo"};

        String[] lastNames = {"Davenport", "Durfee", "Gapas", "Gray", "Leishman", "Pedregon", "Peters", "Pitkin", "Schroeder", "Stoddard", "Wickster", "Yu"};

        TreeSet<Student> studentSet = new TreeSet<>();

        for (int i = 0; i < 12; i++){

               studentSet.add(new Student(firstNames[i], lastNames[i], 100));
            }

       List<Student> studentList = new ArrayList<>();
        studentList.addAll(studentSet);

        TreeSet<Group> groupSet = new TreeSet<>();

        for (int i = 0; i <= 5; i++){

            Group myGroup = new Group(studentList.get(i), studentList.get(11-i));
            groupSet.add(myGroup);
        }

        for (Group group : groupSet){

            for (int i = 0; i <= 4; i++) {
                System.out.println(group.getStudentOne().getChatMessage(i));
                System.out.println(group.getStudentTwo().getChatMessage(i));

            }
        }
    }
}
