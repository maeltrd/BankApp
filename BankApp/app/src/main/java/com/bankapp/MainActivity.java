package com.bankapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    TextView tvBalance;
    TextView tvCurrency;
    Button btRefresh;
    Spinner spAccount;
    Account[] accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        tvBalance = (TextView)findViewById(R.id.tv_balance);
        tvCurrency = (TextView)findViewById(R.id.tv_currency);
        btRefresh = (Button)findViewById(R.id.bt_refresh);
        spAccount = (Spinner)findViewById(R.id.sp_account);

        btRefresh.setOnClickListener(view -> fetchBalance());

        spAccount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvBalance.setText(String.valueOf(accounts[i].getAmount()));
                tvCurrency.setText(String.valueOf(accounts[i].getCurrency()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        fetchAccounts();
    }

    protected void fetchAccounts() {

        accounts = FetchData.GetAccountsFromJson();
        List<String> accountsName = new ArrayList<String>();

        for (Account a: accounts) {
            accountsName.add(a.getName());
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,
                accountsName);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spAccount.setAdapter(adapter);
    }

    protected void fetchBalance() {

        fetchAccounts();
        tvBalance.setText(String.valueOf(accounts[0].getAmount()));
    }
}