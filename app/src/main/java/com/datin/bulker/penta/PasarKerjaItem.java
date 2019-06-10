package com.datin.bulker.penta;

import android.os.Parcel;
import android.os.Parcel;
import android.os.Parcelable;


public class PasarKerjaItem implements Parcelable{
    private String no, name, Position, birth_date, Poster;

    public PasarKerjaItem(String no, String name, String Position, String birth_date, String Poster ) {
        this.no = no;
        this.name = name;
        this.Position = Position;
        this.birth_date = birth_date;
        this.Poster = Poster;
    }


    public String getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return Position;
    }

    public String getBirth_date(){
        return birth_date;
    }

    public String getPoster() {
        return Poster;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.no);
        parcel.writeString(this.name);
        parcel.writeString(this.Position);
        parcel.writeString(this.birth_date);
        parcel.writeString(this.Poster);
    }

    public PasarKerjaItem(){
    }

    protected PasarKerjaItem(Parcel in ){
        this.no = in.readString();
        this.name = in.readString();
        this.Position = in.readString();
        this.birth_date = in.readString();
        this.Poster = in.readString();
    }

    public static final Parcelable.Creator<PasarKerjaItem> CREATOR = new Parcelable.Creator<PasarKerjaItem>(){

        @Override
        public PasarKerjaItem createFromParcel(Parcel source) {
            return new PasarKerjaItem(source);
        }

        @Override
        public PasarKerjaItem[] newArray(int size) {
            return new PasarKerjaItem[size];
        }
    };
}