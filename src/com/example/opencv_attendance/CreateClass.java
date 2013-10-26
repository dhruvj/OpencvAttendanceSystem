package com.example.opencv_attendance;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateClass extends Activity {
	
	EditText className;
	Button saveClass;
	String nameOfClass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.createclass);
		saveClass = (Button)findViewById(R.id.saveClass);
		className = (EditText)findViewById(R.id.className);
		saveClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                 nameOfClass = className.getText().toString();
                 DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                 db.addClass(nameOfClass);
                 Toast toast = Toast.makeText(getApplicationContext(), db.getClass(2), Toast.LENGTH_SHORT);
                 toast.show();
                 
                 
            }
        });
		

	}
	
}
