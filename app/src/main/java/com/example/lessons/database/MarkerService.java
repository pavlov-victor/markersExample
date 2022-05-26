package com.example.lessons.database;

import com.example.lessons.models.Marker;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MarkerService {
    @GET("markers")
    Call<List<Marker>> getMarkers();
}
