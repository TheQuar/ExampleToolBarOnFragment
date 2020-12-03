package uz.coderteam.example_1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uz.coderteam.example_1.R;

public class PageTwoFragment extends Fragment {

    private Context mContext;
    private View rootView;
    private  View back_btn;

    public PageTwoFragment() {
        // Required empty public constructor
    }

    public static PageTwoFragment newInstance(String param1, String param2) {
        PageTwoFragment fragment = new PageTwoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_page_two, container, false);
        init();
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void init(){
        back_btn = rootView.findViewById(R.id.back_btn);

        back_btn.setOnClickListener(v->{
            PageOneFragment pageOneFragment= new PageOneFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fame_layout, pageOneFragment, "page one")
                    .addToBackStack(null)
                    .commit();


        });

    }
}