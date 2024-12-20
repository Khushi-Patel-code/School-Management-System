package school.management.system;
import java.util.List;
/**
 * school has multiple students and teachers so we put them into an arrayList
 */
public class School {

    private List<Teacher> teachers;
    private List<Student> students;

    private static int totalMoneyEarned ;
    private static int totalMoneySpent;

    /**
     * Constructor
     * @param teachers - list of teachers in the school
     * @param students - List of Students in the school
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    /**
     * Setters
     * @return Teachers , students , Money earned , money spent
     */

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * Setters
     */
    public void addATeacher (Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addAStudent(Student student) {
        this.students.add(student);
    }

    public static void updateTotalMoneyEarned(int moneyEarned) {
        totalMoneyEarned += moneyEarned;
    }

    /**
     * Salary given by the school to its teachers
     * @param moneySpent - money spent by the school
     */

    public void updateTotalMoneySpent(int moneySpent) {
        totalMoneySpent += moneySpent;
    }

    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * check if the school has enough funds to pay the teacher
     * After paying teachers salary we need to update the money spent as well as the money earned
     * @param teacher - the teacher to whom we are paying the salary
     */

    public void payTeacherSalary(Teacher teacher) {
        if (totalMoneyEarned >= teacher.getSalary()) {
            totalMoneySpent += teacher.getSalary();
            totalMoneyEarned -= teacher.getSalary(); // Deduct salary from earnings
            System.out.println("Salary paid to " + teacher.getName() + "\nAmount: $" + teacher.getSalary());
        } else {
            System.out.println("Insufficient funds to pay " + teacher.getName() + "'s salary!");
        }
    }

    /**
     * To get a financial summary report breakdown
     */
    public void getFinancialSummary(){
        System.out.println("\nFinancial Report:");
        System.out.println("=========================");
        System.out.println("Total Money Earned: $"+ totalMoneyEarned);
        System.out.println("Total Money Spent: $"+ totalMoneySpent);
        System.out.println("Remaining Balance: $" + (totalMoneyEarned-totalMoneySpent));
    }

    @Override
    public String toString(){
        return "Total Money earned: $"+ totalMoneyEarned +"\nTotal Money Spent: $"+ totalMoneySpent +"\nNumber of Teachers: "+ teachers.size() +"\nNumber of Students: "+ students.size() ;
    }
}
