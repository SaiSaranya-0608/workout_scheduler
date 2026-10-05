java
import goals.HealthGoal;
import workouts.WorkOutHistory;
import tracker.CalorieTracker;

public class User {

    private int userId;

    public String name;
    public int age;
    public float weight_kg;
    public float height_cm;
    public float bp;
    public boolean hasCardiacProblems;

    public HealthGoal healthGoal;

    private WorkOutHistory workoutHistory;
    private CalorieTracker calorieTracker;

    public int daysPerWeek;
    public float hoursPerDay;

    public User(String name, int age, float weight_kg, float height_cm,
                HealthGoal healthGoal, int daysPerWeek, float hoursPerDay,
                WorkOutHistory workoutHistory, CalorieTracker calorieTracker) {

        this.name = name;
        this.age = age;
        this.weight_kg = weight_kg;
        this.height_cm = height_cm;
        this.healthGoal = healthGoal;
        this.daysPerWeek = daysPerWeek;
        this.hoursPerDay = hoursPerDay;

        this.hasCardiacProblems = false;

        this.workoutHistory = workoutHistory;
        this.calorieTracker = calorieTracker;
    }

    public User(String name, int age, float weight_kg, float height_cm,
                HealthGoal healthGoal, int daysPerWeek, float hoursPerDay,
                boolean hasCardiacProblems,
                WorkOutHistory workoutHistory, CalorieTracker calorieTracker) {

        this(name, age, weight_kg, height_cm, healthGoal,
             daysPerWeek, hoursPerDay, workoutHistory, calorieTracker);

        this.hasCardiacProblems = hasCardiacProblems;
    }

    public int getUserId() {
        return userId;
    }

    public WorkOutHistory getWorkoutHistory() {
        return workoutHistory;
    }

    public CalorieTracker getCalorieTracker() {
        return calorieTracker;
    }
}


