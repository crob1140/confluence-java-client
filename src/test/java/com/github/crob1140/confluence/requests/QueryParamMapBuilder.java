package com.github.crob1140.confluence.requests;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class can be used to simplify the construction of query parameter maps in tests
 */
class QueryParamMapBuilder {

  private Map<String, String> map = new HashMap<>();

  QueryParamMapBuilder addEntry(String key, String value) {
    this.map.put(key, value);
    return this;
  }

  Map<String, String> build() {
    return Collections.unmodifiableMap(this.map);
  }
}
