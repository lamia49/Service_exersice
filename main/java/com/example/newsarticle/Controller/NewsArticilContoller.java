package com.example.newsarticle.Controller;

import com.example.newsarticle.Model.NesArticil;
import com.example.newsarticle.Service.NewsArticiService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/nwes/")
@AllArgsConstructor
public class NewsArticilContoller {
    private final  NewsArticiService  newsArticiService;


    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid NesArticil nesArticil, Errors errors){
        if (errors.hasErrors()){
            String massge = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massge);
        }
        newsArticiService.add(nesArticil);
        return ResponseEntity.status(200).body("Added");
    }
@GetMapping("/get")
    public ResponseEntity get(){
        return ResponseEntity.status(200).body(newsArticiService.get());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable int id ,@RequestBody @Valid NesArticil newsArticil , Errors errors){
        if (errors.hasErrors()){
            String massge = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massge);
        }
        boolean isFound =newsArticiService.update(id,newsArticil);
        if(isFound){
            return ResponseEntity.status(200).body("updated");
        }
        return ResponseEntity.status(220).body("Not found");
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable int id){
        boolean isDelete= newsArticiService.delete(id);
        if(isDelete){
            return  ResponseEntity.status(200).body("Deleted");
        } return ResponseEntity.status(400).body("Not Found");
    }

    @PutMapping("/polished/{id}")
    public ResponseEntity polished(@PathVariable int id ){
        boolean isPolishe= newsArticiService.published(id);
        if(isPolishe){
            return ResponseEntity.status(200).body("artical polished");
        }return ResponseEntity.status(400).body("already polished");
    }


    @GetMapping("/allPolshid")
    public ResponseEntity allPublished(){
        return ResponseEntity.status(200).body(newsArticiService.AllPublished());
    }


    @GetMapping("/by-carogary/{catogary}")
    public ResponseEntity byCotogray(@PathVariable String catogary){
        if(newsArticiService.byCatogray(catogary)==null){
            return ResponseEntity.status(400).body("Not found");
        }
        return ResponseEntity.status(200).body(newsArticiService.byCatogray(catogary));
    }


}


