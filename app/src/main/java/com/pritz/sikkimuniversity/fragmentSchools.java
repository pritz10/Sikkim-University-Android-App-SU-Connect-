package com.pritz.sikkimuniversity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragmentSchools extends Fragment {

    String[] schools ={"School of Human Sciences",
            "School of Language And Litreture",
            "School of Life Sciences",
            "School of Physical Sciences",
            "School of Professional Studies",
            "School of Social Sciences"};
    ListView listView;
    List_School lc;
    public fragmentSchools() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_schools, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView= (ListView) getActivity().findViewById(R.id.simplelist);
        int i = 0;
        lc = new List_School(getContext(), R.layout.layout_of_schools);
        listView.setAdapter(lc);
        TeacherDetailsProvider tdp1;
        for (String id : schools) {
            tdp1 = new TeacherDetailsProvider(schools[i]);
            lc.add(tdp1);
            i++;
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent x = new Intent(getContext(),School_list.class);
                x.putExtra("dept_names", position);
                startActivity(x);
            }
        });

    }


}
