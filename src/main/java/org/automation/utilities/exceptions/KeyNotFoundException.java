package org.automation.utilities.exceptions;

public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException(String key) {
        super(STR."No value found for key '\{key}' in testConfig file");
    }
}
