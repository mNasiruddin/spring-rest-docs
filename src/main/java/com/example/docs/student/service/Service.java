package com.example.docs.student.service;

/**
 * The interface Service.
 *
 * @param <T> the type parameter
 * @param <V> the type parameter
 * @param <K> the type parameter
 */
public interface Service<T, V, K> {

    /**
     * Create t.
     *
     * @param v the v
     * @return the t
     */
    T create(V v);

    /**
     * Find by message id t.
     *
     * @param k the k
     * @return the t
     */
    T findByMessageId(K k);

    /**
     * Delete message boolean.
     *
     * @param k the k
     * @return the boolean
     */
    boolean deleteMessage(K k);

    /**
     * Update t.
     *
     * @param k the k
     * @param v the v
     * @return the t
     */
    T update(K k, V v);
}
