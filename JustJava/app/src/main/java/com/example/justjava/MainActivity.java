/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends android.app.Activity {

    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    /**Method*/
    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(this,"You can not order more than 100 cups",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    /**Method*/
    public void decrement(View view) {
        if(quantity==1){
            Toast.makeText(this,"You can not order less than 1 cup",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    /**Method*/
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText name =(EditText) findViewById(R.id.name);
        String enterName = name.getText().toString();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(price,hasWhippedCream,hasChocolate,enterName);


            Intent intent = new Intent(Intent.ACTION_SEND);
            //intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order For " + enterName);
            intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice(boolean hasWhippedCream, boolean hasChocolate) {
        int price = 0;
        if(hasChocolate && hasWhippedCream){
            price = quantity * (5+3);
        } else if (hasChocolate) {
            price = quantity * (5+2);
        } else if (hasWhippedCream){
            price = quantity * (5+1);
        }
        else{
            price = quantity * 5;
        }
        return price;
    }

    private String createOrderSummary(int price, boolean addWhippedCream,boolean addChocolate,String enterName){
        String finalOutput = "Name : "+ enterName+ "\nAdd Whipped cream? " + addWhippedCream +"\nAdd Chocolate? "+ addChocolate +"\nQuantity : " + quantity + "\nTotal: $" + price + "\nThank you!";
        return finalOutput;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


}


