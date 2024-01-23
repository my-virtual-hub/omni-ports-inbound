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
