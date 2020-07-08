package example.com.submission1fundamentalandroid;

/**
 * Written by Irham Nurrahman on 5:55 PM 7/5/2020
 **/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Users> users;

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public UserAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_user, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Users user = (Users) getItem(i);
        viewHolder.bind(user);
        return view;

    }

    private class ViewHolder {
        private TextView txtName, txtLocation, txtFollowing, txtDateTime, txtFollowers, txtRepo;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtLocation = view.findViewById(R.id.txt_location);
            imgPoster = view.findViewById(R.id.img_poster);
            txtFollowing = view.findViewById(R.id.txt_following);
            txtDateTime = view.findViewById(R.id.txt_date_released);
            txtFollowers = view.findViewById(R.id.txt_followers);
            txtRepo = view.findViewById(R.id.txt_repo);
        }

        void bind(Users user) {
            txtName.setText(user.getName());
            txtLocation.setText(user.getLocation());
            imgPoster.setImageResource(user.getPoster());
            txtFollowing.setText(user.getFollowing());
            txtDateTime.setText(user.getYear());
            txtFollowers.setText(user.getFollowers());
            txtRepo.setText(user.getRepo());
        }
    }
}
