package com.example.grownup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

    private int PAGES;
    private Context context;
    Product[] products;

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.image_view_layout, container, false);
        ImageView imageView = v.findViewById(R.id.image_view);
        imageView.setImageDrawable(products[position].getProductImage());
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }

    public ViewPagerAdapter(Context context, Product[] products) {
        this.context = context;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }
}
