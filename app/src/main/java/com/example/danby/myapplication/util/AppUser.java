package com.example.danby.myapplication.util;

import android.support.v4.util.Pair;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by danby on 5/27/2017.
 */

public class AppUser {
    private AccessToken accessToken;
    private List<FBUser> fbFriendList;

    public AppUser() {
        accessToken = AccessToken.getCurrentAccessToken();
        fbFriendList = new ArrayList<>();
    }

    public List<FBUser> getFbFriendList() {
        accessToken = AccessToken.getCurrentAccessToken();
        final GraphRequest graphRequest = new GraphRequest(accessToken, "/me/friends?limit=5000");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                GraphResponse response = graphRequest.executeAndWait();
                try {
                    JSONArray friendsJSONArray = response.getJSONObject().getJSONArray("data");
                    for(int i=0; i < friendsJSONArray.length(); i++) {
                        JSONObject friendJSONObj = friendsJSONArray.getJSONObject(i);
                        String friend_name = friendJSONObj.getString("name");
                        String friend_id = friendJSONObj.getString("id");
                        FBUser friend = new FBUser(friend_name, friend_id);
                        Log.d("fb_friends", friend.toString());
                        fbFriendList.add(friend);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            t.join();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        return fbFriendList;
    }

    public String getFriendsStr() {
        String ret = "";
        Log.d("fb_friends", "Friends size = " + fbFriendList.size());
        for(int i=0; i < fbFriendList.size(); i++) {
            ret += "\nFriend #" + (i+1) + ":\n";
            ret += "\tname: " + fbFriendList.get(i).name + "\n";
            ret += "\tid: " + fbFriendList.get(i).id + "\n";
        }
        return ret;
    }
    private static class FBUser {
        private String name;
        private String id;

        public FBUser(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String toString() {
            return "name: " + this.name + "\nid: " + this.id;
        }
    }
}
