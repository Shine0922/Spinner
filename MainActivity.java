package com.example.win7.exspinner01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Spinner spnPrefer;
    private TextView txtResult;
    String[] Books = new String[]{" 三國演義"," 西遊記 "," 水滸傳 ", " 其他 "};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnPrefer=(Spinner)findViewById(R.id.spnPrefer);
        txtResult=(TextView)findViewById(R.id.txtResult);

        //  建立  ArrayAdapter
        ArrayAdapter<CharSequence>adapterBooks=ArrayAdapter.createFromResource(this,R.array.Books,android.R.layout.simple_spinner_item);

        //  設定  Spinner 顯示的格式
        adapterBooks.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //  設定 Spinner  的資料來源
        spnPrefer.setAdapter(adapterBooks);

        //  設定監聽事件
        spnPrefer.setOnItemSelectedListener(spnPreferListener);
    }

        //  定義  onItemSelected  方法
    private Spinner.OnItemSelectedListener spnPreferListener = new Spinner.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?>parent, View view,int position,long id)
            {
                String sel = parent.getSelectedItem().toString();
                txtResult.setText(sel);
            }
            @Override
            public void onNothingSelected(AdapterView<?>parent)
            {
                // TODO Auto-generated method stub
            }
        };
}
