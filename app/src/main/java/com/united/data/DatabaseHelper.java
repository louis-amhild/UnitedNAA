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

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.united.data.PatientData;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper
{
    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "WishListDB.sqlite";

    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 1;

    // the DAO object we use to access the SimpleData table
    private Dao<PatientData, Integer> mPatientDao = null;

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource)
    {
        try
        {
            TableUtils.createTable(connectionSource, PatientData.class);
        }
        catch (SQLException e)
        {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
        catch (java.sql.SQLException e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion)
    {
        try
        {
            List<String> allSql = new ArrayList<String>();
            switch (oldVersion)
            {
                case 1:
                    //allSql.add("alter table AdData add column `new_col` VARCHAR");
                    //allSql.add("alter table AdData add column `new_col2` VARCHAR");
            }
            for (String sql : allSql)
            {
                db.execSQL(sql);
            }
        }
        catch (SQLException e)
        {
            Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<PatientData, Integer> getPatientDataDao()
    {
        if ( mPatientDao == null )
        {
            try
            {
                mPatientDao = getDao(PatientData.class);
            }
            catch (java.sql.SQLException e)
            {
                e.printStackTrace();
            }
        }
        return mPatientDao;
    }
}
