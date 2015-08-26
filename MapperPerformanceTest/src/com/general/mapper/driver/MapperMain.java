package com.general.mapper.driver;

public class MapperMain {

	public static void main(String[] args) {
		new MapperMain().runPerformance();
	}

	public void runPerformance() {

		int numberOfIteration = 100000;
		
		long javaMapper = runMapper(new JavaMapperPerformanceRunner(numberOfIteration));
		System.out.println("Hand Coded : " + javaMapper);
		
		long beanUtils = runMapper(new BeanUtilsMapperPerformanceRunner(numberOfIteration));
		System.out.println("Bean Utils : " + beanUtils);
		System.out.println("%increase = " + beanUtils / (float) javaMapper + " times");

		long propertyUtils = runMapper(new PropertyUtilsMapperPerformanceRunner(numberOfIteration));
		System.out.println("Property Utils : " + propertyUtils);
		System.out.println("%increase = " + propertyUtils / (float) javaMapper + " times");
	}

	private long runMapper(MapperPerformanceRunner mapperPerformanceRunner) {
		mapperPerformanceRunner.run();
		return mapperPerformanceRunner.getTime();
	}


}
