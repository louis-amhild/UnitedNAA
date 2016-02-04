package com.united.data;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

public class PatientData extends SugarRecord
{
    @Unique
    String isbn;
    String title;
    String edition;

    // Default constructor is necessary for SugarRecord
    public PatientData() {

    }

    public PatientData(String isbn, String title, String edition) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
    }
}
