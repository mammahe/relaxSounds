package sairamkrishna.relax.relaxsounds;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



public class Tab1 extends Fragment {
    private final List<Sounds> movieList = new ArrayList<>();
    private SoundAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_tab1, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.recycler_view);

        mAdapter = new SoundAdapter(movieList, getActivity().getApplication().getApplicationContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplication());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity().getApplication()));
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
        return v;
    }

    private void prepareMovieData() {
        Sounds movie = new Sounds("Relaxing Ocean", "ocean", R.raw.ocean);
        movieList.add(movie);

        movie = new Sounds("Peace Of Mind", "peaceofmind", R.raw.asianduet);
        movieList.add(movie);

        movie = new Sounds("Forest Birds", "forestbirds", R.raw.forest_with_birds);
        movieList.add(movie);

        movie = new Sounds("Summer Forest", "summerforest", R.raw.forest_main);
        movieList.add(movie);

        movie = new Sounds("Calm", "calm", R.raw.lament);
        movieList.add(movie);

        movie = new Sounds("Bamboo Relax", "bamboo", R.raw.bamboo);
        movieList.add(movie);

        movie = new Sounds("Flute Romance", "fluteromance", R.raw.chineseflute);
        movieList.add(movie);

        movie = new Sounds("Waterfall", "waterfall", R.raw.waterfall_birds);
        movieList.add(movie);

        movie = new Sounds("Mountain Forest", "mountainforest", R.raw.moutains_wind);
        movieList.add(movie);

        movie = new Sounds("Windly Mountains", "windlymountains", R.raw.waterfall_main);
        movieList.add(movie);

        movie = new Sounds("Water Prayers", "waterprayers", R.raw.waterprayers);
        movieList.add(movie);

        movie = new Sounds("Winter Night", "winternight", R.raw.waitingforwinter);
        movieList.add(movie);

        movie = new Sounds("Evening Lake", "eveninglake", R.raw.lake_main);
        movieList.add(movie);

        movie = new Sounds("Rain on grass", "rainongrass", R.raw.rain_on_grass);
        movieList.add(movie);

        movie = new Sounds("Rain on Window", "rainonwindow", R.raw.rain_on_window_main);
        movieList.add(movie);

        movie = new Sounds("Prayer", "prayer", R.raw.asianprayer);
        movieList.add(movie);

        movie = new Sounds("Healthy Morning", "hmorning", R.raw.secretpearls);
        movieList.add(movie);

        movie = new Sounds("Thunderstorm", "thunderstrom", R.raw.perfect_rain_thunders);
        movieList.add(movie);

        movie = new Sounds("Cherry Blossom", "cherryblooms", R.raw.cherryblossom);
        movieList.add(movie);

        movie = new Sounds("Harp Music", "harp", R.raw.harp);
        movieList.add(movie);

        movie = new Sounds("Calm night", "night", R.raw.night_main);
        movieList.add(movie);

        movie = new Sounds("Warn Camp Fire", "fire", R.raw.fire_main);
        movieList.add(movie);

        movie = new Sounds("Silk Route", "silkroute", R.raw.silkroute);
        movieList.add(movie);

        movie = new Sounds("Chinese Lullaby", "chineselullaby", R.raw.chineselullaby);
        movieList.add(movie);

        movie = new Sounds("Chinese Melody", "chinesemelody", R.raw.chinesemelody);
        movieList.add(movie);

        movie = new Sounds("Indo Flute", "indoflute", R.raw.indoflute);
        movieList.add(movie);

        movie = new Sounds("Peaceful Lake", "peacefullake", R.raw.peacefull_evening_main);
        movieList.add(movie);

        movie = new Sounds("Gentle Morning", "gentlemorning", R.raw.gm_main);
        movieList.add(movie);

        movie = new Sounds("Sunrise", "sunrise", R.raw.sp_main);
        movieList.add(movie);

        movie = new Sounds("Heaven", "heaven", R.raw.h_main);
        movieList.add(movie);

        movie = new Sounds("Perfect Rain", "prain", R.raw.perfect_rain_main);
        movieList.add(movie);

        movie = new Sounds("Inspiration", "inspiration", R.raw.in_main);
        movieList.add(movie);

        movie = new Sounds("Autumn Forest", "aforest", R.raw.af_main);
        movieList.add(movie);

        movie = new Sounds("Seaside Relaxation", "srelax", R.raw.o_main);
        movieList.add(movie);

        movie = new Sounds("Mystic Temple", "temple", R.raw.it_main);
        movieList.add(movie);

        movie = new Sounds("Soft Romantic Piano", "spiano", R.raw.soft_piano_main);
        movieList.add(movie);


        Collections.sort(movieList, new Comparator<Sounds>() {
            @Override
            public int compare(Sounds lhs, Sounds rhs) {
                return lhs.getTitle().compareTo(rhs.getTitle());
            }
        });

        mAdapter.notifyDataSetChanged();
    }
}
