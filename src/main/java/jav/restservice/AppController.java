package jav.restservice;

import java.io.File;
import java.util.Scanner;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController{
    @GetMapping("/{fileName}")
    public String hello(@PathVariable String fileName){
        File file = new File(fileName);
        String ret = "ERROR";
        try {
            Scanner reader = new Scanner(file);
            StringBuilder str = new StringBuilder();
            while(reader.hasNextLine()){
                str.append(reader.nextLine());
            }

            reader.close();
            ret = str.toString();
        } catch (Exception e) {
        }

        return ret;
    }
}