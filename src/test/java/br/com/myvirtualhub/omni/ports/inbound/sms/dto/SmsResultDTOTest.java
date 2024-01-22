/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SmsResultDTOTest {

    @Test
    void testEqualsWithIdenticalObjects() {
        SmsResultDTO smsResult1 = SmsResultDTO.queued();
        SmsResultDTO smsResult2 = SmsResultDTO.queued();

        assertEquals(smsResult1, smsResult2);
    }

    @Test
    void testEqualsWithNullObject() {
        SmsResultDTO smsResult1 = SmsResultDTO.queued();
        SmsResultDTO smsResult2 = null;

        assertNotEquals(smsResult1, smsResult2);
    }

    @Test
    void testEqualsWithDifferentObjectType() {
        SmsResultDTO smsResult1 = SmsResultDTO.queued();
        String someString = "foobar";

        assertNotEquals(smsResult1, someString);
    }

    @Test
    void testHashCodeWithIdenticalObjects() {
        SmsResultDTO smsResult1 = SmsResultDTO.queued();
        SmsResultDTO smsResult2 = SmsResultDTO.queued();

        assertEquals(smsResult1.hashCode(), smsResult2.hashCode());
    }

    @Test
    void testToString() {
        SmsResultDTO smsResult = SmsResultDTO.queued();

        String expectedString = "SmsResultDTO{status=OMNI_QUEUED}";
        assertEquals(expectedString, smsResult.toString());
    }
}