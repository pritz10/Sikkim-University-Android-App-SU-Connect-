package com.pritz.sikkimuniversity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentBus extends Fragment {
Button admin;

    public fragmentBus() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_bus, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    admin=(Button) getActivity().findViewById(R.id.button8);
    admin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent i = new Intent(getActivity(), Admin.class);
            startActivity(i);
        }
    });
    }
}
