package com.datin.bulker.hi;

import android.os.Parcel;
import android.os.Parcelable;


public class HiItem implements Parcelable{
    private String judul, deskripsi, tahun, tanggal, cover;

    public HiItem(String judul, String deskripsi, String tahun, String tanggal, String cover ) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.tahun = tahun;
        this.tanggal = tanggal;
        this.cover = cover;
    }


    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getTahun() {
        return tahun;
    }

    public String getTanggal(){
        return tanggal;
    }

    public String getCover() {
        return cover;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.judul);
        parcel.writeString(this.deskripsi);
        parcel.writeString(this.tahun);
        parcel.writeString(this.tanggal);
        parcel.writeString(this.cover);
    }

    public HiItem(String judul, String deskripsi, String created_at, String th_id, String file, String cover){
    }

    protected HiItem(Parcel in ){
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.tahun = in.readString();
        this.tanggal = in.readString();
        this.cover = in.readString();
    }

    public static final Parcelable.Creator<HiItem> CREATOR = new Parcelable.Creator<HiItem>(){

        @Override
        public HiItem createFromParcel(Parcel source) {
            return new HiItem(source);
        }

        @Override
        public HiItem[] newArray(int size) {
            return new HiItem[size];
        }
    };
}