package sairamkrishna.relax.relaxsounds;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pkmmte.view.CircularImageView;

import java.util.List;

class SoundAdapter extends RecyclerView.Adapter<SoundAdapter.MyViewHolder> {
    private final Context context;
    private final List<Sounds> soundsList;

    public SoundAdapter(List<Sounds> soundsList, Context context) {
        this.soundsList = soundsList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sound_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SoundAdapter.MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.l1.setBackgroundColor(Color.parseColor("#f4f2c1"));
                break;
            case 1:
                holder.l1.setBackgroundColor(Color.parseColor("#f5ffce"));
                break;
            case 2:
                holder.l1.setBackgroundColor(Color.parseColor("#f4ebc6"));
                break;
            case 3:
                holder.l1.setBackgroundColor(Color.parseColor("#c6f5d1"));
                break;
            case 4:
                holder.l1.setBackgroundColor(Color.parseColor("#c3d8d8"));

                break;
            case 5:
                holder.l1.setBackgroundColor(Color.parseColor("#c6f4f4"));
                break;
            case 6:
                holder.l1.setBackgroundColor(Color.parseColor("#f9e5fc"));
                break;
            case 7:
                holder.l1.setBackgroundColor(Color.parseColor("#b9c9bd"));
                break;
            case 8:
                holder.l1.setBackgroundColor(Color.parseColor("#b7ecda"));
                break;
            case 9:
                holder.l1.setBackgroundColor(Color.parseColor("#fbfcdb"));
                break;
        }
        final Sounds movie = soundsList.get(position);
        holder.title.setText(movie.getTitle());
        holder.title.setTextColor(Color.parseColor("#81815a"));
        holder.l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, soundpage.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("Image", movie.getimage());
                i.putExtra("Tittle", movie.getTitle());
                i.putExtra("soung", movie.getocean());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return soundsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final CircularImageView circularImageView;
        final LinearLayout l1;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            circularImageView = view.findViewById(R.id.image);
            l1 = view.findViewById(R.id.layout);
        }
    }
}
