package com.general.mapper.driver;

import java.math.BigDecimal;

import org.apache.commons.lang.time.StopWatch;
import org.fluttercode.datafactory.impl.DataFactory;

import com.general.mapper.base.BeanUtilsAbstractMapper;
import com.general.mapper.base.JavaAbstractMapper;
import com.general.mapper.base.PropertyUtilsAbstractMapper;
import com.general.mapper.impl.BeanUtilsCustomObjectMapper;
import com.general.mapper.impl.JavaCustomObjectMapper;
import com.general.mapper.impl.PropertyUtilsCustomObjectMapper;
import com.general.mapper.valueobject.CustomSourceObject;
import com.general.mapper.valueobject.CustomTargetObject;

public abstract class MapperPerformanceRunner {

	private DataFactory dataFactory = new DataFactory();

	private int numberOfIteration;

	public MapperPerformanceRunner(int numberOfIteration) {
		this.numberOfIteration = numberOfIteration;
	}

	private StopWatch stopWatch = new StopWatch();

	public void run() {

		stopWatch.start();
		for (int i = 0; i < numberOfIteration; i++)
			executeMap(buildCustomSourceObject());
		stopWatch.stop();
	}

	public long getTime() {
		return stopWatch.getTime();
	}

	private CustomSourceObject buildCustomSourceObject() {
		CustomSourceObject customSourceObject = new CustomSourceObject();

		customSourceObject.setFirstName(dataFactory.getFirstName());
		customSourceObject.setLastName(dataFactory.getLastName());
		customSourceObject.setCity(dataFactory.getCity());
		customSourceObject.setAge(dataFactory.getNumberBetween(18, 99));
		customSourceObject.setWealth(new BigDecimal(dataFactory.getNumberBetween(100000, 999999999)));

		return customSourceObject;
	}

	abstract CustomTargetObject executeMap(CustomSourceObject customSourceObject);
}

class JavaMapperPerformanceRunner extends MapperPerformanceRunner {

	public JavaMapperPerformanceRunner(int numberOfIteration) {
		super(numberOfIteration);
	}

	private JavaAbstractMapper<CustomSourceObject, CustomTargetObject> javaCustomObjectMapper = new JavaCustomObjectMapper();

	@Override
	CustomTargetObject executeMap(CustomSourceObject customSourceObject) {
		return javaCustomObjectMapper.to(customSourceObject);
	}

}

class BeanUtilsMapperPerformanceRunner extends MapperPerformanceRunner {

	public BeanUtilsMapperPerformanceRunner(int numberOfIteration) {
		super(numberOfIteration);
	}
	
	private BeanUtilsAbstractMapper<CustomSourceObject, CustomTargetObject> beanUtilsCustomObjectMapper = new BeanUtilsCustomObjectMapper();

	@Override
	CustomTargetObject executeMap(CustomSourceObject customSourceObject) {
		return beanUtilsCustomObjectMapper.to(customSourceObject);
	}

}

class PropertyUtilsMapperPerformanceRunner extends MapperPerformanceRunner {
	
	public PropertyUtilsMapperPerformanceRunner(int numberOfIteration) {
		super(numberOfIteration);
	}
	private PropertyUtilsAbstractMapper<CustomSourceObject, CustomTargetObject> propertyUtilsCustomObjectMapper = new PropertyUtilsCustomObjectMapper();

	@Override
	CustomTargetObject executeMap(CustomSourceObject customSourceObject) {
		return propertyUtilsCustomObjectMapper.to(customSourceObject);
	}

}