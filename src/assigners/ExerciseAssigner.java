package assigners;

import goals.HealthGoal;
import exercises.Exercise;
import java.util.List;

/**
 * Interface defining exercise assignment operations.
 */
public interface ExerciseAssigner {
    void setExercisesAssigned(boolean hasCardiacProblem, HealthGoal healthGoal);
    List<Exercise> getExerciseAssigned();
}
