package io.vokal.glide_sample;

import io.realm.RealmObject;

public class ImageData extends RealmObject {

    private byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
