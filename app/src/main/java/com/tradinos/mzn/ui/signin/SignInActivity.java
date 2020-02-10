package com.tradinos.mzn.ui.signin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.tradinos.mzn.data.MznUser;
import com.tradinos.mzn.ui.MainActivity;
import com.tradinos.mzn.R;
import com.tradinos.mzn.models.User;
import com.tradinos.mzn.pojo.SigninPojo.SinginModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class SignInActivity extends AppCompatActivity {

    SignInViewModel signInViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);

        signInViewModel = ViewModelProviders.of(this).get(SignInViewModel.class);


        setupActions();

    }

    private void setupActions(){
        Button singinButton = findViewById(R.id.singin_button);

        singinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = ((EditText)findViewById(R.id.email_edittext)).getText().toString();
                final String password = ((EditText)findViewById(R.id.password_edtittext)).getText().toString();
                final String deviceName = "android";

                final String version = "1.0";


                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {

                                if(task.isSuccessful()){

                                    String deviceToken = task.getResult().getToken();

                                    SinginModel singinModel = new SinginModel(email, password, deviceToken, deviceName, version);

                                    signInViewModel.signin(singinModel).observe(SignInActivity.this, new Observer<User>() {
                                        @Override
                                        public void onChanged(User user) {
                                            Toast.makeText(SignInActivity.this,user.getId()+"", Toast.LENGTH_SHORT).show();

                                            MznUser.getINSTANCE().saveUser(user,SignInActivity.this);

                                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                                            startActivity(intent);
                                        }
                                    });
                                }
                                Toast.makeText(SignInActivity.this, "Device token not created error!", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(SignInActivity.this, "Device token not created error!", Toast.LENGTH_SHORT).show();
                    }
                });



            }
        });


        signInViewModel.getOnFailureMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(SignInActivity.this, "Error: " + s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        
    }
}
