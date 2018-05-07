package com.example.lenovo.application1;
//EventEditor
//activity_event_editor

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


public class EventEditor extends AppCompatActivity {
    ActionBar actionBar;
    public static final String TABLE_NAME ="players";
    DBHelper myDBHelper;
    Button insertButton;
    TextView textView;
    EditText editTextName;
    EditText editTextScore;
    ListView listView;
    String[] allColumns = new String[]{"_id","name","score"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_editor);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#BDB76B")));

        myDBHelper = new DBHelper(this);
        insertButton = (Button) findViewById(R.id.buttonInsert);
        listView = (ListView) findViewById(R.id.listView);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextScore = (EditText) findViewById(R.id.editTextScore);
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(editTextName.getText().toString(), editTextScore
                        .getText().toString());
                displayPlayers();

            }
        });
    }
    public List<String> getAllPlayers(){
        List<String> players = new ArrayList<String>();
        SQLiteDatabase db = myDBHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, allColumns, null, null, null, null, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("_id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String score = cursor.getString(cursor.getColumnIndex("score"));
            players.add(id + " . " + name + " ： " + score);
        }
        return players;
    }
    void displayPlayers(){
        List<String> values = getAllPlayers();
                if (values != null){
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                            android.R.layout.simple_list_item_1,values);
            listView.setAdapter(adapter);
        }
    }
    public void insert(String name, String score){
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("score", score);
        SQLiteDatabase db = myDBHelper.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }
}
