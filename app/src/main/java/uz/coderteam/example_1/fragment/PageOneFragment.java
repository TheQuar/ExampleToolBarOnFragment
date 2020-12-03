package uz.coderteam.example_1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import uz.coderteam.example_1.R;

public class PageOneFragment extends Fragment {

    private Context mContext;
    private View menu_btn;
    private View rootView;
    private NavigationView navigationView;

    private DrawerLayout drawer;


    public PageOneFragment() {
        // Required empty public constructor
    }

    public static PageOneFragment newInstance(String param1, String param2) {
        PageOneFragment fragment = new PageOneFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_page_one, container, false);
        init();
        return rootView;
    }

    private void init() {
        drawer = rootView.findViewById(R.id.drawer_layout);

        menu_btn = rootView.findViewById(R.id.back_btn);
        navigationView = rootView.findViewById(R.id.navigation_view);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.PageOne) {
                    Toast.makeText(mContext, "Page One", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.PageTwo) {
                    PageTwoFragment pageTwoFragment= new PageTwoFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fame_layout, pageTwoFragment, "page two")
                            .addToBackStack(null)
                            .commit();

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        menu_btn.setOnClickListener(v -> {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


}