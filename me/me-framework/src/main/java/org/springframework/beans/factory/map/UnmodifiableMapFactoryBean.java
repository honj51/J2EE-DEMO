package org.springframework.beans.factory.map;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.collections.map.UnmodifiableMap;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;


public class UnmodifiableMapFactoryBean implements FactoryBean<UnmodifiableMap>, InitializingBean {

	private List<Resource> locations = new ArrayList<Resource>();

	public void afterPropertiesSet() throws Exception {
		Assert.notEmpty(locations);
	}

	public UnmodifiableMap getObject() throws Exception {
		Map<String, String> map = new Hashtable<String, String>();
		
		for (Resource resource : locations) {
			Properties props = new Properties();
			props.load(resource.getInputStream());
			
			for (Object key : props.keySet()) {
				Object value = props.get(key);
				map.put((String)key, (String)value);
			}
		}
		return (UnmodifiableMap) UnmodifiableMap.decorate(map);
	}
	
	public Class<?> getObjectType() {
		return UnmodifiableMap.class;
	}

	public boolean isSingleton() {
		return true;
	}

	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void setLocations(List<Resource> locations) {
		this.locations = locations;
	}
}
