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

package br.com.myvirtualhub.omni.ports.inbound.core.interfaces;

/**
 * The InboundActionFactory interface represents a factory for creating objects of type T.
 * Implementations of this interface must provide an implementation for the {@link #create()} method,
 * which is responsible for creating and returning an instance of type T.
 *
 * @param <T> the type of objects that this factory creates
 */
public interface InboundActionFactory<T> {

    /**
     * Creates and returns an instance of type T.
     *
     * @return an instance of type T
     */
    T create();
}
