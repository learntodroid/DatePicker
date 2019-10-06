package com.learntodroid.datepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class DatesInRangeActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TextView dateValueTextView;
    private Button updateDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker = (DatePicker) findViewById(R.id.date_picker);
        dateValueTextView = (TextView) findViewById(R.id.date_selected_text_view);
        updateDateButton = (Button) findViewById(R.id.update_date_button);

        // disable dates before two days and after two days after today
        Calendar today = Calendar.getInstance();
        Calendar twoDaysAgo = (Calendar) today.clone();
        twoDaysAgo.add(Calendar.DATE, -2);
        Calendar twoDaysLater = (Calendar) today.clone();
        twoDaysLater.add(Calendar.DATE, 2);
        datePicker.setMinDate(twoDaysAgo.getTimeInMillis());
        datePicker.setMaxDate(twoDaysLater.getTimeInMillis());

        updateDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateValueTextView.setText("Selected date: " + (datePicker.getMonth()+1) + "/" + datePicker.getDayOfMonth() + "/" + datePicker.getYear());
            }
        });
    }
}
