package io.vokal.glide_sample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;

import java.io.File;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

public class MainActivity extends BaseActivity {

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (mCurrentPhotoPath != null) {
                File imageFile = new File(mCurrentPhotoPath);
                Glide.with(this).load(imageFile).into(mPreview);
            }
        }
    }
}
