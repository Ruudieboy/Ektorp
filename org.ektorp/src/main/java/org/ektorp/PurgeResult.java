package org.ektorp;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurgeResult {

	private final Map<String, List<String>> purged;
	private final String purgeSeq;

	@JsonCreator
	public PurgeResult(@JsonProperty("purged") Map<String,
			List<String>> purged,@JsonProperty("purge_seq") String purgeSeq) {
		this.purged = purged;
		this.purgeSeq = purgeSeq;
	}

	public Map<String, List<String>> getPurged() {
		return purged;
	}

	public String getPurgeSeq() {
		return purgeSeq;
	}

	private Map<String, Object> anonymous;

	/**
	 * @return a Map containing fields that did not map to any other field in the class during object deserializarion from a JSON document.
	 */
	@JsonAnyGetter
	public Map<String, Object> getAnonymous() {
		return anonymous();
	}

	/**
	 * Exists in order to future proof this class.
	 * @param key
	 * @param value
	 */
	@JsonAnySetter
	public void setAnonymous(String key, Object value) {
		anonymous().put(key, value);
	}

	private Map<String, Object> anonymous() {
		if (anonymous == null) {
			anonymous = new HashMap<String, Object>();
		}
		return anonymous;
	}
}
