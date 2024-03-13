package com.example.newsarticle.Service;

import com.example.newsarticle.Model.NesArticil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Service
public class NewsArticiService {
ArrayList<NesArticil> newsArticils=new ArrayList<>();

public void add(NesArticil newsArticil){
    newsArticils.add(newsArticil);
}

public ArrayList<NesArticil> get(){
    return newsArticils;
}

public boolean update(int id ,NesArticil nesArticil){
    for (int i=0;i<newsArticils.size();i++){
        if(newsArticils.get(i).getId()==id){
            newsArticils.set(i,nesArticil);
            return true;
        }
    }
   return false;
}

public boolean delete(int id){
    for (int i=0;i<newsArticils.size();i++){
        if(newsArticils.get(i).getId()==id){
            newsArticils.remove(i);
            return true;
        }
    }
    return false;
}

public boolean published(int id){
    for (int i=0; i<newsArticils.size();i++){
        if(newsArticils.get(i).getId()==id){
            newsArticils.get(i).setPublished(true);
            newsArticils.get(i).setPublishDate(LocalDate.now());
            return true;
        }
    }
      return false;
    }

    public ArrayList AllPublished(){
    ArrayList<NesArticil>published=new ArrayList<>();
    for (NesArticil newsArticil:newsArticils){
        if(newsArticil.isPublished()){
            published.add(newsArticil);
        }}

        return published;

    }


    public NesArticil byCatogray(String catogary){
    for (NesArticil cato: newsArticils){
        if(cato.getCatogary().equalsIgnoreCase(catogary)) {
            return cato;
        }
    }
    return null;
}




}
