package com.tutorial.springfundamental.service;

import com.tutorial.springfundamental.dto.KeyboardRecord;
import com.tutorial.springfundamental.exception.InvalidException;
import com.tutorial.springfundamental.exception.NotFoundException;
import com.tutorial.springfundamental.model.KeyboardModel;
import com.tutorial.springfundamental.repository.KeyboardRepository;
import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.tutorial.springfundamental.constants.ErrorMessage.INVALID_SORT_BY;
import static com.tutorial.springfundamental.constants.ErrorMessage.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class KeyboardService {
    private final KeyboardRepository keyboardRepository ;
    public List<KeyboardModel> getAllKeyboard() {
        return keyboardRepository.findAllBy();
    }

    public List<KeyboardModel> getKeyboardWithPagination(int page,int size,String sortBy,String order){
        Pageable pageable;

        //setup default page and size value
        page = page <=0 ? 1 :page -1;
        size = size <=0 ? 10:size;

        if(StringUtils.isNotBlank(sortBy)){
            //setup order direction
            var orderBy =StringUtils.isBlank(order)? Sort.Direction.ASC : Sort.Direction.valueOf(order.toUpperCase());

            //Validate sort by specific colum
            if(!isSortByValid(sortBy)){
               throw new InvalidException(INVALID_SORT_BY.formatted(sortBy));
            }

            pageable = PageRequest.of(page, size, orderBy, sortBy);

        }else {
            pageable = PageRequest.of(page, size);
        }
        var keyboardPagination = keyboardRepository.findAll(pageable);
        return keyboardPagination.getContent();
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

    private boolean isSortByValid(String sortBY){
        return switch (sortBY){
            case "name","price","quantity"->true;
            default -> false;
        };
    }
}
