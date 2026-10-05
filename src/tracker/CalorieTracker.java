package tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * CalorieTracker class as defined in the UML Class Diagram.
 * Tracks total calories burned, daily logs, daily targets, and BMR.
 */
public class CalorieTracker {
    private float totalCaloriesBurned;
    private List<Float> caloriesBurntPerDay;
    private float dailyTargetCalorie;
    private float bmr;

    public CalorieTracker(float dailyTargetCalorie, float bmr) {
        this.totalCaloriesBurned = 0.0f;
        this.caloriesBurntPerDay = new ArrayList<>();
        this.dailyTargetCalorie = dailyTargetCalorie;
        this.bmr = bmr;
    }

    public float getTotalCaloriesBurned() {
        return totalCaloriesBurned;
    }

    public void setTotalCaloriesBurned(float totalCaloriesBurned) {
        this.totalCaloriesBurned = totalCaloriesBurned;
    }

    public List<Float> getCaloriesBurntPerDay() {
        return caloriesBurntPerDay;
    }

    public void setCaloriesBurntPerDay(List<Float> caloriesBurntPerDay) {
        this.caloriesBurntPerDay = caloriesBurntPerDay;
    }

    public float getDailyTargetCalorie() {
        return dailyTargetCalorie;
    }

    public void setDailyTargetCalorie(float dailyTargetCalorie) {
        this.dailyTargetCalorie = dailyTargetCalorie;
    }

    public float getBmr() {
        return bmr;
    }

    public void setBmr(float bmr) {
        this.bmr = bmr;
    }

    public float calculateBMR() {
        return bmr;
    }

    public void logCalorieBurn(float calories) {
        this.totalCaloriesBurned += calories;
        this.caloriesBurntPerDay.add(calories);
    }

    public float calculateDailyDeficitOrSurplusToBurn() {
        if (caloriesBurntPerDay.isEmpty()) {
            return dailyTargetCalorie;
        }
        float lastBurn = caloriesBurntPerDay.get(caloriesBurntPerDay.size() - 1);
        return dailyTargetCalorie - lastBurn;
    }
}
