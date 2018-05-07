package com.example.lenovo.application1;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Developer extends ListActivity {
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[]{"Developer: Martin", "Director: David", "Lecturer: Henry"};
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,values);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }

}

