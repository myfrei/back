package org.dnd.adapter.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dnd.app.impl.GetDictionaryInbound;
import org.dnd.app.impl.GetDictionaryInboundValue;
import org.dnd.app.impl.exeption.DictionaryNotFoundException;
import org.dnd.domain.Dictionary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("back/dictionary/v1")
public class DictionaryController {

    private final GetDictionaryInbound getDictionaryInbound;
    private final GetDictionaryInboundValue getDictionaryInboundValue;

    @GetMapping(value = "/values", params = {"name"})
    public ResponseEntity<List<? extends Dictionary>> getDictionary(@RequestParam String name) {
        return new ResponseEntity<>(getDictionaryInbound.execute(name), HttpStatus.OK);
    }

    @GetMapping(value = "/values", params = {"name", "code"})
    public ResponseEntity<Dictionary> getDictionary(@RequestParam String name,@RequestParam String code) {
        return new ResponseEntity<>(getDictionaryInboundValue.executeValue(name, code), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(DictionaryNotFoundException.class)
    public List<Dictionary> getDictionaryErrorHandler(DictionaryNotFoundException e) {
        log.error("Error: " + e.getMessage());
        return Collections.emptyList();

    }
}
