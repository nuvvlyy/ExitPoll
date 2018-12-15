package com.example.exitpoll;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exitpoll.db.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.exitpoll.db.DatabaseHelper.*;

public class ShowScore extends AppCompatActivity {


    private DatabaseHelper mHelper;
    private SQLiteDatabase mDb;
    private List<VoteItem> mItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showscore);
        mHelper = new DatabaseHelper(ShowScore.this);
        mDb = mHelper.getWritableDatabase();


        Button vButton = findViewById(R.id.button);
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHelper helper = new DatabaseHelper(ShowScore.this);
                SQLiteDatabase db = helper.getWritableDatabase();


                db.execSQL("UPDATE " + TABLE_NAME + " SET " +
                        COL_SCORE + "= 0 "

                );
                recreate();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadData();
        setupListView();
    }

        private void loadData() {

            Cursor c = mDb.query(TABLE_NAME, null, null, null, null, null, null);

            mItemList = new ArrayList<>();
            while (c.moveToNext()) {
                long id = c.getLong(c.getColumnIndex(COL_ID));
                int title =  c.getInt(c.getColumnIndex(COL_SCORE));
                String image = c.getString(c.getColumnIndex(COL_IMAGE));

                VoteItem item = new VoteItem(id,title,image);
                mItemList.add(item);
            }
            c.close();
        }

        private void setupListView() {
            ListAdapter adapter = new ListAdapter(
                    ShowScore.this,
                    R.layout.activity_vote_item,
                    mItemList
            );
            ListView lv = findViewById(R.id.result_list_view);
            lv.setAdapter(adapter);

        }


    }

