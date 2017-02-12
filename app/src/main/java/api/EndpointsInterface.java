package api;

import models.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Akinsete on 2/11/17.
 */

public interface EndpointsInterface {

    @GET("Search")
    Call<SearchResponse> searchProduct(@Query("term") String queryString, @Query("key") String key);
}
