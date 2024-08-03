package com.example.demo.validations;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

public class Constants {

    @AllArgsConstructor
    @Getter
    public enum Status {

        deposit((byte)1,"deposit.title"),
        withdraw((byte)2,"withdraw.title");
        private final byte code;
        private final String title;

    }
}
