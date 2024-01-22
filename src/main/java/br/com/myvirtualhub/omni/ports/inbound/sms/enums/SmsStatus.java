/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.enums;

/**
 * This enum represents the status of an SMS message.
 */
public enum SmsStatus {
    /**
     * Represents the status of an SMS message when it is queued in the Omni SMS system.
     */
    OMNI_QUEUED,
    /**
     * This enum value represents the status of an SMS message that has been successfully sent by the Omni SMS system.
     */
    OMNI_SENT
}
