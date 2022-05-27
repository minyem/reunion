package com.openclassrooms.reunion.ui.reunion_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.openclassrooms.reunion.R;
import com.openclassrooms.reunion.model.Reunion;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyReunionRecyclerViewAdapter extends RecyclerView.Adapter<MyReunionRecyclerViewAdapter.ViewHolder> {

    private List<Reunion> mReunion;
    private View view;

    public MyReunionRecyclerViewAdapter(List<Reunion> items) {
        mReunion = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_reunion, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Reunion reunion = mReunion.get(position);
        holder.mReunionName.setText(reunion.getNameReunion());
        holder.mReunionHeure.setText(reunion.getHeureReunion());
        holder.mReunionSalle.setText(reunion.getHeureReunion());
        holder.listParticipant.setText((CharSequence) reunion.getMailAddresse());


        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mReunion.remove(mReunion);
               notifyDataSetChanged();
           }
             }
        );
    }

    ;
    //   holder.mainContent.setOnClickListener(new View.OnClickListener() {
    //          @Override
    //        public void onClick(View view) {
    //             Bundle i = new Bundle();
    //            i.putInt("id", (int) neighbour.getId());
    //             i.putString("username", neighbour.getName());
    //             i.putString("photo", neighbour.getAvatarUrl());
    //            i.putString("addresse", neighbour.getAddress());
    //            i.putString("phonenumber", neighbour.getPhoneNumber());
    //           i.putString("addressemail", neighbour.getMailAddresse());
    //             i.putString("aboutme", neighbour.getAboutMe());
    //              i.putBoolean("isFavorite", neighbour.getFavorite());


    //             ViewNeighbourFragment viewNeighbourFragment =  new ViewNeighbourFragment();
    //             viewNeighbourFragment.setArguments(i);

    //             ListNeighbourActivity mainActivity = (ListNeighbourActivity)holder.mainContent.getContext();

    //               mainActivity.getSupportFragmentManager().beginTransaction()
    //                      .replace(R.id.viewFragments,viewNeighbourFragment)
    //                      .addToBackStack(null)
    //                    .commit();

    //         }
    //     });
    //  }

    @Override
    public int getItemCount() {
        return mReunion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_list_avatar)
        public ImageView mReunionAvatar;

        @BindView(R.id.item_list_nameR)
        public TextView mReunionName;

        @BindView(R.id.item_list_heureR)
        public TextView mReunionHeure;

        @BindView(R.id.item_list_salleR)
        public TextView mReunionSalle;

        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;

        @BindView(R.id.main_content)
        public LinearLayout mainContent;


        @BindView(R.id.item_list_participant)
        public TextView listParticipant;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
