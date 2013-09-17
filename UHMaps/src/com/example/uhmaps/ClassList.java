package com.example.uhmaps;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ClassList extends Activity {
	
	protected ArrayList<Class> Arr_ClassList;
	
	protected EditText EditText_Building;

	protected EditText EditText_Room;
	
	protected TextView Class_List;
	
	protected Button Button_Enter;
	
	protected Button Button_FindClass;


	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();
        Arr_ClassList = new ArrayList<Class>();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    protected void initLayout() {
    	setContentView(R.layout.activity_main);
    	EditText_Building = (EditText) this.findViewById(R.id.editText_building);
    	Button_Enter = (Button) this.findViewById(R.id.button_enter);
    	EditText_Room = (EditText) this.findViewById(R.id.editText_room);
    	Button_FindClass = (Button) this.findViewById(R.id.button_findclasses);
    	Class_List = (TextView) this.findViewById(R.id.textView_classlist);
    }
    protected void addClass(String build, int room) {
		// TODO
    	Arr_ClassList.add(new Class(build, room));
	}
    protected void initAddClassListeners() {
        Button_Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            	String Build = EditText_Building.getText().toString();
            	String room_string = EditText_Room.getText().toString();
            	int room = Integer.parseInt(room_string);
                if (Build != null && !("").equals(Build))
                    addClass(Build, room);
                EditText_Building.setText("");
                EditText_Room.setText("");
                Class_List.setText(Build);
                Class_List.setText(room_string);
                

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);

                imm.hideSoftInputFromWindow(EditText_Building.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(EditText_Room.getWindowToken(), 0);
            }
        });
        EditText_Building.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_ENTER) {
                    String Build = EditText_Building.getText().toString().replaceAll("\n", "");
                    if (Build != null && !("").equals(Build)) {
                        addClass(Build, 1);
                    }
                    EditText_Building.setText("");

                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    Log.d("uhmaps","log"+EditText_Building);
                    imm.hideSoftInputFromWindow(EditText_Building.getWindowToken(), 0);
                }
                return false;
            }
        });
    }
}
