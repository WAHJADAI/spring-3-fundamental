package com.tutorial.springfundamental.service;

import com.tutorial.springfundamental.model.KeyboardModel;
import com.tutorial.springfundamental.repository.KeyboardRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class KeyboardService {
    private final KeyboardRepository keyboardRepository ;
    public List<KeyboardModel> getAllKeyboard() {
        return keyboardRepository.findAllBy();
    }

    public KeyboardModel getKeyboardById(String id){
        return keyboardRepository.findById(UUID.fromString(id))
                .orElseThrow();
    }


}
