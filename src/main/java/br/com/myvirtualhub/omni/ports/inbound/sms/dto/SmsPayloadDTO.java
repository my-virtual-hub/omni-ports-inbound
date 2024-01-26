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

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import br.com.myvirtualhub.omni.commons.core.OmniPhoneNumber;

import java.util.Objects;

/**
 * The SmsPayloadDTO class represents a payload for sending an SMS message.
 * It contains information about the recipient, the message content, and the client message ID.
 * The class provides methods to retrieve the recipient, the message, and the client message ID.
 * It also provides a Builder class for creating instances of SmsPayloadDTO.
 */
public class SmsPayloadDTO {

    private final OmniPhoneNumber fromOmniPhoneNumber;
    private final SmsRecipientDTO recipient;
    private final SmsMessageDTO message;
    private final String clientMessageId;

    private SmsPayloadDTO(OmniPhoneNumber fromOmniPhoneNumber, SmsRecipientDTO recipient, SmsMessageDTO message, String clientMessageId) {
        this.fromOmniPhoneNumber = fromOmniPhoneNumber;
        this.recipient = recipient;
        this.message = message;
        this.clientMessageId = clientMessageId;
    }

    /**
     * Retrieves the phone number of the SmsPayloadDTO.
     *
     * @return the phone number of the SmsPayloadDTO
     */
    public OmniPhoneNumber getFromOmniPhoneNumber() {
        return fromOmniPhoneNumber;
    }

    /**
     * Retrieves the recipient of the SMS message.
     *
     * @return The SmsRecipientDTO object representing the recipient of the SMS message.
     */
    public SmsRecipientDTO getRecipient() {
        return recipient;
    }

    /**
     * Retrieves the message object representing the SMS message.
     *
     * @return The SmsMessageDTO object representing the SMS message.
     */
    public SmsMessageDTO getMessage() {
        return message;
    }

    /**
     * Retrieves the clientMessageId of the SmsPayloadDTO.
     *
     * @return The clientMessageId of the SmsPayloadDTO.
     */
    public String getClientMessageId() {
        return clientMessageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsPayloadDTO smsPayloadDTO)) return false;
        return Objects.equals(getFromOmniPhoneNumber(), smsPayloadDTO.getFromOmniPhoneNumber()) &&
                Objects.equals(getRecipient(), smsPayloadDTO.getRecipient()) &&
                Objects.equals(getMessage(), smsPayloadDTO.getMessage()) &&
                Objects.equals(getClientMessageId(), smsPayloadDTO.getClientMessageId());
    }

    @Override
    public int hashCode() {
        int result = getRecipient() != null ? getRecipient().hashCode() : 0;
        result = 31 * result + (getFromOmniPhoneNumber() != null ? getFromOmniPhoneNumber().hashCode() : 0);
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (getClientMessageId() != null ? getClientMessageId().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SmsPayloadDTO{" +
                "fromOmniPhoneNumber=" + fromOmniPhoneNumber +
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
        private OmniPhoneNumber fromOmniPhoneNumber;
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
         * Sets the "from" phone number for the SmsPayloadDTO.
         *
         * @param fromOmniPhoneNumber The "from" phone number as an instance of the OmniPhoneNumber class.
         * @return The updated Builder instance.
         */
        public Builder withFromOmniPhoneNumber(OmniPhoneNumber fromOmniPhoneNumber) {
            this.fromOmniPhoneNumber = fromOmniPhoneNumber;
            return this;
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
            return new SmsPayloadDTO(fromOmniPhoneNumber, recipient, message, clientMessageId);
        }
    }
}
