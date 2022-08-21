package com.orangetoolz.urlshortener.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UrlStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId;

    private String longUrl;

    public UrlStore(String longUrl){
        this.longUrl=longUrl;
    }

}
