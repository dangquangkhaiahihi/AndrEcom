package com.allandroidprojects.ecomsample.fakedata;

import com.allandroidprojects.ecomsample.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListProductData {

    protected final List<Product> products;

    public ListProductData()
    {
        products = new ArrayList<>();
    }

    public List<Product> getData(){return products;};
}
