package com.general.mapper.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public abstract class JavaAbstractMapper<S,D> {
	
	abstract public D to(S sourceObject);
	abstract public S from(D destinationObject);
	
	abstract public void to(S sourceObject,D destinationObject);
	abstract public void from(S sourceObject,D destinationObject);
	
	public List<D> to(List<S> sourceObjects){
		List<D> destinationObjects = new ArrayList<D>();
		for(S sourceObject: sourceObjects){
			destinationObjects.add(to(sourceObject));
		}
		return destinationObjects;
	}
	
	public List<S> from(List<D> destinationObjects){
		List<S> sourceObjects = new ArrayList<S>();
		for(D destinationObject: destinationObjects){
			sourceObjects.add(from(destinationObject));
		}
		return sourceObjects;
	}
	
	/**
	 * Methods related to String 
	 */
	public boolean isNull(String inputString) {
		return StringUtils.isBlank(inputString);
	}

	public boolean isNotNull(String inputString) {
		return !isNull(inputString);
	}

	public boolean isEmpty(String inputString) {
		return StringUtils.isEmpty(inputString);
	}

	public boolean isNotEmpty(String inputString) {
		return !isEmpty(inputString);
	}
	
	
	/**
	 * Methods related to Collection 
	 * @param <E>
	 */
	
	public <E> boolean  isNull(Collection<E> inputCollection) {
		return (inputCollection==null);
	}
	
	public <E> boolean  isNotNull(Collection<E> inputCollection) {
		return !isNull(inputCollection);
	}
	
	public <E> boolean  isEmpty(Collection<E> inputCollection) {
		return CollectionUtils.isEmpty(inputCollection);
	}

	public <E> boolean  isNotEmpty(Collection<E> inputCollection) {
		return !isEmpty(inputCollection);
	}

	
	/**
	 * Methods related to Integer and BigDecimal 
	 */
	public boolean isNull(Integer inputInteger) {
		return (inputInteger == null);
	}

	public boolean isNotNull(Integer inputDate) {
		return !isNull(inputDate);
	}
	
	public boolean isNull(BigDecimal inputDecimal) {
		return (inputDecimal == null);
	}

	public boolean isNotNull(BigDecimal inputDate) {
		return !isNull(inputDate);
	}

}
