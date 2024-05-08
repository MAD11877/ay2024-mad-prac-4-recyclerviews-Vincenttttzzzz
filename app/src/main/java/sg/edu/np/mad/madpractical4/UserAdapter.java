package sg.edu.np.mad.madpractical4;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.xml.namespace.QName;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> list_objects;
    private ListActivity activity;

    public UserAdapter(ArrayList<User> list_objects, ListActivity activity) {
        this.list_objects = list_objects;
        this.activity = activity;
    }
    //Method to create a view holder for a username.
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_activity_list, parent, false);
        UserViewHolder holder = new UserViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(UserViewHolder holder, int position){
        //Get position of a username
        User list_items = list_objects.get(position);
        holder.bigImage.setVisibility(View.GONE);
        //Set username to the view holder based on custom_activity_list.xml
        holder.name.setText(list_items.getName());
        //Set description to the view holder based on custom_activity_list.xml
        holder.description.setText(list_items.getDescription());
        //Configure setOnClickListener() for the small image on the view holder based on custom_activity_list.xml
        holder.smallImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Context context = v.getContext(); // Get context from the clicked view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Profile");
                builder.setMessage(list_items.name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(activity, MainActivity.class);
                        i.putExtra("keyName", list_items.name);
                        i.putExtra("keyDesc", list_items.description);
                        i.putExtra("keyFoll", list_items.followed);
                        activity.startActivity(i);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        holder.bigImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Context context = v.getContext(); // Get context from the clicked view
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Profile");
                builder.setMessage(list_items.name);
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(activity, MainActivity.class);
                        i.putExtra("keyName", list_items.name);
                        i.putExtra("keyDesc", list_items.description);
                        i.putExtra("keyFoll", list_items.followed);
                        activity.startActivity(i);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });

        char num = list_items.name.charAt(list_items.name.length() - 1);
        Log.d("num", String.valueOf(num));
        if (num == '7') {
            holder.bigImage.setVisibility(View.VISIBLE);
        }
        else {
            holder.bigImage.setVisibility(View.GONE);
        }
    }

    public int getItemCount() {return list_objects.size();}
}
