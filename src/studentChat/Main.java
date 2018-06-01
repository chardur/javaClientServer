package studentChat;

import java.util.TreeSet;
// charles durfee CS3230 sum 18
public class Main {

    public static void main(String[] args) {

        String [] firstNames =
                {"Gracie", "Charles", "Michael", "Michael", "Patrick", "Jonathan", "Clifford", "Jacob", "Margaret", "Randal", "Joshua", "Bo"};

        String[] lastNames = {"Davenport", "Durfee", "Gapas", "Gray", "Leishman", "Pedregon", "Peters", "Pitkin", "Schroeder", "Stoddard", "Wickster", "Yu"};

        Student [] studentArray = new Student[12];

        for (int i = 0; i < 12; i++){

               studentArray[i] = new Student(firstNames[i], lastNames[i], 100);
            }

        TreeSet<Group> studentSet = new TreeSet<Group>();

        for (int i = 0; i <= 5; i++){

            Group myGroup = new Group(studentArray[i], studentArray[11-i]);
            studentSet.add(myGroup);
        }

        for (Group group : studentSet){

            for (int i = 0; i <= 4; i++) {
                System.out.print(group.getStudentOne().getfName() + " " + group.getStudentOne().getlName() + ": ");
                System.out.println(group.getStudentOne().getResponses().get(i));

                System.out.print(group.getStudentTwo().getfName() + " " + group.getStudentTwo().getlName() + ": ");
                System.out.println(group.getStudentTwo().getResponses().get(i));
            }
        }
    }
}
