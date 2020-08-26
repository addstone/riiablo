package com.riiablo.logger;

import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class SimpleEncoder implements Encoder {
  static final Charset US_ASCII = Charset.forName("US-ASCII");
  final byte[] newLine = System.getProperty("line.separator").getBytes(US_ASCII);

  private final StringBuilder buffer = new StringBuilder(1024);

  @Override
  public void encode(LogEvent event, OutputStream out) {
    try {
      buffer.append(StringUtils.rightPad(event.level().name(), 5));
      buffer.append(' ');
      buffer.append('[');
      buffer.append(ClassUtils.getShortClassName(event.source().getClassName()));
      buffer.append(']');
      buffer.append(' ');
      buffer.append(event.message().format());
      out.write(buffer.toString().getBytes(US_ASCII));
      out.write(newLine);
      out.flush();
    } catch (Throwable t) {
      ExceptionUtils.rethrow(t);
    } finally {
      buffer.setLength(0);
    }
  }
}