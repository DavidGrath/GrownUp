package com.example.grownup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductPurchase extends AppCompatActivity implements View.OnClickListener {
    TextView priceLabel;
    Button buy;
    ImageView productView;
    ImageView[] imageViews;
    LinearLayout linearLayout;
    TextView productName;
    Product product, nextProd, thirdProd, anotherProd;
    Product[] productList;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    FragmentManager fragmentManager;
    Context context;
    private static int PAGES = 3;
    private String[] productNames = {"Wrist Watch", "Bow Tie", "Chinos"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO initialise the resource XML file data members
        setContentView(R.layout.product_preview);
        context = this;
        priceLabel = findViewById(R.id.product_price);
        productName = findViewById(R.id.product_name);
        productView = findViewById(R.id.image_view);
        buy = findViewById(R.id.buy_button);
        viewPager = findViewById(R.id.view_pager);

        product = new Product("Wrist Watch", 56.67, context.getDrawable(R.drawable.sample_watch));
        nextProd = new Product("Bow Tie", 2000.00, context.getDrawable(R.drawable.sample_bowtie));
        thirdProd = new Product("Chinos", 1000.98, context.getDrawable(R.drawable.sample_chinos));
        anotherProd = new Product("Undefined", 0.0, context.getDrawable(R.drawable.ic_launcher_background));
        productList = new Product[]{product, nextProd, thirdProd, anotherProd};
        productName.setText(product.getProductName());
        priceLabel.setText(product.getPriceCurrency());
        //productView.setImageDrawable(product.getProductImage());
        buy.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        linearLayout = findViewById(R.id.linear_horiz);
        viewPagerAdapter = new ViewPagerAdapter(context, productList);
        viewPager.setAdapter(viewPagerAdapter);
        imageViews = new ImageView[productList.length];
        for(int i = 0; i < imageViews.length; i++) {
            imageViews[i] = new ImageView(context);
            imageViews[i].setImageDrawable(i == 0?context.getDrawable(R.drawable.indicator_active) :
                    context.getDrawable(R.drawable.indicator_inactive));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            linearLayout.addView(imageViews[i], params);
            final int finalI = i;
            imageViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewPager.setCurrentItem(finalI, true);
                }
            });
        }
        viewPager.addOnPageChangeListener(new PageChangeListener(productName, priceLabel, productList, imageViews, context));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buy_button:
                Intent intent = new Intent(context, FragmentExtender.class);
                startActivity(intent);
                break;
        }
    }
}

class PageChangeListener extends ViewPager.SimpleOnPageChangeListener {

    TextView productName, productPrice;
    Product[] products;
    ImageView[] imageViews;
    Context context;

    public PageChangeListener(TextView productName, TextView productPrice, Product[] products, ImageView[] imageViews, Context context) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.products = products;
        this.imageViews = imageViews;
        this.context = context;
    }

    @Override
    public void onPageSelected(int position) {
        productName.setText(products[position].getProductName());
        productPrice.setText(products[position].getPriceCurrency());
        for(int i = 0; i < imageViews.length; i++) {
            if(i == position)
                imageViews[i].setImageDrawable(context.getDrawable(R.drawable.indicator_active));
            else
                imageViews[i].setImageDrawable(context.getDrawable(R.drawable.indicator_inactive));
        }
    }

//    @Override
//    public void onPageScrollStateChanged(int state) {
//        switch (state) {
//            case ViewPager.SCROLL_STATE_DRAGGING:
//
//        }
//    }
}