/**
 * This class will create a course with four modules.
 * It will calculate the credits for the course and the overall grade of the four modules.
 * @author Andrei Cruceru
 * @version 12102020
 */
public class Course
{
    // Course name
    private String courseName;
    // Course Code
    private String courseCode;
    // The four modules of the course
    private Module moduleOne;
    private Module moduleTwo;
    private Module moduleThree;
    private Module moduleFour;
    // Course credits
    private int credits = 0;
    // Marks for the modules
    private int mark = 0;
    // The final grade of the course
    private String finalGrades;
         
    /**
     * Add a name and code to this course.
     */
    public Course(String courseName, String courseCode)
    {
        this.courseName = courseName;
        this.courseCode = courseCode;
    }
    
    /**
     * Add module one to this course.
     */
    public void addModuleOne(Module newModule)
    {
        moduleOne = newModule;
    }
    
    /**
     * Add module Two to this course.
     */
    public void addModuleTwo(Module newModule)
    {
        moduleTwo = newModule;
    }
    
    /**
     * Add module three to this course.
     */
    public void addModuleThree(Module newModule)
    {
        moduleThree = newModule;
    }
    
    /**
     * Add module four to this course.
     */
    public void addModuleFour(Module newModule)
    {
        moduleFour = newModule;
    }
    
    /**
     * This method will calculate the final grades of the course.
     * The student receives 15 credits for each module with a mark over 39%.
     */
    public void calculateCredits()
    {
        if (moduleOne.isCompleted == true && moduleTwo.isCompleted == true
        && moduleThree.isCompleted == true && moduleFour.isCompleted == true)
        {
            credits = credits + 60;
        }
        else
        {
            System.out.println("We can only calculate the final grades when ");
            System.out.println("the student have completed all four modules.");
        }
    }
    
    /**
     * This method will calculate the final grade of a student based on his percentage marks.
     * It will print this details to the terminal window.
     */
    public void calculateFinalGrades()
    {
        mark = moduleOne.getMark() + moduleTwo.getMark() + moduleThree.getMark() + moduleFour.getMark();
        mark = mark / 4;
        if (mark <= 39)
        {
            finalGrades = "F";
        }
        else if (mark > 39 && mark <= 49)
        {
            finalGrades = "D";
        }
        else if (mark > 49 && mark <= 59)
        {
            finalGrades = "C";
        }
        else if (mark > 59 && mark <= 69)
        {
            finalGrades = "B";
        }
        else
        {
            finalGrades = "A";
        }
        System.out.println("Your final marks are: " + mark + "%");
        System.out.println("Your final grades are: " + finalGrades);
    }
        
    /**
     * This method will print all the course details.
     * It will include separate marks for each modules and the total credits.
     */
    public void printCourseDetails()
    {
        System.out.println("Course: " + courseName + " Course code " + courseCode + " Credits: " + credits);
        System.out.println("Modules and mark:");
        moduleOne.printModuleDetails();
        moduleTwo.printModuleDetails();
        moduleThree.printModuleDetails();
        moduleFour.printModuleDetails();
    }
    
}