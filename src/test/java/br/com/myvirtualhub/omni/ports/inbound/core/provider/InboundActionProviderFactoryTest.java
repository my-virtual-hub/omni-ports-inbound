/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.core.provider;

import br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboudActionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InboundActionProviderFactoryTest {

    private InboundActionProviderFactory inboundActionProviderFactoryUnderTest;

    @BeforeEach
    void setUp() {
        inboundActionProviderFactoryUnderTest = InboundActionProviderFactory.getInstance();
    }

    @Test
    void testInitialize() throws ProviderFactoryException {
        InboudActionFactory<?> factory = (InboudActionFactory) () -> null;
        final List<? extends InboudActionFactory<?>> factories = List.of(factory);
        inboundActionProviderFactoryUnderTest.initialize(factories);
        InboudActionFactory<?> result = inboundActionProviderFactoryUnderTest.getFactory(factory.getClass());
        assertNotNull(result);
        assertEquals(factory.getClass(), result.getClass());
    }

    @Test
    void testGetInstance() {
        final InboundActionProviderFactory result = InboundActionProviderFactory.getInstance();
        assertNotNull(result);
    }

    @Test
    void testGetFactory_ThrowsProviderFactoryException() {
        inboundActionProviderFactoryUnderTest.resetProviderFactory();
        assertThrows(ProviderFactoryException.class,
                () -> inboundActionProviderFactoryUnderTest.getFactory(InboudActionFactory.class));
    }
}
