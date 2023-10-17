package replaybot.replay.storage;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import replaybot.replay.attribute.Attribute;

public class AttributeDeserializer extends StdDeserializer<Attribute> {
	
	private static final String ATTRIBUTE_CLASSPATH = "replaybot.replay.attribute.Attribute$";
	
	public AttributeDeserializer() {
		super(Attribute.class);
	}

	@Override
	public Attribute deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		if(jp.getCurrentToken() != JsonToken.START_OBJECT) {
			jp.nextToken();
		}
		
		jp.nextValue();

		Attribute result = new Attribute.NotImplemented();
		
		try {
			String attributeSimpleName = getClassName(jp);
			
			Class<?> attributeClass = resolveAttributeClass(attributeSimpleName);
			Constructor<?> attributeConstructor = getAttributeConstructor(attributeClass);
			Class<?> valueClass = resolveValueClass(attributeConstructor);
			
			Object value = jp.readValueAs(valueClass);
			
			result = constructAttribute(attributeConstructor, value);

		} catch(IllegalArgumentException | ClassNotFoundException e) {
			System.err.println(e);
			jp.skipChildren();
		} catch (ReflectiveOperationException e) {
			throw new IOException("Unexpected error");
		} 
		
		jp.nextToken();
		
		return result;
	}
	
	private static String getClassName(JsonParser jp) throws IOException {
		String name = jp.getCurrentName();
		
		if(name == null) {
			throw new IllegalArgumentException("Field for attribute class-name is empty");
		}
		
		return name;
	}
	
	private static Class<?> resolveAttributeClass(String classSimpleName) throws ClassNotFoundException {
		return Class.forName(ATTRIBUTE_CLASSPATH + classSimpleName);
	}
	
	private static Constructor<?> getAttributeConstructor(Class<?> attributeClass) {
		Constructor<?>[] constructors = attributeClass.getConstructors();
		
		if(constructors.length == 0) {
			throw new IllegalArgumentException("No constructor found for " + attributeClass);
		}
		
		return constructors[0];
	}
	
	private static Class<?> resolveValueClass(Constructor<?> attributeConstructor) throws IllegalArgumentException {
		Class<?>[] parameterClasses = attributeConstructor.getParameterTypes();
		
		if(parameterClasses.length != 1) {
			throw new IllegalArgumentException("No parameters found for constructor");
		}
		
		return parameterClasses[0];
	}
	
	private static Attribute constructAttribute(Constructor<?> constructor, Object value) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object attribute = constructor.newInstance(value);

		if(!(attribute instanceof Attribute)) {
			throw new IllegalArgumentException("Constructed object was somehow not a subclass of Attribute");
		}
		
		return (Attribute) attribute;
	}

}
