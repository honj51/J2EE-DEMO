package net.grosso.me.ibatis;

import java.sql.SQLException;
import java.sql.Types;

import net.grosso.me.domain.User.Gender;
import net.grosso.me.domain.User.Lock;

import com.ibatis.sqlmap.client.extensions.ParameterSetter;
import com.ibatis.sqlmap.client.extensions.ResultGetter;
import com.ibatis.sqlmap.client.extensions.TypeHandlerCallback;

public class GenderEnumHandler implements TypeHandlerCallback {
	@Override
	public void setParameter(ParameterSetter setter, Object parameter)
			throws SQLException {

		if (null == parameter) {
			setter.setString(Gender.MALE.toString());
		} else {
			setter.setString(((Gender) parameter).toString());
		}
	}

	@Override
	public Object getResult(ResultGetter getter) throws SQLException {

		
		Object result = null;

		if (null != getter.getObject()) {
			result = Gender.valueOf(getter.getString());
		}

		return result;
	}

	@Override
	public Object valueOf(String string) {
		return string;
	}

}
