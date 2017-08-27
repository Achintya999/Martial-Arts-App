package com.example.achintya.martialartsclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.achintya.martialartsclub.Model.DatabaseHandler;
import com.example.achintya.martialartsclub.Model.MartialArts;

public class AddMartialArtsActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName, edtPrice, edtColor;
    Button btnAddMartialArt, btnBack;

    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_arts);

       //Toast.makeText(AddMartialArtsActivity.this, "This is Add Martial Arts Activity", Toast.LENGTH_SHORT).show();


        edtName = (EditText)findViewById(R.id.edtName);
        edtPrice = (EditText)findViewById(R.id.edtPrice);
        edtColor = (EditText)findViewById(R.id.edtColor);

        btnAddMartialArt = (Button)findViewById(R.id.btnAddMartialArt);
        btnBack = (Button)findViewById(R.id.btnGoBack);

        databaseHandler = new DatabaseHandler(AddMartialArtsActivity.this);

        btnAddMartialArt.setOnClickListener(AddMartialArtsActivity.this);
        btnBack.setOnClickListener(AddMartialArtsActivity.this);


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnAddMartialArt:
                addMartialArtObjectToDatabase();
                break;

            case R.id.btnGoBack:
                this.finish();
                break;

        }

    }

    private void addMartialArtObjectToDatabase(){

        String nameValue = edtName.getText().toString();
        String priceValue = edtPrice.getText().toString();
        String colorValue = edtColor.getText().toString();

        try {

            double priceDoubleValue = Double.parseDouble(priceValue);

            MartialArts martialArtsObject = new MartialArts(0, nameValue, priceDoubleValue, colorValue);

            databaseHandler.addMartialArt(martialArtsObject);

            Toast.makeText(AddMartialArtsActivity.this,
                    martialArtsObject + " Martial Art Object Is Added To Database ", Toast.LENGTH_SHORT).show();



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
