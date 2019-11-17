package com.example.docs.student.service;

/**
 * The interface Repository.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 * @param <V> the type parameter
 */
public interface Repository<T, K, V> {

    /**
     * Find by message id t.
     *
     * @param v the v
     * @return the t
     */
    T findByMessageId(V v);

    /**
     * Save t.
     *
     * @param k the k
     * @return the t
     */
    T save(K k);

    /**
     * Delete boolean.
     *
     * @param v the v
     * @return the boolean
     */
    boolean delete(V v);

    /**
     * Update t.
     *
     * @param id the id
     * @param k the k
     * @return the t
     */
    T update(String id, K k);
}
