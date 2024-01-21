/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import br.com.myvirtualhub.omni.commons.core.OmniPhoneNumber;

/**
 * The SmsRecipientDTO class represents a recipient for SMS messages.
 * It provides methods to retrieve the recipient's phone number and
 * create a new SmsRecipientDTO instance using a builder pattern.
 *
 *  @author  Marco Quiçula
 *  @version 1.0
 *  @since   2024-01-21
 */
public class SmsRecipientDTO {

    private final OmniPhoneNumber omniPhoneNumber;

    /**
     * The SmsRecipientDTO class represents a recipient for SMS messages.
     * It provides methods to retrieve the recipient's phone number and
     * create a new SmsRecipientDTO instance using a builder pattern.
     */
    private SmsRecipientDTO(OmniPhoneNumber omniPhoneNumber) {
        this.omniPhoneNumber = omniPhoneNumber;
    }

    /**
     * Returns the phone number of the SmsRecipientDTO.
     *
     * @return the phone number of the SmsRecipientDTO
     */
    public OmniPhoneNumber getOmniPhoneNumber() {
        return omniPhoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsRecipientDTO that)) return false;
        return getOmniPhoneNumber() != null ? getOmniPhoneNumber().equals(that.getOmniPhoneNumber()) : that.getOmniPhoneNumber() == null;
    }

    @Override
    public int hashCode() {
        return getOmniPhoneNumber() != null ? getOmniPhoneNumber().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SmsRecipientDTO{" +
                "phoneNumber=" + omniPhoneNumber +
                '}';
    }

    /**
     * Creates a new instance of the SmsRecipientDTO.Builder class.
     *
     * @return A new instance of the SmsRecipientDTO.Builder class.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * The Builder class is a static nested class that provides a fluent interface
     * for creating instances of the SmsRecipientDTO class using the builder pattern.
     * <p>
     * Example usage:
     * SmsRecipientDTO recipient = SmsRecipientDTO.Builder.newBuilder()
     *                             .withPhoneNumber(omniPhoneNumber)
     *                             .build();
     */
    public static class Builder {

        private OmniPhoneNumber omniPhoneNumber;

        /**
         * Sets the phone number of the recipient.
         *
         * @param omniPhoneNumber The phone number of the recipient.
         * @return The updated Builder instance.
         */
        public Builder withPhoneNumber(OmniPhoneNumber omniPhoneNumber) {
            this.omniPhoneNumber = omniPhoneNumber;
            return this;
        }

        /**
         * Creates a new instance of the SmsRecipientDTO class using the provided phoneNumber.
         *
         * @return A new instance of the SmsRecipientDTO class.
         */
        public SmsRecipientDTO build() {
            return new SmsRecipientDTO(omniPhoneNumber);
        }

    }
}