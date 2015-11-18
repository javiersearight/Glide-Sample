package io.vokal.glide_sample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
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
                Glide.with(this)
                        .load(imageFile)
                        .asBitmap()
                        .toBytes()
                        .override(400, 400)
                        .into(new SimpleTarget<byte[]>() {
                            @Override
                            public void onResourceReady(byte[] resource, GlideAnimation<? super byte[]> glideAnimation) {

                                Bitmap bitmap = BitmapFactory.decodeByteArray(resource, 0, resource.length);

                                mPreview.setImageBitmap(bitmap);

                                mRealm.beginTransaction();
                                ImageData image = new ImageData();
                                image.setData(resource);
                                mRealm.commitTransaction();
                            }
                        });
            }
        }
    }

}
