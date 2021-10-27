package com.example.modul2_kelompok17.Model.response;

import com.example.modul2_kelompok17.Model.DataItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ListUserResponse {

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("total")
    private int total;

    @SerializedName("data")
    private ArrayList<DataItem> data;

    @SerializedName("page")
    private int page;

    @SerializedName("total_pages")
    private int totalPages;

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ArrayList<DataItem> getData() {
        return data;
    }

    public void setData(ArrayList<DataItem> data) {
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public String toString() {
        return "ListUserResponse{" +
                "perPage=" + perPage +
                ", total=" + total +
                ", data=" + data +
                ", page=" + page +
                ", totalPages=" + totalPages +
                '}';
    }
}
