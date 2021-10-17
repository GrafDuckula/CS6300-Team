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
            COLUMN_GYMALLOW + " INT " +
            ")";

    // WEIGHTS table create statement
    private static final String CREATE_TABLE_WEIGHTS = "CREATE TABLE " + TABLE_WEIGHTS + " (" +
            COLUMN_WGT_SALARY + " INT DEFAULT 1, " +
            COLUMN_WGT_BONUS + " INT DEFAULT 1, " +
            COLUMN_WGT_LEAVETIME + " INT DEFAULT 1, " +
            COLUMN_WGT_REMOTEDAYS + " INT DEFAULT 1, " +
            COLUMN_WGT_GYMALLOW + " INT DEFAULT 1 " +
            ")";

    public DatabaseHelper(@Nullable Context context) {
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
        String queryString = "SELECT * FROM " + TABLE_JOBS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new job objects. Put them
            // into the return list.
            do {

                String status = cursor.getString(1);
                String title = cursor.getString(2);
                String company = cursor.getString(3);
                String city = cursor.getString(4);
                String state = cursor.getString(5);

                int costindex = cursor.getInt(6);
                int salary = cursor.getInt(7);
                int bonus = cursor.getInt(8);
                int allowedRemote = cursor.getInt(9);
                int leave = cursor.getInt(10);
                int gymAllow = cursor.getInt(11);

                Job newJob = new Job(
                        status,
                        title,
                        company,
                        city,
                        state,
                        costindex,
                        salary,
                        bonus,
                        allowedRemote,
                        leave,
                        gymAllow);

                // add record to list
                returnList.add(newJob);


            } while (cursor.moveToNext());
        } else {
            // failure, do not add anything to the list
        }
        cursor.close();
        db.close();


        return returnList;
    }

    // retrieve Current Job
    public Job getCurrentJob() {
        SQLiteDatabase db = this.getReadableDatabase();

        String status = "current";
        String selectQuery = "SELECT  * FROM " + TABLE_JOBS + " WHERE "
                + COLUMN_STATUS + " = " + status;

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Job cj = new Job();
        cj.setStatus(c.getString(c.getColumnIndex(COLUMN_STATUS))); // Remove?
        cj.setTitle(c.getString(c.getColumnIndex(COLUMN_TITLE)));
        cj.setCompany(c.getString(c.getColumnIndex(COLUMN_COMPANY)));
        cj.setCity(c.getString(c.getColumnIndex(COLUMN_CITY)));
        cj.setState(c.getString(c.getColumnIndex(COLUMN_STATE)));
        cj.setLivingCostIndex(c.getInt(c.getColumnIndex(COLUMN_COST_INDEX)));
        cj.setYearlySalary(c.getInt(c.getColumnIndex(COLUMN_SALARY)));
        cj.setYearlyBonus(c.getInt(c.getColumnIndex(COLUMN_BONUS)));
        cj.setWeeklyAllowedRemoteDays(c.getInt(c.getColumnIndex(COLUMN_REMOTEDAYS)));
        cj.setLeaveTime(c.getInt(c.getColumnIndex(COLUMN_LEAVETIME)));
        cj.setGymAllowance(c.getInt(c.getColumnIndex(COLUMN_GYMALLOW)));

        c.close();
        db.close();

        return cj;
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

        // updating row
        return db.update(TABLE_JOBS, cv, COLUMN_STATUS + " = ?",
                new String[]{status});
    }


    // ------- "WEIGHTS" Table Methods ---------- //

    // retrieves all weights in the WEIGHTS table in the form of a list
    public List<WeightModel> getAllWgts() {
        List<WeightModel> returnList = new ArrayList<>();

        // get data from the database
        String queryString = "SELECT * FROM " + TABLE_WEIGHTS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through the cursor (result set) and create new customer objects. Put them
            // into the return list.
            do {
                int salaryWeight = cursor.getInt(0);
                int bonusWeight = cursor.getInt(1);
                int allowedRemoteWeight = cursor.getInt(2);
                int leaveWeight = cursor.getInt(3);
                int gymAllowWeight = cursor.getInt(4);


                WeightModel newWeight = new WeightModel(
                        salaryWeight,
                        bonusWeight,
                        allowedRemoteWeight,
                        leaveWeight,
                        gymAllowWeight);

                // add record to list
                returnList.add(newWeight);


            } while (cursor.moveToNext());
        } else {
            // failure, do not add anything to the list
        }
        cursor.close();
        db.close();


        return returnList;
    }

    // update Weights
    public int updateWeights(WeightModel weightModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WGT_SALARY, weightModel.getYearlySalaryWeight());
        cv.put(COLUMN_WGT_BONUS, weightModel.getYearlyBonusWeight());
        cv.put(COLUMN_WGT_LEAVETIME, weightModel.getLeaveTimeWeight());
        cv.put(COLUMN_WGT_REMOTEDAYS, weightModel.getAllowedRemoteDaysWeight());
        cv.put(COLUMN_WGT_GYMALLOW, weightModel.getGymAllowanceWeight());

        // updating row
        return db.update(TABLE_WEIGHTS, cv, null, null);

    }
}