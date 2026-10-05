import exercises.Exercise;
import java.util.List;

public class ExerciseScheduler {

    private final int breakTime = 5;
    private float cumulativeTime;

    private List<Exercise> exercises;
    private int targetDays;
    private int daysPerWeek;

    public ExerciseScheduler(List<Exercise> exercises, int targetDays, int daysPerWeek) {
        this.exercises = exercises;
        this.targetDays = targetDays;
        this.daysPerWeek = daysPerWeek;
    }

    public int computeNoOFExercisesperday() {
        int totalWeeks = (targetDays + 6) / 7;

        int totalWorkoutDays = totalWeeks * daysPerWeek;

        if (totalWorkoutDays == 0) {
            return 0;
        }

        return exercises.size() / totalWorkoutDays;
    }

    public void displaySchduledExercises() {
        int exercisesPerDay = computeNoOFExercisesperday();

        cumulativeTime = 0;

        for (int i = 0; i < exercisesPerDay && i < exercises.size(); i++) {

            Exercise ex = exercises.get(i);
            int duration = ex.getDurationMinutes();

            if (i > 0) {
                cumulativeTime += breakTime;
                System.out.println("Break: " + breakTime + " minutes");
            }

            System.out.println(ex.getName() + " - " + duration + " minutes");

            cumulativeTime += duration;
        }

        System.out.println("Number of exercises: " + exercisesPerDay);
        System.out.println("Total time: " + cumulativeTime + " minutes");
    }
}
