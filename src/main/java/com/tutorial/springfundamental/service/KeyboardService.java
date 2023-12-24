package com.tutorial.springfundamental.service;

import com.tutorial.springfundamental.dto.KeyboardRecord;
import com.tutorial.springfundamental.exception.InvalidException;
import com.tutorial.springfundamental.exception.NotFoundException;
import com.tutorial.springfundamental.model.KeyboardModel;
import com.tutorial.springfundamental.repository.KeyboardRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.tutorial.springfundamental.constants.ErrorMessage.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class KeyboardService {
    private final KeyboardRepository keyboardRepository ;
    public List<KeyboardModel> getAllKeyboard() {
        return keyboardRepository.findAllBy();
    }

    public KeyboardModel getKeyboardById(String id){
        return keyboardRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new NotFoundException(NOT_FOUND.formatted("keyboard")));
    }

    public KeyboardModel saveKeyboard(KeyboardRecord request){
        var keyboard =new KeyboardModel();
        keyboard.setName(request.name());
        keyboard.setQuantity(request.quantity());
        keyboard.setPrice(BigDecimal.valueOf(request.price()));
        keyboardRepository.save(keyboard);
      return keyboard;
    }

    public KeyboardModel updateKeyboard(String id,KeyboardRecord request){
        var existingKeyboard = getKeyboardById(id);
        existingKeyboard.setName(request.name());
        existingKeyboard.setQuantity(request.quantity());
        existingKeyboard.setPrice(BigDecimal.valueOf(request.price()));
        keyboardRepository.save(existingKeyboard);
        return existingKeyboard;
    }
    public void deleteKeyboard(String id){
        var existingKeyboard = getKeyboardById(id);
        keyboardRepository.delete(existingKeyboard);

    }
}
