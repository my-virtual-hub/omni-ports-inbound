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
