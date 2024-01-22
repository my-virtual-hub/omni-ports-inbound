/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.core.exceptions;

import br.com.myvirtualhub.omni.commons.exceptions.OmniException;

/**
 * An exception that is thrown when there is an error in the ProviderFactory class.
 */
public class ProviderFactoryException extends OmniException {

    /**
     * Creates a new ProviderFactoryException with the specified message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the Throwable.getMessage() method).
     */
    public ProviderFactoryException(String message) {
        super(message);
    }

    /**
     * Constructs a new ProviderFactoryException with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param cause   the cause (which is saved for later retrieval by the Throwable.getCause() method).
     */
    public ProviderFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ProviderFactoryException with the specified detail message and throwable cause.
     *
     * @param message         the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
     * @param throwableCause the cause (which is saved for later retrieval by the Throwable.getCause() method).
     * @throws NullPointerException if the message or throwableCause is null
     */
    public ProviderFactoryException(String message, String throwableCause) {
        super(message, throwableCause);
    }

}
