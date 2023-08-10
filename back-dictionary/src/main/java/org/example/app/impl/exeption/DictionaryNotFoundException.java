package org.example.app.impl.exeption;

public class DictionaryNotFoundException extends RuntimeException {
    public DictionaryNotFoundException(String message) {
        super(message);
    }
}
