package org.example.app.impl.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    NOT_FOUND("dictionary %s doesn't exist");
    private final String value;
}
