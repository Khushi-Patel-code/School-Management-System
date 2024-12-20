package school.management.system;

/* This class is responsible for keeping Track of students id, fees , name , grade & fees paid */

public class Student {
    private int id;
    private String name;
    private int grade;
    private int feesPaid;
    private int feesTotal;
    private int feesRemaining;


    /**
     *Constructor to initialize values
     * fees that every student has to pay is $40,000.
     * Fess paid initially when new student enrolls is $0.
     * @param id - for student id
     * @param name - for student name
     * @param grade - for student's current class
     */

    public Student (int id, String name, int grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.feesPaid = 0;
        this.feesTotal = 40000;
    }

    //do not change student's name and name so no setters needed

    public void setGrade (int grade){
        this.grade = grade;
    }


    /**
     * Getters for all the Parameters
     * @return
     */

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     * Tells how much fees You still need to pay
     * @return remaining fees
     */

    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    /**
     * Pays the selected amount of fees to the school
     * @param fees - fees that student pays
     */
    public void payFees(int fees){
        if (fees <=0){
            System.out.println("Invalid amount. Payment must be greater than zero.");
            return;
        }
        feesPaid += fees;
        School.updateTotalMoneyEarned(fees);
    }

    @Override
    public String toString(){
        return "Student ID: "+  id +"\nName: "+ name +"\nGrade: "+ grade +"\nFees Paid: $"+ feesPaid +"\nRemaining Fees: $"+ getRemainingFees();
    }
}
