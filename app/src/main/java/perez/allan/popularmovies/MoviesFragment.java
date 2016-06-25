package perez.allan.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MoviesFragment extends Fragment {
    private AndroidMoviesAdapter moviesAdapter;

    AndroidMovies[] androidMovies = {
            new AndroidMovies("Perrito0", "0", R.drawable.sample_0),
            new AndroidMovies("Perrito1", "1", R.drawable.sample_1),
            new AndroidMovies("Perrito2", "2", R.drawable.sample_2),
            new AndroidMovies("Perrito3", "3", R.drawable.sample_3),
            new AndroidMovies("Perrito4", "4", R.drawable.sample_4),
            new AndroidMovies("Perrito5", "5", R.drawable.sample_5),
            new AndroidMovies("Perrito6", "6", R.drawable.sample_6),
            new AndroidMovies("Perrito7", "7", R.drawable.sample_7),

    };



    public MoviesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        moviesAdapter = new AndroidMoviesAdapter(getActivity(), Arrays.asList(androidMovies));
        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);
        gridView.setAdapter(moviesAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String name = moviesAdapter.getItem(position).versionName;
                Toast.makeText(getContext(),name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailMovies.class).putExtra(Intent.EXTRA_TEXT, name);
                startActivity(intent);
            }
        });
        return rootView;

    }



}
