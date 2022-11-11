package com.example.expenso.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.expenso.R;
import com.example.expenso.adapter.MyAdapter;
import com.example.expenso.db.MyExpenseDao;
import com.example.expenso.db.MyExpenseDb;
import com.example.expenso.model.ExpenseModel;
import com.example.expenso.util.DatabaseService;

import java.util.List;

public class Dashboard extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    TextView txt_getTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txt_getTotal = findViewById(R.id.txt_getTotal);

        final MyExpenseDb myExpenseDb = new DatabaseService().initDb(this);
        final MyExpenseDao myExpenseDao = myExpenseDb.myExpenseDao();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final List<ExpenseModel> myExpenseList = myExpenseDao.getAllExpense();
                adapter = new MyAdapter(myExpenseList);
                recyclerView.setAdapter(adapter);

            }
        }).start();

        findViewById(R.id.btn_add).setOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), AddExpense.class));
            finish();
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                final int myExpense = myExpenseDao.getAllPrice();
                txt_getTotal.setText("Total Expense: " + String.valueOf(myExpense));
            }
        }).start();
    }
}