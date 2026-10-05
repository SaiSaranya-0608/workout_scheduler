import goals.*;
import exercises.*;
import assigners.*;
import workouts.*;
import tracker.*;
import analytics.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Integrated Demonstration Class for Workout Scheduler & Performance Analyzer System.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================================");
        System.out.println("   WORKOUT SCHEDULER & PERFORMANCE ANALYZER - INTEGRATED SYSTEM   ");
        System.out.println("==================================================================\n");

        // 1. Health Goals Validation
        System.out.println(">>> 1. TESTING HEALTH GOALS & REALISTIC GOAL VALIDATION <<<\n");

        HealthGoal weightLossGoal = new WeightLossGoal("Weight Loss Goal", 60, 70.0f, 80.0f, 1.0f);
        weightLossGoal.displayGoal();
        System.out.println("Is Realistic Goal? " + weightLossGoal.isRealisticGoal());

        System.out.println("\n------------------------------------------------------------------\n");

        // 2. Regular & Additional Exercise Assigners
        System.out.println(">>> 2. TESTING EXERCISE ASSIGNERS <<<\n");

        ExerciseAssigner regularAssigner = new RegularExerciseAssigner();
        regularAssigner.setExercisesAssigned(false, weightLossGoal);
        List<Exercise> assignedExercises = regularAssigner.getExerciseAssigned();

        System.out.println("Assigned " + assignedExercises.size() + " regular exercises:");
        for (Exercise ex : assignedExercises) {
            ex.displayExercise();
            System.out.println();
        }

        System.out.println("------------------------------------------------------------------\n");

        // 3. Testing Workout Class
        System.out.println(">>> 3. TESTING WORKOUT SESSION MANAGEMENT <<<\n");

        Workout workoutSession = new Workout(101, weightLossGoal, assignedExercises);
        System.out.println("Workout ID: " + workoutSession.getWorkoutId());
        System.out.println("Calculated Total Workout Duration: " + workoutSession.getWorkoutMinutes() + " mins");

        // Mark exercise with ID 101 as completed
        System.out.println("\nMarking Exercise ID 101 as completed...");
        workoutSession.markCompletedExercise(101);

        System.out.println("\nUpdated Exercise Completion Statuses:");
        for (Exercise ex : workoutSession.getExercises()) {
            System.out.println("- " + ex.getName() + ": " + (ex.isComplete() ? "Completed" : "Pending"));
        }

        System.out.println("\n------------------------------------------------------------------\n");

        // 4. Testing Workout History Tracking
        System.out.println(">>> 4. TESTING WORKOUT HISTORY TRACKING <<<\n");

        WorkoutHistory history = new WorkoutHistory();

        // Session 1: 1 Completed, 1 Missed
        List<Exercise> s1Completed = new ArrayList<>();
        List<Exercise> s1Missed = new ArrayList<>();
        if (!assignedExercises.isEmpty()) {
            s1Completed.add(assignedExercises.get(0));
        }
        if (assignedExercises.size() > 1) {
            s1Missed.add(assignedExercises.get(1));
        }
        history.addWorkoutRecord(s1Completed, s1Missed);

        // Session 2: 2 Completed, 0 Missed
        List<Exercise> s2Completed = new ArrayList<>(assignedExercises);
        List<Exercise> s2Missed = new ArrayList<>();
        history.addWorkoutRecord(s2Completed, s2Missed);

        // Print History Report
        System.out.println(history.generateHistoryReport(5001));

        System.out.println("------------------------------------------------------------------\n");

        // 5. Testing Workout Performance Analyzer & Calorie Tracker
        System.out.println(">>> 5. TESTING WORKOUT PERFORMANCE ANALYZER <<<\n");

        WorkoutPerformanceAnalyzer analyzer = new WorkoutPerformanceAnalyzer();

        float completionRate = analyzer.getCompletionRate(history);
        System.out.println("Overall Completion Rate: " + String.format("%.2f", completionRate) + "%");
        System.out.println("Completion Rate Insight: " + analyzer.analyzeCompletionRate(completionRate));

        int currentStreak = analyzer.getCurrentStreak(history);
        System.out.println("\nCurrent Active Streak: " + currentStreak + " session(s)");
        System.out.println("Streak Feedback: " + analyzer.analyzeCurrentStreak(currentStreak));

        System.out.println("\nBest Performing Session: " + analyzer.getBestPerformingDay(history));

        // Calorie Tracker
        CalorieTracker tracker = new CalorieTracker(2000.0f, 1600.0f);
        tracker.logCalorieBurn(400.0f);
        tracker.logCalorieBurn(480.0f);
        System.out.println("Calorie Progress Trend : " + analyzer.getProgressTrend(tracker));

        System.out.println("\n==================================================================");
        System.out.println("             SYSTEM VERIFICATION COMPLETED SUCCESSFULLY            ");
        System.out.println("==================================================================");
    }
}
