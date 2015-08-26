package com.general.mapper.impl;

import com.general.mapper.base.PropertyUtilsAbstractMapper;
import com.general.mapper.valueobject.CustomSourceObject;
import com.general.mapper.valueobject.CustomTargetObject;
import com.general.mapper.valueobject.MapperEnum;

public class PropertyUtilsCustomObjectMapper
		extends PropertyUtilsAbstractMapper<CustomSourceObject, CustomTargetObject> {

	@Override
	public CustomTargetObject to(CustomSourceObject sourceObject) {
		CustomTargetObject customTargetObject = new CustomTargetObject();

		map(customTargetObject, customTargetObject.InsuredFirstName, sourceObject.getFirstName(), MapperEnum.NOT_BLANK);
		map(customTargetObject, customTargetObject.InsuredLastName, sourceObject.getLastName(), MapperEnum.NOT_BLANK);
		map(customTargetObject, customTargetObject.InsuredCity, sourceObject.getCity(), MapperEnum.NOT_BLANK);
		map(customTargetObject, customTargetObject.InsuredAge, sourceObject.getAge(), MapperEnum.NOT_BLANK);
		map(customTargetObject, customTargetObject.WealthTobeInsured, sourceObject.getWealth(), MapperEnum.NOT_BLANK);

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
