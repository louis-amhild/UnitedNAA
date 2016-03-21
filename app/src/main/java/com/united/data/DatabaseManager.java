/**
    United Projects Nurse Assistant App
        Copyright (C) 2016 United Projects
        Author: Louis Amhild, Pedro Olivares

        This program is free software: you can redistribute it and/or modify
        it under the terms of the GNU General Public License as published by
        the Free Software Foundation, version 3 of the License, or
        (at your option) any later version.

        This program is distributed in the hope that it will be useful,
        but WITHOUT ANY WARRANTY; without even the implied warranty of
        MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        GNU General Public License for more details.

        You should have received a copy of the GNU General Public License
        along with this program.  If not, see <http://www.gnu.org/licenses/>.
        package com.UnitedProjects,naa;
*/

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
