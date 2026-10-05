package assigners;

import goals.HealthGoal;
import goals.WeightLossGoal;
import goals.WeightGainGoal;
import exercises.Exercise;
import exercises.WeightLossExercise;
import exercises.WeightGainExercise;
import exercises.ExerciseRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Assigns primary exercises matching the user's HealthGoal and cardiac status.
 */
public class RegularExerciseAssigner implements ExerciseAssigner {
    private List<Exercise> suitableExercises;

    public RegularExerciseAssigner() {
        this.suitableExercises = new ArrayList<>();
    }

    @Override
    public void setExercisesAssigned(boolean hasCardiacProblem, HealthGoal healthGoal) {
        suitableExercises.clear();

        if (healthGoal == null) {
            return;
        }

        if (healthGoal instanceof WeightLossGoal) {
            List<WeightLossExercise> pool = ExerciseRepository.getPredefinedWeightLossExercises();
            for (WeightLossExercise ex : pool) {
                if (hasCardiacProblem) {
                    if (ex.getIntensityLevel() <= 5.0f) {
                        suitableExercises.add(ex);
                    }
                } else {
                    suitableExercises.add(ex);
                }
            }
        } else if (healthGoal instanceof WeightGainGoal) {
            List<WeightGainExercise> pool = ExerciseRepository.getPredefinedWeightGainExercises();
            for (WeightGainExercise ex : pool) {
                if (hasCardiacProblem) {
                    if (ex.getIntensityLevel() <= 5.5f) {
                        suitableExercises.add(ex);
                    }
                } else {
                    suitableExercises.add(ex);
                }
            }
        }
    }

    @Override
    public List<Exercise> getExerciseAssigned() {
        return new ArrayList<>(suitableExercises);
    }
}
