package israel.healthapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.UUID;

public class DAO extends SQLiteOpenHelper {

    private static final String TAG = "DAO";
    public DAO(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {

        String sqlCreateUserTableStmt =
                "CREATE TABLE IF NOT EXISTS User " +
                        "(" +
                        "id TEXT NOT NULL UNIQUE, " +
                        "birthday TEXT NOT NULL, " +
                        "height FLOAT NOT NULL, " +
                        "weight FLOAT NOT NULL, " +
                        "gender TEXT NOT NULL, " +
                        "fitnessLevel TEXT NOT NULL, " +
                        "PRIMARY KEY (id)" +
                        ");";

        DB.execSQL(sqlCreateUserTableStmt);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS UserTable");
    }

//    public Workout loadWorkout(UUID workoutID) throws DataAccessException {
//        Workout workout = null;
//        SQLiteDatabase DB = this.getWritableDatabase();
//        String id = workoutID.toString();
//        try {
//            Cursor cursor = DB.rawQuery("Select * from WorkoutTable where id = ?", new String[]{id});
//            if (cursor.getCount() > 0) {
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                String muscleGroup = cursor.getString(cursor.getColumnIndex("muscleGroup"));
//                workout = new Workout(workoutID, name, null, muscleGroup);
//            }
//            return workout;
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new DataAccessException("ERROR: encountered while executing loadWorkout");
//        }
//    }
//
//    public Boolean saveWorkout(Workout workout) throws DataAccessException {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", workout.getId().toString());
//        contentValues.put("name", workout.getName());
//        contentValues.put("muscleGroup", workout.getMuscleGroup());
//        try {
//            long result=DB.insert("WorkoutTable", null, contentValues);
//            if(result==-1){
//                Log.e(TAG, "saveWorkout failed");
//                return false;
//            }else{
//                Log.i(TAG, "saveWorkout executed successfully");
//                return true;
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new DataAccessException("ERROR: encountered while executing saveWorkout");
//        }
//    }
//
//    public Exercise loadExercise(UUID exerciseID) throws DataAccessException {
//        Exercise exercise = null;
//        SQLiteDatabase DB = this.getWritableDatabase();
//        String id = exerciseID.toString();
//        try {
//            Cursor cursor = DB.rawQuery("Select * from ExerciseTable where id = ?", new String[]{id});
//            if (cursor.getCount() > 0) {
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                String muscleGroup = cursor.getString(cursor.getColumnIndex("muscleGroup"));
//                exercise = new Exercise(exerciseID, name, null, null, null, muscleGroup);
//            }
//            return exercise;
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new DataAccessException("ERROR: encountered while executing loadExercise");
//        }
//    }
//
//    public Boolean saveExercise(Exercise exercise) throws DataAccessException {
//        SQLiteDatabase DB = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("id", exercise.getId().toString());
//        contentValues.put("name", exercise.getName());
//        contentValues.put("muscleGroup", exercise.getMuscleGroup());
//        try {
//            long result=DB.insert("ExerciseTable", null, contentValues);
//            if(result==-1){
//                Log.e(TAG, "saveExercise failed");
//                return false;
//            }else{
//                Log.i(TAG, "saveExercise executed successfully");
//                return true;
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//            throw new DataAccessException("ERROR: encountered while executing saveExercise");
//        }
//    }
}


