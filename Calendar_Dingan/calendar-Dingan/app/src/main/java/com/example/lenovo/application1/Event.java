package com.example.lenovo.application1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Event extends AppCompatActivity {
    public static final String TABLE_NAME ="players";
    ActionBar actionBar;
    DBHelper myDBHelper;
    ListView listView;
    String[] allColumns = new String[]{"_id","name","score"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        int a = 1;
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#a465d7")));
        myDBHelper = new DBHelper(this);
        listView = (ListView) findViewById(R.id.listView);
        if (a == 1){
            displayPlayers();
        }


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.any,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.id_designer){
            Intent intent = new Intent(Event.this, Developer.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.id_editevent){
            Intent intent = new Intent(Event.this, EventEditor.class);
            startActivity(intent);
            return true;
        }

        if(id == R.id.id_back){
            Intent intent = new Intent(Event.this, Home.class);
            startActivity(intent);
            return true;
        }

        if(id == R.id.id_cacultor){
            Intent intent = new Intent(Event.this,Cacultor.class);
            startActivity(intent);
            return true;
        }

        if(id == R.id.id_note){
            Intent intent = new Intent(Event.this,Note.class);
            startActivity(intent);
            return true;
        }
        return true;
    }

}
