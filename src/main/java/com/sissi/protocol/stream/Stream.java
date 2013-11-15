package com.sissi.protocol.stream;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sissi.context.JIDContext;
import com.sissi.protocol.Feature;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.auth.Auth;
import com.sissi.protocol.auth.Mechanisms;
import com.sissi.protocol.iq.bind.Bind;
import com.sissi.protocol.iq.session.Session;
import com.sissi.write.WriterWithOutClose;

/**
 * @author Kim.shen 2013-10-16
 */
@XmlRootElement(namespace = Stream.NAMESPACE)
public class Stream extends Protocol {

	private final static Log LOG = LogFactory.getLog(Stream.class);

	public final static String NAMESPACE = "http://etherx.jabber.org/streams";

	private final static String XMLNS = "jabber:client";

	private String version;

	private List<Feature> features;

	@XmlAttribute
	public String getXmlns() {
		return XMLNS;
	}

	public String getVersion() {
		return version;
	}

	public void addFeature(Feature feature) {
		if (this.features == null) {
			this.features = new ArrayList<Feature>();
		}
		LOG.info("Add feature: " + feature);
		this.features.add(feature);
	}

	@XmlElementWrapper(namespace = Stream.NAMESPACE, name = "features")
	@XmlElements({ @XmlElement(name = "auth", type = Auth.class), @XmlElement(name = "mechanisms", type = Mechanisms.class), @XmlElement(name = "bind", type = Bind.class), @XmlElement(name = "session", type = Session.class) })
	public List<Feature> getFeatures() {
		return features;
	}

	public static Stream generate(JIDContext context) {
		return new StreamOpen();
	}

	@XmlRootElement(name = "stream", namespace = Stream.NAMESPACE)
	public static class StreamOpen extends Stream implements WriterWithOutClose {

	}
}
