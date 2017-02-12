package com.demo.demoapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adapters.ProductAdapterOld;
import api.Client;
import api.EndpointsInterface;
import butterknife.Bind;
import butterknife.ButterKnife;
import interfaces.ProductInterface;
import models.Results;
import models.SearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ProductInterface {

    @Bind(R.id.search_bar) EditText search_bar;
    @Bind(R.id.fab) FloatingActionButton fab;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    String TAG  = "MainActivity";
    private List<Results> products = new ArrayList<>();
    ProductInterface buttonListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if(toolbar!=null) {
            setSupportActionBar(toolbar);
        }

        setUpRecyclerView();

        setClickEvents();

        setupSearchBarListener();


    }

    private void testAnimation() {
        final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.vibrate);
        fab.startAnimation(animShake);
    }

    private void setUpRecyclerView() {
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void setupSearchBarListener() {
        search_bar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() > 2){
                    startSearchQuery();
                }else{
                    products = new ArrayList<>();
                    recyclerView.setAdapter(new ProductAdapterOld(products, R.layout.adapater_product_item, getApplicationContext(),MainActivity.this));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void startSearchQuery(){
        String searchQuery = search_bar.getText().toString();

        EndpointsInterface apiService = Client.getClient().create(EndpointsInterface.class);
        Call<SearchResponse> call = apiService.searchProduct(searchQuery, BuildConfig.API_KEY);

        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                int statusCode = response.code();

                if(statusCode == 200){
                    products = Arrays.asList(response.body().getResults());
                    recyclerView.setAdapter(new ProductAdapterOld(products, R.layout.adapater_product_item, getApplicationContext(),MainActivity.this));
                }else{
                    Log.d(TAG, String.valueOf(response.errorBody()));
                    Log.d(TAG, String.valueOf(response.raw()));
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.d(TAG, String.valueOf(t.getMessage()));
            }
        });
    }

    private void setClickEvents() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void addToBasket() {
        testAnimation();
    }
}
