package com.example.assigment_ph48770_app.Fragment.Admin;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.assigment_ph48770_app.adapter.AdapterViewPager;
import com.example.assigment_ph48770_app.Fragment.Admin.AdminAccountFragment;
import com.example.assigment_ph48770_app.Fragment.Admin.AdminChatFragment;
import com.example.assigment_ph48770_app.Fragment.Admin.AdminHomeFragment;
import com.example.assigment_ph48770_app.Fragment.Admin.AdminNotificationFragment;
import com.example.assigment_ph48770_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class Admin_Bottom_navigation extends AppCompatActivity {
    ViewPager2 pagerMain;
    BottomNavigationView bottomNav;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_bottom_navigation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // anh xa
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);
        fragmentArrayList.add(new AdminHomeFragment());
        fragmentArrayList.add(new AdminChatFragment());
        fragmentArrayList.add(new AdminNotificationFragment());
        fragmentArrayList.add(new AdminAccountFragment());

        // khởi tạo adapter
        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        //set adapter
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.setSelectedItemId(R.id.admin_menu_Home);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.admin_menu_chat);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.admin_menu_notification);
                        break;
                    case 3:
                        bottomNav.setSelectedItemId(R.id.admin_menu_account);
                        break;
                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.admin_menu_Home) {
                    pagerMain.setCurrentItem(0);
                    return true;
                } else if (item.getItemId() == R.id.admin_menu_chat) {
                    pagerMain.setCurrentItem(1);
                    return true;

                } else if (item.getItemId() == R.id.admin_menu_notification) {
                    pagerMain.setCurrentItem(2);
                    return true;
                } else {
                    pagerMain.setCurrentItem(3);
                    return true;
                }
            }
        });
    }
}