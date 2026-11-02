package com.example.autumn24_practice;

import java.time.LocalDate;

public class Article {
    private String Title,Author,ArticleType,CitationStatus;
    private int NoOfAuthors;
    private LocalDate PublicationDate;

    public Article(String title, String author, String articleType, String citationStatus, int noOfAuthors, LocalDate publicationDate) {
        Title = title;
        Author = author;
        ArticleType = articleType;
        CitationStatus = citationStatus;
        NoOfAuthors = noOfAuthors;
        PublicationDate = publicationDate;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getArticleType() {
        return ArticleType;
    }

    public String getCitationStatus() {
        return CitationStatus;
    }

    public int getNoOfAuthors() {
        return NoOfAuthors;
    }

    public LocalDate getPublicationDate() {
        return PublicationDate;
    }

    public void setCitationStatus(String citationStatus) {
        CitationStatus = citationStatus;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setArticleType(String articleType) {
        ArticleType = articleType;
    }

    public void setNoOfAuthors(int noOfAuthors) {
        NoOfAuthors = noOfAuthors;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        PublicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", ArticleType='" + ArticleType + '\'' +
                ", CitationStatus='" + CitationStatus + '\'' +
                ", NoOfAuthors=" + NoOfAuthors +
                ", PublicationDate=" + PublicationDate +
                '}';
    }

}
