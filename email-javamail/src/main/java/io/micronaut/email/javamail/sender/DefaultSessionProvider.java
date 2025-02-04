/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.email.javamail.sender;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Secondary;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import javax.mail.Session;

/**
 * @author Sergio del Amo
 * @since 1.0.0
 */
@Requires(beans = MailPropertiesProvider.class)
@Secondary
@Singleton
public class DefaultSessionProvider implements SessionProvider {
    private final MailPropertiesProvider mailPropertiesProvider;

    /**
     *
     * @param mailPropertiesProvider Mail Properties Provider
     */
    public DefaultSessionProvider(MailPropertiesProvider mailPropertiesProvider) {
        this.mailPropertiesProvider = mailPropertiesProvider;
    }

    @Override
    @NonNull
    public Session session() {
        return Session.getDefaultInstance(mailPropertiesProvider.mailProperties());
    }
}
