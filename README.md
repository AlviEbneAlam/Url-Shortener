# Url-Shortener
A url shortener project that takes in a long url and produces unique short url. Produces the same short url for the same link.
# API DOCUMENTATION

API Endpoint
------------
base-url: /url-shortener

The list of endpoints related to encoding and decoding urls-

1. POST: host-url/base-url/getShortUrl [Takes long url as json body and return short url as string]
   - Content-Type: application/json
   - Example Request-Body: 
   {
    "url":"https://byjus.com/maths/hex-to-decimal/"
   }
## POST: host-url/base-url/getLongUrl [Takes short url as json body and return long url as string]
   1.Content-Type: application/json
   2.Example Request-Body: 
        {
         "url":"https://url-shortener/e"
        }

The list of endpoints related to accessing the home page of ui-

* /host-url/base-url/welcome

