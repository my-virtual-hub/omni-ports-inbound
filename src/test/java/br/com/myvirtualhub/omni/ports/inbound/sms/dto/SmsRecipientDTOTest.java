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
