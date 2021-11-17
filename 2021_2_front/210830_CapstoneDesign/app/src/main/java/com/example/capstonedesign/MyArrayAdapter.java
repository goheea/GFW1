package com.example.capstonedesign;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.capstonedesign.retrofit.Friend;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyArrayAdapter extends ArrayAdapter {
    public MyArrayAdapter(Context context, ArrayList users){
        super(context,0,users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.cfriend_list_item, parent, false);
        }

        // Get the data item for this position
        Friend friend = (Friend) getItem(position);

        Uri img_src = Uri.parse(friend.getImage());
        String name = friend.getName();
        String email = friend.getEmail();

        // Lookup view for data population
        CircleImageView profile_img = convertView.findViewById(R.id.cmp_friendItem_profile_img);
        TextView name_view = (TextView) convertView.findViewById(R.id.cfriend_list_Item_name);
        CheckBox checkBox = convertView.findViewById(R.id.cfriend_list_Item_check_box);

        // Populate the data into the template view using the data object
        name_view.setText(name);

        if(position == 0){
            checkBox.setChecked(true);
            profile_img.setVisibility(profile_img.GONE);
        }else{
            profile_img.setImageURI(img_src);
            checkBox.setChecked(false);
        }

        // Return the completed view to render on screen
        return convertView;
    }
}
