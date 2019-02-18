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
public class fragmenttools extends Fragment {

Button pf,ant,sm,dev,cb,nss,lib;
    public fragmenttools() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmenttools, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
pf=(Button) getActivity().findViewById(R.id.pf);
        cb=(Button) getActivity().findViewById(R.id.cb);
        nss=(Button) getActivity().findViewById(R.id.nss);
        lib=(Button) getActivity().findViewById(R.id.lib);
        dev=(Button) getActivity().findViewById(R.id.dev);
        sm=(Button) getActivity().findViewById(R.id.map);
        ant=(Button) getActivity().findViewById(R.id.ant);

pf.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent status_intent = new Intent(getActivity(), handwriting.class);
        startActivity(status_intent);
    }
});

        nss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), NSS.class);
                startActivity(status_intent);
            }
        });

        dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), Developers.class);
                startActivity(status_intent);
            }
        });
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), contact_book.class);
                startActivity(status_intent);
            }
        });

        sm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), SU_Map.class);
                startActivity(status_intent);
            }
        });

        lib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), LibSu.class);
                startActivity(status_intent);
            }
        });

        ant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent status_intent = new Intent(getActivity(), AntiRagging.class);
                startActivity(status_intent);
            }
        });
    }

}
