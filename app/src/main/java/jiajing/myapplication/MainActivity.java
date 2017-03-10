package jiajing.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void save(View view) {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        EditText user = (EditText) findViewById(R.id.yourName);
        String username = user.getText().toString();
        DatabaseReference myRef = database.getReference(username).child("secret");

        EditText editText = (EditText) findViewById(R.id.secret);
        String userSecret = editText.getText().toString();


        myRef.setValue(editText.getText().toString());
    }

    public void reveal(View view) {
        Intent intent = new Intent(this, Main2Activity.class);

        EditText target = (EditText) findViewById(R.id.people);
        intent.putExtra("target", target.getText().toString());

        startActivity(intent);

    }
}
