package com.sissi.write;

import io.netty.buffer.ByteBuf;

import java.io.IOException;
import java.io.OutputStream;

import com.sissi.context.JIDContext;
import com.sissi.protocol.Element;

/**
 * @author kim 2013-10-24
 */
public interface Writer {

	public Element write(JIDContext context, Element element, OutputStream outputStream) throws IOException;

	public interface Transfer {
		
		public ByteBuf allocBuffer();

		public Transfer transfer(ByteBuf bytebuf);

		public Transfer close();
	}
}
