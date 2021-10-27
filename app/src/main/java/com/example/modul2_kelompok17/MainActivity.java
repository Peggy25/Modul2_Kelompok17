package com.example.modul2_kelompok17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.modul2_kelompok17.Model.DataItem;
import com.example.modul2_kelompok17.activity.AboutActivity;
import com.example.modul2_kelompok17.adapter.RecycleAdapter;
import com.example.modul2_kelompok17.data.ApiClient;
import com.example.modul2_kelompok17.Model.response.ListUserResponse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvListUser;

    private ArrayList<DataItem> listItem;
    private RecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvListUser = findViewById(R.id.rv_list_user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvListUser.setLayoutManager(layoutManager);
        rvListUser.setHasFixedSize(true);
        getData();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater in=getMenuInflater();
        in.inflate(R.menu.menu_top,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btn_info) {
            Intent about = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(about);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData(){
        ApiClient.getService().getList().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                assert response.body() != null;
                adapter = new RecycleAdapter(response.body().getData(), MainActivity.this);
                adapter.notifyDataSetChanged();
                rvListUser.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), (CharSequence) t, Toast.LENGTH_LONG).show();
            }
        });
    }
}
