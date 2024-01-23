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

package br.com.myvirtualhub.omni.ports.inbound.core.provider;

import br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboundActionFactory;
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
        InboundActionFactoryTestImpl inboudActionFactoryTest = new InboundActionFactoryTestImpl();
        inboundActionProviderFactoryUnderTest.initialize(List.of(inboudActionFactoryTest));
        InboundActionFactory<?> result = inboundActionProviderFactoryUnderTest.getFactory("InboundActionFactory");
        assertNotNull(result);
        assertEquals(inboudActionFactoryTest.getClass(), result.getClass());
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
                () -> inboundActionProviderFactoryUnderTest.getFactory("InboundActionFactory"));
    }

    static class InboundActionFactoryTestImpl implements InboundActionFactory<Object> {
        @Override
        public Object create() {
            return null;
        }
    }
}
