package com.united.data;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

public class DatabaseManager
{
    // Singleton mInstance
    static private DatabaseManager mInstance;

    static public void init(Context ctx)
    {
        if (null == mInstance)
        {
            mInstance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance()
    {
        return mInstance;
    }

    private DatabaseHelper helper;

    private DatabaseManager(Context ctx)
    {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper()
    {
        return helper;
    }

    public List<PatientData> getAllPatients()
    {
        List<PatientData> patientList = null;
        try
        {
            patientList = getHelper().getPatientDataDao().queryForAll();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return patientList;
    }

    public void addPatientData(PatientData patientData)
    {
        try {
            getHelper().getPatientDataDao().create(patientData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePatientData(PatientData patientData)
    {
        try {
            getHelper().getPatientDataDao().update(patientData);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
