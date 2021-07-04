package com.gerenciador.comics.resources.response;

import java.util.ArrayList;

public class ResultIdResponse {
    private float id;
    private float digitalId;
    private String title;
    private float issueNumber;
    private String variantDescription;
    private String description = null;
    private String modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private float pageCount;
    ArrayList<Object> textObjects = new ArrayList<Object>();
    private String resourceURI;
    ArrayList<Object> urls = new ArrayList<Object>();
    Series SeriesObject;
    ArrayList<Object> variants = new ArrayList<Object>();
    ArrayList<Object> collections = new ArrayList<Object>();
    ArrayList<Object> collectedIssues = new ArrayList<Object>();
    ArrayList<Object> dates = new ArrayList<Object>();
    ArrayList<PriceResponse> prices = new ArrayList<PriceResponse>();
    Thumbnail ThumbnailObject;
    ArrayList<Object> images = new ArrayList<Object>();
    Creators CreatorsObject;
    Characters CharactersObject;
    Stories StoriesObject;
    Events EventsObject;


    // Getter Methods

    public float getId() {
        return id;
    }

    public float getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public float getIssueNumber() {
        return issueNumber;
    }

    public String getVariantDescription() {
        return variantDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getModified() {
        return modified;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getUpc() {
        return upc;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public String getEan() {
        return ean;
    }

    public String getIssn() {
        return issn;
    }

    public String getFormat() {
        return format;
    }

    public float getPageCount() {
        return pageCount;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public Series getSeries() {
        return SeriesObject;
    }

    public Thumbnail getThumbnail() {
        return ThumbnailObject;
    }

    public Creators getCreators() {
        return CreatorsObject;
    }

    public Characters getCharacters() {
        return CharactersObject;
    }

    public Stories getStories() {
        return StoriesObject;
    }

    public Events getEvents() {
        return EventsObject;
    }

    public ArrayList<PriceResponse> getPrices() {
        return prices;
    }
// Setter Methods

    public void setId( float id ) {
        this.id = id;
    }

    public void setDigitalId( float digitalId ) {
        this.digitalId = digitalId;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public void setIssueNumber( float issueNumber ) {
        this.issueNumber = issueNumber;
    }

    public void setVariantDescription( String variantDescription ) {
        this.variantDescription = variantDescription;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public void setModified( String modified ) {
        this.modified = modified;
    }

    public void setIsbn( String isbn ) {
        this.isbn = isbn;
    }

    public void setUpc( String upc ) {
        this.upc = upc;
    }

    public void setDiamondCode( String diamondCode ) {
        this.diamondCode = diamondCode;
    }

    public void setEan( String ean ) {
        this.ean = ean;
    }

    public void setIssn( String issn ) {
        this.issn = issn;
    }

    public void setFormat( String format ) {
        this.format = format;
    }

    public void setPageCount( float pageCount ) {
        this.pageCount = pageCount;
    }

    public void setResourceURI( String resourceURI ) {
        this.resourceURI = resourceURI;
    }

    public void setSeries( Series seriesObject ) {
        this.SeriesObject = seriesObject;
    }

    public void setThumbnail( Thumbnail thumbnailObject ) {
        this.ThumbnailObject = thumbnailObject;
    }

    public void setCreators( Creators creatorsObject ) {
        this.CreatorsObject = creatorsObject;
    }

    public void setCharacters( Characters charactersObject ) {
        this.CharactersObject = charactersObject;
    }

    public void setStories( Stories storiesObject ) {
        this.StoriesObject = storiesObject;
    }

    public void setEvents( Events eventsObject ) {
        this.EventsObject = eventsObject;
    }

    public void setPrices(ArrayList<PriceResponse> prices) {
        this.prices = prices;
    }
}
class Events {
    private float available;
    private String collectionURI;
    ArrayList<Object> items = new ArrayList<Object>();
    private float returned;


    // Getter Methods

    public float getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public float getReturned() {
        return returned;
    }

    // Setter Methods

    public void setAvailable( float available ) {
        this.available = available;
    }

    public void setCollectionURI( String collectionURI ) {
        this.collectionURI = collectionURI;
    }

    public void setReturned( float returned ) {
        this.returned = returned;
    }
}
class Stories {
    private float available;
    private String collectionURI;
    ArrayList<Object> items = new ArrayList<Object>();
    private float returned;


    // Getter Methods

    public float getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public float getReturned() {
        return returned;
    }

    // Setter Methods

    public void setAvailable( float available ) {
        this.available = available;
    }

    public void setCollectionURI( String collectionURI ) {
        this.collectionURI = collectionURI;
    }

    public void setReturned( float returned ) {
        this.returned = returned;
    }
}
class Characters {
    private float available;
    private String collectionURI;
    ArrayList<Object> items = new ArrayList<Object>();
    private float returned;


    // Getter Methods

    public float getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public float getReturned() {
        return returned;
    }

    // Setter Methods

    public void setAvailable( float available ) {
        this.available = available;
    }

    public void setCollectionURI( String collectionURI ) {
        this.collectionURI = collectionURI;
    }

    public void setReturned( float returned ) {
        this.returned = returned;
    }
}
class Creators {
    private float available;
    private String collectionURI;
    ArrayList<Object> items = new ArrayList<Object>();
    private float returned;


    // Getter Methods

    public float getAvailable() {
        return available;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public float getReturned() {
        return returned;
    }

    // Setter Methods

    public void setAvailable( float available ) {
        this.available = available;
    }

    public void setCollectionURI( String collectionURI ) {
        this.collectionURI = collectionURI;
    }

    public void setReturned( float returned ) {
        this.returned = returned;
    }
}
class Thumbnail {
    private String path;
    private String extension;


    // Getter Methods

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    // Setter Methods

    public void setPath( String path ) {
        this.path = path;
    }

    public void setExtension( String extension ) {
        this.extension = extension;
    }
}
class Series {
    private String resourceURI;
    private String name;


    // Getter Methods

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    // Setter Methods

    public void setResourceURI( String resourceURI ) {
        this.resourceURI = resourceURI;
    }

    public void setName( String name ) {
        this.name = name;
    }
}
