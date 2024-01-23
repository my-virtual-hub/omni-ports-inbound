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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The InboundActionProviderFactory class is responsible for creating and managing instances of InboundActionFactory.
 * It provides a singleton instance and allows for initializing the factory with a list of InboundActionFactory implementations.
 * Instances of the factory can be retrieved by providing the class of the desired factory.
 * <p>
 * Note: This class is thread-safe.
 */
public class InboundActionProviderFactory {

    private boolean isInitialized = false;

    private final Map<String, InboundActionFactory<?>> factoryMap = new HashMap<>();

    private static final InboundActionProviderFactory INSTANCE = new InboundActionProviderFactory();

    private InboundActionProviderFactory() {
        // private constructor
    }

    /**
     * Initializes the InboundActionProviderFactory with a list of InboundActionFactory implementations.
     * @param factories the list of InboundActionFactory implementations to initialize the factory with
     */
    public void initialize(List<? extends InboundActionFactory<?>> factories) {
        factoryMap.clear();
        for (InboundActionFactory<?> factory : factories) {
            Class<?>[] interfaces = factory.getClass().getInterfaces();
            factoryMap.put(interfaces.length>0 ? interfaces[0].getSimpleName() : factory.getClass().getSimpleName(), factory);
        }
        isInitialized = true;
    }

    /**
     * Retrieves the singleton instance of the InboundActionProviderFactory class.
     *
     * @return the singleton instance of the InboundActionProviderFactory class
     */
    public static InboundActionProviderFactory getInstance() {
        return INSTANCE;
    }

    /**
     * Retrieves an instance of the desired InboundActionFactory implementation based on the provided factory class.
     * @param factoryClass the class name of the desired factory
     * @param <T> the type of the desired factory
     * @return an instance of the desired factory
     * @throws ProviderFactoryException if the factory is not initialized
     */
    public <T extends InboundActionFactory<?>> T getFactory(String factoryClass) throws ProviderFactoryException {
        if (!isInitialized) {
            throw new ProviderFactoryException("Factory not initialized");
        }
        return (T) factoryMap.get(factoryClass);
    }

    /**
     * Resets the provider factory by clearing the factory map and setting the initialized flag to false.
     */
    public void resetProviderFactory() {
        factoryMap.clear();
        isInitialized = false;
    }
}
