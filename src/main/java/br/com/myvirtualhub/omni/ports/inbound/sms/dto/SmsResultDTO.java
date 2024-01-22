/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import br.com.myvirtualhub.omni.ports.inbound.sms.enums.SmsStatus;

/**
 * The SmsResultDTO class represents the result of sending an SMS message.
 * It contains the status of the message and provides a method to retrieve the status.
 */
public class SmsResultDTO {

    /**
     * The status variable represents the status of an SMS message.
     * It is of type SmsStatus, which is an enumeration representing different status values.
     * The status variable is declared as final, indicating that its value cannot be changed once assigned.
     * It is a private variable, meaning it can only be accessed within the SmsResultDTO class.
     *
     * @see SmsResultDTO
     */
    private final SmsStatus status;

    /**
     * The SmsResultDTO class represents the result of sending an SMS message.
     * It contains the status of the message and provides a method to retrieve the status.
     * The private SmsResultDTO constructor initializes the status variable.
     */
    private SmsResultDTO(SmsStatus status) {
        this.status = status;
    }

    /**
     * Returns an SmsResultDTO object with the status set to OMNI_QUEUED.
     *
     * @return an SmsResultDTO object with the status set to OMNI_QUEUED
     * @see SmsResultDTO
     */
    public static SmsResultDTO queued() {
        return new SmsResultDTO(SmsStatus.OMNI_QUEUED);
    }

    /**
     * Retrieves the status of the SMS message.
     *
     * @return The status of the SMS message.
     */
    public SmsStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsResultDTO that)) return false;
        return getStatus() == that.getStatus();
    }

    @Override
    public int hashCode() {
        return getStatus() != null ? getStatus().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SmsResultDTO{" +
                "status=" + status +
                '}';
    }
}
