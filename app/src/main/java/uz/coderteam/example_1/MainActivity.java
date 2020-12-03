package uz.coderteam.example_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uz.coderteam.example_1.fragment.PageOneFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fame_layout, new PageOneFragment()).commit();
    }


}