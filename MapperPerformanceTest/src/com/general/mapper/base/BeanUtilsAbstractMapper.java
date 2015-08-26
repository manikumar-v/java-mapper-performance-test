package com.general.mapper.base;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.general.mapper.valueobject.MapperEnum;

public abstract class BeanUtilsAbstractMapper<S, D> {

	abstract public D to(S sourceObject);
	abstract public S from(D destinationObject);

	abstract public void to(S sourceObject, D destinationObject);
	abstract public void from(S sourceObject, D destinationObject);

	public List<D> to(List<S> sourceObjects) {
		List<D> destinationObjects = new ArrayList<D>();
		for (S sourceObject : sourceObjects) {
			destinationObjects.add(to(sourceObject));
		}
		return destinationObjects;
	}

	public List<S> from(List<D> destinationObjects) {
		List<S> sourceObjects = new ArrayList<S>();
		for (D destinationObject : destinationObjects) {
			sourceObjects.add(from(destinationObject));
		}
		return sourceObjects;
	}

	public void map(Object destinationObject, String propertyName, String value, MapperEnum mapperEnum) {

		if (mapperEnum.equals(MapperEnum.NOT_BLANK)) {
			if (StringUtils.isBlank(value))
				return;
		}

		try {
			BeanUtils.setProperty(destinationObject, propertyName, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void map(Object destinationObject, String propertyName, BigDecimal value, MapperEnum mapperEnum) {

		try {
			BeanUtils.setProperty(destinationObject, propertyName, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void map(Object destinationObject, String propertyName, Integer value, MapperEnum mapperEnum) {

		try {
			BeanUtils.setProperty(destinationObject, propertyName, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Methods related to String
	 */
	private boolean isNull(String inputString) {
		return StringUtils.isBlank(inputString);
	}

	private boolean isNotNull(String inputString) {
		return !isNull(inputString);
	}

	private boolean isEmpty(String inputString) {
		return StringUtils.isEmpty(inputString);
	}

	private boolean isNotEmpty(String inputString) {
		return !isEmpty(inputString);
	}

	/**
	 * Methods related to Collection
	 * 
	 * @param <E>
	 */

	private <E> boolean isNull(Collection<E> inputCollection) {
		return (inputCollection == null);
	}

	private <E> boolean isNotNull(Collection<E> inputCollection) {
		return !isNull(inputCollection);
	}

	private <E> boolean isEmpty(Collection<E> inputCollection) {
		return CollectionUtils.isEmpty(inputCollection);
	}

	private <E> boolean isNotEmpty(Collection<E> inputCollection) {
		return !isEmpty(inputCollection);
	}

	/**
	 * Methods related to Date
	 */
	private boolean isNull(Date inputDate) {
		return (inputDate == null);
	}

	private boolean isNotNull(Date inputDate) {
		return !isNull(inputDate);
	}

}
