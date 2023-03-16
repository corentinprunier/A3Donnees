package fr.ensma.a3.ia.jeupersonnagesv1.utils;

/**
 * Définition d'une exception ValParamException
 * @author Mikky
 * @version 1.0
 */
public class ValParamException extends Exception {

    private String messageEx;

    public ValParamException(){}

    public ValParamException(final String mess){
        messageEx = mess;
    }

    @Override
    public String getMessage() {
        return "ValParamException : " + messageEx;
    }
}
