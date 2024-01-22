/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.interfaces;

import br.com.myvirtualhub.omni.ports.inbound.core.interfaces.InboudActionFactory;

/**
 * The SmsInboundActionFactory interface extends the InboundActionFactory interface and represents a factory for creating
 * action objects of type A. Implementations of this interface must provide an implementation for the {@link #create()} method,
 * which is responsible for creating and returning an instance of type A.
 *
 * @param <A> the type of action objects that this factory creates
 */
public interface SmsInboundActionFactory<A> extends InboudActionFactory<A> {
    /**
     * Creates an instance of SmsInboundAction.
     *
     * @return an instance of type A
     */
    @Override
    A create();
}
