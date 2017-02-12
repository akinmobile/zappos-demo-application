package adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import models.Results;


/**
 * Created by Louisa on 02/02/2017.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductBindingHolder> {

    private List<Results> products;
    private int rowLayout;
    private Context context;


    public static class ProductBindingHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mViewDataBinding;


        public ProductBindingHolder(View rowView) {
            super(rowView);
            mViewDataBinding = DataBindingUtil.bind(rowView);

        }

        public ViewDataBinding getViewDataBinding() {
            return mViewDataBinding;
        }
    }

    public ProductAdapter(List<Results> products, Context context) {
        this.products = products;
        this.rowLayout = rowLayout;
        this.context = context;
    }



    @Override
    public ProductAdapter.ProductBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        ProductBindingHolder holder = new ProductBindingHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(ProductBindingHolder holder, final int position) {
        final Results results = products.get(position);
        ViewDataBinding viewDataBinding = holder.getViewDataBinding();
        //viewDataBinding.setVariable(BR.results,results);
        //holder.getViewDataBinding().executePendingBindings();

//
//
//        Glide.with(context)
//                .load(results.getThumbnailImageUrl())
//                .override(150, 170)
//                .placeholder(R.mipmap.empty_img)
//                .centerCrop()
//                .error(R.mipmap.empty_img)
//                .centerCrop()
//                .fallback(R.mipmap.empty_img)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.product_image);

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}