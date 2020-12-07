package com.group7.prototype.controller;

import com.group7.prototype.model.Item;
import com.group7.prototype.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.io.*;

@Controller
public class index {
    @GetMapping(value = "/")
    public String index(Model model){
                    return "index";
    }
 //   @GetMapping("/")
  /*  public String index(Model model,@RequestParam("username") String username,
                        @RequestParam("password") String password)
    {
        return "redirect:/customer/catalog";
    }*/
    @PostMapping(value = "/login")
    public String indexForm(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password) throws IOException {
        String temp="";
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("users1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while ((temp = file.readLine()) != null) {

            String[] arr = new String[5];
            arr = temp.split(":");
            if (username.equals(arr[2]) && password.equals(arr[3]) && arr[4].equals("C")) {
                return "redirect:/customer/catalog";
            }else if(username.equals(arr[2]) && password.equals(arr[3]) && arr[4].equals("M")) {
                return "redirect:/manager/items/view";
            }
        }
        model.addAttribute("Invalid UserId or Password");
        return "index";
    }

    @GetMapping(value = "/customer/newUsr")
    public String newUser(Model model){
        return "newUser";
    }
    @PostMapping(value = "/customer/newUsr")
    public String newUserRegisterForm(Model model, @RequestParam("name") String name,
                                      @RequestParam("lastName") String lastName, @RequestParam("email") String email,
                                      @RequestParam("password") String password) {

        if ((String) name == null || name.isEmpty()) {
            model.addAttribute("errorMessage", "Name is required");
            return "newUser";
        } else if (lastName == null || lastName.isEmpty()) {
            model.addAttribute("errorMessage", "Last Name is required");
            return "newUser";
        } else if ((String) email == null || email.isEmpty()) {
            model.addAttribute("errorMessage", "Email is required");
            return "newUser";
        }else if ((String) password == null || password.isEmpty() ) {
            model.addAttribute("errorMessage", "Password is required");
            return "newUser";
        }
        //return "index";
        File file = new File("users1.txt");
        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
        }
        FileWriter writer = null;
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) { }
        try {
            writer.write(name+":"+lastName+":"+email+":"+password+":"+"C"+"\n");
        } catch (IOException e) { }
        try {
            writer.close();
        } catch (IOException e) { }

        model.addAttribute("success",Boolean.TRUE);
        return "index";
    }
}



