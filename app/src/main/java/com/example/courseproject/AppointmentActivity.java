package com.example.courseproject;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AppointmentActivity extends AppCompatActivity {

    private EditText etClass, etSemester, etDateTime;
    private RadioGroup rgGender;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        etClass = findViewById(R.id.et_class);
        etSemester = findViewById(R.id.et_semester);
        rgGender = findViewById(R.id.rg_gender);
        etDateTime = findViewById(R.id.et_date_time);
        btnSubmit = findViewById(R.id.btn_submit);

        etDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimePicker();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAppointment();
            }
        });
    }

    private void showDateTimePicker() {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            calendar.set(year, month, dayOfMonth);
            TimePickerDialog timePickerDialog = new TimePickerDialog(AppointmentActivity.this, (view1, hourOfDay, minute) -> {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                etDateTime.setText(android.text.format.DateFormat.format("yyyy-MM-dd HH:mm", calendar));
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
            timePickerDialog.show();
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void submitAppointment() {
        String studentClass = etClass.getText().toString();
        String semester = etSemester.getText().toString();
        int selectedGenderId = rgGender.getCheckedRadioButtonId();
        String dateTime = etDateTime.getText().toString();

        String gender = selectedGenderId == R.id.rb_male ? "Male" : "Female";

        // Here you can add the logic to handle the form submission
        // For now, we just show a Toast message with the entered data

        Toast.makeText(this, "Class: " + studentClass + "\nSemester: " + semester + "\nGender: " + gender + "\nDate and Time: " + dateTime, Toast.LENGTH_LONG).show();
    }
}
