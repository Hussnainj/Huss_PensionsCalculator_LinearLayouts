package com.example.wasim.pensionscalculator;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.icu.util.GregorianCalendar;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Calendar;

import java.util.Date;


public class MainActivity extends AppCompatActivity {

    EditText retirementET,appointmentET,birthET,payET;
   int retirementYear,retirementMonth,retirementDay,appointmentYear,appointmentMonth,appointmentDay,birthYear,birthMonth,birthDay;
    static  final int DIAL_LOG = 0;
    static  final int DIAL_LOG1 = 1;
    static  final int DIAL_LOG2 = 2;
    String retirementYearString, retirementMonthString,retirementDayString,appointmentYearString,appointmentMonthString,appointmentDayString,
            birthYearString, birthMonthString, birthDayString,payETString;
    Spinner typeSpinner,paySpinner,serviceYearSpinner,serviceMonthSpinner,serviceDateSpinner;
   String typeSpinnerString,paySpinnerString,serviceYearSpinnerString,serviceMonthSpinnerString,serviceDateSpinnerString;
    String showRecord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final Calendar cal =Calendar.getInstance();
        retirementYear= cal.get(Calendar.YEAR);
        retirementMonth= cal.get(Calendar.MONTH);
        retirementDay= cal.get(Calendar.DATE);
        appointmentYear= cal.get(Calendar.YEAR);
        appointmentMonth= cal.get(Calendar.MONTH);
        appointmentDay= cal.get(Calendar.DATE);
        birthYear= cal.get(Calendar.YEAR);
        birthMonth= cal.get(Calendar.MONTH);
        birthDay= cal.get(Calendar.DATE);

       /* Date dt = new Date();
        retirementYear=dt.getYear();
        retirementMonth=dt.getMonth();
        dt.getDay();*/
        showdialogonbuttonclick();

    }

    public void showdialogonbuttonclick()
    {
       // this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        retirementET = (EditText) findViewById(R.id.retirementet);
        appointmentET = (EditText) findViewById(R.id.appointmentet);
        birthET = (EditText) findViewById(R.id.birthet);


        retirementET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIAL_LOG);
            }




        });
        appointmentET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIAL_LOG1);
            }
        });
        birthET.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIAL_LOG2);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog (int id)
    {

        if (id == DIAL_LOG)
        {
            return  new DatePickerDialog(this,dpickerListner,retirementYear,retirementMonth,retirementDay);

        }
        if (id == DIAL_LOG1)
        {
            return  new DatePickerDialog(this,dpickerListner2,appointmentYear,appointmentMonth,appointmentDay);

        }
        if (id == DIAL_LOG2)
        {
            return  new DatePickerDialog(this,dpickerListner3,birthYear,birthMonth,birthDay);

        }
        return  null;

    }

    private  DatePickerDialog.OnDateSetListener dpickerListner = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            retirementYear= i;
            retirementMonth = i1 +1;
            retirementDay= i2;
            Toast.makeText(getApplicationContext(),retirementYear+ "/ " + retirementMonth + "/" + retirementDay + " ", Toast.LENGTH_SHORT).show();
            retirementYearString =String.valueOf(retirementYear);
            retirementMonthString=String.valueOf(retirementMonth);
            retirementDayString=String.valueOf(retirementDay);
            retirementET.setText(retirementYearString+"/"+retirementMonthString+"/"+retirementDayString, TextView.BufferType.EDITABLE);

        }
    };
    private  DatePickerDialog.OnDateSetListener dpickerListner2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            appointmentYear= i;
            appointmentMonth = i1 +1;
            appointmentDay= i2;
            Toast.makeText(getApplicationContext(),appointmentYear+ "/ " + appointmentMonth + "/" + appointmentDay + " ", Toast.LENGTH_SHORT).show();
            appointmentYearString=String.valueOf(appointmentYear);
            appointmentMonthString=String.valueOf(appointmentMonth);
            appointmentDayString=String.valueOf(appointmentDay);
            appointmentET.setText(appointmentYearString+"/"+appointmentMonthString+"/"+appointmentDayString, TextView.BufferType.EDITABLE);
        }
    };
    private  DatePickerDialog.OnDateSetListener dpickerListner3 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            birthYear= i;
            birthMonth = i1 +1;
            birthDay= i2;
            Toast.makeText(getApplicationContext(),birthYear+ "/ " + birthMonth+ "/" + birthDay + " ", Toast.LENGTH_SHORT).show();
            birthYearString=String.valueOf(birthYear);
            birthMonthString=String.valueOf(birthMonth);
            birthDayString=String.valueOf(birthDay);
            birthET.setText( birthYearString+"/"+birthMonthString+"/"+birthDayString, TextView.BufferType.EDITABLE);
        }
    };

    public void viewCalculation(View view) {

          //typeSpinner,paySpinner,serviceYearSpinner,serviceMonthSpinner,serviceDateSpinner;

        typeSpinner = (Spinner) findViewById(R.id.typespinner);
        typeSpinnerString = String.valueOf(typeSpinner.getSelectedItem());

        paySpinner = (Spinner) findViewById(R.id.payspinner);
        paySpinnerString = String.valueOf(paySpinner.getSelectedItem());

        serviceYearSpinner = (Spinner) findViewById(R.id.serviceyear);
        serviceYearSpinnerString = String.valueOf(serviceYearSpinner.getSelectedItem());

        serviceMonthSpinner = (Spinner) findViewById(R.id.servicemonth);
        serviceMonthSpinnerString = String.valueOf(serviceMonthSpinner.getSelectedItem());

        serviceDateSpinner = (Spinner) findViewById(R.id.serviceday);
        serviceDateSpinnerString = String.valueOf(serviceDateSpinner.getSelectedItem());

        payET = (EditText) findViewById(R.id.payet);
        payETString=String.valueOf(payET.getText().toString());


        showRecord = "Pension Type:  " +typeSpinnerString + "\n"
                      + "Pay Scale:        " +paySpinnerString+ "\n"
                      + "Pay:                  " +payETString+ "\n\n"
                      + "  ***** Year/Month/Day ******" + "\n"
                      +"\n"
                      + "Non Qualify Service:       " +serviceYearSpinnerString+"/"+serviceMonthSpinnerString+"/"+serviceDateSpinnerString+ "\n"
                      + "Retirement:       " +retirementYearString+"/"+retirementMonthString+"/"+retirementDayString+ "\n"
                      + "Appointment:   " +appointmentYearString+"/"+appointmentMonthString+"/"+appointmentDayString+ "\n"
                      + "Birth:                  " +birthYearString+"/"+birthMonthString+"/"+birthDayString+ "\n";
        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setMessage( showRecord).setTitle("Entered Record by User").create().show();

    }
}
