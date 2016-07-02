/**
 * 
 */
package com.bs.lsx.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONNull;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author mx.li
 * @version 2013-8-12 下午3:41:42 
 */
public class JsonUtils {

	/**
	 * json字符串转换map对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:06:22 
	 * @param str
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String str){
		JSONObject json = JSONObject.fromObject(str);
		return jsonToMap(json);
	}
	
	public static String valueToString(Object obj){
		return JSONUtils.valueToString(obj);
	}
	
	/**
     * 对象转换为Json
     * @param obj 
     * @return
     */
    public static String object2json(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
//            json.append("\"\"");
            json.append(obj);
        } else if (obj instanceof String || obj instanceof Integer
                || obj instanceof Float || obj instanceof Boolean
                || obj instanceof Short || obj instanceof Double
                || obj instanceof Long || obj instanceof BigDecimal
                || obj instanceof BigInteger || obj instanceof Byte) {
            json.append("\"").append(string2json(obj.toString())).append("\"");
        } else if (obj instanceof Object[]) {
            json.append(array2json((Object[]) obj));
        } else if (obj instanceof List) {
            json.append(list2json((List<?>) obj));
        } else if (obj instanceof Map) {
            json.append(map2json((Map<?, ?>) obj));
        } else if (obj instanceof Set) {
            json.append(set2json((Set<?>) obj));
        } else {
            json.append(bean2json(obj));
        }
        return json.toString();
    }
    
    /**
     * 对象bean转换为Json
     * @param bean
     * @return
     */
    public static String bean2json(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)
                    .getPropertyDescriptors();
        } catch (IntrospectionException e) {
        }
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = object2json(props[i].getName());
                    String value = object2json(props[i].getReadMethod().invoke(
                            bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Exception e) {
                }
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * List集合转换为Json
     * @param list
     * @return
     */
    public static String list2json(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * 对象数组转换为Json
     * @param array
     * @return
     */
    public static String array2json(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * Map集合转换为Json
     * @param map
     * @return
     */
    public static String map2json(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * Set集合转为Json
     * @param set
     * @return
     */
    public static String set2json(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object obj : set) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * 字符串转换为Json
     * @param s
     * @return
     */
    public static String string2json(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
            case '"':
                sb.append("\\\"");
                break;
            case '\\':
                sb.append("\\\\");
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\r':
                sb.append("\\r");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '/':
                sb.append("\\/");
                break;
            default:
                if (ch >= '\u0000' && ch <= '\u001F') {
                    String ss = Integer.toHexString(ch);
                    sb.append("\\u");
                    for (int k = 0; k < 4 - ss.length(); k++) {
                        sb.append('0');
                    }
                    sb.append(ss.toUpperCase());
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }


	/**
	 * json对象转换map对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:05:56 
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap(JSONObject json){  
		Map<String, Object> result = null;
		if(json != null && json.keySet().size() > 0){
			result = new HashMap<String, Object>();
			Iterator<String> keys=json.keys();  
			JSONObject jo=null;  
			Object o;  
			String key;  
			while(keys.hasNext()){  
				key=keys.next();  
				o=json.get(key);  
				if(o instanceof JSONObject){  
					jo=(JSONObject)o;  
					if(jo.keySet().size()>0){  
						Map<String, Object> map = new HashMap<String, Object>();
						map = jsonToMap(jo);  
						result.put(key, map);
					}else{  
						result.put(key, null);
					}  
				} else if(JSONUtils.isArray(o)){
					JSONArray oArray = (JSONArray) o;
					List<Object> list = new ArrayList<Object>();
					for (int i = 0; i < oArray.size(); i++) { 
						if(oArray.get(i) instanceof JSONObject){
							jo = (JSONObject) oArray.get(i);  
							Map<String, Object> map = new HashMap<String, Object>();
							map = jsonToMap(jo);  
							list.add(map);
						} else {
							list.add(oArray.get(i));
						}
					}
					result.put(key, list);
					
//					Iterator<String> listKeys=jo.keys(); 
//					JSONObject listJo=null;  
//					Object listO;  
//					String listKey; 
//					for (int i = 0; i < oArray.size(); i++) {  
//						jo = (JSONObject) oArray.get(i);  
//						System.out.println(jo.get("name")); 
//						while(listKeys.hasNext()){  
//							listKey = listKeys.next();  
//							listO = jo.get(listKey); 
//							Map<String, Object> m = new HashMap<String, Object>();
//							if(listO instanceof JSONObject){  
//								listJo=(JSONObject)listO;  
//								m = jsonToMap(listJo);
//							} else {
//								m.put(listKey, listO);
//							}
//							list.add(m);
//						}
//					}
//					
//					result.put(key, list);
				} else {
					if("null".equals(o) || o == JSONNull.getInstance()){
						o = null;
					}
					result.put(key, o);
				}  
			}  
		}
		return result != null && result.size() > 0 ? result : null;
	}  
	
	/**
	 * map对象映射实体对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:06:58 
	 * @param name 映射名称
	 * @param retObject 映射的map值
	 * @param bean map中的其中一个对象
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException 
	 */
	@SuppressWarnings("unchecked")
	public static void mapToBean(String name, Map<String, Object> retObject, Object bean) throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		setDateConverter();
		BeanUtils.populate(bean, (Map<String, Object>)retObject.get(name));
	}
	
	/**
	 * map对象映射实体对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:06:58 
	 * @param name 映射名称
	 * @param retObject 映射的map值
	 * @param bean map中的其中一个对象
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public static void mapToBean(Map<String, Object> retObject, Object bean) throws IllegalAccessException,
			InvocationTargetException {
		setDateConverter();
		BeanUtils.populate(bean, retObject);
	}
	
	/**
	 * beanutils日期转换有问题 必须注册转换器
	 */
	private static void setDateConverter(){
		DateConverter dateConverter = new DateConverter(null);
		dateConverter.setPatterns(new String[]{"yyyy-MM-dd","yyyy/MM/dd","yyyy-MM-dd HH:mm:ss","yyyy/MM/dd HH:mm:ss"});
		ConvertUtils.register(dateConverter, Date.class); 
	}
	
	/**
	 * map对象映射数组对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:07:38 
	 * @param mapName
	 * @param listName
	 * @param retObject
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> mapToList(String mapName, String listName, Map<String, Object> retObject, Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<Object> result = null;
		Map<String, Object> map = (Map<String, Object>) retObject.get(mapName);
		if (map != null) {
			List<Object> list = (List<Object>)map.get(listName);
			if (list != null && list.size() > 0) {
				result = new ArrayList<Object>();
				for (int i = 0; i < list.size(); i++) {
					Object bean = clazz.newInstance();
					setDateConverter();
					BeanUtils.populate(bean, (Map<String, Object>)list.get(i));
					result.add(bean);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * String对象映射数组对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:07:38 
	 * @param <calzz>
	 * @param mapName
	 * @param listName
	 * @param retObject
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> jsonToList(String jsonStr, Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<Object> result = null;
		JSONArray jsonArray = JSONArray.fromObject(jsonStr);
		if(jsonArray != null && jsonArray.size() > 0){
			result = new ArrayList<Object>();
			for (int i = 0; i < jsonArray.size(); i++) {
				Object bean = clazz.newInstance();
				setDateConverter();
				BeanUtils.populate(bean, (Map<String, Object>)jsonArray.get(i));
				result.add(bean);
			}
		}
		return result;
	}
	/**
	 * map对象映射数组对象
	 * @author mx.li
	 * @version 2013-8-12 下午4:07:38 
	 * @param <calzz>
	 * @param mapName
	 * @param listName
	 * @param retObject
	 * @param clazz
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static List<Object> mapToList(String listName, Map<String, Object> retObject, Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<Object> result = null;
		List<Object> list = (List<Object>)retObject.get(listName);
		if (list != null && list.size() > 0) {
			result = new ArrayList<Object>();
			for (int i = 0; i < list.size(); i++) {
				Object bean = clazz.newInstance();
				setDateConverter();
				BeanUtils.populate(bean, (Map<String, Object>)list.get(i));
				result.add(bean);
			}
		}
		return result;
	}
	
	/**
	 * map转换指定List
	 * @param retObject
	 * @param objList 不能为null
	 * @param zclass
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static void mapToList(Map<String, Object> retObject, List<?> objList, Class<?> zclass) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> result = (List<T>) objList;
		List<Object> list = (List<Object>)retObject;
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				T bean = (T) zclass.newInstance();
				setDateConverter();
				BeanUtils.populate(bean, (Map<String, Object>)list.get(i));
				result.add(bean);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static List<?> mapToBeanList(Map<String, Object> map, Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException {
		List<T> result = null;
		List<Object> list = (List<Object>)map;
		if (list != null && list.size() > 0) {
			result = new ArrayList<T>();
			for (int i = 0; i < list.size(); i++) {
				T bean = (T) clazz.newInstance();
				setDateConverter();
				BeanUtils.populate(bean, (Map<String, Object>)list.get(i));
				result.add(bean);
			}
		}
		return result;
	}
	
	public static void testMap(Map<String, Object> inputPaMap) {
		for (String key : inputPaMap.keySet()) {
			Object o = inputPaMap.get(key);
			if(o instanceof Map){
				@SuppressWarnings("unchecked")
				Map<String, Object> iMap = (Map<String, Object>)o;
				testMap(iMap);
			} else if(o instanceof List){
				System.out.println("实现List");
			} else {
				System.out.println("没有实现");
				
			}
		}
	}
	
	public static void main(String[] args) {
		
	}

}
