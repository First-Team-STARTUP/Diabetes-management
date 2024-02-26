package org.startup.diabetes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.startup.diabetes.dto.FastingDTO;

@Controller
//@RequestMapping("/empty")
//@RequiredArgsConstructor
public class FastingController {

    //private final EmptyService emptyService;

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/empty")
    public String emptyForm() {
        return "fasting";
    }

    @PostMapping("/empty")
    public String save(@ModelAttribute FastingDTO fastingDTO){
        System.out.println("fastingDTO =" + fastingDTO);
        return null;
    }


//    @PostMapping("/empty")
//    public ResponseEntity<CreateEmptyResponse> emptyCreate(
//            @RequestBody CreateEmptyRequest request){
//        CreateEmptyResponse response = emptyService.createEmpty(request);
//
//        //return
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
}
