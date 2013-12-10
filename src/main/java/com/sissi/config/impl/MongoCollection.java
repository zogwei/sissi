package com.sissi.config.impl;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.sissi.config.MongoConfig;

/**
 * @author kim 2013-11-15
 */
public class MongoCollection implements MongoConfig {

	private final Map<String, String> configs = new HashMap<String, String>();

	private final DBCollection collection;

	private final MongoClient client;

	public MongoCollection(MongoClient client, String db, String collection) {
		super();
		this.client = client;
		this.configs.put(MongoCollection.D_NAME, db);
		this.configs.put(MongoCollection.C_NAME, collection);
		this.collection = this.client.getDB(db).getCollection(collection);
	}

	@Override
	public String get(String key) {
		return this.configs.get(key);
	}

	public MongoConfig clear() {
		this.find().drop();
		return this;
	}

	public DBCollection find() {
		return this.collection;
	}

	public String asString(DBObject db, String key) {
		if (db == null) {
			return null;
		}
		Object value = db.get(key);
		return value != null ? value.toString() : null;
	}

	public Boolean asBoolean(DBObject db, String key) {
		if (db == null) {
			return null;
		}
		Object value = db.get(key);
		return value != null ? (Boolean) value : Boolean.FALSE;

	}
}
