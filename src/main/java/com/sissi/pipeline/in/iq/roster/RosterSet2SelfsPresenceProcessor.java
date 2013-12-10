package com.sissi.pipeline.in.iq.roster;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.UtilProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.roster.Roster;
import com.sissi.protocol.presence.Presence;

/**
 * @author kim 2013-11-18
 */
public class RosterSet2SelfsPresenceProcessor extends UtilProcessor {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		super.presenceQueue.offer(context.getJid(), super.build(Roster.class.cast(protocol).getFirstItem().getJid()), context.getJid(), new Presence().setType(Presence.Type.UNAVAILABLE));
		return true;
	}
}
