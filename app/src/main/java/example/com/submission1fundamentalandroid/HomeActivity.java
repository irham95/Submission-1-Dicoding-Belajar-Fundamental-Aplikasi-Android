package example.com.submission1fundamentalandroid;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] dataName, dataLocation, dataRepo, dataFollowing, dataFollowers,
            dataUsername, dataUserCompany, dataYear;
    private TypedArray dataPoster;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        adapter = new UserAdapter(this);
        ListView listView = findViewById(R.id.lv_user);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent moveWithObject = new Intent(HomeActivity.this, DetailActivity.class);

                ArrayList<Users> users = new ArrayList<Users>();

                Users user = new Users();
                user.setPoster(dataPoster.getResourceId(i, -1));
                user.setName(dataName[i]);
                user.setLocation(dataLocation[i]);
                user.setRepo(dataRepo[i]);
                user.setUsername(dataUsername[i]);
                user.setFollowing(dataFollowing[i]);
                user.setUser_company(dataUserCompany[i]);
                user.setFollowers(dataFollowers[i]);
                user.setYear(dataYear[i]);

                users.add(user);

                moveWithObject.putParcelableArrayListExtra(DetailActivity.EXTRA_USER, users);
                moveWithObject.putExtra(DetailActivity.EXTRA_USER, user);
                startActivity(moveWithObject);
            }
        });
    }

    @Override
    public void onClick(View v) {
        //
    }

    private void addItem() {

        ArrayList<Users> users = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Users user = new Users();
            user.setPoster(dataPoster.getResourceId(i, -1));
            user.setName(dataName[i]);
            user.setLocation(dataLocation[i]);
            user.setRepo(dataRepo[i]);
            user.setUsername(dataUsername[i]);
            user.setFollowing(dataFollowing[i]);
            user.setUser_company(dataUserCompany[i]);
            user.setFollowers(dataFollowers[i]);
            user.setYear(dataYear[i]);
            users.add(user);
        }
        adapter.setUsers(users);
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataLocation = getResources().getStringArray(R.array.data_location);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataRepo = getResources().getStringArray(R.array.data_repo);
        dataUsername = getResources().getStringArray(R.array.data_username);
        dataUserCompany = getResources().getStringArray(R.array.data_userCompany);
        dataFollowers = getResources().getStringArray(R.array.data_followers);
        dataFollowing = getResources().getStringArray(R.array.data_following);
        dataYear = getResources().getStringArray(R.array.data_year);
    }

}
