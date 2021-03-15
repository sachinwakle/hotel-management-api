package com.hotel.app.common.dto;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

public class QueryParamDto {
    private StringBuilder query = new StringBuilder();
    private MapSqlParameterSource parameterSource = new MapSqlParameterSource();

    public String getQuery() {
	return query.toString();
    }

    public MapSqlParameterSource getParameterSource() {
	return parameterSource;
    }

    public QueryParamDto withQuery(String query) {
	this.query = new StringBuilder(query);
	return this;
    }

    public QueryParamDto withParameterSource(MapSqlParameterSource parameterSource) {
	if (parameterSource != null) {
	    this.parameterSource = parameterSource;
	}
	return this;
    }

    public QueryParamDto addQueryCriteria(String query) {
	if (this.isQueryParameterPresent()) {
	    this.query.append(" and ");
	} else {
	    this.query.append(" where ");
	}
	this.query.append(query);
	return this;
    }

    public QueryParamDto appendQuery(String query) {
	this.query.append(query);
	return this;
    }

    public int calculateOffset(int page, int size) {
	int offset = 0;
	if (page > 1) {
	    offset = (page - 1) * size;
	}
	return offset;
    }

    public QueryParamDto addQueryParameter(String key, Object value) {
	parameterSource.addValue(key, value);
	return this;
    }

    public boolean isQueryParameterPresent() {
	return !this.parameterSource.getValues().isEmpty();
    }
}
