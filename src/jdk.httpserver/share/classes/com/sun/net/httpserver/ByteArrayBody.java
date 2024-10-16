package com.sun.net.httpserver;

import java.io.IOException;
import java.io.OutputStream;

final class ByteArrayBody implements Body {
    private final byte[] value;

    ByteArrayBody(byte[] value) {
        this.value = value;
    }

    @Override
    public ResponseLength responseLength() {
        return ResponseLength.known(value.length);
    }

    @Override
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(value);
    }

    @Override
    public String toString() {
        return "ByteArrayBody[value=" + value + "]";
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ByteArrayBody b && value.equals(b.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}