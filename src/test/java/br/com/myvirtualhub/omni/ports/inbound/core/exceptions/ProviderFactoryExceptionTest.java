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
