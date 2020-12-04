package by.company.hotel.repository;

import by.company.hotel.entity.Entity;
import by.company.hotel.exception.RepositoryException;
import by.company.hotel.specification.Specification;

import java.util.List;

public interface Repository< T extends Entity> {

    boolean add(T entity) throws RepositoryException;
    boolean remove(T entity) throws RepositoryException;
    boolean update(T entity) throws RepositoryException;

    List<T> query(Specification specification) throws RepositoryException;

}
