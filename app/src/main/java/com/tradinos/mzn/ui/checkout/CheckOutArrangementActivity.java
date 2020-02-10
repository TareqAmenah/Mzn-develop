package com.tradinos.mzn.ui.checkout;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tradinos.mzn.R;
import com.tradinos.mzn.data.MznCart;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.models.CardType;
import com.tradinos.mzn.models.City;
import com.tradinos.mzn.models.ItemInCart;
import com.tradinos.mzn.models.TimeBlock;
import com.tradinos.mzn.models.User;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderModel;
import com.tradinos.mzn.pojo.setOrderPojo.SetOrderResponse;

import java.util.ArrayList;
import java.util.Calendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class CheckOutArrangementActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    TextView totalPriceTextView, cardFeeTextView, subtotalTextView, dateTextView;
    EditText areaET, streetET, houseNumberET, cardMessageET;
    CheckBox addCardCheckbox;
    LinearLayout cardAttributeLayout;
    Spinner cardTypeSpinner, citySpinner, timeBlouckSpinner;
    Button continueButton;

    CheckOutViewModel checkOutViewModel;
    CardType selectedCardType;
    City selectedCity;
    TimeBlock selectedTimeBlouck;

    String orderDate;
    DatePickerDialog datePickerDialog;

    float totalPrice=0;
    private String currencyName;

    private View progressLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out_arrangement);

        checkOutViewModel = ViewModelProviders.of(this).get(CheckOutViewModel.class);
        currencyName = getString(R.string.currency_name);

        MznCart.getINSTANCE().logCart();

        setUpUi();
        setUpActivity();


    }

    private void setUpActivity() {

        initializeCardTypeSpinner();
        initializeCitySpinner();
        initializeTimeBlockSpinner();

        checkOutViewModel.getOnFailureMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(CheckOutArrangementActivity.this, s, Toast.LENGTH_SHORT).show();
                showErrorDialog(s);
                progressLayout.setVisibility(View.GONE);
            }
        });
    }

    private void setUpUi() {

        setupToolbar();
        addCardCheckbox = findViewById(R.id.add_card_checkbox);
        cardAttributeLayout = findViewById(R.id.card_attribute_layout);
        totalPriceTextView = findViewById(R.id.checkout_total_price_text_view);
        subtotalTextView = findViewById(R.id.checkout_subtotal_price_text_view);
        cardFeeTextView = findViewById(R.id.checkout_card_price_text_view);
        cardTypeSpinner = findViewById(R.id.checkout_card_type_spinner);
        continueButton = findViewById(R.id.checkout_continue_button);
        citySpinner = findViewById(R.id.checkout_city_spinner);
        timeBlouckSpinner = findViewById(R.id.checkout_time_block_spinner);
        dateTextView = findViewById(R.id.checkout_date_text_view);
        areaET = findViewById(R.id.checkout_area_edit_text);
        streetET = findViewById(R.id.checkout_street_edit_text);
        houseNumberET = findViewById(R.id.checkout_house_number_edit_text);
        cardMessageET = findViewById(R.id.checkout_card_message);

        progressLayout = findViewById(R.id.progress_layout);

        subtotalTextView.setText(MznCart.getINSTANCE().getTotal() + currencyName);
        totalPrice = MznCart.getINSTANCE().getTotal();
        // TODO: get card price
        totalPriceTextView.setText(totalPrice + currencyName);

        cardAttributeLayout.setVisibility(View.GONE);

        dateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);

                datePickerDialog = new DatePickerDialog(CheckOutArrangementActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        String day, month;
                        month = i1 < 10? "0"+i1: ""+i1;
                        day = i2 < 10? "0"+i2 : ""+i2;
                        orderDate = "" + i + "-" + month + "-" + day;
                        dateTextView.setText(orderDate);
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(areaET.getText()==null || streetET.getText()==null || houseNumberET.getText() == null || orderDate==null){
                    Toast.makeText(CheckOutArrangementActivity.this, "Address details is missed", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(selectedCardType != null){
                    if (cardMessageET.getText()==null){
                        Toast.makeText(CheckOutArrangementActivity.this, "Card message is missed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }

                progressLayout.setVisibility(View.VISIBLE);

                String area = areaET.getText().toString();
                String street = streetET.getText().toString();
                String housNumber = houseNumberET.getText().toString();
                String cardMessage = cardMessageET.getText().toString();

                try {
                    User user = MznUser.getINSTANCE().getMyUser(CheckOutArrangementActivity.this);
                    String headerToken = "Bearer " + user.getToken();

                    ArrayList<SetOrderModel.ArrangementInOrder> arrangementInOrders = new ArrayList<>();
                    for (ItemInCart itemInCart : MznCart.getINSTANCE().getArrangementsList()) {
                        arrangementInOrders.add(new SetOrderModel.ArrangementInOrder(itemInCart.getId(), itemInCart.getQuantity(), itemInCart.getNote()));
                    }

                    ArrayList<SetOrderModel.TrayInOrder> trayInOrders = new ArrayList<>();
                    for (ItemInCart itemInCart : MznCart.getINSTANCE().getTraysList()) {
                        trayInOrders.add(new SetOrderModel.TrayInOrder(itemInCart.getId(), itemInCart.getQuantity(), itemInCart.getNote()));
                    }

                    if(selectedCardType == null)
                        selectedCardType = new CardType(0,"", 0.0f);

                    SetOrderModel setOrderModel = new SetOrderModel(
                            user.getId(),
                            arrangementInOrders,
                            trayInOrders,
                            1,
                            selectedTimeBlouck.getId(),
                            area,
                            selectedCity.getId(),
                            street,
                            housNumber,
                            0.0,
                            0.0,
                            0,
                            addCardCheckbox.isChecked()? 1:0,
                            selectedCardType.getId(),
                            cardMessage,
                            orderDate,
                            "This is note");

                    checkOutViewModel.setOrder(headerToken, setOrderModel).observe(CheckOutArrangementActivity.this, new Observer<SetOrderResponse>() {
                        @Override
                        public void onChanged(SetOrderResponse setOrderResponse) {
                            if(setOrderResponse.getMessage()!=null){
                                Toast.makeText(CheckOutArrangementActivity.this, setOrderResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                MznCart.getINSTANCE().clear();
                            }
                            progressLayout.setVisibility(View.GONE);
                        }
                    });


                } catch (MznUser.UserNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setElevation(0);
        toolbar.setElevation(0);
        TextView toolbar_title = toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText("Checkout Arrangement");



        ImageView shoppingCartAction = toolbar.findViewById(R.id.toolbar_shopping_cart);
        shoppingCartAction.setVisibility(View.INVISIBLE);

        ImageView backArrowAction = toolbar.findViewById(R.id.toolbar_back_arrow);
        backArrowAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void initializeCardTypeSpinner() {
        ArrayList<String> cardTypeSpinnerTextList = new ArrayList<>();
        ArrayList<CardType> cardTypeArrayList = MznUser.getINSTANCE().getFormData().getCardTypes();
        for (CardType cardType : cardTypeArrayList) {
            cardTypeSpinnerTextList.add(cardType.getName());
        }



        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, cardTypeSpinnerTextList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cardTypeSpinner.setAdapter(spinnerArrayAdapter);

        cardTypeSpinner.setOnItemSelectedListener(onCardTypeSelectedListener);
    }

    private void initializeCitySpinner() {
        ArrayList<String> citySpinnerTextList = new ArrayList<>();
        ArrayList<City> cityArrayList = MznUser.getINSTANCE().getFormData().getCity();
        for (City city : cityArrayList) {
            citySpinnerTextList.add(city.getName());
        }



        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, citySpinnerTextList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(spinnerArrayAdapter);

        citySpinner.setOnItemSelectedListener(onCitySelectedListener);
    }

    private void initializeTimeBlockSpinner() {
        ArrayList<String> timeSpinnerTextList = new ArrayList<>();

        ArrayList<TimeBlock> timeArrayList = MznUser.getINSTANCE().getFormData().getTime_blocks();
        for (TimeBlock timeBlock : timeArrayList) {
            timeSpinnerTextList.add(timeBlock.getAsString());
        }

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, timeSpinnerTextList);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeBlouckSpinner.setAdapter(spinnerArrayAdapter);

        timeBlouckSpinner.setOnItemSelectedListener(onTimeBlockSelectedListener);
    }

    private void refreshActivity(){
        finish();
        startActivity(getIntent());
    }

    private void showErrorDialog(String message){
        new AlertDialog.Builder(this)
                .setTitle("Something wrong!")
                .setMessage(message)
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        setUpActivity();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.add_card_checkbox:
                if (checked){
                    cardAttributeLayout.setVisibility(View.VISIBLE);
                    if(selectedCardType!= null){
                        totalPrice += selectedCardType.getFee();
                        totalPriceTextView.setText(totalPrice + currencyName);
                        cardFeeTextView.setText(selectedCardType.getFee() + currencyName);
                    }
                } else {
                    cardAttributeLayout.setVisibility(View.GONE);
                    cardFeeTextView.setText(0.0 + currencyName);
                    totalPrice = MznCart.getINSTANCE().getTotal();
                    totalPriceTextView.setText(totalPrice + currencyName);
                }
                break;
        }
    }

    private void onCardTypeSelected(int i){
        selectedCardType = MznUser.getINSTANCE().getFormData().getCardTypes().get(i);
        cardFeeTextView.setText(selectedCardType.getFee() + currencyName);
        totalPrice = MznCart.getINSTANCE().getTotal() + selectedCardType.getFee();
        totalPriceTextView.setText(totalPrice + currencyName);
    }

    private void onCitySelected(int i){
        selectedCity = MznUser.getINSTANCE().getFormData().getCity().get(i);
    }

    private void onTimeBlockSelected(int i){
        selectedTimeBlouck = MznUser.getINSTANCE().getFormData().getTime_blocks().get(i);
    }

    private String getArrangementsListAsString(ArrayList<SetOrderModel.ArrangementInOrder> arrayList) {

        String s = "[";
        for (int i = 0; i < arrayList.size(); i++) {
            if(i!=0)
                s+=",";
            s+= arrayList.get(i).getAsString();
        }
        s+="]";

        Log.v("**********", s);
        return s;
    }



    // Listeners
    private AdapterView.OnItemSelectedListener onCardTypeSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            onCardTypeSelected(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener onCitySelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            onCitySelected(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private AdapterView.OnItemSelectedListener onTimeBlockSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            onTimeBlockSelected(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

}
