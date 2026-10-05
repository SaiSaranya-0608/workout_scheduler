package workouts;

import exercises.Exercise;
import java.util.ArrayList;
import java.util.List;

/**
 * WorkoutHistory class as defined in the UML Class Diagram.
 * Maintains completed and missed exercises across workout sessions.
 */
public class WorkoutHistory {
    private List<List<Exercise>> missedExercises;
    private List<List<Exercise>> completedExercises;

    public WorkoutHistory() {
        this.missedExercises = new ArrayList<>();
        this.completedExercises = new ArrayList<>();
    }

    public List<List<Exercise>> getMissedExercises() {
        return missedExercises;
    }

    public void setMissedExercises(List<List<Exercise>> missedExercises) {
        this.missedExercises = missedExercises;
    }

    public List<List<Exercise>> getCompletedExercises() {
        return completedExercises;
    }

    public void setCompletedExercises(List<List<Exercise>> completedExercises) {
        this.completedExercises = completedExercises;
    }

    /**
     * Adds an empty workout record entry for a new session.
     */
    public void addWorkoutRecord() {
        this.completedExercises.add(new ArrayList<>());
        this.missedExercises.add(new ArrayList<>());
    }

    /**
     * Adds a workout record entry with specific lists of completed and missed exercises.
     * @param completed List of completed exercises in the session
     * @param missed List of missed exercises in the session
     */
    public void addWorkoutRecord(List<Exercise> completed, List<Exercise> missed) {
        this.completedExercises.add(completed != null ? completed : new ArrayList<>());
        this.missedExercises.add(missed != null ? missed : new ArrayList<>());
    }

    /**
     * Updates the most recent workout record.
     */
    public void updateWorkoutRecord() {
        if (!completedExercises.isEmpty()) {
            int lastIndex = completedExercises.size() - 1;
            // Retain existing records or update latest entry
        }
    }

    /**
     * Updates a workout record at a specific session index.
     * @param index Session record index
     * @param completed Updated list of completed exercises
     * @param missed Updated list of missed exercises
     */
    public void updateWorkoutRecord(int index, List<Exercise> completed, List<Exercise> missed) {
        if (index >= 0 && index < completedExercises.size()) {
            if (completed != null) {
                completedExercises.set(index, completed);
            }
            if (missed != null) {
                missedExercises.set(index, missed);
            }
        }
    }

    /**
     * Generates a formatted history report string for a specified user.
     * @param userId User ID
     * @return Formatted report text
     */
    public String generateHistoryReport(int userId) {
        StringBuilder report = new StringBuilder();
        report.append("=== WORKOUT HISTORY REPORT FOR USER ").append(userId).append(" ===\n");
        report.append("Total Sessions Tracked: ").append(completedExercises.size()).append("\n");

        int totalCompletedCount = 0;
        for (List<Exercise> session : completedExercises) {
            totalCompletedCount += session.size();
        }

        int totalMissedCount = 0;
        for (List<Exercise> session : missedExercises) {
            totalMissedCount += session.size();
        }

        report.append("Total Completed Exercises: ").append(totalCompletedCount).append("\n");
        report.append("Total Missed Exercises   : ").append(totalMissedCount).append("\n");
        report.append("Missed Sessions Count    : ").append(getMissedWorkoutsCount()).append("\n");
        return report.toString();
    }

    /**
     * Returns the total count of workout sessions that contained missed exercises.
     * @return Number of missed sessions
     */
    public int getMissedWorkoutsCount() {
        int count = 0;
        for (List<Exercise> missedList : missedExercises) {
            if (!missedList.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    /**
     * Filters exercise history lists by completion status.
     * @param status Status string ("completed" or "missed")
     * @return List of exercise lists matching status
     */
    public List<List<Exercise>> getHistoryByCompletionStatus(String status) {
        if ("completed".equalsIgnoreCase(status)) {
            return completedExercises;
        } else if ("missed".equalsIgnoreCase(status)) {
            return missedExercises;
        }
        return new ArrayList<>();
    }

    /**
     * Clears all workout history logs for the given user.
     * @param userId User ID
     */
    public void clearHistory(int userId) {
        this.completedExercises.clear();
        this.missedExercises.clear();
    }
}
