package org.dnd.app.exeption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessages {
    NOT_FOUND("Individual with icp = %s doesn't exist");
    private final String value;
}
