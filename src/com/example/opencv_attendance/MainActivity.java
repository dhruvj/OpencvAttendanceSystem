package com.example.opencv_attendance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	Button createClass;
	Button attendanceClassList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_createclass);
		
		createClass = (Button)findViewById(R.id.makeClass);
		createClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToCreateClass = new Intent("CreateClass");
                startActivity(goToCreateClass);
            }
        });
		
		attendanceClassList = (Button)findViewById(R.id.seeAttendance);
		attendanceClassList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent goToattendanceClassList = new Intent("AttendanceClassList");
                startActivity(goToattendanceClassList);
            }
        });
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.createclass, menu);
		return true;
	}

}
