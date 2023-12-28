package com.tutorial.springfundamental.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
 class DateFormatUtilsTest {
    @Test
    void testForStringToLocalDate(){
        var expect = LocalDate.of(2023,12,1);
        var inputDate = "2023-12-01";

        var actual =DateFormatUtils.stringToLocalDate(inputDate);

        assertThat(expect).isEqualTo(actual);
    }
    @ParameterizedTest
    @CsvSource(value = {
            "2023-12-27,2023-12-27",
            "2023-12-28,2023-12-28",
            "2023-12-29,2023-12-29"
    },delimiter = ',')
    void testForStringToLocalParameterCsv(String inputDate, String expect){
        var df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        var expectDate= LocalDate.parse(expect,df);

        var actual = DateFormatUtils.stringToLocalDate(inputDate);
        assertThat(actual).isEqualTo(expectDate);
    }


}
