package school.management.system;

/**
 * This class is for keeping track of the teacher's name, id and their salary
 */
public class Teacher {

    private int id;
    private String name;
    private int salary;

    /**
     * Create a new object for the Teacher - Constructor
     * @param id - Teacher's ID : unique
     * @param name - Teacher's name : Unique
     * @param salary - Teacher's Salary - can be same for many
     */
    public Teacher (int id, String name, int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    //Getters for all parameters

    public int getId (){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public int getSalary(){
        return this.salary;
    }

    /**
     * Setters for the parameters that needs to be changed
     * @param salary - for updating salary
     */
    public void setSalary(int salary){
        if (salary <0){
            System.out.println("Salary cannot be negative.");
            return;
        }
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Teacher ID: "+  id +"\nName: "+ name +"\nSalary: "+ salary ;
    }
}
