/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import java.util.Objects;

/**
 * The SmsPayloadDTO class represents a payload for sending an SMS message.
 * It contains information about the recipient, the message content, and the client message ID.
 * The class provides methods to retrieve the recipient, the message, and the client message ID.
 * It also provides a Builder class for creating instances of SmsPayloadDTO.
 */
public class SmsPayloadDTO {

    private final SmsRecipientDTO recipient;
    private final SmsMessageDTO message;
    private final String clientMessageId;

    private SmsPayloadDTO(SmsRecipientDTO recipient, SmsMessageDTO message, String clientMessageId) {
        this.recipient = recipient;
        this.message = message;
        this.clientMessageId = clientMessageId;
    }

    public SmsRecipientDTO getRecipient() {
        return recipient;
    }

    public SmsMessageDTO getMessage() {
        return message;
    }

    public String getClientMessageId() {
        return clientMessageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsPayloadDTO smsPayloadDTO)) return false;
        return Objects.equals(getRecipient(), smsPayloadDTO.getRecipient()) &&
                Objects.equals(getMessage(), smsPayloadDTO.getMessage()) &&
                Objects.equals(getClientMessageId(), smsPayloadDTO.getClientMessageId());
    }

    @Override
    public int hashCode() {
        int result = getRecipient() != null ? getRecipient().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getClientMessageId() != null ? getClientMessageId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SmsPayloadDTO{" +
                "recipient=" + recipient +
                ", message=" + message +
                ", clientMessageId='" + clientMessageId + '\'' +
                '}';
    }

    /**
     * Returns a new instance of the SmsPayloadDTO.Builder class.
     *
     * @return A new instance of the SmsPayloadDTO.Builder class.
     */
    public static SmsPayloadDTO.Builder builder() {
        return new SmsPayloadDTO.Builder();
    }

    /**
     * The Builder class provides methods for creating instances of SmsPayloadDTO.
     */
    public static class Builder {
        private SmsRecipientDTO recipient;
        private SmsMessageDTO message;
        private String clientMessageId;

        /**
         * Creates a new instance of the SmsPayloadDTO.Builder class.
         */
        public Builder() {
            // empty constructor. Using builder pattern.
        }

        /**
         * Sets the recipient of the SmsPayloadDTO.
         *
         * @param recipient The recipient of the SmsPayloadDTO as an instance of the SmsRecipientDTO class.
         * @return The SmsPayloadDTO.Builder instance.
         */
        public Builder withRecipient(SmsRecipientDTO recipient) {
            this.recipient = recipient;
            return this;
        }

        /**
         * Sets the message of the SmsPayloadDTO.
         *
         * @param message The message of the SmsPayloadDTO as an instance of the SmsMessageDTO class.
         * @return The SmsPayloadDTO.Builder instance.
         */
        public Builder withMessage(SmsMessageDTO message) {
            this.message = message;
            return this;
        }

        /**
         * Sets the client message ID of the SmsPayloadDTO.
         *
         * @param clientMessageId The client message ID of the SmsPayloadDTO as a string.
         * @return The SmsPayloadDTO.Builder instance.
         */
        public Builder withClientMessageId(String clientMessageId) {
            this.clientMessageId = clientMessageId;
            return this;
        }

        /**
         * Creates a new instance of the SmsPayloadDTO class.
         *
         * @return A new instance of the SmsPayloadDTO class.
         */
        public SmsPayloadDTO build() {
            return new SmsPayloadDTO(recipient, message, clientMessageId);
        }
    }
}
