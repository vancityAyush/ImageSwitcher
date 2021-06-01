package com.ak11.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    LinearLayout linearLayoutHorizontal;
    ImageSwitcher imageSwitcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutHorizontal = findViewById(R.id.linearLayoutHorizontal);
        imageSwitcher = findViewById(R.id.imgSwitcher);
        imageSwitcher.setFactory(this);

        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
        imageSwitcher.setPadding(20,20,20,20);


        for(int index=0;index<Animal.animalImages.length;index++){
            final int i=index;
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(Animal.animalImages[i]);
            letsSetLayoutParams(imageView);
            imageView.setPadding(100,100,100,100);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imageSwitcher.setImageResource(Animal.animalImages[i]);
                    Toast.makeText(MainActivity.this,"This is : "+Animal.animalNames[i],Toast.LENGTH_SHORT).show();
                }
            });
            linearLayoutHorizontal.addView(imageView);
        }


    }
    public void letsSetLayoutParams(ImageView imageView){
        imageView.setLayoutParams(new LinearLayout.LayoutParams(1000,1000));
    }


    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        return imageView;
    }
        }