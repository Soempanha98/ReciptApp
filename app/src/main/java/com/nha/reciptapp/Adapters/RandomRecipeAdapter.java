package com.nha.reciptapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.nha.reciptapp.Listener.RecipeClickListener;
import com.nha.reciptapp.Models.Recipe;
import com.nha.reciptapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder> {
    Context context;
    List<Recipe> list;
    RecipeClickListener listener;

    public RandomRecipeAdapter(Context context, List<Recipe> list, RecipeClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipe, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView_title.setText(list.get(position).title);
        holder.textView_title.setSelected(true);
        holder.textView_Person.setText(list.get(position).servings+"Person");
        holder.textView_time.setText(list.get(position).aggregateLikes+"Minutes");
        holder.textView_price.setText(list.get(position).readyInMinutes+"$");
        Picasso.get().load(list.get(position).image).into(holder.imageView_food);


        holder.random_list_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onRecipeClicked(String.valueOf(list.get(position).id));

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder {
    CardView random_list_container;
    TextView textView_title, textView_time, textView_Person, textView_price;
    ImageView imageView_food;

    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_list_container = itemView.findViewById(R.id.random_list_container);
        textView_title = itemView.findViewById(R.id.textview_title);
        textView_time = itemView.findViewById(R.id.textView_time);
        textView_Person = itemView.findViewById(R.id.textView_person);
        textView_price = itemView.findViewById(R.id.textView_Price);
        imageView_food = itemView.findViewById(R.id.imageView_food);
    }
}