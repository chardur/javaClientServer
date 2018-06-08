package studentChat;

/**
 * @author Charles Durfee
 * @since CS 3230 Summer 2018
 */

public class Group implements Comparable<Group> {

    private Student studentOne;
    private Student studentTwo;

    public Group(Student studentOne, Student studentTwo) {

        this.studentOne = studentOne;
        this.studentTwo = studentTwo;
    }

    public Student getStudentOne() {
        return studentOne;
    }

    public void setStudentOne(Student studentOne) {

        this.studentOne = studentOne;
    }

    public Student getStudentTwo() {

        return studentTwo;
    }

    public void setStudentTwo(Student studentTwo) {

        this.studentTwo = studentTwo;
    }

    @Override
    public int compareTo(Group group) {

        int compareValue = studentOne.getFirstName().compareTo(group.studentOne.getFirstName());
        if (compareValue == 0) {
            compareValue = studentOne.getLastName().compareTo(group.studentOne.getLastName());
        }
        return compareValue;
    }
}
