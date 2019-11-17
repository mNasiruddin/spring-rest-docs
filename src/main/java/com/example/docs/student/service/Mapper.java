package com.example.docs.student.service;

/**
 * The interface Mapper.
 *
 * @param <T> the type parameter
 * @param <V> the type parameter
 */
public interface Mapper<T, V> {

    /**
     * Transform t.
     *
     * @param v the v
     * @return the t
     */
    T transform(V v);
}
