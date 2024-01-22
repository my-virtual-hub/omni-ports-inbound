/*
 * Copyright (c) 2024.
 *
 *  This software is provided under the BSD-2-Clause license. By using this software,
 *  * you agree to respect the terms and conditions of the BSD-2-Clause license.
 */

package br.com.myvirtualhub.omni.ports.inbound.sms.interfaces;

import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsPayloadDTO;
import br.com.myvirtualhub.omni.ports.inbound.sms.dto.SmsResultDTO;

/**
 * The SmsInboundAction interface represents an action to send an inbound SMS message.
 * It defines a single method sendSms() that accepts an SmsPayloadDTO and returns a SmsResultDTO.
 */
public interface SmsInboundAction {

    /**
     * Sends an SMS message using the provided payload.
     *
     * @param smsPayload The payload for sending the SMS message.
     * @return The result of sending the SMS message as an instance of SmsResultDTO.
     */
    SmsResultDTO sendSms(SmsPayloadDTO smsPayload);
}
