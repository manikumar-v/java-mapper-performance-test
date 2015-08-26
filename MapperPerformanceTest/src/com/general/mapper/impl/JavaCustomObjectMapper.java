package com.general.mapper.impl;

import com.general.mapper.base.JavaAbstractMapper;
import com.general.mapper.valueobject.CustomSourceObject;
import com.general.mapper.valueobject.CustomTargetObject;

public class JavaCustomObjectMapper extends JavaAbstractMapper<CustomSourceObject, CustomTargetObject> {

	@Override
	public CustomTargetObject to(CustomSourceObject sourceObject) {
		CustomTargetObject customTargetObject = new CustomTargetObject();

		if (isNotEmpty(sourceObject.getFirstName()))
			customTargetObject.setInsuredFirstName(sourceObject.getFirstName());

		if (isNotEmpty(sourceObject.getLastName()))
			customTargetObject.setInsuredLastName(sourceObject.getLastName());

		if (isNotEmpty(sourceObject.getCity()))
			customTargetObject.setInsuredCity(sourceObject.getCity());
		
		if (isNotNull(sourceObject.getAge()))
			customTargetObject.setInsuredAge(sourceObject.getAge());

		if (isNotNull(sourceObject.getWealth()))
			customTargetObject.setWealthTobeInsured(sourceObject.getWealth());

		return customTargetObject;
	}

	@Override
	public CustomSourceObject from(CustomTargetObject destinationObject) {

		return null;
	}

	@Override
	public void to(CustomSourceObject sourceObject, CustomTargetObject destinationObject) {

	}

	@Override
	public void from(CustomSourceObject sourceObject, CustomTargetObject destinationObject) {

	}

}
