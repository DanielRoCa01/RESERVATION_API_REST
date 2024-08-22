package com.daroca.reservas.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public interface Search {
    Query toQuery(EntityManager entityManager);

}
