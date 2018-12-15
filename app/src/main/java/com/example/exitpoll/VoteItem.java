package com.example.exitpoll;


import java.util.Locale;

public class VoteItem {
    public final long _id;
    public final int score;
    public final String image;
    public VoteItem(long _id,int score,String image) {
        this._id = _id;
       this.score = score;
        this.image = image;
    }

    @Override
    public String toString() {
        String msg = String.format(
                Locale.getDefault(),
                "%s (%s)",
                this._id
                ,this.score
        );
        return msg;
    }

}
