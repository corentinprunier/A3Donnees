package carnetcontacts.utils;

/**
 * Exception utilisée pour signaler un mauvais paramètre d'entrée
 **/
public class ValParamException extends Exception {
    private String messageEx;

    /**
     * Instancie une ValParamException
     */
    public ValParamException() {
    }

    /**
     * Instancie une ValParamException
     *
     * @param mess message associé
     */
    public ValParamException(final String mess) {
        messageEx = mess;
    }

    /**
     * Redéfinition de getMessage
     */
    @Override
    public String getMessage() {
        return messageEx;
    }

}
