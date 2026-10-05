package exercises;

/**
 * Concrete Exercise implementation for Weight Gain (Strength focus).
 */
public class WeightGainExercise extends Exercise {
    private float weightLifted_kg;
    private String equipmentUsed;
    private float intensityLevel;

    public WeightGainExercise(int exerciseId, String name, int durationMinutes, int setsCount, int repsCount,
                               float weightLifted_kg, String equipmentUsed, float intensityLevel) {
        super(exerciseId, name, durationMinutes, setsCount, repsCount);
        this.weightLifted_kg = weightLifted_kg;
        this.equipmentUsed = equipmentUsed;
        this.intensityLevel = intensityLevel;
        calculateCaloriesBurned();
    }

    public float getWeightLifted_kg() {
        return weightLifted_kg;
    }

    public void setWeightLifted_kg(float weightLifted_kg) {
        this.weightLifted_kg = weightLifted_kg;
    }

    public String getEquipmentUsed() {
        return equipmentUsed;
    }

    public void setEquipmentUsed(String equipmentUsed) {
        this.equipmentUsed = equipmentUsed;
    }

    public float getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(float intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    @Override
    public void displayExercise() {
        System.out.println("--- Weight Gain Exercise ---");
        System.out.println("ID               : " + exerciseId);
        System.out.println("Name             : " + name);
        System.out.println("Duration         : " + durationMinutes + " mins");
        System.out.println("Sets x Reps      : " + setsCount + " x " + repsCount);
        System.out.println("Weight Lifted    : " + weightLifted_kg + " kg");
        System.out.println("Equipment Used   : " + equipmentUsed);
        System.out.println("Intensity Level  : " + intensityLevel + " / 10.0");
        System.out.println("Calories Burned  : " + String.format("%.1f", calculatedCalories) + " kcal");
        System.out.println("Completion Status: " + (isComplete ? "Completed" : "Pending"));
    }

    @Override
    public float calculateCaloriesBurned() {
        float durationFactor = durationMinutes * (3.0f + (intensityLevel * 0.4f));
        float resistanceWork = (setsCount * repsCount * weightLifted_kg) * 0.04f;
        this.calculatedCalories = durationFactor + resistanceWork;
        return this.calculatedCalories;
    }

    @Override
    public int recalculateDuration(float bp, float intensityLevel) {
        if (bp > 140.0f) {
            this.durationMinutes = Math.max(10, (int)(this.durationMinutes * 0.80f));
            this.weightLifted_kg = this.weightLifted_kg * 0.80f;
        } else if (bp > 130.0f) {
            this.durationMinutes = Math.max(10, (int)(this.durationMinutes * 0.90f));
        }

        if (intensityLevel > 8.0f) {
            this.intensityLevel = 8.0f;
        } else if (intensityLevel > 0.0f) {
            this.intensityLevel = intensityLevel;
        }

        calculateCaloriesBurned();
        return this.durationMinutes;
    }
}
