package com.sujan.quizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AsyncRequestQueue;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
    }


    public void handleSignClick(View v) {
        Button _button = (Button) v;
        String _actionText = _button.getText().toString();

        View _vPhone = findViewById(R.id.editTextPhone);
        EditText _tPhone = (EditText) _vPhone;
        String _phoneText = _tPhone.getText().toString();

        View _vPass = findViewById(R.id.editTextTextPassword);
        EditText _tPass = (EditText) _vPass;
        String _passwordText = _tPass.getText().toString();

        Log.d("sign action", _actionText);
        Log.d("sign Phone", _phoneText);
        Log.d("sign Password", _passwordText);


//        if (_phoneText.length() < 11) {
//            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (_passwordText.length() < 6) {
//            Toast.makeText(this, "Password length must be greater than 5 character.", Toast.LENGTH_LONG).show();
//            return;
//        }



        RequestQueue queue = Volley.newRequestQueue(this);

        String url;

        if (_actionText == "Sign In") {
            url = "https://salahrand.me/quiz-api-cse5-bu/api/login.php";
        } else {
            url = "https://salahrand.me/quiz-api-cse5-bu/api/register.php";
        }

        StringRequest signRequest = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Sign res", response.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Sign Res error", error.getLocalizedMessage());
                    }
                }

        ){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("phone", "01728536713");//_phoneText
                params.put("password", "123456");//_passwordText
                return params;
            }
        };

        queue.add(signRequest);


    }

    public void handleChangeSignOption(View v) {
        TextView _clickedText = (TextView) v;
        String _text = _clickedText.getText().toString();

        View _mV = findViewById(R.id.buttonSign);
        Button _signBtn = (Button) _mV;

        View _vSignQues = findViewById(R.id.textView3);
        TextView _tSignQues = (TextView) _vSignQues;

        Log.d("Message", _text);

        if (_text == "Sign Up") {
            _tSignQues.setText("Already have an account?");
            _signBtn.setText("Sign Up");
            _clickedText.setText("Sign In");
        } else {
            _tSignQues.setText("Don't have an account?");
            _signBtn.setText("Sign In");
            _clickedText.setText("Sign Up");
        }
    }


}