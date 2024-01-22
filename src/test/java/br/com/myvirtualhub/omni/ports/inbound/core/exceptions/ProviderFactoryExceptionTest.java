/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.core.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProviderFactoryExceptionTest {

    @Test
    void testConstructorMessage() {
        final ProviderFactoryException result = new ProviderFactoryException("message");
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException: message, throwableCause={null}}", result.toString());
    }

    @Test
    void testConstructorMessageThrowable() {
        final ProviderFactoryException result = new ProviderFactoryException("message", new Throwable("cause"));
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException: message, throwableCause={java.lang.Throwable: cause}}", result.toString());
    }

    @Test
    void testConstructorMessageThrowableCause() {
        final ProviderFactoryException result = new ProviderFactoryException("message", "throwableCause");
        assertEquals("OmniException{Exception.toString()=br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException: message, throwableCause={throwableCause}}", result.toString());
    }
}
