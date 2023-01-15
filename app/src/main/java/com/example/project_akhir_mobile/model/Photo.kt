package com.example.project_akhir_mobile.model
import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("namahotel")
    val title: String?,
    @SerializedName("gambarhotel")
    val thumbnail: String?,
    @SerializedName("lokasihotel")
    val lokasi: String?,
    @SerializedName("ratinghotel")
    val rating: String?,
    @SerializedName("namawisata")
    val titleWisata: String?,
    @SerializedName("gambarwisata")
    val gambarWisata: String?,
    @SerializedName("lokasiwisata")
    val lokasiWisata: String?,
    @SerializedName("ratingwisata")
    val ratingWisata: String?,
    @SerializedName("namakuliner")
    val titleKuliner: String?,
    @SerializedName("gambarkuliner")
    val gambarKuliner: String?,
    @SerializedName("lokasikuliner")
    val lokasiKuliner: String?,
    @SerializedName("ratingkuliner")
    val ratingKuliner: String?
)