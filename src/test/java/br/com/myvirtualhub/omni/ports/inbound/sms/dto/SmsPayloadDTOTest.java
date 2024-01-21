/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import br.com.myvirtualhub.omni.commons.core.OmniPhoneNumber;
import br.com.myvirtualhub.omni.commons.exceptions.PhoneNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmsPayloadDTOTest {

    SmsRecipientDTO recipient;
    SmsMessageDTO message;
    String clientMessageId;

    SmsPayloadDTO payload;

    @BeforeEach
    void setUp() throws PhoneNumberException {
        recipient = SmsRecipientDTO.builder()
                .withPhoneNumber(new OmniPhoneNumber("+1234567890")).build();
        message = SmsMessageDTO.builder().withContent("Test message").withEncodingType("UTF-8").build();
        clientMessageId = "12345";
        payload = SmsPayloadDTO.builder()
                .withRecipient(recipient)
                .withMessage(message)
                .withClientMessageId(clientMessageId)
                .build();
    }

    @Test
    void testBuilderAndAccessors() {

        assertEquals(recipient, payload.getRecipient());
        assertEquals(message, payload.getMessage());
        assertEquals(clientMessageId, payload.getClientMessageId());
    }

    @Test
    void testEquals() {
        SmsPayloadDTO payload2 = SmsPayloadDTO.builder()
                .withRecipient(recipient)
                .withMessage(message)
                .withClientMessageId(clientMessageId)
                .build();

        assertEquals(payload, payload2);
    }

    @Test
    void testHashCode() {
        SmsPayloadDTO payload2 = SmsPayloadDTO.builder()
                .withRecipient(recipient)
                .withMessage(message)
                .withClientMessageId(clientMessageId)
                .build();

        assertEquals(payload.hashCode(), payload2.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "SmsPayloadDTO{recipient=" + recipient +
                ", message=" + message +
                ", clientMessageId='" + clientMessageId + '\'' +
                '}';
        assertEquals(expectedString, payload.toString());
    }
}
