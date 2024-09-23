package app.project.uno.project1.rest;


import app.project.uno.project1.database.Concepts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControl {
    Concepts db = new Concepts();
    private static int counter = 0;

    //exposes root url
    @GetMapping("/{id}/{salary}")
    public String hello(@PathVariable("id") int id, @PathVariable("salary") int salary){


        StringBuilder output = new StringBuilder();
        output.append(db.sqlQuery2(id,salary)).append("Client Request # " + counter++);
        System.out.println(output.toString());
        return output.toString() ;
    }

}
