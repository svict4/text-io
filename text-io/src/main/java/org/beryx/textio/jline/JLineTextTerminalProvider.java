/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beryx.textio.jline;

import jline.console.ConsoleReader;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.TextTerminalProvider;

import java.io.IOException;

/**
 * If {@link System#console()} is not null and a ConsoleReader can be created, it provides a {@link JLineTextTerminal}.
 */
public class JLineTextTerminalProvider implements TextTerminalProvider {
    public TextTerminal getTextTerminal() {
        if(System.console() == null) return null;
        try {
            ConsoleReader reader = new ConsoleReader();
            return new JLineTextTerminal(reader);
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "JLine terminal";
    }
}
