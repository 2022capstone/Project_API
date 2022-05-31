package com.hansung.capstone.project.util;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    private String resultMsg; // SUCCESS, FAIL
    private int totalCount; // 데이터 갯수
    private T list;
    private String error;

    public static <T> Header<T> SUCCESS(int totalCount, T list){
        return (Header<T>) Header.builder()
            .resultMsg("SUCCESS")
            .totalCount(totalCount)
            .list(list)
            .build();
    }
    public static <T> Header<T> FAIL(Exception e){
        return (Header<T>) Header.builder()
                .resultMsg("FAIL")
                .error(e.getMessage())
                .build();
    }
}
