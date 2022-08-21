package com.orangetoolz.urlshortener.Repository;

import com.orangetoolz.urlshortener.Entity.UrlStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlStoreRepo extends JpaRepository<UrlStore, Integer> {

    public UrlStore findByLongUrl(String longUrl);
}
