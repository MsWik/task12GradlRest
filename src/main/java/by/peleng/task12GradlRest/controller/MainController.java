package by.peleng.task12GradlRest.controller;

import by.peleng.task12GradlRest.domain.Message;
import by.peleng.task12GradlRest.domain.User;
import by.peleng.task12GradlRest.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.HashMap;

@Controller
@RequestMapping("/")
public class MainController {
    private final MessageRepo messageRepo;

    @Autowired
    public MainController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }


    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){
        Message messagesTest = new Message();
        messagesTest.setCreationDate(LocalDateTime.now());
        messagesTest.setText("Тест");
        messagesTest.setId((long) 25);



        HashMap<Object, Object> data = new HashMap<>();
        data.put("profile", user);
        data.put("messages",messageRepo.findAll());
        model.addAttribute("frontendData", data);
        return "index";
    }
}
