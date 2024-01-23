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

package br.com.myvirtualhub.omni.ports.inbound.sms.enums;

/**
 * This enum represents the status of an SMS message.
 */
public enum SmsStatus {
    /**
     * Represents the status of an SMS message when it is queued in the Omni SMS system.
     */
    OMNI_QUEUED,
    /**
     * This enum value represents the status of an SMS message that has been successfully sent by the Omni SMS system.
     */
    OMNI_SENT
}
