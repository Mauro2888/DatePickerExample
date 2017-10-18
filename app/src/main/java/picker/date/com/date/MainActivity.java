package picker.date.com.date;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button mOpenPicker;
    EditText mTextData;
    DatePickerDialog.OnDateSetListener onDateSetListener;

    Button mOpenPickerOra;
    EditText mTextDataOra;
    TimePickerDialog.OnTimeSetListener mTimeSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextData = (EditText) findViewById(R.id.text_data) ;
        mOpenPicker = (Button)findViewById(R.id.open_picker);
        mOpenPickerOra = (Button)findViewById(R.id.open_picker_ora);
        mTextDataOra = (EditText)findViewById(R.id.text_ora);

        //Data
        final Calendar calendar = Calendar.getInstance();
        final SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
        final SimpleDateFormat formatOra = new SimpleDateFormat("HH:mm");

        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.YEAR,year);
                mTextData.setText(formatData.format(calendar.getTime()));
            }
        };


        mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                calendar.set(Calendar.MINUTE,minute);
                mTextDataOra.setText(formatOra.format(calendar.getTime()));

            }
        };

        mOpenPickerOra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(MainActivity.this,mTimeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),true).show();
            }
        });


        mOpenPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, onDateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }



}
