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

class SmsRecipientDTOTest {

    OmniPhoneNumber phoneNumber;

    SmsRecipientDTO recipient;

    @BeforeEach
    void setUp() throws PhoneNumberException {
        phoneNumber = new OmniPhoneNumber("+1234567890");
        recipient = SmsRecipientDTO.builder()
                .withPhoneNumber(phoneNumber)
                .build();
    }

    @Test
    void testBuilderAndAccessor() {
        assertEquals(phoneNumber, recipient.getOmniPhoneNumber());
    }

    @Test
    void testEquals() throws PhoneNumberException {
        OmniPhoneNumber phoneNumber2 = new OmniPhoneNumber("+1234567890");
        OmniPhoneNumber phoneNumber3 = new OmniPhoneNumber("+1234567891");

        SmsRecipientDTO recipient2 = SmsRecipientDTO.builder()
                .withPhoneNumber(phoneNumber2)
                .build();

        SmsRecipientDTO recipient3 = SmsRecipientDTO.builder()
                .withPhoneNumber(phoneNumber3)
                .build();

        assertEquals(recipient, recipient2);
        assertNotEquals(recipient, recipient3);
    }

    @Test
    void testHashCode() {
        SmsRecipientDTO recipient2 = SmsRecipientDTO.builder()
                .withPhoneNumber(phoneNumber)
                .build();

        assertEquals(recipient.hashCode(), recipient2.hashCode());
    }

    @Test
    void testToString() {
        String expectedString = "SmsRecipientDTO{phoneNumber=" + phoneNumber + '}';
        assertEquals(expectedString, recipient.toString());
    }
}
