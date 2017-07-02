package com.company;

import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Bing Zhang on 07/02/2017.
 */
public class DemoCrawler {
    public void getAmazonProd(String url) {
        try
        {
            Document doc = Jsoup.connect(url).timeout(1000).get();
            String fullText = doc.text();
            String title = doc.title();
            System.out.println("web page title: " + title);

            //String bodyText = doc.body().text();
/*            System.out.println("bodyText size: " + bodyText.length());

            System.out.println("bodyText: " + bodyText);


            System.out.println("fullText size: " + fullText.length());

            System.out.println("fullText: " + fullText);*/

            Element titleEle = doc.getElementById("productTitle");
            String titleStr = titleEle.text().trim();
            System.out.println("prod title: " + titleStr);


            Element priceEle = doc.getElementById("priceblock_ourprice");
            String priceStr = priceEle.text().trim();
            System.out.println("priceStr: " + priceStr);

            Elements reviews = doc.getElementsByClass("a-section review");
            System.out.println("number of reviews: " + reviews.size());
            for (Element review : reviews) {
                System.out.println("review content: " + review.text());
            }

            //#customer_review-R188VC0CBW8NLR > div:nth-child(4) > span > div > div.a-expander-content.a-expander-partial-collapse-content
            //#customer_review-R1ALUDYEGFXWR1 > div:nth-child(4) > span > div > div.a-expander-content.a-expander-partial-collapse-content
            //#customer_review-R1IX2OFNBEAP4C > div:nth-child(4) > span > div > div.a-expander-content.a-expander-partial-collapse-content








        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //log

        }

    }

}
