package com.example.thymeleaf.entity.utils;

import com.example.thymeleaf.entity.Address;
import com.example.thymeleaf.entity.Student;
import lombok.NoArgsConstructor;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class SensitiveDataUtils {

    public static Student anonymize(Student student) {
        return Optional.ofNullable(student)
                .map(s -> new Student(
                        s.getId(),
                        s.getName(),
                        anonymize(s.getEmail()),
                        null,
                        s.getCreatedAt(),
                        s.getUpdatedAt(),
                        anonymize(s.getAddress())
                ))
                .orElse(null);
    }

    private static Address anonymize(Address address) {
        return Optional.of(address)
                .map(a -> new Address(
                        a.getId(),
                        anonymize(a.getZipCode()),
                        anonymize(a.getStreet()),
                        anonymize(a.getNumber()),
                        anonymize(a.getComplement()),
                        anonymize(a.getDistrict()),
                        anonymize(a.getCity()),
                        anonymize(a.getState()),
                        a.getCreatedAt(),
                        a.getUpdatedAt(),
                        a.getStudent()
                ))
                .orElse(null);
    }

    private static String anonymize(String value) {
        return Optional.ofNullable(value)
                .map(String::length)
                .map("*"::repeat)
                .orElse("*");
    }
}
