package com.tutorial.springfundamental.utils;

import com.tutorial.springfundamental.exception.InvalidException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @ParameterizedTest
    @MethodSource("sourceForStringToLocalDateWithParameterizedTestByMethodSource")
    void testForStringToLocalParameterMethodSource(String inputDate, LocalDate expect){
        var actualDate = DateFormatUtils.stringToLocalDate(inputDate);
        assertThat(actualDate).isEqualTo(expect);
    }

    private static Stream<Arguments> sourceForStringToLocalDateWithParameterizedTestByMethodSource() {
        var df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Stream.of(
                Arguments.of("2021-01-01", LocalDate.parse("2021-01-01", df)),
                Arguments.of("2022-02-01", LocalDate.parse("2022-02-01", df)),
                Arguments.of("2023-03-03", LocalDate.parse("2023-03-03", df))
        );
    }
    @Test
    void testForStringToLocalDateWithException(){
        assertThatThrownBy(()->DateFormatUtils.stringToLocalDate("2023-01-022"))
                .isInstanceOf(InvalidException.class)
                .hasMessageContaining("Invalid date format.");
    }
}
