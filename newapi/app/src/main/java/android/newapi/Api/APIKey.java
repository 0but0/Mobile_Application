package android.newapi.Api;
import android.newapi.Implementation.Newfeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
public interface APIKey {
    @GET("top-headlines")
    Call<Newfeed> getNewfeed(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}

