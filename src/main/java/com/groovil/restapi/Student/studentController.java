// package com.groovil.restapi.Student;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

// @Controller
// @RequestMapping(path="/student")
// public class studentController {
    
//     @Autowired
//     private  StudentRepository studentRepository;


//     @PostMapping(path="/add") // Map ONLY POST Requests
// //   public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String rollNumber) {  
//     public @ResponseBody String addNewUser (@RequestBody students s) {


//     students n = new students(s.getRollNumber(), null, s.getName());
//     // n.setName(s.getName());
//     // n.setId(1);
//     studentRepository.save(n);
//     return "Saved";
//   }

//    @GetMapping(path="/all")
//   public @ResponseBody Iterable<students> getAllUsers() {
//     // This returns a JSON or XML with the users
//     return studentRepository.findAll();
//   }
// }
