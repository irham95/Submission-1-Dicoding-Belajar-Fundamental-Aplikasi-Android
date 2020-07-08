package example.com.submission1fundamentalandroid;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Written by Irham Nurrahman on 5:55 PM 7/5/2020
 **/
public class Users implements Parcelable {
    private String name;
    private String location;
    private String user_company;
    private String username;
    private String followers;
    private String following;
    private String repo;
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUser_company() {
        return user_company;
    }

    public void setUser_company(String user_company) {
        this.user_company = user_company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    private int poster;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Users() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.location);
        dest.writeString(this.user_company);
        dest.writeString(this.username);
        dest.writeString(this.followers);
        dest.writeString(this.following);
        dest.writeString(this.repo);
        dest.writeString(this.year);
        dest.writeInt(this.poster);
    }

    protected Users(Parcel in) {
        this.name = in.readString();
        this.location = in.readString();
        this.user_company = in.readString();
        this.username = in.readString();
        this.followers = in.readString();
        this.following = in.readString();
        this.repo = in.readString();
        this.year = in.readString();
        this.poster = in.readInt();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel source) {
            return new Users(source);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };
}
