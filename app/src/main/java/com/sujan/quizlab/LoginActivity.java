package com.sujan.quizlab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sujan.quizlab.api.ApiClient;
import com.sujan.quizlab.api.request.LoginReq;
import com.sujan.quizlab.api.request.SignUpReq;
import com.sujan.quizlab.api.response.LoginRes;
import com.sujan.quizlab.api.response.SignUpRes;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

//        AndroidNetwo

    }


    public void handleSignClick(View v) {
        Button _button = (Button) v;
        String _actionText = _button.getText().toString();

        View _vPhone = findViewById(R.id.editTextPhone);
        EditText _tPhone = (EditText) _vPhone;
        String _phoneText = _tPhone.getText().toString();//

        View _vPass = findViewById(R.id.editTextTextPassword);
        EditText _tPass = (EditText) _vPass;
        String _passwordText = _tPass.getText().toString();//

        Log.d("sign _phoneText", _phoneText);
        Log.d("sign _passwordText", _passwordText);


//        if (_actionText == "Sign In") {
//
//        } else if (_actionText == "Sign Up") {
//        }


        SignUpReq signUpReq = new SignUpReq();
        signUpReq.setPhone(RequestBody.create("+8801303458821", MediaType.parse("text/plain")));
        signUpReq.setPassword(RequestBody.create("23423423", MediaType.parse("text/plain")));
        signUp(signUpReq);

//        LoginReq loginReq = new LoginReq();
//        loginReq.setPhone(RequestBody.create(MediaType.parse("text/plain"), "+8801303458829"));//
//        loginReq.setPassword(RequestBody.create(MediaType.parse("text/plain"), "23423423"));//"23423423"
//        login(loginReq);
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
            Log.d("check", "Sign Up Condition Matched");
            _tSignQues.setText("Already have an account?");
            _signBtn.setText("Sign Up");
            _clickedText.setText("Sign In");
        } else {
            _tSignQues.setText("Don't have an account?");
            _signBtn.setText("Sign In");
            _clickedText.setText("Sign Up");
        }
    }


    public void signUp(SignUpReq signupReq) {
        Call<SignUpRes> signUpResCall = ApiClient.getUserService().signupUser(signupReq.getPhone(), signupReq.getPassword());
        signUpResCall.enqueue(new Callback<SignUpRes>() {
            @Override
            public void onResponse(Call<SignUpRes> call, Response<SignUpRes> response) {
                Log.d("sign res", response.toString());
                if(response.isSuccessful()) {
                    Log.d("sign res", "signup success");
                } else {
                    String message = "Error Occurred";
                }
                    Log.d("sign res errorBody", response.toString());
            }

            @Override
            public void onFailure(Call<SignUpRes> call, Throwable t) {
//                String message = t.getLocalizedMessage();
                Log.d("signup failure", "on no");
//                Log.d("signup failure all", t.toString());
            }
        });
    }

    public void login(LoginReq loginReq) {
        Call<LoginRes> loginResCall = ApiClient.getUserService().loginUser(loginReq.getPhone(), loginReq.getPassword());
        loginResCall.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                Log.d("login res", response.toString());
                if(response.isSuccessful()) {
                    Log.d("login res", "signup success");
                } else {
                    String message = "Error Occurred";
                }
                Log.d("login res errorBody", response.toString());
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {
//                String message = t.getLocalizedMessage();
                Log.d("login failure", "on no");
//                Log.d("signup failure all", t.toString());
            }
        });
    }

}