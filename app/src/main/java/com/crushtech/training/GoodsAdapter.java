package com.crushtech.training;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.crushtech.training.MainActivity.Goods;

import java.util.ArrayList;

public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHolder> {
    private final ArrayList<Goods> goodsArrayList;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class GoodsViewHolder extends RecyclerView.ViewHolder {
        private final TextView goodsNameTv, goodsIdTv, goodsPriceTv;

        public GoodsViewHolder(View itemView) {
            super(itemView);
            goodsNameTv = (TextView) itemView.findViewById(R.id.tv_goodsName);
            goodsIdTv = (TextView) itemView.findViewById(R.id.tv_goodsId);
            goodsPriceTv = (TextView) itemView.findViewById(R.id.tv_price);
        }

        public TextView getGoodsIdTv() {
            return goodsIdTv;
        }

        public TextView getGoodsNameTv() {
            return goodsNameTv;
        }

        public TextView getGoodsPriceTv() {
            return goodsPriceTv;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param goods ArrayList<Goods> containing the data to populate views to be used
     *              by RecyclerView.
     */
    public GoodsAdapter(ArrayList<Goods> goods) {
        this.goodsArrayList = goods;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public GoodsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.goods_items, parent, false);
        return new GoodsViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull GoodsViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Goods currentGoods = goodsArrayList.get(position);
        holder.getGoodsIdTv().setText(currentGoods.goodId);
        holder.getGoodsNameTv().setText(currentGoods.name);
        String priceString = "$" + currentGoods.price;
        holder.getGoodsPriceTv().setText(priceString);
    }

    @Override
    public int getItemCount() {
        return goodsArrayList.size();
    }
}
