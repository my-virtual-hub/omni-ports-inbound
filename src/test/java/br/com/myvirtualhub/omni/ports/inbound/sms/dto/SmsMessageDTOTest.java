/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmsMessageDTOTest {

    @Test
    void testBuilderAndAccessors() {
        String content = "Test Message";
        String encodingType = "UTF-8";

        SmsMessageDTO message = SmsMessageDTO.builder()
                .withContent(content)
                .withEncodingType(encodingType)
                .build();

        assertEquals(content, message.getContent());
        assertEquals(encodingType, message.getEncodingType());
    }

    @Test
    void testEquals() {
        SmsMessageDTO message1 = SmsMessageDTO.builder()
                .withContent("Message")
                .withEncodingType("UTF-8")
                .build();

        SmsMessageDTO message2 = SmsMessageDTO.builder()
                .withContent("Message")
                .withEncodingType("UTF-8")
                .build();

        SmsMessageDTO message3 = SmsMessageDTO.builder()
                .withContent("Different")
                .withEncodingType("UTF-8")
                .build();

        assertEquals(message1, message2);
        assertNotEquals(message1, message3);
    }

    @Test
    void testHashCode() {
        SmsMessageDTO message1 = SmsMessageDTO.builder()
                .withContent("Message")
                .withEncodingType("UTF-8")
                .build();

        SmsMessageDTO message2 = SmsMessageDTO.builder()
                .withContent("Message")
                .withEncodingType("UTF-8")
                .build();

        assertEquals(message1.hashCode(), message2.hashCode());
    }

    @Test
    void testToString() {
        SmsMessageDTO message = SmsMessageDTO.builder()
                .withContent("Test Message")
                .withEncodingType("UTF-8")
                .build();

        String expectedString = "SmsMessageDTO{content='Test Message', encodingType='UTF-8'}";
        assertEquals(expectedString, message.toString());
    }
}
