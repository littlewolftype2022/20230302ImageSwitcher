package com.example.a20230302imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    private LinearLayout mLinearLayout;
    private ImageSwitcher mIageSwitcher;
    //yuantu
    private Integer[] mImages = {R.drawable.test1c,R.drawable.test2c,
            R.drawable.test3c,R.drawable.test4c,R.drawable.test5c,
            R.drawable.test6c,R.drawable.test7c,R.drawable.test8c,
            R.drawable.test9c,R.drawable.test10c,R.drawable.test11c,
            R.drawable.test12,R.drawable.test13};

    private Integer[] mSmallImages = {R.drawable.test1s,R.drawable.test2s,
            R.drawable.test3s,R.drawable.test4s,R.drawable.test5s,
            R.drawable.test6s,R.drawable.test7s,R.drawable.test8s,
            R.drawable.test9s,R.drawable.test10s,R.drawable.test11s,
            R.drawable.test12s,R.drawable.test13s};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        mIageSwitcher.setFactory(this);
        mIageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        mIageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        mIageSwitcher.setImageResource(mImages[0]);


        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        for(int i = 0;i < mSmallImages.length;i++){
            mLinearLayout.addView(getImageView(i));

        }
    }

    private ImageView getImageView(int i) {
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(mSmallImages[i]);
        imageView.setId(i);
        imageView.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v){
                mIageSwitcher.setImageResource(mImages[v.getId()]);
                Toast.makeText(v.getContext(),"choose picture" + (v.getId() + 1)+"",Toast.LENGTH_LONG).show();


            }
        });
        return imageView;
    }


    @Override
    public View makeView(){
        ImageView imageView = new ImageView(this);
        return imageView;

    }

}