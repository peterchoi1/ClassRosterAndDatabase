package ssa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Student implements Comparable<Student> {

    public String id;
    public String firstName;
    public String lastName;
    public String eyeColor;
    public int monthsEmployed;

    //arraylist of every student
    static ArrayList<Student> studentRoster = new ArrayList<Student>();
    //hashmap with key - id and student objects as the values
    static HashMap<String, Student> studentDatabase = new HashMap<String, Student>();

    //default constructor that is loading the arraylist with students
    public Student() {
        loadStudentRoster();
    }

    //constructor for initializing the variables
    public Student(String id, String firstName, String lastName, String eyeColor, int monthsEmployed) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eyeColor = eyeColor;
        this.monthsEmployed = monthsEmployed;
    }

    //adds all of the student objects to the arraylist and then to the hashmap
    private void loadStudentRoster() {
        studentRoster.add(new Student("004444", "Peter", "Choi", "Brown", 2));
        studentRoster.add(new Student("001122", "Michael", "Clair", "Purple", 12));
        studentRoster.add(new Student("001212", "Stephen", "Rook", "Brown", 11));
        studentRoster.add(new Student("005295", "Kyle", "Deen", "Blue", 2));
        studentRoster.add(new Student("004400", "Kevin", "Tran", "Red", 12));
        studentRoster.add(new Student("132617", "Reuben", "Turner", "Blue", 12));
        studentRoster.add(new Student("306700", "Li", "Liu", "Brown", 12));
        studentRoster.add(new Student("215296", "Joshua", "Franey", "Brown", 27));
        studentRoster.add(new Student("523420", "Gabriel", "Hamiliton", "Black", 10));
        studentRoster.add(new Student("004014", "Aisha", "Covington", "Brown", 10));
        studentRoster.add(new Student("006789", "Arun", "Soma", "Brown", 2));
        studentRoster.add(new Student("009999", "Steve", "Ellwood", "Green", 2));
        studentRoster.add(new Student("343769", "Shaquil", "Timmons", "Brown", 11));
        studentRoster.add(new Student("001449", "Karen", "Reiter", "Blue", 10));
        studentRoster.add(new Student("267252", "Dax", "Richards", "Brown", 12));
        studentRoster.add(new Student("229949", "Mike", "Sykes", "Brown", 13));
        studentRoster.add(new Student("772223", "Daniel", "Kiros", "Brown", 3));
        studentRoster.add(new Student("005255", "Joe", "Hill", "Brown", 13));
        loadStudentDatabase();
    }

    //adds all of the arraylist objects into the hashmap
    public void loadStudentDatabase() {
        for (Student student : studentRoster) {
            studentDatabase.put(student.id, student);
        }
    }

    //prints to the console all of the students in ascending order by first name
    //prints to the console the students with the one before, current, and after based off order of Id
    public void printClassRoster() {
        printTemplate();
        Collections.sort(studentRoster, studentNameComparator);
        for (Student student : studentRoster) {
            System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", student.id, student.firstName, student.lastName,
                    student.eyeColor, student.monthsEmployed);

        }
        System.out.println();
        printStudentDatabase("004444");
    }

    //template for the title and spacing
    public void printTemplate() {
        System.out.println("Student Class Roster");
        System.out.println();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "Empl ID", "First Name", "Last Name", "Eye Color",
                "Months at SSA");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", "=======", "==========", "=========", "=========",
                "=============");
    }

    //prints to the console all of the students before, current, and after the input id
    public void printStudentDatabase(String employeeId) {

        String myId = employeeId;
        String lowKey = "";
        String highKey = "999999";

        // for(String key : studentDatabase.keySet())

        for (String key : studentDatabase.keySet()) {
            String foundId = key;

            if ((foundId.compareTo(myId) < 0) && (foundId != myId)) {
                if (foundId.compareTo(lowKey) > 0) {
                    lowKey = foundId;
                }

            }

            if ((myId.compareTo(foundId) < 0) && (foundId != myId)) {
                if (foundId.compareTo(highKey) < 0) {
                    highKey = foundId;
                }

            }

        }

        printTemplate();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", studentDatabase.get(lowKey).id,
                studentDatabase.get(lowKey).firstName, studentDatabase.get(lowKey).lastName,
                studentDatabase.get(lowKey).eyeColor, studentDatabase.get(lowKey).monthsEmployed);

        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", studentDatabase.get(myId).id,
                studentDatabase.get(myId).firstName, studentDatabase.get(myId).lastName,
                studentDatabase.get(myId).eyeColor, studentDatabase.get(myId).monthsEmployed);

        System.out.printf("%-20s%-20s%-20s%-20s%-20s\n", studentDatabase.get(highKey).id,
                studentDatabase.get(highKey).firstName, studentDatabase.get(highKey).lastName,
                studentDatabase.get(highKey).eyeColor, studentDatabase.get(highKey).monthsEmployed);
    }

    //compareTo method for names
    @Override
    public int compareTo(Student o) {

        if (this.firstName.equalsIgnoreCase(o.firstName))
            return 0;
        else

            return -1;
    }

    //comparator for comparing firstNames
    public static Comparator<Student> studentNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student std1, Student std2) {

            String firstName1 = std1.firstName;
            String firstName2 = std2.firstName;

            // ascending order
            return firstName1.compareTo(firstName2);

            // descending order
            // return firstName2.compareTo(firstName1);
        }

    };

//    public static void main(String[] args) {
//        Student st = new Student();
//        st.printClassRoster();
//    }

}
