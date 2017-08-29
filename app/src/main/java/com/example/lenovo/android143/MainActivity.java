package com.example.lenovo.android143;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    //declaration
    EditText editText;
    Button save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        save_button=(Button)findViewById(R.id.button);
        //setting the save button
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //creating the object of fileoutputstream
                    //for writing the file
                    FileOutputStream fileOutputStream=openFileOutput("myFile.txt",MODE_PRIVATE);
                    OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                    //gettinng the data as a string
                    outputStreamWriter.write(editText.getText().toString());
                    //closing the file
                    outputStreamWriter.close();
                    //display file saved message
                    Toast.makeText(getBaseContext(), "File saved successfully!",
                            Toast.LENGTH_SHORT).show();

                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //setting the check button
        Button check_button=(Button)findViewById(R.id.button2);
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finding the path of the fille
                String path =getFilesDir().getAbsolutePath()+"/myFile.txt";
                //creating the obect of the file
                File file=new File(path);
                //Applying condtion to check the file is exist or not
                if (file.exists()){
                    // Toast File is exists
                    Toast.makeText(getBaseContext(), "File is Exist",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // Toast File is not exists
                    Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
