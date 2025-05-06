package com.bbva.demodbalternate.exceptions;

public class InvalidIdPrefixException extends Exception{
    public InvalidIdPrefixException() {
        super("Invalid Prefix. ID starts with 'ACC' with numbers");
    }
}
