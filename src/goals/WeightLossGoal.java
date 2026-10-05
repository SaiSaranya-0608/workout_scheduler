package goals;

/**
 * Concrete HealthGoal implementation for Weight Loss goals.
 */
public class WeightLossGoal extends HealthGoal {
    private float currentWeight;
    private float weeklyLossRate;

    public WeightLossGoal(String goalName, int targetDays, float targetWeight, float currentWeight, float weeklyLossRate) {
        super(goalName, targetDays, targetWeight);
        this.currentWeight = currentWeight;
        this.weeklyLossRate = weeklyLossRate;
    }

    public WeightLossGoal(int targetDays, float targetWeight, float currentWeight, float weeklyLossRate) {
        super("Weight Loss Goal", targetDays, targetWeight);
        this.currentWeight = currentWeight;
        this.weeklyLossRate = weeklyLossRate;
    }

    public float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public float getWeeklyLossRate() {
        return weeklyLossRate;
    }

    public void setWeeklyLossRate(float weeklyLossRate) {
        this.weeklyLossRate = weeklyLossRate;
    }

    @Override
    public boolean isRealisticGoal() {
        if (currentWeight <= targetWeight || targetDays <= 0 || weeklyLossRate <= 0.0f) {
            return false;
        }

        if (weeklyLossRate > 1.5f) {
            return false;
        }

        float totalWeightToLose = currentWeight - targetWeight;
        float weeksAvailable = targetDays / 7.0f;
        float requiredWeeklyRate = totalWeightToLose / weeksAvailable;

        return requiredWeeklyRate <= 1.5f;
    }

    @Override
    public void displayGoal() {
        System.out.println("================ HEALTH GOAL DETAILS ================");
        System.out.println("Goal Name        : " + goalName);
        System.out.println("Current Weight   : " + currentWeight + " kg");
        System.out.println("Target Weight    : " + targetWeight + " kg");
        System.out.println("Target Duration  : " + targetDays + " days (" + String.format("%.1f", targetDays / 7.0f) + " weeks)");
        System.out.println("Weekly Loss Rate : " + weeklyLossRate + " kg/week");
        System.out.println("Realistic Goal   : " + (isRealisticGoal() ? "Yes" : "No (Rate too aggressive or invalid targets)"));
        System.out.println("=====================================================");
    }
}
