package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Names
    private static final String TABLE_JOBS = "JOBS";
    private static final String TABLE_WEIGHTS = "WEIGHTS";

    // JOBS Table - column names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_COMPANY = "company";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_COST_INDEX = "livingCostIndex";
    private static final String COLUMN_SALARY = "yearlySalary";
    private static final String COLUMN_BONUS = "yearlyBonus";
    private static final String COLUMN_REMOTEDAYS = "weeklyAllowedRemoteDays";
    private static final String COLUMN_LEAVETIME = "leaveTime";
    private static final String COLUMN_GYMALLOW = "gymAllowance";
    private static final String COLUMN_SCORE = "score";

    // WEIGHTS Table - column names
    private static final String COLUMN_WGT_SALARY = "yearlySalaryWeight";
    private static final String COLUMN_WGT_BONUS = "yearlyBonusWeight";
    private static final String COLUMN_WGT_REMOTEDAYS = "allowedRemoteDaysWeight";
    private static final String COLUMN_WGT_LEAVETIME = "leaveTimeWeight";
    private static final String COLUMN_WGT_GYMALLOW = "gymAllowanceWeight";

    // Table Create Statements
    // JOBS table create statement
    private static final String CREATE_TABLE_JOBS = "CREATE TABLE " + TABLE_JOBS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_STATUS + " TEXT, " +
            COLUMN_TITLE + " TEXT, " +
            COLUMN_COMPANY + " TEXT, " +
            COLUMN_CITY + " TEXT, " +
            COLUMN_STATE + " TEXT, " +
            COLUMN_COST_INDEX + " INT, " +
            COLUMN_SALARY + " INT, " +
            COLUMN_BONUS + " INT, " +
            COLUMN_REMOTEDAYS + " INT, " +
            COLUMN_LEAVETIME + " INT, " +
            COLUMN_GYMALLOW + " INT, " +
            COLUMN_SCORE + " INT " +
            ")";

    // WEIGHTS table create statement
    private static final String CREATE_TABLE_WEIGHTS = "CREATE TABLE " + TABLE_WEIGHTS + " (" +
            COLUMN_WGT_SALARY + " INT DEFAULT 0, " +
            COLUMN_WGT_BONUS + " INT DEFAULT 0, " +
            COLUMN_WGT_LEAVETIME + " INT DEFAULT 0, " +
            COLUMN_WGT_REMOTEDAYS + " INT DEFAULT 0, " +
            COLUMN_WGT_GYMALLOW + " INT DEFAULT 0 " +
            ")";

    private static DatabaseHelper sInstance;

    public static synchronized DatabaseHelper getInstance(Context context) {

        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    private DatabaseHelper(@Nullable Context context) {
        super(context, "jobOffers", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_TABLE_JOBS);
        db.execSQL(CREATE_TABLE_WEIGHTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    // ------------------------ "JOBS" table methods ----------------//

    // inserts a job record in the JOBS table
    public boolean addJob(Job job) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STATUS, job.getStatus()); // Edit?
        cv.put(COLUMN_TITLE, job.getTitle());
        cv.put(COLUMN_COMPANY, job.getCompany());
        cv.put(COLUMN_CITY, job.getCity());
        cv.put(COLUMN_STATE, job.getState());

        cv.put(COLUMN_COST_INDEX, job.getLivingCostIndex());
        cv.put(COLUMN_SALARY, job.getYearlySalary());
        cv.put(COLUMN_BONUS, job.getYearlyBonus());
        cv.put(COLUMN_REMOTEDAYS, job.getWeeklyAllowedRemoteDays());
        cv.put(COLUMN_LEAVETIME, job.getLeaveTime());
        cv.put(COLUMN_GYMALLOW, job.getGymAllowance());
        cv.put(COLUMN_SCORE, job.getScore());

        long insert = db.insert(TABLE_JOBS, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }

    }

    // retrieves all jobs in the JOBS table in the form of a list
    public List<Job> getAllJobs() {
        List<Job> returnList = new ArrayList<>();

        // get data from the database
//        String queryString = "SELECT * FROM " + TABLE_JOBS;

        SQLiteDatabase db = this.getReadableDatabase();

        String sortOrder = COLUMN_SCORE + " DESC";
        Cursor cursor = db.query(TABLE_JOBS, null, null, null,
                null, null, sortOrder);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new job objects. Put them
            // into the return list.
            do {

                String status = cursor.getString(1);
                String title = cursor.getString(2);
                String company = cursor.getString(3);
                String city = cursor.getString(4);
                String state = cursor.getString(5);

                int costIndex = cursor.getInt(6);
                int salary = cursor.getInt(7);
                int bonus = cursor.getInt(8);
                int allowedRemote = cursor.getInt(9);
                int leave = cursor.getInt(10);
                int gymAllow = cursor.getInt(11);
                int score = cursor.getInt(12);

                Job newJob = new Job(
                        status,
                        title,
                        company,
                        city,
                        state,
                        costIndex,
                        salary,
                        bonus,
                        allowedRemote,
                        leave,
                        gymAllow);

                newJob.setScore(getAllWgts()); // to be deleted

                // add record to list
                returnList.add(newJob);


            } while (cursor.moveToNext());
        } else {
            // failure, do not add anything to the list
        }
        cursor.close();

        return returnList;
    }

    // retrieve Current Job
    public Job getCurrentJob() {
        SQLiteDatabase db = this.getReadableDatabase();

        String status = "current";
        String selectQuery = "SELECT  * FROM " + TABLE_JOBS + " WHERE "
                + COLUMN_STATUS + " = '" + status + "'";

        // add descend by score

        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            if (c.moveToFirst()) {
                Job cj = new Job();
                cj.setStatus(c.getString(1)); // Remove?
                cj.setTitle(c.getString(2));
                cj.setCompany(c.getString(3));
                cj.setCity(c.getString(4));
                cj.setState(c.getString(5));
                cj.setLivingCostIndex(c.getInt(6));
                cj.setYearlySalary(c.getInt(7));
                cj.setYearlyBonus(c.getInt(8));
                cj.setWeeklyAllowedRemoteDays(c.getInt(9));
                cj.setLeaveTime(c.getInt(10));
                cj.setGymAllowance(c.getInt(11));
                return cj;
            }
            c.close();}

        return null;
    }


    // update Current Job
    public int updateCurrentJob(Job job) {
        SQLiteDatabase db = this.getWritableDatabase();

        String status = "current";
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_TITLE, job.getTitle());
        cv.put(COLUMN_COMPANY, job.getCompany());
        cv.put(COLUMN_CITY, job.getCity());
        cv.put(COLUMN_STATE, job.getState());

        cv.put(COLUMN_COST_INDEX, job.getLivingCostIndex());
        cv.put(COLUMN_SALARY, job.getYearlySalary());
        cv.put(COLUMN_BONUS, job.getYearlyBonus());
        cv.put(COLUMN_REMOTEDAYS, job.getWeeklyAllowedRemoteDays());
        cv.put(COLUMN_LEAVETIME, job.getLeaveTime());
        cv.put(COLUMN_GYMALLOW, job.getGymAllowance());
        cv.put(COLUMN_SCORE, job.getScore());

        // updating row
        return db.update(TABLE_JOBS, cv, COLUMN_STATUS + " = ?",
                new String[]{status});
    }

    // update score in Table

    public void updateAllJobScore(){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_JOBS;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new job objects. Put them
            // into the return list.
            do {
                int id = cursor.getInt(0);
                int costIndex = cursor.getInt(6);
                int salary = cursor.getInt(7);
                int bonus = cursor.getInt(8);
                int allowedRemote = cursor.getInt(9);
                int leave = cursor.getInt(10);
                int gymAllow = cursor.getInt(11);

                Job newJob = new Job();
                newJob.setLivingCostIndex(costIndex);
                newJob.setYearlySalary(salary);
                newJob.setYearlyBonus(bonus);
                newJob.setWeeklyAllowedRemoteDays(allowedRemote);
                newJob.setLeaveTime(leave);
                newJob.setGymAllowance(gymAllow);

                Weight weight = getAllWgts();
                newJob.setScore(weight);
                int score = newJob.getScore();

                String updateQuery = "UPDATE " + TABLE_JOBS + " SET " + COLUMN_SCORE + " = "+ score +" WHERE " + COLUMN_ID +" = " + id;
                db.execSQL(updateQuery);

            } while (cursor.moveToNext());
        } else {
            // failure, do not add anything to the list
        }
        cursor.close();


    }





    // ------- "WEIGHTS" Table Methods ---------- //

    // retrieves all weights in the WEIGHTS table in the form of a list
    public Weight getAllWgts() {

        // get data from the database
        String queryString = "SELECT * FROM " + TABLE_WEIGHTS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        Weight weight = new Weight(); // default value 1

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WGT_SALARY, weight.getYearlySalaryWeight());
        cv.put(COLUMN_WGT_BONUS, weight.getYearlyBonusWeight());
        cv.put(COLUMN_WGT_LEAVETIME, weight.getLeaveTimeWeight());
        cv.put(COLUMN_WGT_REMOTEDAYS, weight.getAllowedRemoteDaysWeight());
        cv.put(COLUMN_WGT_GYMALLOW, weight.getGymAllowanceWeight());

        if (!cursor.moveToFirst()){
            db.insert(TABLE_WEIGHTS, null, cv);

        }else {

            weight.setWeights(cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    cursor.getInt(4));

        }
        cursor.close();

        return weight;
    }

    // update Weights
    public void updateWeights(Weight weight) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WGT_SALARY, weight.getYearlySalaryWeight());
        cv.put(COLUMN_WGT_BONUS, weight.getYearlyBonusWeight());
        cv.put(COLUMN_WGT_LEAVETIME, weight.getLeaveTimeWeight());
        cv.put(COLUMN_WGT_REMOTEDAYS, weight.getAllowedRemoteDaysWeight());
        cv.put(COLUMN_WGT_GYMALLOW, weight.getGymAllowanceWeight());

        // updating row
        String queryString = "SELECT * FROM " + TABLE_WEIGHTS;
        Cursor cursor = db.rawQuery(queryString, null);

        if (!cursor.moveToFirst()) {
            db.insert(TABLE_WEIGHTS, null, cv);
        }else{
            db.update(TABLE_WEIGHTS, cv, null, null);
        }

        cursor.close();

    }
}