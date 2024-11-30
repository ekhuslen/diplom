package com.example.gymnasticsScoringSystem;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.Tuple;
import jakarta.persistence.TupleElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class CoreDataTableBase {
    @PersistenceContext
    protected EntityManager em;


    public List<Map<String, Object>> runNativeQuery(String query) {
        return this.runNativeQuery(query, (Map) null);
    }

    public List<Map<String, Object>> runNativeQuery(String query, Map<String, Object> params) {
        try {
            Query q = this.em.createNativeQuery(query, Tuple.class);
            if (params != null) {
                Iterator var4 = params.entrySet().iterator();

                while (var4.hasNext()) {
                    Map.Entry<String, Object> i = (Map.Entry) var4.next();
                    if (query.contains((CharSequence) i.getKey())) {
                        q.setParameter((String) i.getKey(), i.getValue());
                    }
                }
            }

            return convertTuplesToMap(q.getResultList());
        } catch (NoResultException var6) {
            return new ArrayList<>();
        }
    }

    public static List<Map<String, Object>> convertTuplesToMap(List<?> tuples) {
        List<Map<String, Object>> result = new ArrayList<>();
        Iterator var2 = tuples.iterator();

        while (var2.hasNext()) {
            Object item = var2.next();
            if (item instanceof Tuple tuple) {
                result.add(convertTuplesToMap(tuple));
            }
        }

        return result;
    }

    public static Map<String, Object> convertTuplesToMap(Tuple tuple) {
        LinkedHashMap<String, Object> map = new LinkedHashMap();
        Iterator var2 = tuple.getElements().iterator();

        while (var2.hasNext()) {
            TupleElement<?> key = (TupleElement) var2.next();
            map.put(toStdStr(key.getAlias()), tuple.get(key));
        }

        return map;
    }

    public static String toStdStr(Object pVal) {
        return null == pVal ? null : toStr(pVal).toUpperCase().trim();
    }

    public static String toStr(Object val) {
        if (null == val) {
            return "";
        } else {
            Class<?> type = val.getClass();
            if (type == Date.class) {
                Date d = (Date) val;
                return datetimeToStr(d, "yyyy-MM-dd HH:mm:ss");
            } else {
                return type == String.class ? (String) val : String.valueOf(val);
            }
        }
    }

    @Deprecated
    public static String datetimeToStr(Date dateTime, String pattern) {
        SimpleDateFormat dateParser = new SimpleDateFormat(pattern);
        return dateParser.format(dateTime);
    }


}
