/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.core.interfaces;

/**
 * The InboudActionFactory interface represents a factory for creating objects of type T.
 * Implementations of this interface must provide an implementation for the {@link #create()} method,
 * which is responsible for creating and returning an instance of type T.
 *
 * @param <T> the type of objects that this factory creates
 */
public interface InboudActionFactory<T> {

    /**
     * Creates and returns an instance of type T.
     *
     * @return an instance of type T
     */
    T create();
}
