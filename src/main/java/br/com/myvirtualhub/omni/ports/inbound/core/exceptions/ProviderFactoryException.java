/*
 * Copyright 2024 My Virtual Hub
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
