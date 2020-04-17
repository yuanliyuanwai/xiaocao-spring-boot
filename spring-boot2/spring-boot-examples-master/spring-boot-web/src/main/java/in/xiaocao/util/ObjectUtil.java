package in.xiaocao.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.Transient;

/**
 * 类型转换帮助类
 * 
 * @author zhengchong.wan
 * 
 */
public class ObjectUtil {

    /**
     * 某个对象是否在一个变长数组中
     * 
     * @param souce
     * @param targets
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> boolean in(T souce, T... targets) {
        for (T target : targets) {
            if (souce.equals(target))
                return true;
        }
        return false;
    }

    /**
     * 自动转换
     * 
     * @param obj
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        if (obj == null)
            return null;
        return (T) obj;
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj, Class<T> clazz) {
        if (obj == null)
            return null;
        return (T) obj;
    }

    /**
     * equal
     * 
     * @param x
     * @param Y
     * @return
     */
    public static <X, Y extends X> boolean equal(X x, Y y) {
        if (x == null)
            return false;
        return x.equals(y);
    }

    /**
     * 获取方法的返回类型
     * 
     * @param target
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static Class<?> getReturnType(Class<?> target, String methodName, Class<?>... parameterTypes) {
        Class<?> temp = target;
        while (true) {
            try {
                if (temp == null)
                    return null;
                Method m = temp.getDeclaredMethod(methodName, parameterTypes);
                return m.getReturnType();
            } catch (NoSuchMethodException e) {
            	
            } catch (SecurityException e) {
            }
            temp = temp.getSuperclass();
        }
    }
    
    /**
     * 获取参数的值
     * @param target
     * @param propertyNames 多级用.分割
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T getFieldValue(Object target, String propertyNames) {
    	if (StringUtil.isNullOrEmpty(propertyNames)) return null;
    	String[] propertyNameArr = propertyNames.split("\\.");
    	Object tempObject = target;
    	int index  =  0;
    	for (String propertyName : propertyNameArr) {
    		if (tempObject == null) return null;
    		try {
    			// 最后一个
        		if (index == propertyNameArr.length - 1) {
        			String methodName = getMethodName("get", propertyName);
    				Method m = getMethod(tempObject.getClass(), methodName);
    				if (m != null) {
    					m.setAccessible(true);
    					return (T) m.invoke(tempObject);
    				} else {
    					Field f = getField(tempObject.getClass(), propertyName);
    					f.setAccessible(true);
    					return (T) f.get(tempObject);
    				}
        		} else {
        			// 中间的一个
        			String methodName = getMethodName("get", propertyName);
    				Method m = getMethod(tempObject.getClass(), methodName);
    				if (m != null) {
    					m.setAccessible(true);
    					tempObject = m.invoke(tempObject);
    				} else {
    					Field f = getField(tempObject.getClass(), propertyName);
    					f.setAccessible(true);
    					tempObject = f.get(tempObject);
    				}
        			index++;
        		}
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }
    
    
    public static Field getField(Class<?> target, String propertyName) {
        Class<?> temp = target;
        while (true) {
            try {
                if (temp == null)  return null;
                Field f = temp.getDeclaredField(propertyName);
                f.setAccessible(true);
                return f;
            } catch (NoSuchFieldException e) {
            	
            } catch (SecurityException e) {
            	
            }
            temp = temp.getSuperclass();
        }
    }
    
    public static Method getMethod(Class<?> target, String methodName, Class<?>... parameterTypes) {
    	 Class<?> temp = target;
         while (true) {
             try {
                 if (temp == null)  return null;
                 Method m = temp.getDeclaredMethod(methodName, parameterTypes);
                 m.setAccessible(true);
                 return m;
             } catch (NoSuchMethodException e) {
             	
             } catch (SecurityException e) {
             	
             }
             temp = temp.getSuperclass();
         }
    }
    
    public static void setField(Object target, String propertyName, Object value) {
    	Field field = getField(target.getClass(), propertyName);
    	if (field == null) throw new RuntimeException("the property[" + propertyName + "] is not found!");
    	field.setAccessible(true);
    	try {
			field.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("set the property[" + propertyName + "] by reflect unsuccessfully!");
		} 
    }
    
    /**
     * 获取父类中的泛型类型
     * @param clazz 当前类
     * @param index 泛型索引
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> Class<T> getGenericTypeFromSuperClass(Class<?> clazz, int index) {
    	 ParameterizedType parameterizedType = (ParameterizedType) (clazz.getGenericSuperclass());
	     Type type = parameterizedType.getActualTypeArguments()[index];
	     if (type instanceof ParameterizedType) {
	           type = ((ParameterizedType) type).getRawType();
	           return (Class<T>) type;
	     } else if (type instanceof Class) {
	    	 return (Class<T>) type;
	     }
	     return null;
    }
    
    /**
     * 根据属性名和前缀获取方法名称
     * @param perfix
     * @param fieldName
     * @return
     */
    public static String getMethodName(String perfix, String fieldName) {
		String firstLetter = fieldName.substring(0, 1);
		String methodName = perfix + fieldName.replaceFirst(firstLetter, firstLetter.toUpperCase());
		return methodName;
    }
    
    /**
     * 是否是透明化的属性
     * @param target
     * @param field
     * @return
     */
    public static boolean isTransient(Class<?> target, Field field) {
    	// 判断属性上是否有Transient注解
		Transient transientAnno = field.getAnnotation(Transient.class);
		if (transientAnno != null) return true;
		// 判断方法上面是否有Transient注解
		String methodName = getMethodName("get", field.getName());
		Method method = ObjectUtil.getMethod(target, methodName);
		if (method != null) {
			transientAnno = method.getAnnotation(Transient.class);
			if (transientAnno != null) return true;
		}
		return false;
    }
    
    /**
     * 获取注解
     * @param target
     * @param field
     * @param annotationClass
     * @return
     */
    public static <T extends Annotation> T getAnnotation(Class<?> target, Field field, Class<T> annotationClass){
    	T t = field.getAnnotation(annotationClass);
    	if (t != null) return t;
    	String methodName = getMethodName("get", field.getName());
    	Method method = getMethod(target, methodName);
    	return method.getAnnotation(annotationClass);
    }
    
    /**
     * 获取注解
     * @param target
     * @param field
     * @param annotationClass
     * @return
     */
    public static <T extends Annotation> T getMethodAnnotation(Class<?> target, String methodName,  Class<T> annotationClass, Class<?>... parameterTypes){
    	Method method = getMethod(target, methodName, parameterTypes);
    	return method.getAnnotation(annotationClass);
    }
    
}
