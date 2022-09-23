package com.jsonparser.jsonparserdb.service;

import com.jsonparser.jsonparserdb.entity.EClassEntity;
import com.jsonparser.jsonparserdb.repository.EClassRepository;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@RequiredArgsConstructor
@Service
public class JSONParseService {

    private final EClassRepository eClassRepository;
    public void parse() throws Exception{
        int sayac = 0;
        for (int y = 13;y < 51;y++){
            System.out.println(y);
            JSONParser jsonParser = new JSONParser();

            //Dosya konumunuzu kendi bilgisayarınıza göre ayarlamanız yeterlidir
            FileReader reader = new FileReader("C:\\Users\\erenb\\OneDrive\\Masaüstü\\Yedek\\"+y+".json");
            JSONObject document = new JSONObject(jsonParser.parse(reader).toString());
            JSONArray classifications = document.getJSONArray("classifications");
            for(int i = 0;i < classifications.length();i++){
                EClassEntity eClassEntity = new EClassEntity();
                eClassEntity.setName(classifications.getJSONObject(i).getJSONObject("level4").getString("name"));
                String totalValue = "";
                totalValue += classifications.getJSONObject(i).getJSONObject("level3").getString("value") + " ";
                totalValue += classifications.getJSONObject(i).getJSONObject("level2").getString("value") + " ";
                totalValue += classifications.getJSONObject(i).getJSONObject("level1").getString("value") + " ";
                for (int k = 0;k < classifications.getJSONObject(i).getJSONArray("properties").length();k++){
                    totalValue += classifications.getJSONObject(i).getJSONArray("properties").getString(k) + " ";
                }
                eClassEntity.setDescription(totalValue);
                eClassRepository.save(eClassEntity);

                sayac++;
            }
        }


    }
}
