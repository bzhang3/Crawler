package com.company.crawler.demo;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.crawler.ad.Ad;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException{

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


        File adsDataFile = new File(adsDataFilePath);

        if(!adsDataFile.exists()){
            adsDataFile.createNewFile();
        }

        FileWriter fw = new FileWriter(adsDataFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

        try(BufferedReader br = new BufferedReader(new FileReader(rawQueryDataFilePath))){

            String line;

            while((line = br.readLine()) != null){
                if(line.isEmpty()){
                    continue;
                }

                //Read each query.
                //System.out.println(line);
                String[] fields = line.split(",");
                String query = fields[0].trim();
                double bidPrice = Double.parseDouble(fields[1].trim());
                int campaignID = Integer.parseInt(fields[2].trim());
                int queryGroupID = Integer.parseInt(fields[3].trim());
                System.out.println(query);

                //set index for current ads.
                int startInd = 0;

                //read first 3 page for each query.
                for(int pageNum = 1; pageNum <= 3; pageNum++){
                    List<Ad> ads = crawler.GetAdsInfoByQuery(query, bidPrice, campaignID, queryGroupID, pageNum, startInd);
                    if(ads==null || ads.size()==0) break;
                    for(Ad ad: ads){
                        if(ad==null) continue;
                        String jsonInString = mapper.writeValueAsString(ad);
                        //System.out.println(jsonInString);
                        bw.write(jsonInString);
                        bw.newLine();
                    }
                    startInd += ads.size();
                    Thread.sleep(2000);
                }

            }

            bw.close();
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }catch (JsonGenerationException e){
            e.printStackTrace();
        }catch (JsonMappingException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}