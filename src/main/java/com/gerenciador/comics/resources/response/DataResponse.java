package com.gerenciador.comics.resources.response;

import java.util.ArrayList;

public class DataResponse {
    private float offset;
    private float limit;
    private float total;
    private float count;
    ArrayList<ResultIdResponse> results = new ArrayList<ResultIdResponse>();

    // Getter Methods

    public float getOffset() {
        return offset;
    }

    public float getLimit() {
        return limit;
    }

    public float getTotal() {
        return total;
    }

    public float getCount() {
        return count;
    }

    public ArrayList<ResultIdResponse> getResults() {
        return results;
    }

    // Setter Methods

    public void setOffset(float offset) {
        this.offset = offset;
    }

    public void setLimit(float limit) {
        this.limit = limit;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public void setResults(ArrayList<ResultIdResponse> results) {
        this.results = results;
    }
}

