package example.com.submission1fundamentalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    String name, username, user_company, repo, following, followers, location;
    int path;

    public static final String EXTRA_USER = "test_extra_user";

    TextView tViewName, tViewUserName, tViewUserCompany, tViewRepo,
            textViewFollowing, tViewFollowers, tViewLocation;

    ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tViewName = findViewById(R.id.txt_name);
        tViewUserName = findViewById(R.id.txt_username);
        tViewUserCompany = findViewById(R.id.txt_user_company);
        tViewRepo = findViewById(R.id.txt_repo);
        textViewFollowing = findViewById(R.id.txt_following);
        tViewFollowers = findViewById(R.id.txt_followers);
        tViewLocation = findViewById(R.id.txt_location);
        imagePoster = findViewById(R.id.img_poster);

        Users user = getIntent().getParcelableExtra(EXTRA_USER);

        if (user != null) {
            name = user.getName();
            tViewName.setText(name);

        }

        if (user != null) {
            username = user.getUsername();
            tViewUserName.setText(username);

        }

        if (user != null) {
            user_company = user.getUser_company();
            tViewUserCompany.setText(user_company);

        }

        if (repo != null) {
            repo = user.getRepo();
            tViewRepo.setText(repo);

        }

        if (user != null) {
            following = user.getFollowing();
            textViewFollowing.setText(following);
        }

        if (user != null) {
            followers = user.getFollowers();
            tViewFollowers.setText(followers);

        }

        if (user != null) {
            location = user.getLocation();
            tViewLocation.setText(location);

        }

        if (user != null) {
            path = user.getPoster();
            imagePoster.setImageResource(path);

        }

    }
}
