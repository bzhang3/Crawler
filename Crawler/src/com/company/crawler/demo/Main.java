package com.company.crawler.demo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qingxuan.ad.Ad;


public class Main {

    public static void main(String[] args) {

        // input: rawQuery3.txt, prixylist_bittiger.csv outputAdsDataFilePath
        if(args.length < 3){
            System.out.println("Please input: rawQueryDataFilePath, proxyFilePath and outputAdsDataFilePath.");
            System.exit(0);
        }

        ObjectMapper mapper = new ObjectMapper();

        String rawQueryDataFilePath = args[0];
        String proxyFilePath = args[1];
        String adsDataFilePath = args[2];

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