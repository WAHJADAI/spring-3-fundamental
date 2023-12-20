package com.tutorial.springfundamental.controller;

import com.tutorial.springfundamental.model.KeyboardModel;
import com.tutorial.springfundamental.repository.KeyboardRepository;
import com.tutorial.springfundamental.service.KeyboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/keyboard")
public class KeyboardController {

    private final KeyboardService keyboardService;
    @GetMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public List<KeyboardModel> getAllKeyboard() {
        return keyboardService.getAllKeyboard();
    }

    @GetMapping(value = "/id")
    @ResponseStatus(HttpStatus.OK)
    public String getKeyboardById() {
        return "GET Keyboard by id";
    }

    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public String createKeyboard() {
        return "POST Keyboard";
    }

    @PutMapping(value = "")
    @ResponseStatus(HttpStatus.OK)
    public String updateKeyboard() {
        return "PUT Keyboard";
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKeyboard() {
        // statement
    }
}
