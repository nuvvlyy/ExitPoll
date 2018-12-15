package com.example.exitpoll;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapter  extends ArrayAdapter<VoteItem> {

    private Context mContext;
    private int mResource;
    private List<VoteItem> mItemList;

    public ListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<VoteItem> ItemList) {
        super(context, resource, ItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mItemList = ItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView titleTextView = view.findViewById(R.id.score_text_view);
        

        VoteItem phoneItem = mItemList.get(position);
        String title = String.valueOf(phoneItem.score);
        titleTextView.setText(title);




        return view;
    }
}
