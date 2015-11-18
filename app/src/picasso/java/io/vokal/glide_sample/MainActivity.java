package io.vokal.glide_sample;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;
import java.io.File;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import io.vokal.glide_sample.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            if (mCurrentPhotoPath != null) {
                File imageFile = new File(mCurrentPhotoPath);
                Picasso.with(this)
                        .load(imageFile)
                        .resize(400, 400)
                        .centerCrop()
                        .into(new Target() {
                            @Override
                            public void onBitmapLoaded(Bitmap aBitmap, Picasso.LoadedFrom from) {
                                mPreview.setImageBitmap(aBitmap);

                                byte[] imageData = getDataFromBitmap(aBitmap);

                                mRealm.beginTransaction();
                                ImageData image = new ImageData();
                                image.setData(imageData);
                                mRealm.commitTransaction();
                            }

                            @Override
                            public void onBitmapFailed(Drawable errorDrawable) { }

                            @Override
                            public void onPrepareLoad(Drawable placeHolderDrawable) { }
                        });
            }
        }
    }

    private byte[] getDataFromBitmap(Bitmap aBitmap) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        aBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
        return bos.toByteArray();
    }
}
