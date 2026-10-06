aimport exercises.Exercise;
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

        return (int) Math.ceil((double) exercises.size() / totalWorkoutDays);
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
         public List<Workout> getWorkoutSchedule(HealthGoal healthGoal) 
         {
            List<Workout> schedule = new ArrayList<>();
            int totalWorkoutDays = ((targetDays + 6) / 7) * daysPerWeek;
            
            if (totalWorkoutDays == 0 || exercises.isEmpty()) {
                return schedule;
            }
            int workoutDays = Math.min(totalWorkoutDays, exercises.size());
            int perDay = exercises.size() / workoutDays;
            int extra = exercises.size() % workoutDays; 
            int start = 0;
            for (int day = 0; day < workoutDays; day++) {
                int count = perDay + (day < extra ? 1 : 0);
                int end = start + count;
                List<Exercise> dayExercises = new ArrayList<>(exercises.subList(start, end));
                schedule.add(new Workout(day + 1, healthGoal, dayExercises));
                start = end;
            }
            return schedule;
        }
      }
