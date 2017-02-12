package adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.demo.demoapplication.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import interfaces.ProductInterface;
import models.Results;

/**
 * Created by Louisa on 02/02/2017.
 */
public class ProductAdapterOld extends RecyclerView.Adapter<ProductAdapterOld.ProductViewHolder> {

    private List<Results> products;
    private int rowLayout;
    private Context context;
    ProductInterface productInterface;

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;
        @Bind(R.id.original_price) TextView original_price;
        @Bind(R.id.product_name) TextView product_name;
        @Bind(R.id.product_price) TextView product_price;
        @Bind(R.id.brand_name) TextView brand_name;
        @Bind(R.id.product_image) ImageView product_image;
        @Bind(R.id.btn_add_to_cart) ImageButton btn_add_to_cart;

        public ProductViewHolder(ViewDataBinding v) {
            super(v.getRoot());
            mViewDataBinding = v;
            mViewDataBinding.executePendingBindings();
            ButterKnife.bind(this,v.getRoot());
        }


        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }

    public ProductAdapterOld(List<Results> products, int rowLayout, Context context, ProductInterface productInterface) {
        this.products = products;
        this.rowLayout = rowLayout;
        this.context = context;
        this.productInterface = productInterface;
    }

    @Override
    public ProductAdapterOld.ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);

        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), rowLayout, parent, false);

        //LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);
        //ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, rowLayout, parent, false);


        return new ProductViewHolder(viewDataBinding);
    }


    @Override
    public void onBindViewHolder(ProductViewHolder holder, final int position) {
        Results results = products.get(position);
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        viewDataBinding.setVariable(1,results);


        holder.brand_name.setText(results.getBrandName());
        holder.product_name.setText(results.getProductName());
        holder.product_price.setText(results.getOriginalPrice());
        holder.original_price.setText(results.getPrice());
        holder.product_price.setPaintFlags(holder.product_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        Glide.with(context)
                .load(results.getThumbnailImageUrl())
                .override(150, 170)
                .placeholder(R.mipmap.empty_img)
                .fitCenter()
                .crossFade()
                .error(R.mipmap.empty_img)
                .fallback(R.mipmap.empty_img)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.product_image);

        holder.btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productInterface.addToBasket();
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}