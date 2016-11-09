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
package org.beryx.textio;

import java.util.function.Function;
import java.util.function.Supplier;

public class TextIO {
    private final TextTerminal textTerminal;
    private final Supplier<TextTerminal> textTerminalSupplier;

    public TextIO(TextTerminal textTerminal) {
        this.textTerminal = textTerminal;
        this.textTerminalSupplier = () -> textTerminal;
    }

    public TextTerminal getTextTerminal() {
        return textTerminal;
    }

    public void dispose() {
        textTerminal.dispose();
    }

    public BooleanInputReader newBooleanInputReader() {
        return new BooleanInputReader(textTerminalSupplier);
    }

    public DoubleInputReader newDoubleInputReader() {
        return new DoubleInputReader(textTerminalSupplier);
    }

    public IntInputReader newIntInputReader() {
        return new IntInputReader(textTerminalSupplier);
    }

    public LongInputReader newLongInputReader() {
        return new LongInputReader(textTerminalSupplier);
    }

    public StringInputReader newStringInputReader() {
        return new StringInputReader(textTerminalSupplier);
    }

    public <T extends Enum<T>> EnumInputReader<T> newEnumInputReader(Class<T> enumClass) {
        return new EnumInputReader(textTerminalSupplier, enumClass);
    }

    public <T> GenericInputReader<T> newGenericInputReader(Function<String, InputReader.ParseResult<T>> parser) {
        return new GenericInputReader(textTerminalSupplier, parser);
    }
}
