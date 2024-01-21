/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import java.util.Objects;

/**
 * Represents an SMS message.
 *
 *  @author  Marco Quiçula
 *  @version 1.0
 *  @since   2024-01-21
 */
public class SmsMessageDTO {

    private final String content;

    private final String encodingType;

    /**
     * Represents an SMS message.
     */
    private SmsMessageDTO(Builder builder) {
        this.content = builder.content;
        this.encodingType = builder.encodingType;
    }

    /**
     * Returns the content of the SMS message.
     *
     * @return the content of the SMS message as a string
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns the encoding type of the SMS message.
     *
     * @return the encoding type of the SMS message as a string
     */
    public String getEncodingType() {
        return encodingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SmsMessageDTO that)) return false;
        return Objects.equals(getContent(), that.getContent()) && Objects.equals(getEncodingType(), that.getEncodingType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContent(), getEncodingType());
    }

    @Override
    public String toString() {
        return "SmsMessageDTO{" +
                "content='" + content + '\'' +
                ", encodingType='" + encodingType + '\'' +
                '}';
    }

    /**
     * Returns a new instance of the Builder class for creating an SmsMessageDTO object.
     * The Builder class provides methods for setting the content and encoding type of the SMS message.
     *
     * @return a new instance of the Builder class
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder is a helper class for creating instances of SmsMessageDTO.
     * <p>
     * Usage:
     * <p>
     * SmsMessageDTO message = SmsMessageDTO.Builder.builder()
     *                              .content("Hello, world!")
     *                              .encodingType("UTF-8")
     *                              .build();
     * <p>
     * The Builder class provides methods for setting the content and encoding type
     * of the SMS message, and a build() method to create the SmsMessageDTO object.
     */
    public static class Builder {

        private String content;
        private String encodingType;

        /**
         * Sets the content of the SMS message.
         *
         * @param content the content of the SMS message as a string
         * @return the Builder instance
         */
        public Builder content(String content) {
            this.content = content;
            return this;
        }

        /**
         * Sets the encoding type of the SMS message.
         *
         * @param encodingType the encoding type of the SMS message as a string
         * @return the Builder instance
         */
        public Builder encodingType(String encodingType) {
            this.encodingType = encodingType;
            return this;
        }

        /**
         * Builds an instance of SmsMessageDTO using the provided content and encoding type.
         *
         * @return the built SmsMessageDTO object
         */
        public SmsMessageDTO build() {
            return new SmsMessageDTO(this);
        }
    }
}