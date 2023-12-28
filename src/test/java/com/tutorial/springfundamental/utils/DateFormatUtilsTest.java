package com.tutorial.springfundamental.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
 class DateFormatUtilsTest {
    @Test
    void testForStringToLocalDate(){
        var expect = LocalDate.of(2023,12,1);
        var inputDate = "2023-12-01";

        var actual =DateFormatUtils.stringToLocalDate(inputDate);

        assertThat(expect).isEqualTo(actual);


    }
}
