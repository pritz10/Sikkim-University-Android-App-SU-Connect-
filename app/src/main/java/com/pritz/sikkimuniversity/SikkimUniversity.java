package com.pritz.sikkimuniversity;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by pritz on 22/12/17.
 */

public class SikkimUniversity extends Application {

    private static FirebaseDatabase mDatabase;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }

        return mDatabase;
    }
}