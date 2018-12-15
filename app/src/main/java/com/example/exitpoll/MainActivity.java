package com.example.exitpoll;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.exitpoll.db.DatabaseHelper.*;
import static com.example.exitpoll.db.DatabaseHelper.COL_ID;
import static com.example.exitpoll.db.DatabaseHelper.COL_SCORE;
import static com.example.exitpoll.db.DatabaseHelper.TABLE_NAME;

import com.example.exitpoll.db.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nPageButton = findViewById(R.id.resource);
        nPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShowScore.class);
                startActivity(intent);
            }


        });

        Button vOneButton = findViewById(R.id.one);
        vOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                        COL_SCORE + "=" + COL_SCORE + " + 1 " +
                        "WHERE " + COL_ID+ " = ?", new String[]{String.valueOf(2)}
                );
            }
        });
        Button vTwoButton = findViewById(R.id.two);
        vTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                        COL_SCORE + "=" + COL_SCORE + " + 1 " +
                        "WHERE " + COL_ID+ " = ?", new String[]{String.valueOf(3)}
                );
            }
        });
        Button vThreeButton = findViewById(R.id.three);
        vThreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                        COL_SCORE + "=" + COL_SCORE + " + 1 " +
                        "WHERE " + COL_ID+ " = ?", new String[]{String.valueOf(4)}
                );
            }
        });
        Button vNovoteButton = findViewById(R.id.novote);
        vNovoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(MainActivity.this);
                SQLiteDatabase db = helper.getWritableDatabase();
                db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                        COL_SCORE + "=" + COL_SCORE + " + 1 " +
                        "WHERE " + COL_ID+ " = ?", new String[]{String.valueOf(1)}
                );
            }
        });


    }
}
