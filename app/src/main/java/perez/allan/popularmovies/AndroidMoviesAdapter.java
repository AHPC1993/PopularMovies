package perez.allan.popularmovies;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by GSG on 24/06/2016.
 */
public class AndroidMoviesAdapter extends ArrayAdapter<AndroidMovies>{
private static final String LOG_TAG = AndroidMoviesAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the List is the data we want
     * to populate into the lists
     * context        The current context. Used to inflate the layout file.
     * androidMovies A List of AndroidFlavor objects to display in a list
     */
    public AndroidMoviesAdapter(Activity context, List<AndroidMovies> androidMovies) {
        super(context, 0, androidMovies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AndroidMovies androidMovies = getItem(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.movies_item,parent,false);
        }
        //I must to change this for the text real about movies.
        ImageView imageView = (ImageView) convertView.findViewById(R.id.movies_image);
        imageView.setImageResource(androidMovies.image);

        TextView versionNameView = (TextView) convertView.findViewById(R.id.movies_text);
        versionNameView.setText(androidMovies.versionName);
        return convertView;
    }
}
