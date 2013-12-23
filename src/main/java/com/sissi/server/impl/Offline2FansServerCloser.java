package com.sissi.server.impl;

import com.sissi.addressing.Addressing;
import com.sissi.broadcast.ProtocolBraodcast;
import com.sissi.context.JIDContext;
import com.sissi.protocol.presence.Presence;
import com.sissi.protocol.presence.Presence.Type;
import com.sissi.server.ServerCloser;

/**
 * @author kim 2013-11-20
 */
public class Offline2FansServerCloser implements ServerCloser {

	private final Integer IS_OFFLINE = 2;

	private final Addressing addressing;

	private final ProtocolBraodcast protocolBraodcast;

	public Offline2FansServerCloser(Addressing addressing, ProtocolBraodcast protocolBraodcast) {
		super();
		this.addressing = addressing;
		this.protocolBraodcast = protocolBraodcast;
	}

	@Override
	public Offline2FansServerCloser close(JIDContext context) {
		if (this.hasOther(context)) {
			this.protocolBraodcast.broadcast(context.getJid(), new Presence().setFrom(context.getJid().getBare()).setType(Type.UNAVAILABLE));
		}
		return this;
	}

	private boolean hasOther(JIDContext context) {
		return this.addressing.others(context.getJid()) < IS_OFFLINE;
	}
}
