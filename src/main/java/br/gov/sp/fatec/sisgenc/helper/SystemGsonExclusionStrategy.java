package br.gov.sp.fatec.sisgenc.helper;

import java.util.Collection;

import org.hibernate.collection.internal.PersistentSet;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class SystemGsonExclusionStrategy implements ExclusionStrategy {

	@SuppressWarnings("rawtypes")
	private Class classToExclude;

	@SuppressWarnings("rawtypes")
	public SystemGsonExclusionStrategy(Class classToExclude) {
		this.classToExclude = classToExclude;
	}

	// This method is called for all fields. if the method returns false the
	// field is excluded from serialization
	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		if (f.getDeclaredType() == PersistentSet.class)
			return true;
		else if (Collection.class.isAssignableFrom(f.getDeclaredClass()))
			return true;

		return false;
	}

	// This method is called for all classes. If the method returns false the
	// class is excluded.
	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		if (clazz.equals(classToExclude))
			return true;
		if (Collection.class.isAssignableFrom(clazz)) {
			return true;
		}
		return false;
	}

}
