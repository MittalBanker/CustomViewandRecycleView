package compoundview.customview.android.vogella.com.compoundview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class person_cardscreen extends AppCompatActivity {
    private List<Person> persons;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_person_cardscreen);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

private  void  initializeData()
{
    persons = new ArrayList<Person>();
    persons.add(new Person("Emma Watson",R.drawable.icon_1,"35 years"));
    persons.add(new Person("Joe Watson",R.drawable.icon_2,"30 years"));
    persons.add(new Person("Marry Watson",R.drawable.icon_3,"32 years"));


}

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
