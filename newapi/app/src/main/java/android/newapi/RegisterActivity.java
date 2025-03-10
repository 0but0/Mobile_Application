package android.newapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    DataBases db;
    EditText e1,e2,e3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBases(this);
        e1=(EditText) findViewById(R.id.TextEmailR);
        e2=(EditText) findViewById(R.id.TextPasswordR);
        e3=(EditText) findViewById(R.id.TextCPasswordR);
        b1=(Button)  findViewById(R.id.buttonRegis);
        b2=(Button)  findViewById(R.id.buttonLogin1);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iten = new Intent(getApplicationContext(),LoginFaceBook.class);
                startActivity(iten);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if(s1.equals("") ){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if( s2.equals("") ){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();}

                else if( s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)) {
                        Boolean emailchk = db.emailchk(s1);
                        if (emailchk == true) {
                            Boolean insert = db.insert(s1, s2);
                            if (insert == true) {
                                Button button = view.findViewById(R.id.buttonRegis);
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent= new Intent(getApplicationContext(),LoginFaceBook.class);
                                        startActivity(intent);
                                    }
                                });
                                Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "This email is already existed!!", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Re-confirm password!!",Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
}