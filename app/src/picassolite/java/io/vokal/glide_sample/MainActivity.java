package io.vokal.glide_sample;

import android.app.Activity;
import android.content.Intent;

import java.io.File;

import com.squareup.picasso.Picasso;

public class MainActivity extends BaseActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (mCurrentPhotoPath != null) {
                File imageFile = new File(mCurrentPhotoPath);
                Picasso.with(this).load(imageFile).into(mPreview);
            }
        }
    }
}
