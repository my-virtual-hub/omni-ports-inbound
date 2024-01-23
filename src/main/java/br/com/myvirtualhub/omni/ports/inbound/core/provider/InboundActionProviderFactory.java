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

import java.util.HashMap;
import java.util.Map;

/**
 * The InboundActionProviderFactory class is responsible for managing a map of InboundActionFactory instances
 * and providing access to these factories based on their class.
 *
 * @param <F> the type of InboundActionFactory
 * @param <A> the type of InboundAction or its subclass that the factories create
 */
public class InboundActionProviderFactory<F extends InboundActionFactory<A>, A extends InboundAction> {

    private boolean isInitialized = false;

    private final Map<String, F> factoryMap = new HashMap<>();

    private static final InboundActionProviderFactory<?,?> INSTANCE = new InboundActionProviderFactory<>();

    private InboundActionProviderFactory() {
        // private constructor
    }

    /**
     * Checks if the factory is initialized.
     *
     * @return true if the factory is initialized, false otherwise
     */
    public boolean isInitialized() {
        return isInitialized;
    }

    /**
     * Retrieves the size of the factory map.
     *
     * @return The size of the factory map.
     */
    public int getFactoryMapSize() {
        return factoryMap.size();
    }

    /**
     * Adds the given factory to the factory map if it implements the InboundActionFactory interface.
     *
     * @param factory the factory to be charged
     */
    public void charge(F factory) {
        Class<?>[] interfaces = factory.getClass().getInterfaces();
        for (Class<?> interfaceClass : interfaces) {
            if (InboundActionFactory.class.isAssignableFrom(interfaceClass)) {
                factoryMap.put(interfaceClass.getSimpleName(), factory);
            }
        }
        isInitialized = true;
    }

    /**
     * Retrieves the singleton instance of {@link InboundActionProviderFactory}.
     *
     * @param <F> the type of InboundActionFactory
     * @param <A> the type of InboundAction or its subclass that the factories create
     * @return the singleton instance of InboundActionProviderFactory
     */
    public static <F extends InboundActionFactory<A>, A extends InboundAction> InboundActionProviderFactory<F, A> getINSTANCE() {
        @SuppressWarnings("unchecked")
        InboundActionProviderFactory<F, A> factory = (InboundActionProviderFactory<F, A>) INSTANCE;
        return factory;
    }

    /**
     * Retrieves the factory instance of the specified factory class.
     *
     * @param factoryClass the class of the factory to retrieve
     * @return the factory instance of the specified factory class
     * @throws ProviderFactoryException if the factory has not been initialized
     */
    public F getFactory(Class<F> factoryClass) throws ProviderFactoryException {
        if (!isInitialized) {
            throw new ProviderFactoryException("Factory not initialized");
        }
        return factoryMap.get(factoryClass.getSimpleName());
    }

    /**
     * Resets the provider factory by clearing the factory map and setting the initialized flag to false.
     */
    public void resetProviderFactory() {
        InboundActionProviderFactory<?, ?> inboundActionProviderFactory = InboundActionProviderFactory.getINSTANCE();
        if (inboundActionProviderFactory.isInitialized()) {
            factoryMap.clear();
            isInitialized = false;
        }
    }
}
