package com.united.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class PatientData
{
    @DatabaseField(generatedId=true)
    private int id;

    @DatabaseField
    private String name;

    @DatabaseField
    private String description;

    @DatabaseField(foreign=true,foreignAutoRefresh=true)
    private PatientData list;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setList(PatientData list) {
        this.list = list;
    }

    public PatientData getList() {
        return list;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
