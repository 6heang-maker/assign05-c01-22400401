package org.example.week05_javacrud1.domain;

public class Game {
    private Long id;
    private String title;
    private String genre;
    private String developer;
    private int price;
    private double rating;

    public Game() {}
    public Game(Long id, String title, String genre, String developer, int price, double rating) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.developer = developer;
        this.price = price;
        this.rating = rating;
    }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }

    public String getTitle(){ return title; }
    public void setTitle(String title){ this.title = title; }

    public String getGenre(){ return genre; }
    public void setGenre(String genre){ this.genre = genre; }

    public String getDeveloper(){ return developer; }
    public void setDeveloper(String developer){ this.developer = developer; }

    public int getPrice(){ return price; }
    public void setPrice(int price){ this.price = price; }

    public double getRating(){ return rating; }
    public void setRating(double rating){ this.rating = rating; }
}