package com.allandroidprojects.ecomsample.fakedata;

import java.util.List;

import com.allandroidprojects.ecomsample.model.Product;

public class SearchProduct {

    public ListProductData productList = new ListProductData();

    public SearchProduct()
    {
        ListProductData dogData  = new DogData();
        ListProductData catData  = new CatData();

        for (Product product : catData.getData()) {
            productList.getData().add(product);
        }

        for (Product product : dogData.getData()) {
            productList.getData().add(product);
        }
    }

    public List<Product> getProductList(){
        return productList.getData();
    }
}
