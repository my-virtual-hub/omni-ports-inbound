/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.core.provider;

import br.com.myvirtualhub.omni.ports.inbound.core.exceptions.ProviderFactoryException;
import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboudActionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The InboundActionProviderFactory class is responsible for creating and managing instances of InboudActionFactory.
 * It provides a singleton instance and allows for initializing the factory with a list of InboudActionFactory implementations.
 * Instances of the factory can be retrieved by providing the class of the desired factory.
 * <p>
 * Note: This class is thread-safe.
 */
public class InboundActionProviderFactory {

    private boolean isInitialized = false;

    private final Map<String, InboudActionFactory<?>> factoryMap = new HashMap<>();

    private static final InboundActionProviderFactory INSTANCE = new InboundActionProviderFactory();

    private InboundActionProviderFactory() {
        // private constructor
    }

    /**
     * Initializes the InboundActionProviderFactory with a list of InboudActionFactory implementations.
     * @param factories the list of InboudActionFactory implementations to initialize the factory with
     */
    public void initialize(List<? extends InboudActionFactory<?>> factories) {
        factoryMap.clear();
        for (InboudActionFactory<?> factory : factories) {
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
     * Retrieves an instance of the desired InboudActionFactory implementation based on the provided factory class.
     * @param factoryClass the class name of the desired factory
     * @param <T> the type of the desired factory
     * @return an instance of the desired factory
     * @throws ProviderFactoryException if the factory is not initialized
     */
    public <T extends InboudActionFactory<?>> T getFactory(String factoryClass) throws ProviderFactoryException {
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
