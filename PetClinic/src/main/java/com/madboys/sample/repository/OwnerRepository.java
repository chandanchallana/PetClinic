package com.madboys.sample.repository;

import org.springframework.dao.DataAccessException;
import com.madboys.sample.model.Owner;

import java.util.Collection;

import com.madboys.sample.model.BaseEntity;

/**
 * Repository class for owner. All method names are compliant with Spring data naming conventions
 * so this interface can easily be extended to Spring data.
 * <p/>
 * Created by Joker on 6/15/15.
 *
 * @author Joker
 */
public interface OwnerRepository {
    /**
     * Retrieve <code>Owner</code>s from the data store by last name, returning all owners whose
     * last name starts with the given name
     *
     * @param lastName value to search for
     * @return a <code>Collection</code> of matching <code>owner</code>s
     * (or an empty collection if none found)
     */

    Collection<Owner> findByLastName(String lastName) throws DataAccessException;


    /**
     * Retrieve an <code>Owner</code> from the data store by id.
     *
     * @param id the id to search for.
     * @return the <code>Owner</code> if found.
     * @throws org.springframework.dao.DataRetrievalFailureException if not found
     */

    Owner findById(int id) throws DataAccessException;

    /**
     * Save an <code>Owner</code> to the data store either inserting or updating it.
     *
     * @see BaseEntity#isNew
     */

    void save(Owner owner) throws DataAccessException;
}
