package analytics;

import workouts.WorkoutHistory;
import tracker.CalorieTracker;
import exercises.Exercise;

import java.util.List;

/**
 * WorkoutPerformanceAnalyzer class as defined in the UML Class Diagram.
 * Computes completion rates, active streaks, progress trends, and best performing sessions.
 */
public class WorkoutPerformanceAnalyzer {

    /**
     * Calculates the percentage of completed exercises relative to total assigned exercises.
     * @param history WorkoutHistory instance
     * @return Completion rate percentage (0.0f to 100.0f)
     */
    public float getCompletionRate(WorkoutHistory history) {
        if (history == null) {
            return 0.0f;
        }

        int completedCount = 0;
        for (List<Exercise> session : history.getCompletedExercises()) {
            completedCount += session.size();
        }

        int missedCount = 0;
        for (List<Exercise> session : history.getMissedExercises()) {
            missedCount += session.size();
        }

        int total = completedCount + missedCount;
        if (total == 0) {
            return 0.0f;
        }

        return ((float) completedCount / total) * 100.0f;
    }

    /**
     * Returns qualitative feedback analysis on the given completion rate.
     * @param completionRate Completion rate percentage
     * @return Qualitative feedback string
     */
    public String analyzeCompletionRate(float completionRate) {
        if (completionRate >= 90.0f) {
            return "Outstanding! You are completing almost all assigned exercises.";
        } else if (completionRate >= 75.0f) {
            return "Great effort! Consistent completion across workout sessions.";
        } else if (completionRate >= 50.0f) {
            return "Fair performance. Try to minimize missed exercises to stay on track.";
        } else {
            return "Needs improvement. Consider adjusting target intensity or duration.";
        }
    }

    /**
     * Calculates the length of the current active streak of sessions with zero missed exercises.
     * @param history WorkoutHistory instance
     * @return Current active streak count
     */
    public int getCurrentStreak(WorkoutHistory history) {
        if (history == null || history.getCompletedExercises().isEmpty()) {
            return 0;
        }

        List<List<Exercise>> completed = history.getCompletedExercises();
        List<List<Exercise>> missed = history.getMissedExercises();
        int streak = 0;

        for (int i = completed.size() - 1; i >= 0; i--) {
            boolean hasCompleted = !completed.get(i).isEmpty();
            boolean hasMissed = (i < missed.size()) && !missed.get(i).isEmpty();

            if (hasCompleted && !hasMissed) {
                streak++;
            } else {
                break;
            }
        }
        return streak;
    }

    /**
     * Provides qualitative feedback on the current active streak.
     * @param streak Active streak length
     * @return Streak analysis feedback string
     */
    public String analyzeCurrentStreak(int streak) {
        if (streak >= 14) {
            return "Phenomenal! " + streak + "-session streak! Exceptional consistency!";
        } else if (streak >= 7) {
            return "Solid progress! " + streak + "-session streak achieved!";
        } else if (streak > 0) {
            return "Keep it up! Active streak: " + streak + " session(s).";
        } else {
            return "No active streak. Complete your next full workout session to start a streak!";
        }
    }

    /**
     * Evaluates calorie burn trends over time using CalorieTracker records.
     * @param calorieTracker CalorieTracker instance
     * @return Progress trend description ("Increasing Trend", "Decreasing Trend", "Stable Trend", or "Insufficient Data")
     */
    public String getProgressTrend(CalorieTracker calorieTracker) {
        if (calorieTracker == null) {
            return "Insufficient Data";
        }

        List<Float> caloriesPerDay = calorieTracker.getCaloriesBurntPerDay();
        if (caloriesPerDay == null || caloriesPerDay.size() < 2) {
            return "Insufficient Data - Minimum 2 logged days required.";
        }

        int size = caloriesPerDay.size();
        float recent = caloriesPerDay.get(size - 1);
        float previous = caloriesPerDay.get(size - 2);

        float diff = recent - previous;
        if (diff > 20.0f) {
            return "Increasing Trend (+ " + String.format("%.1f", diff) + " kcal)";
        } else if (diff < -20.0f) {
            return "Decreasing Trend (" + String.format("%.1f", diff) + " kcal)";
        } else {
            return "Stable Trend";
        }
    }

    /**
     * Identifies the session index with the highest count of completed exercises.
     * @param history WorkoutHistory instance
     * @return Description of best performing day/session
     */
    public String getBestPerformingDay(WorkoutHistory history) {
        if (history == null || history.getCompletedExercises().isEmpty()) {
            return "No history available";
        }

        List<List<Exercise>> completed = history.getCompletedExercises();
        int maxIndex = 0;
        int maxCount = 0;

        for (int i = 0; i < completed.size(); i++) {
            int count = completed.get(i).size();
            if (count > maxCount) {
                maxCount = count;
                maxIndex = i;
            }
        }

        if (maxCount == 0) {
            return "No completed exercises logged yet";
        }

        return "Session #" + (maxIndex + 1) + " with " + maxCount + " completed exercise(s)";
    }
}
