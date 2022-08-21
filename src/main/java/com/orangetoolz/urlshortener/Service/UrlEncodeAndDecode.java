package com.orangetoolz.urlshortener.Service;

import com.orangetoolz.urlshortener.Entity.UrlStore;
import com.orangetoolz.urlshortener.Repository.UrlStoreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlEncodeAndDecode {

    private final String base_url="https://url-shortener/";

    private final UrlStoreRepo urlStoreRepo;
    UrlStore urlStore;

    String base62_chars="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    String short_url="";

    @Autowired
    public UrlEncodeAndDecode(UrlStoreRepo urlStoreRepo){
        this.urlStoreRepo=urlStoreRepo;
    }

    public String encodeLongUrl(String long_url){

        short_url="";

        urlStore=urlStoreRepo.findByLongUrl(long_url);

        if(urlStore!=null){
            short_url=convertIdToHash(urlStore.getUrlId());
            return short_url;
        }
        else{
            saveLongUrl(long_url);

            int urlId=urlStore.getUrlId();

             return convertIdToHash(urlId);

        }

    }

    public String decodeLongUrl(String short_url){

        String [] url_parts=short_url.split("/");

        String short_url_id=url_parts[url_parts.length-1];

        int url_id=0;

        for(int i=short_url_id.length()-1,j=0;i>=0;i--,j++){
            if('a' <= short_url_id.charAt(i) &&
                    short_url_id.charAt(i) <= 'z'){
                url_id=(int)Math.pow(62,j)*(short_url_id.charAt(i)-'a');

            }
            else if('A' <= short_url_id.charAt(i) &&
                    short_url_id.charAt(i) <= 'Z'){
                url_id=url_id+(int)Math.pow(62,j)*short_url_id.charAt(i)-'A'+26;
            }
            else{
                url_id=url_id+(int)Math.pow(62,j)*short_url_id.charAt(i)-'0'+52;
            }
        }

        return urlStoreRepo.findById(url_id).get().getLongUrl();


    }

    public void saveLongUrl(String long_url){
        urlStore=new UrlStore(long_url);
        urlStoreRepo.save(urlStore);
    }

    public String convertIdToHash(int urlId){
        while(urlId>0){

            short_url=base62_chars.charAt((int)urlId%62)+short_url;

            urlId=urlId/62;

        }

        return base_url+short_url;
    }
}
