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
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboundAction;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboundActionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InboundActionProviderFactoryTest {

    interface TestInboundAction extends InboundAction {}
    interface TestInboundActionFactory extends InboundActionFactory<TestInboundAction> {}
    private static class TestInboundActionImpl implements TestInboundAction {}
    private static class TestInboundActionFactoryImpl implements TestInboundActionFactory {
        @Override
        public TestInboundActionImpl createAction() {
            return new TestInboundActionImpl();
        }
    }


    interface Test2InboundAction extends InboundAction {}
    interface Test2InboundActionFactory extends InboundActionFactory<Test2InboundAction> {}
    private static class Test2InboundActionImpl implements Test2InboundAction {}
    private static class Test2InboundActionFactoryImpl implements Test2InboundActionFactory {
        @Override
        public Test2InboundActionImpl createAction() {
            return new Test2InboundActionImpl();
        }
    }

    private final InboundActionProviderFactory<TestInboundActionFactory, TestInboundAction> factory = InboundActionProviderFactory.getINSTANCE();
    private final InboundActionProviderFactory<Test2InboundActionFactory, Test2InboundAction> factory2 = InboundActionProviderFactory.getINSTANCE();

    @BeforeEach
    void setUp() {
        factory.resetProviderFactory();
    }

    @Test
    void initialize_shouldInitializeFactoryMap() {
        factory.charge(new TestInboundActionFactoryImpl());
        assertTrue(factory.isInitialized());
        assertEquals(1, factory.getFactoryMapSize());
    }

    @Test
    void getINSTANCE_shouldReturnSameInstance() {
        InboundActionProviderFactory<TestInboundActionFactory, TestInboundAction> instance1 = InboundActionProviderFactory.getINSTANCE();
        InboundActionProviderFactory<TestInboundActionFactory, TestInboundAction> instance2 = InboundActionProviderFactory.getINSTANCE();

        assertSame(instance1, instance2);
    }

    @Test
    void getFactory_shouldRetrieveFactoryInstance() throws ProviderFactoryException {
        TestInboundActionFactory testFactory = new TestInboundActionFactoryImpl();
        factory.charge(testFactory);
        TestInboundActionFactory retrievedFactory = factory.getFactory(TestInboundActionFactory.class);
        assertNotNull(retrievedFactory);
        assertSame(testFactory, retrievedFactory);
    }

    @Test
    void getFactory_shouldRetrieveFactoryInstanceWith2Factories() throws ProviderFactoryException {
        TestInboundActionFactory testFactory = new TestInboundActionFactoryImpl();
        Test2InboundActionFactory test2Factory = new Test2InboundActionFactoryImpl();
        factory.charge(testFactory);
        factory2.charge(test2Factory);
        TestInboundActionFactory retrievedFactory = factory.getFactory(TestInboundActionFactory.class);
        Test2InboundActionFactory retrievedFactory2 = factory2.getFactory(Test2InboundActionFactory.class);
        assertNotNull(retrievedFactory);
        assertSame(testFactory, retrievedFactory);
        assertNotNull(retrievedFactory2);
        assertSame(test2Factory, retrievedFactory2);
        retrievedFactory = factory.getFactory(TestInboundActionFactory.class);
        assertNotNull(retrievedFactory);
        assertSame(testFactory, retrievedFactory);
    }

    @Test
    void getFactory_shouldThrowExceptionIfNotInitialized() {
        assertThrows(ProviderFactoryException.class, () -> factory.getFactory(TestInboundActionFactory.class));
    }

    @Test
    void resetProviderFactory_shouldResetFactory() {
        factory.charge(new TestInboundActionFactoryImpl());
        assertTrue(factory.isInitialized());
        assertEquals(1, factory.getFactoryMapSize());
        factory.resetProviderFactory();
        assertFalse(factory.isInitialized());
        assertEquals(0, factory.getFactoryMapSize());
    }
}
