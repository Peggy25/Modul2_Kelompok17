package com.example.modul2_kelompok17.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.modul2_kelompok17.Model.OnBoardingItem;
import com.example.modul2_kelompok17.R;

import java.util.ArrayList;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder> {

    private ArrayList<OnBoardingItem> onBoardingItems;

    public OnBoardingAdapter(ArrayList<OnBoardingItem> onBoardingItems){
        this.onBoardingItems = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingAdapter.OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_onboarding,parent,false
        );
        return new OnBoardingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingAdapter.OnBoardingViewHolder holder, int position) {
        holder.setOnboardingData(onBoardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onBoardingItems.size();
    }

    public class OnBoardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textDescription;
        private ImageView imageOnboarding;

        public OnBoardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textDescription = itemView.findViewById(R.id.textDescription);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }
        void setOnboardingData(OnBoardingItem onboardingItem) {
            textDescription.setText(onboardingItem.getDescription());
            imageOnboarding.setImageResource(onboardingItem.getImage());
        }

    }
}
