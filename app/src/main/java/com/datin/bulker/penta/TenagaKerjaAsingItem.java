package com.datin.bulker.penta;

import android.os.Parcel;
import android.os.Parcelable;


public class TenagaKerjaAsingItem implements Parcelable{
    private String judul, deskripsi, th_id, created_at, cover, file;

    public TenagaKerjaAsingItem(String judul, String deskripsi, String th_id, String created_at, String cover, String file ) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.th_id = th_id;
        this.created_at = created_at;
        this.cover = cover;
        this.file = file;
    }


    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getTh_id() {
        return th_id;
    }

    public String getCreated_at(){
        return created_at;
    }

    public String getCover() {
        return cover;
    }

    public String getFile() {
        return file;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTh_id(String th_id) {
        this.th_id = th_id;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setFile(String file) {
        this.file = file;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.judul);
        parcel.writeString(this.deskripsi);
        parcel.writeString(this.th_id);
        parcel.writeString(this.created_at);
        parcel.writeString(this.cover);
        parcel.writeString(this.file);
    }


    protected TenagaKerjaAsingItem(Parcel in ){
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.created_at = in.readString();
        this.th_id = in.readString();
        this.cover = in.readString();
    }

    public static final Parcelable.Creator<com.datin.bulker.penta.TenagaKerjaAsingItem> CREATOR = new Parcelable.Creator<com.datin.bulker.penta.TenagaKerjaAsingItem>(){

        @Override
        public com.datin.bulker.penta.TenagaKerjaAsingItem createFromParcel(Parcel source) {
            return new com.datin.bulker.penta.TenagaKerjaAsingItem(source);
        }

        @Override
        public com.datin.bulker.penta.TenagaKerjaAsingItem[] newArray(int size) {
            return new com.datin.bulker.penta.TenagaKerjaAsingItem[size];
        }
    };
}
