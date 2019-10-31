package com.sulail.giftsuggestion;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();//TAG to show logcat messages about the app work

    // this variable handle mCerrentIndex value and return it without load the activity
    private static final String BUNDLE_CURRENT_INDEX = "BUNDLE_CURRENT_INDEX";

    //Random variable to show gifts randomll
    private Random mRandom;

    //ImageView to display gift's pictures
    ImageView giftImageView;

    //TextView to display gift name
    private TextView mGiftNameTextView;

   //Declare an array "mGift
    private Gift[] mGifts = new Gift[10];

    //Intioialize the value of mCerrentIndex to -1
    int mCurrentIndex = -1;
    private Log log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main);
        //Creat new object of Random
        mRandom = new Random( );
        //Find ImageView by its id
        giftImageView = findViewById( R.id.image_gift);
        mGiftNameTextView = findViewById( R.id.text_gift_name);

        /*
        Use the constructor to setName and setPicture to the gifts
         */
        Gift gift1 = new Gift(R.string.damask_rose, R.drawable.gift_1);
        mGifts[0] = gift1;

        Gift gift2 = new Gift(R.string.flower, R.drawable.gift_2);
        mGifts[1] = gift2;

        Gift gift3 = new Gift(R.string.cake,  R.drawable.gift_3);
        mGifts[2] = gift3;

        Gift gift4 = new Gift(R.string.laptop, R.drawable.gift_4);
        mGifts[3] = gift4;

        Gift gift5 = new Gift(R.string.mobile, R.drawable.gift_5);
        mGifts[4] = gift5;

        Gift gift6 = new Gift(R.string.book, R.drawable.gift_6);
        mGifts[5] = gift6;

        Gift gift7 = new Gift(R.string.peace_of_cake,R.drawable.gift_7);
        mGifts[6] = gift7;

        Gift gift8 = new Gift(R.string.shirt, R.drawable.gift_8);
        mGifts[7] = gift8;

        Gift gift9 = new Gift(R.string.shoe, R.drawable.gift_9);
        mGifts[8] = gift9;

        Gift gift10 = new Gift(R.string.diamond, R.drawable.gift_10);
        mGifts[9] = gift10;
    }

    //Create disply method to display gift's pictures

    public void display(View view) {
        if (mCurrentIndex < 10) {
             log.d( TAG, "Display " + mCurrentIndex);
            // mCurrentIndex++; نستبدل العداد باعطاد الدالة العشوائية قيمة
            mCurrentIndex = mRandom.nextInt(10);
            //Calling ShowImage
            showISuggestedGift();
        } else
            //Toast.makeText( this, "لا يوجد مزيد من الصور لعرضها",  Toast.LENGTH_SHORT ).show();
        //Return mCerrentIndex to the first index 0
            mCurrentIndex = 0;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );
        outState.putInt( BUNDLE_CURRENT_INDEX, mCurrentIndex );
        log.i(TAG, "SavedInstanceState");// This message to display information in logcat
    }

    //Save the diplay code in showISuggestedGift() to call it as needed
    private void showISuggestedGift(){
        //save currentIndex variable in suggestedGift
        Gift suggestedGift = mGifts[mCurrentIndex];
        Drawable giftDrawable = ContextCompat.getDrawable( this, suggestedGift.getPicture()); //Give picture to gitDrawable
        giftImageView.setImageDrawable( giftDrawable );
        mGiftNameTextView.setText( suggestedGift.getName()); //Show the name of picture in mGiftNameTextView

    }

    //Create onRestoreInstanceState() to return pictures to the first one without closing the activity

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
        if(savedInstanceState != null){
        mCurrentIndex = savedInstanceState.getInt(BUNDLE_CURRENT_INDEX);

        if (mCurrentIndex != -1) {
            log.d( TAG, "Display " + mCurrentIndex);
            showISuggestedGift();
        }
        }
        log.i(TAG, "onRestoreInstanceState");
    }
    //Call the onRestart() method
    @Override
    protected void onRestart() {
        super.onRestart();
        log.i(TAG, "Restarted");
    }
}



