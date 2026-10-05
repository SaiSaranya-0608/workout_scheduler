package exercises;

import java.util.ArrayList;
import java.util.List;

/**
 * Repository class providing predefined lists of WeightLoss and WeightGain concrete exercises.
 */
public class ExerciseRepository {

    public static List<WeightLossExercise> getPredefinedWeightLossExercises() {
        List<WeightLossExercise> list = new ArrayList<>();
        list.add(new WeightLossExercise(101, "Brisk Walking", 30, 1, 1, "Low-Impact Cardio", 3.5f));
        list.add(new WeightLossExercise(102, "Jogging", 25, 1, 1, "Moderate Cardio", 6.5f));
        list.add(new WeightLossExercise(103, "Outdoor Cycling", 40, 1, 1, "Low-Impact Cardio", 4.5f));
        list.add(new WeightLossExercise(104, "Jumping Jacks", 15, 3, 30, "HIIT Cardio", 8.5f));
        list.add(new WeightLossExercise(105, "Stair Climbing", 20, 4, 25, "High-Impact Cardio", 7.5f));
        return list;
    }

    public static List<WeightLossExercise> getAdditionalWeightLossExercises() {
        List<WeightLossExercise> list = new ArrayList<>();
        list.add(new WeightLossExercise(106, "Aerobic Dance Routine", 30, 1, 1, "Low-Impact Cardio", 4.0f));
        list.add(new WeightLossExercise(107, "Incline Treadmill Walk", 25, 1, 1, "Low-Impact Cardio", 4.5f));
        list.add(new WeightLossExercise(108, "Jump Rope Intervals", 15, 5, 50, "HIIT Cardio", 9.0f));
        list.add(new WeightLossExercise(109, "Stationary Ergometer Cycling", 20, 1, 1, "Low-Impact Cardio", 3.8f));
        return list;
    }

    public static List<WeightGainExercise> getPredefinedWeightGainExercises() {
        List<WeightGainExercise> list = new ArrayList<>();
        list.add(new WeightGainExercise(201, "Barbell Squats", 30, 4, 10, 60.0f, "Barbell & Squat Rack", 7.5f));
        list.add(new WeightGainExercise(202, "Dumbbell Bench Press", 25, 4, 12, 20.0f, "Dumbbells & Bench", 6.5f));
        list.add(new WeightGainExercise(203, "Barbell Deadlift", 30, 3, 8, 80.0f, "Barbell & Weight Plates", 8.5f));
        list.add(new WeightGainExercise(204, "Dumbbell Bent-Over Rows", 20, 3, 12, 15.0f, "Dumbbells", 5.5f));
        list.add(new WeightGainExercise(205, "Standing Shoulder Press", 20, 3, 10, 12.0f, "Dumbbells", 5.0f));
        return list;
    }

    public static List<WeightGainExercise> getAdditionalWeightGainExercises() {
        List<WeightGainExercise> list = new ArrayList<>();
        list.add(new WeightGainExercise(206, "Bodyweight Push-ups", 15, 3, 15, 0.0f, "Yoga Mat", 3.5f));
        list.add(new WeightGainExercise(207, "Seated Cable Row", 20, 3, 12, 25.0f, "Cable Machine", 4.5f));
        list.add(new WeightGainExercise(208, "Leg Press Machine", 25, 4, 12, 90.0f, "Leg Press Machine", 7.0f));
        list.add(new WeightGainExercise(209, "Bicep Dumbbell Curls", 15, 3, 12, 10.0f, "Dumbbells", 4.0f));
        return list;
    }
}
