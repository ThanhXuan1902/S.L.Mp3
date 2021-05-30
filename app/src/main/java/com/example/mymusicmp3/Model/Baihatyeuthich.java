package com.example.mymusicmp3.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Baihatyeuthich implements Parcelable {

            @SerializedName("IdBaiHat")
            @Expose
            private String idBaiHat;
            @SerializedName("TenBaiHat")
            @Expose
            private String tenBaiHat;
            @SerializedName("HinhBaiHat")
            @Expose
            private String hinhBaiHat;
            @SerializedName("CaSi")
            @Expose
            private String caSi;
            @SerializedName("LinkBaiHat")
            @Expose
            private String linkBaiHat;
            @SerializedName("LuotThich")
            @Expose
            private Object luotThich;

    protected Baihatyeuthich(Parcel in) {
        idBaiHat = in.readString();
        tenBaiHat = in.readString();
        hinhBaiHat = in.readString();
        caSi = in.readString();
        linkBaiHat = in.readString();
    }

    public static final Creator<Baihatyeuthich> CREATOR = new Creator<Baihatyeuthich>() {
        @Override
        public Baihatyeuthich createFromParcel(Parcel in) {
            return new Baihatyeuthich(in);
        }

        @Override
        public Baihatyeuthich[] newArray(int size) {
            return new Baihatyeuthich[size];
        }
    };

    public String getIdBaiHat() {
            return idBaiHat;
            }

            public void setIdBaiHat(String idBaiHat) {
            this.idBaiHat = idBaiHat;
            }

            public String getTenBaiHat() {
            return tenBaiHat;
            }

            public void setTenBaiHat(String tenBaiHat) {
            this.tenBaiHat = tenBaiHat;
            }

            public String getHinhBaiHat() {
            return hinhBaiHat;
            }

            public void setHinhBaiHat(String hinhBaiHat) {
            this.hinhBaiHat = hinhBaiHat;
            }

            public String getCaSi() {
            return caSi;
            }

            public void setCaSi(String caSi) {
            this.caSi = caSi;
            }

            public String getLinkBaiHat() {
            return linkBaiHat;
            }

            public void setLinkBaiHat(String linkBaiHat) {
            this.linkBaiHat = linkBaiHat;
            }

            public Object getLuotThich() {
            return luotThich;
            }

            public void setLuotThich(Object luotThich) {
            this.luotThich = luotThich;
            }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idBaiHat);
        dest.writeString(tenBaiHat);
        dest.writeString(hinhBaiHat);
        dest.writeString(caSi);
        dest.writeString(linkBaiHat);
    }
}