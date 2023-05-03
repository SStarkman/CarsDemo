package com.example.carsdemo;

import android.animation.Animator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CarsItemAdapter extends RecyclerView.Adapter<CarsItemViewHolder> {

    private final int [] carImages;
    private final String [] carNames;

    public CarsItemAdapter(int[] carImages, String[] carNames) {
        this.carImages = carImages;
        this.carNames = carNames;
    }

    @NonNull
    @Override
    public CarsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Make one "tile"; this will be called once per number of visible tiles on screen
        View itemView = LayoutInflater.from(
                parent.getContext()).inflate(R.layout.rv_item, parent, false);

        return new CarsItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsItemViewHolder holder, int position) {
        // Insert into this tile the image and name of the car we are up to
        holder.imageView.setImageResource(carImages[position]);
        holder.textView.setText(carNames[position]);
        holder.itemView.setOnClickListener (v -> clickHandler (v, holder));
    }

    private void clickHandler (View v, @NonNull CarsItemViewHolder holder)
    {
        int currentPosition = holder.getBindingAdapterPosition ();
        String msg = "Clicked on #" +  + (currentPosition+1) + ": " + carNames[currentPosition];
        Snackbar.make(v, msg, Snackbar.LENGTH_LONG).show ();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull CarsItemViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        animateCard(holder.cardView);
    }

    private void animateCard(CardView view) {
        int centerX = 0, centerY = 0, startRadius = 0;
        int endRadius = Math.max(view.getWidth(), view.getHeight());
        Animator circularRevealAnimationOfCard = ViewAnimationUtils.createCircularReveal
                (view, centerX, centerY, startRadius, endRadius);
        circularRevealAnimationOfCard.start();
    }

    @Override
    public int getItemCount() {
        return carImages.length;
    }
}
