package parikshit.chavhan.signupactivityinjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    private Button signUpBtn;
    private EditText nameEdt, emailEdt, passEdt, repassEdt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        setVariable();

    }

    private void setVariable(){
        signUpBtn.setOnClickListener(v -> {
            if(nameEdt.getText().toString().trim().isEmpty() || emailEdt.getText().toString().trim().isEmpty()
                    || passEdt.getText().toString().trim().isEmpty() || repassEdt.getText().toString().trim().isEmpty()){
                Toast.makeText(SignUpActivity.this, "Please Fill the Sign Up form", Toast.LENGTH_SHORT).show();
            } else if (!passEdt.getText().toString().trim().equals(repassEdt.getText().toString().trim())) {
                Toast.makeText(SignUpActivity.this, "Your password is not matched", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });
    }

    private void initView(){
        signUpBtn = findViewById(R.id.button);
        nameEdt = findViewById(R.id.edtName);
        emailEdt = findViewById(R.id.edtEmail);
        passEdt = findViewById(R.id.edtPassword);
        repassEdt = findViewById(R.id.edtRePassword);
    }
}
