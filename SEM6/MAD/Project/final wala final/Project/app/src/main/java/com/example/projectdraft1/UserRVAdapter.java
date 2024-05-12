package com.example.projectdraft1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class UserRVAdapter extends  RecyclerView.Adapter<UserRVAdapter.ViewHolder> {

    // variable for our array list and context.
    private final ArrayList<UserModal> userModalArrayList;
    //public ArrayList Demo = null;
    private final Context context;


    public static class ViewHolder extends RecyclerView.ViewHolder {

        // creating a variable for our text view and image view.
        private final TextView idTV;
        private final TextView firstNameTV;

        private final Button buttonTV;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTV = (TextView) itemView.findViewById(R.id.idTVId);

            // initializing our variables.
            firstNameTV = (TextView) itemView.findViewById(R.id.idTVFirstName);

            buttonTV = itemView.findViewById(R.id.button2);

        }

        public TextView getFirstNameTV() {
            return firstNameTV;
        }

        public TextView getIdTV() {
            return idTV;
        }
    }
    // creating a constructor.
    public UserRVAdapter(ArrayList<UserModal> userModalArrayList, Context context) {
        super();
        this.userModalArrayList = userModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating our layout file on below line.
        View view = LayoutInflater.from(context).inflate(R.layout.user_rv_item, parent, false);
        return new ViewHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // getting data from our array list in our modal class.
        UserModal userModal = userModalArrayList.get(position);

        Dictionary<String, ArrayList<Integer>> dict= new Hashtable<>();
        dict.put(userModal.getFirst_name(), userModal.getArray());

        //Toast.makeText(context, " "+dict, Toast.LENGTH_SHORT).show();
//        Demo.add(userModal.getDE_3());
//        Demo.add(userModal.getDE_4());
//        Demo.add(userModal.getOE_3());
//        Demo.add(userModal.getOE_4());
//        Demo.add(userModal.getMOBILE_APPLICATION_DEVELOPMENT());
//        Demo.add(userModal.getMACHINE_LEARNING_ALGORITHMS());
//        Demo.add(userModal.getSOFTWARE_PROJECT_MANAGEMENT());
//        Demo.add(userModal.getINTERPERSONAL_SKILLS());
//        Demo.add(userModal.getSYSTEM_ADMINISTRATION());
//        Toast.makeText(context, ""+Demo, Toast.LENGTH_SHORT).show();

        // on the below line we are setting data to our text view.
        holder.getFirstNameTV().setText(userModal.getFirst_name());
        holder.getIdTV().setText(userModal.getId());
        holder.buttonTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> arr = dict.get(userModal.getFirst_name());
                //Toast.makeText(context, " "+str, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BarPlot.class);
                intent.putExtra("key", arr);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        // returning the size of array list.
        return userModalArrayList.size();
    }


}
