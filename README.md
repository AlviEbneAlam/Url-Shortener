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
2. POST: host-url/base-url/getLongUrl [Takes short url as json body and return long url as string]
   - Content-Type: application/json
   - Example Request-Body: 
        {
         "url":"https://url-shortener/e"
        }

The list of endpoints related to accessing the home page of ui-

1. /host-url/base-url/welcome
2. Click on retrieved short url on welcome page to get original long url
## Issues

* Failed to implement redirection due to cors.
