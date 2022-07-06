package com.sprinthive.pokerhands.exception;

public class NotEnoughCardsInDeckException extends RuntimeException {

    public NotEnoughCardsInDeckException(String message) {
        super(message);
    }
}
