package com.tutorial.springfundamental.controller;

import com.tutorial.springfundamental.dto.KeyboardRecord;
import com.tutorial.springfundamental.model.KeyboardModel;
import com.tutorial.springfundamental.repository.KeyboardRepository;
import com.tutorial.springfundamental.service.KeyboardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public KeyboardModel getKeyboardById(@PathVariable("id") String id) {
        return keyboardService.getKeyboardById(id);
    }
    @GetMapping(value = "/pagination")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all keyboard with pagination",description = "Get all keyboard in table with pagination")
    public List<KeyboardModel> getAllKeyboardWithPagination(@RequestParam("page") int page,@RequestParam("size") int size){
        return keyboardService.getKeyboardWithPagination(page,size,null,null);
    }
    @GetMapping(value = "/pagination/sort")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all Keyboard with pagination and sort",
    description = "Get all keyboard in table with pagination and sortable")
    public List<KeyboardModel> getAllKeyboardWithPaginationAndSort(
            @RequestParam ("page") int page,@RequestParam("size") int size,
            @RequestParam("sort") String sortBy, @RequestParam("orderBy") String orderBy
    ){
        return keyboardService.getKeyboardWithPagination(page,size,sortBy,orderBy);
    }


    @PostMapping(value = "")
    @ResponseStatus(HttpStatus.CREATED)
    public KeyboardModel createKeyboard(@RequestBody KeyboardRecord request) {
        return keyboardService.saveKeyboard(request);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public KeyboardModel updateKeyboard(@PathVariable("id") String id, @RequestBody KeyboardRecord request) {
        return keyboardService.updateKeyboard(id,request);
    }

    @DeleteMapping(value = "")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteKeyboard(@PathVariable("id")String id) {
        keyboardService.deleteKeyboard(id);
    }
}
