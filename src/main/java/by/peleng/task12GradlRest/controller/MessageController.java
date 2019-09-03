package by.peleng.task12GradlRest.controller;

import by.peleng.task12GradlRest.controller.exceptions.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class MessageController {
public List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
   add(new HashMap<String, String>(){{ put("id","1"); put("text","First message");             }});
    add(new HashMap<String, String>(){{ put("id","2"); put("text","First message");             }});
    add(new HashMap<String, String>(){{ put("id","3"); put("text","Third message");             }});
    add(new HashMap<String, String>(){{ put("id","4"); put("text","First message");             }});
}};


@GetMapping
    public List<Map<String,String>> list(){
    return messages;
}
@GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){

    return messages.stream()
            .filter(message -> message.get("id").equals(id))
            .findFirst()
            .orElseThrow(NotFoundException::new);
}
@PostMapping
public Map<String,String> create(@RequestBody Map<String,String> message){

}
}

