package goals;

/**
 * Abstract base class representing a generic Health Goal.
 */
public abstract class HealthGoal {
    protected String goalName;
    protected int targetDays;
    protected float targetWeight;

    public HealthGoal(String goalName, int targetDays, float targetWeight) {
        this.goalName = goalName;
        this.targetDays = targetDays;
        this.targetWeight = targetWeight;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public int getTargetDays() {
        return targetDays;
    }

    public void setTargetDays(int targetDays) {
        this.targetDays = targetDays;
    }

    public float getTargetWeight() {
        return targetWeight;
    }

    public void setTargetWeight(float targetWeight) {
        this.targetWeight = targetWeight;
    }

    public abstract boolean isRealisticGoal();
    public abstract void displayGoal();
}
