package com.github.crob1140.confluence.requests;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class can be used to simplify the construction of query parameter maps in tests
 */
public class QueryParamMapBuilder {

  private Map<String, Set<String>> map = new HashMap<>();

  public QueryParamMapBuilder addEntry(String key, Collection<String> values) {
    this.map.put(key, new HashSet<>(values));
    return this;
  }

  public Map<String, Set<String>> build() {
    return Collections.unmodifiableMap(this.map);
  }
}
