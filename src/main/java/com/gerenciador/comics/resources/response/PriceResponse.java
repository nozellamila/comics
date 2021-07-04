package com.gerenciador.comics.resources.response;

public class PriceResponse {
    private String type;
    private float price;


    // Getter Methods

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    // Setter Methods

    public void setType( String type ) {
        this.type = type;
    }

    public void setPrice( float price ) {
        this.price = price;
    }
}
