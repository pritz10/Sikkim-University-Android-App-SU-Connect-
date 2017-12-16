
package com.pritz.sikkimuniversity;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
import android.text.Editable;
        import android.text.TextWatcher;
        import android.widget.EditText;
        import android.widget.ListView;

        import java.util.ArrayList;
        import java.util.Locale;

public class contact_book extends AppCompatActivity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    EditText editsearch;
    String[] number;

    String[] country;
    ArrayList<Contactboo_kGettersetter> arraylist = new ArrayList<Contactboo_kGettersetter>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_book);
getSupportActionBar().setTitle("Contact Book");
        getSupportActionBar().setSubtitle("120 Contacts");

        // Generate sample data

        country = new String[] { "Office of the Vice Chancellor","Office of the Registrar","Office of the Controller of Examination",
                "Office of the Finance Officer","Office of the Librarian","Dean, Students' Welfare","Dean, School of Social Sciences","Dean, School of Professional Studies",
                "Dean, School of Physical Sciences","Dean, School of Life Sciences","Dean, School of Languages and Literature","Dean, School of Human Sciences",
                "Finance","Academics","Administration","Establishment","Evaluation","Systems Management","Medical Unit","Guest House", "Science Library","Department of Anthropology",
                "Department of Chinese","Department of Management","Department of Economics","Department of Horticulture","Department of Geography","Department of International Relations"
                ,"Department of Mass communication","Department of Law","Department of Computer Applications","Department of Peace & Conflict Studies and Management",
                "Department of Nepali","Department of Psychology Studies","Department of Sociology","Department of Physics","Department of History","Department of Chemistry",
                "Department of Microbiology","Department of Botany","Department of Geology","Department of Music","Department of Political Science","Department of Education",
                "Department of English","Department of Hindi","Department of Zoology","Department of Tourism","Department of Commerce","Department of Mathematics"," PS to Vice-Chancellor",
                " PS to Registrar","PA to Finance Officer"," Joint Registrar, Finance"," Joint Registrar, Academics","Assistant Registrar, Establishment","Assistant Registrar, Administration"
                ,"Section Officer, Academics","Assistant, Registrar Office"," Dispatch Section","Section Officer, Administration Section","Section Officer, Establishment Section","Section Officer, Finance Section",
                "Finance Section, Second connection","System Analyst","Security Officer","Assistant Engineer"};

        number  = new String[] {"251067","251403","250104","251396","251060","231198","251111","251225","251222","251188","251078","251221","250074","251130",
                "250228","251066","250225","251186","251056","251042","232062","231121","231662","251968","251152","251485","280302","201826","280337","231549","251788",
                "251441","251342","280774","231547","232080","251004","232067","232085","231270","231151","232225","201827","280239","231551","231776","231302","231318","231322","231522","251011","251013",
                "251015","251016","251017","251018","251019","251021","251022","251023","251024","251025","251027","251028","251032","251033","251034"
        };

        // Locate the ListView in listview_main.xml
        list = (ListView)findViewById(R.id.listview);

        for (int i = 0; i < number.length; i++)
        {
            Contactboo_kGettersetter wp = new Contactboo_kGettersetter(country[i],number[i]);
            // Binds all strings into an array
            arraylist.add(wp);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (EditText) findViewById(R.id.find);

        // Capture Text in EditText
        editsearch.addTextChangedListener(new TextWatcher()
                {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }



}