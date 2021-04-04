package com.smile.duplicateremoval;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author smi1e
 * Date 2019/11/21 10:24
 * Description
 */
public class CollectionUtil<T> {
    public static <T> Set<T> removeDuplicateBySet(List<T> data) {

        HashSet<T> stringHashSet = new HashSet<T>();
        stringHashSet.addAll(data);
        return stringHashSet;
    }

    public static <T>List<T> removeDuplicateByList(List<T> data) {
        ArrayList<T> results = new ArrayList<>(data.size());
        data.forEach(x->{
            if (!results.contains(x)){
                results.add(x);
            }
        });
        return results;
    }
}
