/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.skyler.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Create public quantity and price variables to be used by most methods.
     */
    int quantity;
    int cupPrice = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the text value of the quantity_text_view TextView, get the integer value from it
        // and set the initial value of "quantity" to that value.
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantity = Integer.parseInt(quantityTextView.getText().toString());
        initialPrice();
    }

    /**
     * This method is called on create and displays the correct initial price total
     * based on the text in quantity_text_view.
     */
    public void initialPrice() {
        String priceMessage = "Total: $" + (quantity * cupPrice);
        displayMessage(priceMessage);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String message = createOrderSummary(calculatePrice());
        displayMessage(message);
    }

    /**
     * Calculates the price of the order.
     *
     * @return the total price
     */
    private int calculatePrice() {
        return (quantity * cupPrice);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity ++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        if(quantity > 0)
            quantity --;

        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * Creates the summary for an order.
     *
     * @param price is the total price of the order.
     * @return the complete String message for the order summary.
     */
    private String createOrderSummary(int price){
        String orderMessage;
        orderMessage = "Name:  Skyler" + "\n"
                        + "Quantity:  " + quantity + "\n"
                        + "Total:  " + "$" + price + "\n"
                        + "Thank you!";

        return orderMessage;
    }

}