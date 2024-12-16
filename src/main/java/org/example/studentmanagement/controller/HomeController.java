package org.example.studentmanagement.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Controller
public class HomeController {

    @Value("${student.management.image.upload.path}")
    private String imagePath;

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/getImage")
    @SneakyThrows
    public @ResponseBody byte[] getImage(@RequestParam String imageName) {
        if (imageName != null) {
            File file = new File(imagePath + imageName);
            try (InputStream inputStream = new FileInputStream(file)) {
                return IOUtils.toByteArray(inputStream);
            }
        }
        return null;
    }


}
