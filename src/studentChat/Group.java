package studentChat;
// charles durfee CS3230 sum 18
public class Group implements Comparable<Group>{

    private Student studentOne;
    private Student studentTwo;

    public Group (Student studentOne, Student studentTwo){

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

       int compareValue = this.studentOne.getfName().compareTo(group.studentOne.getfName());
       if (compareValue == 0) {
           compareValue = this.studentOne.getlName().compareTo(group.studentOne.getlName());
       }
        return compareValue;
    }
}
