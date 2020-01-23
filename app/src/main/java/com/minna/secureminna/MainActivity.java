package com.minna.secureminna;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    FabBottomNavigationView fabBottomNavigationView;
    //Button button;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabBottomNavigationView = findViewById(R.id.bottomNavigationView);
        floatingActionButton = findViewById(R.id.fab);
        //button = findViewById(R.id.button);

        fabBottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, HomeFragment.newInstance());
        transaction.commit();

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabBottomNavigationView.transform(floatingActionButton);
            }
        });*/
    }


    private FabBottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new FabBottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedfrag = null;
            switch (item.getItemId()) {
                case R.id.home:
                    selectedfrag = HomeFragment.newInstance();
                    break;
                case R.id.location:
                    selectedfrag = MapFragment.newInstance();
                    break;
                case R.id.feeds:
                    selectedfrag = FeedsFragment.newInstance();
                    break;
                case R.id.contacts:
                    selectedfrag = ContactsFragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame, selectedfrag);
            transaction.commit();
            return true;
        }
    };
}
