package exercises;

/**
 * Concrete Exercise implementation for Weight Loss (Cardio focus).
 */
public class WeightLossExercise extends Exercise {
    private String cardioType;
    private float intensityLevel;

    public WeightLossExercise(int exerciseId, String name, int durationMinutes, int setsCount, int repsCount,
                              String cardioType, float intensityLevel) {
        super(exerciseId, name, durationMinutes, setsCount, repsCount);
        this.cardioType = cardioType;
        this.intensityLevel = intensityLevel;
        calculateCaloriesBurned();
    }

    public String getCardioType() {
        return cardioType;
    }

    public void setCardioType(String cardioType) {
        this.cardioType = cardioType;
    }

    public float getIntensityLevel() {
        return intensityLevel;
    }

    public void setIntensityLevel(float intensityLevel) {
        this.intensityLevel = intensityLevel;
    }

    @Override
    public void displayExercise() {
        System.out.println("--- Weight Loss Exercise ---");
        System.out.println("ID               : " + exerciseId);
        System.out.println("Name             : " + name);
        System.out.println("Duration         : " + durationMinutes + " mins");
        System.out.println("Sets x Reps      : " + setsCount + " x " + repsCount);
        System.out.println("Cardio Type      : " + cardioType);
        System.out.println("Intensity Level  : " + intensityLevel + " / 10.0");
        System.out.println("Calories Burned  : " + String.format("%.1f", calculatedCalories) + " kcal");
        System.out.println("Completion Status: " + (isComplete ? "Completed" : "Pending"));
    }

    @Override
    public float calculateCaloriesBurned() {
        float baseFactor = 6.0f + (intensityLevel * 0.8f);
        float total = durationMinutes * baseFactor;
        if (setsCount > 1) {
            total += (setsCount * repsCount * 0.2f);
        }
        this.calculatedCalories = total;
        return this.calculatedCalories;
    }

    @Override
    public int recalculateDuration(float bp, float intensityLevel) {
        if (bp > 140.0f) {
            this.durationMinutes = Math.max(10, (int)(this.durationMinutes * 0.75f));
        } else if (bp > 130.0f) {
            this.durationMinutes = Math.max(10, (int)(this.durationMinutes * 0.85f));
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
