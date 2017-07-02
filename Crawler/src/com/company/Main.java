package com.company;

public class Main {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();
        /*
            for(int i = 0 ;i < 1000 ;i++) {
            System.out.println("current iteration: " + i);
            crawler.getAmazonProds("nikon d3400");
        }*/
        crawler.initProxy();
        crawler.testProxy();
        crawler.getAmazonProds("nikon d3400");
        String url = "https://www.amazon.com/AmazonBasics-Portable-Bluetooth-Speaker-Red/dp/B01GF5AFB2/ref=sr_1_5?s=amazonbasics&srs=10112675011&ie=UTF8&qid=1498352225&sr=8-5&keywords=bluetooth";
        crawler.parseAmazonProdPage(url);

        //DemoCrawler demo = new DemoCrawler();
        //String demoUrl = "https://jsoup.org/download";
        //demo.getAmazonProd(url);


    }


}