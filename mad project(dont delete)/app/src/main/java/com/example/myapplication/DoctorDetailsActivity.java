package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Docotr name:Ajit","Hospital Address: Delhi","Exp: 5yrs","Mobile No:9898989898","600"},
                    {"Docotr name:Abdul","Hospital Address: Pune","Exp: 3yrs","Mobile No:1234567895","300"},
                    {"Docotr name:Rajesh","Hospital Address: Kolkata","Exp: 2yrs","Mobile No:2345617895","200"},
                    {"Docotr name:Krishnappa","Hospital Address: Bangalore","Exp: 1yrs","Mobile No:7531598526","100"},
                    {"Docotr name:Anirudh","Hospital Address: Mangalore","Exp: 8yrs","Mobile No:1478523691","700"},
            };

    private String[][] doctor_details2 = {
            {"Doctor name: Priya", "Hospital Address: Mumbai", "Exp: 4yrs", "Mobile No: 9876543210", "400"},
            {"Doctor name: Sneha", "Hospital Address: Chennai", "Exp: 6yrs", "Mobile No: 8765432109", "500"},
            {"Doctor name: Vishal", "Hospital Address: Hyderabad", "Exp: 7yrs", "Mobile No: 7654321098", "650"},
            {"Doctor name: Sanjay", "Hospital Address: Jaipur", "Exp: 9yrs", "Mobile No: 6543210987", "800"},
            {"Doctor name: Priyanka", "Hospital Address: Lucknow", "Exp: 3yrs", "Mobile No: 5432109876", "350"}
    };

    private String[][] doctor_details3= {
            {"Doctor name: Rahul", "Hospital Address: Chandigarh", "Exp: 5yrs", "Mobile No: 9876543210", "600"},
            {"Doctor name: Neha", "Hospital Address: Ahmedabad", "Exp: 2yrs", "Mobile No: 8765432109", "300"},
            {"Doctor name: Arjun", "Hospital Address: Coimbatore", "Exp: 6yrs", "Mobile No: 7654321098", "700"},
            {"Doctor name: Sunita", "Hospital Address: Bhopal", "Exp: 4yrs", "Mobile No: 6543210987", "500"},
            {"Doctor name: Rohit", "Hospital Address: Guwahati", "Exp: 8yrs", "Mobile No: 5432109876", "800"}
    };


    private String[][] doctor_details4= {
            {"Doctor name: Priyanka", "Hospital Address: Indore", "Exp: 3yrs", "Mobile No: 9876543210", "350"},
            {"Doctor name: Siddharth", "Hospital Address: Kochi", "Exp: 7yrs", "Mobile No: 8765432109", "650"},
            {"Doctor name: Tanvi", "Hospital Address: Nagpur", "Exp: 4yrs", "Mobile No: 7654321098", "400"},
            {"Doctor name: Aarav", "Hospital Address: Patna", "Exp: 6yrs", "Mobile No: 6543210987", "600"},
            {"Doctor name: Shruti", "Hospital Address: Raipur", "Exp: 2yrs", "Mobile No: 5432109876", "300"}
    };

    private String[][] doctor_details5= {
            {"Doctor name: Ananya", "Hospital Address: Jaipur", "Exp: 4yrs", "Mobile No: 9876543210", "450"},
            {"Doctor name: Rohan", "Hospital Address: Varanasi", "Exp: 5yrs", "Mobile No: 8765432109", "550"},
            {"Doctor name: Pooja", "Hospital Address: Ranchi", "Exp: 3yrs", "Mobile No: 7654321098", "350"},
            {"Doctor name: Sumit", "Hospital Address: Dehradun", "Exp: 6yrs", "Mobile No: 6543210987", "600"},
            {"Doctor name: Kavya", "Hospital Address: Amritsar", "Exp: 2yrs", "Mobile No: 5432109876", "250"}
    };


    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
            }

        sa =new SimpleAdapter(this,list, R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view,int i,long l){
                Intent it=new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}