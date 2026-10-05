package goals;

/**
 * Concrete HealthGoal implementation for Weight Gain goals.
 */
public class WeightGainGoal extends HealthGoal {
    private float currentWeight;
    private float weeklyGainRate;

    public WeightGainGoal(String goalName, int targetDays, float targetWeight, float currentWeight, float weeklyGainRate) {
        super(goalName, targetDays, targetWeight);
        this.currentWeight = currentWeight;
        this.weeklyGainRate = weeklyGainRate;
    }

    public WeightGainGoal(int targetDays, float targetWeight, float currentWeight, float weeklyGainRate) {
        super("Weight Gain Goal", targetDays, targetWeight);
        this.currentWeight = currentWeight;
        this.weeklyGainRate = weeklyGainRate;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public float getWeeklyGainRate() {
        return weeklyGainRate;
    }

    public void setWeeklyGainRate(float weeklyGainRate) {
        this.weeklyGainRate = weeklyGainRate;
    }

    @Override
    public boolean isRealisticGoal() {
        if (targetWeight <= currentWeight || targetDays <= 0 || weeklyGainRate <= 0.0f) {
            return false;
        }

        if (weeklyGainRate > 1.0f) {
            return false;
        }

        float totalWeightToGain = targetWeight - currentWeight;
        float weeksAvailable = targetDays / 7.0f;
        float requiredWeeklyRate = totalWeightToGain / weeksAvailable;

        return requiredWeeklyRate <= 1.0f;
    }

    @Override
    public void displayGoal() {
        System.out.println("================ HEALTH GOAL DETAILS ================");
        System.out.println("Goal Name        : " + goalName);
        System.out.println("Current Weight   : " + currentWeight + " kg");
        System.out.println("Target Weight    : " + targetWeight + " kg");
        System.out.println("Target Duration  : " + targetDays + " days (" + String.format("%.1f", targetDays / 7.0f) + " weeks)");
        System.out.println("Weekly Gain Rate : " + weeklyGainRate + " kg/week");
        System.out.println("Realistic Goal   : " + (isRealisticGoal() ? "Yes" : "No (Rate too aggressive or invalid targets)"));
        System.out.println("=====================================================");
    }
}
