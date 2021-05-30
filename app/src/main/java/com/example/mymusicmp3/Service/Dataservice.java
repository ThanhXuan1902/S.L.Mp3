package com.example.mymusicmp3.Service;

import com.example.mymusicmp3.Model.Album;
import com.example.mymusicmp3.Model.Baihatyeuthich;
import com.example.mymusicmp3.Model.ChuDe;
import com.example.mymusicmp3.Model.Chudevatheloaitrongngay;
import com.example.mymusicmp3.Model.LoginResponseModel;
import com.example.mymusicmp3.Model.Play;
import com.example.mymusicmp3.Model.QuangCao;
import com.example.mymusicmp3.Model.RegistrationResponseModel;
import com.example.mymusicmp3.Model.TheLoai;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("Song_Banner.php")
    Call<List<QuangCao>> getDataQuangCao();

    @GET("playListCurrentDay.php")
    Call<List<Play>> getplayListCurrentDay();

    @GET("chudevathelaoitrongngay.php")
    Call<Chudevatheloaitrongngay> getChudevatheloaitrongngay();

    @GET("album.php")
    Call<List<Album>> getAlbumToday();

    @GET("baihatduocyeuthich.php")
    Call<List<Baihatyeuthich>> getbaiHatYeuThich();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatyeuthich>> getdanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatyeuthich>> getdanhsachbaihattheoplaylist(@Field("idplaylist") String idplaylist);

    @GET("danhsachcacplaylist.php")
    Call<List<Play>> getDanhSachAllPlaylist();

    @FormUrlEncoded
    @POST("danhsanhbaihattheotheloai.php")
    Call<List<Baihatyeuthich>> getdanhsachbaihattheotheloai(@Field("idtheloai") String idtheloai);

    @GET("Allchude.php")
    Call<List<ChuDe>> getAllChuDe();

    @FormUrlEncoded
    @POST("theloaithechude.php")
    Call<List<TheLoai>> getdanhsachtheloaitheochude(@Field("idchude") String idchude);

    @GET("AllAlbum.php")
    Call<List<Album>> getAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<Baihatyeuthich>> getdanhsachbaihattheoAlbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("CapNhatLuotThich.php")
    Call<String> getCapNhatLuotThich(@Field("luotThich") String luotThich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("timkiembaihat.php")
    Call<List<Baihatyeuthich>> gettimkiembaihat(@Field("tukhoa") String tukhoa);


    @FormUrlEncoded
    @POST("dangky.php")
    Call<RegistrationResponseModel> register(@FieldMap HashMap<String, String> params);

    @FormUrlEncoded
    @POST("dangnhap.php")
    Call<LoginResponseModel> login(@Field("email") String email, @Field("password") String password);

}
