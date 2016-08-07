package com.example.android.coffeeorder;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.StringCharacterIterator;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int num ;
    int CoffeePricePerCup =5;
    int WhippedCreamPricePerCup = 1;
    int ChocolatePriceperCup = 2;
    boolean hasWhippedCream;
    boolean hasChocolate;


private String calculation(int num,boolean CheckWhipped,boolean CheckChocolate){
    TextView textView = (TextView) findViewById(R.id.orderDetailView);
    if(CheckWhipped && CheckChocolate){
        CoffeePricePerCup = 5;
        CoffeePricePerCup += WhippedCreamPricePerCup + ChocolatePriceperCup;
    }
    else if(CheckWhipped && !CheckChocolate){
        CoffeePricePerCup = 5;
        CoffeePricePerCup += WhippedCreamPricePerCup;
    }
    else if(!CheckWhipped && CheckChocolate){
        CoffeePricePerCup = 5;
        CoffeePricePerCup += ChocolatePriceperCup;
    }
    else{
        CoffeePricePerCup = 5;
    }
    textView.setText("$"+(num*CoffeePricePerCup)+".00");
    return (""+(num*CoffeePricePerCup)+".00");
}


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView SecondTextView = (TextView) findViewById(R.id.SecondTextView);
        SecondTextView.setText("" + number);
        TextView textView = (TextView) findViewById(R.id.OrderSummary);
        textView.setText("Price");

    }
    private boolean IsChechkWhippedCream(){
        CheckBox whippedCream = (CheckBox) findViewById(R.id.Whipped_Cream_CheckedBox);
        return hasWhippedCream = whippedCream.isChecked();

    }
    private boolean IsChechkChocolate(){
        CheckBox Chocolate = (CheckBox) findViewById(R.id.Chocolate_CheckBox);
        return hasChocolate = Chocolate.isChecked();

    }
    public void OrderSummary(View view){
        EditText Name_TextField = (EditText) findViewById(R.id.Name_TextField);
        TextView textView = (TextView) findViewById(R.id.orderDetailView);
        String Check_Name_field = Name_TextField.getText().toString();
        if(Check_Name_field.matches("")){
            Toast toast = Toast.makeText(this,"Please Enter Name",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.s
            toast.show();

        }
        else if(IsChechkWhippedCream() && IsChechkChocolate()){

        textView.setText( "Name : "+Name_TextField.getText()+"\nTotal Cup Of Coffee "+num+"\nWith Whipped Cream And Chocolate.\nTotal $"+calculation(num,IsChechkWhippedCream(),IsChechkChocolate())+ "\nThank You!");

        }
        else if(IsChechkWhippedCream() && !IsChechkChocolate()){

        textView.setText( "Name : "+Name_TextField.getText()+"\nTotal Cup Of Coffee "+num+"\nWith Whipped Cream.\nTotal $"+calculation(num,IsChechkWhippedCream(),IsChechkChocolate())+ "\nThank You!");
        }
        else if(IsChechkChocolate() && !IsChechkWhippedCream()){

            textView.setText( "Name : "+Name_TextField.getText()+"\nTotal Cup Of Coffee "+num+"\nWith Chocolate.\nTotal $"+calculation(num,IsChechkWhippedCream(),IsChechkChocolate())+ "\nThank You!");
        }
        else{

            textView.setText( "Name : "+Name_TextField.getText()+"\nTotal Cup Of Coffee "+num+" \n" +
                    "\nTotal $\"+calculation(num,IsChechkWhippedCream(),IsChechkChocolate())\nThank You!");
        }
        Name_TextField.setText(null);
        TextView textView1 = (TextView) findViewById(R.id.OrderSummary);
       if(!Check_Name_field.matches("")){
        textView1.setText("Order Summary");}
    }
    public void Increment(View view){
        display(++num);
        calculation(num,IsChechkWhippedCream(),IsChechkChocolate());
    }
    public void Decrement(View view){

        display(--num > 0 ? num : 0);
        if(num<0){
            num=0;
        }
        calculation(num,IsChechkWhippedCream(),IsChechkChocolate());

    }
}
