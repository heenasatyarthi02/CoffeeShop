package com.noralynn.coffeeHelper.beveragelist;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.noralynn.coffeeHelper.R;
import com.noralynn.coffeeHelper.common.Beverage;

import java.util.ArrayList;
import java.util.List;

class BeverageAdapter extends RecyclerView.Adapter<BeverageViewHolder> {

    @Nullable
    private List<Beverage> beverages = new ArrayList<>();

    @NonNull
    private BeverageListViewPresenter presenter;

    BeverageAdapter(@NonNull BeverageListViewPresenter presenter, @Nullable List<Beverage> beverages) {
        this.beverages = beverages;
        this.presenter = presenter;
    }

    @Override
    public BeverageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_beverage, parent, false);
        final BeverageViewHolder viewHolder = new BeverageViewHolder(itemView);
        itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != beverages) {
                    presenter.onClickBeverage(beverages.get(viewHolder.getAdapterPosition()));
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BeverageViewHolder holder, int position) {
        if (null == beverages) {
            return;
        }
        Beverage beverage = beverages.get(position);
        holder.bind(beverage);
    }

    @Override
    public int getItemCount() {
        if (beverages == null) {
            return 0;
        }
        return beverages.size();
    }

}
