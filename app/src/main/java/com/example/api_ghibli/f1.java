package com.example.api_ghibli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class f1 extends AppCompatActivity {
    private ImageView poster;
    private TextView titulo, titulo_japones, diretor, dataLancamento, sinopse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f1);

        poster = findViewById(R.id.imgPoster);
        titulo = findViewById(R.id.txtTitulo);
        titulo_japones = findViewById(R.id.txtTituloJapan);
        diretor = findViewById(R.id.txtDiretor);
        dataLancamento = findViewById(R.id.txtData);
        sinopse = findViewById(R.id.txtSinopse);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ghibliapi.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        StudioGhibliAPI studioGhibliAPI = retrofit.create(StudioGhibliAPI.class);

        Call<List<PostFilme>> call = studioGhibliAPI.getPosts("dc2e6bd1-8156-4886-adff-b39e6043af0c");

        call.enqueue(new Callback<List<PostFilme>>() {

            @Override
            public void onResponse(Call<List<PostFilme>> call, Response<List<PostFilme>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Code: " + response.code(), Toast.LENGTH_SHORT);
                    return;
                }

                List<PostFilme> postFilmes = response.body();

                for (PostFilme postFilme : postFilmes) {
                    //Pega o poster
                    Picasso.get().load("https://image.tmdb.org/t/p/w600_and_h900_bestv2/39wmItIWsg5sZMyRUHLkWBcuVCM.jpg").into(poster);

                    //Pega o título na API
                    String title = "";
                    title = postFilme.getTitle();
                    titulo.setText(title);

                    //Pega o título em japonês na API
                    String originalTitleRomanised = "";
                    originalTitleRomanised = postFilme.getOriginal_title_romanised();
                    titulo_japones.setText(originalTitleRomanised);

                    //Pega o nome do diretor na API
                    String director = "";
                    director = postFilme.getDirector();
                    diretor.setText(director);

                    //Pega a data de lançamento
                    String releaseDate = "";
                    releaseDate = postFilme.getRelease_date();
                    dataLancamento.setText(releaseDate);

                    //Pega a sinopse na API
                    String description = "";
                    description = postFilme.getDescription();
                    sinopse.setText(description);
                }
            }

            @Override
            public void onFailure(Call<List<PostFilme>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }
}