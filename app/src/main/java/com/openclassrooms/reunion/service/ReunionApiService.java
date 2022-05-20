package com.openclassrooms.reunion.service;

import com.openclassrooms.reunion.model.Reunion;

import java.util.List;


/**
 * Neighbour API client
 */
public interface ReunionApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Reunion> getReunion();

    /**
     * Get Favoris Neighbours
     * @return {@link List}
     */
  //  List<Neighbour> getFavorisNeighbours();

    /**
     * Deletes a neighbour
     * @param reunion
     */
    void deleteReunion(Reunion reunion);

    /**
     * Create a neighbour
     * @param reunion
     */
    void createReunion(Reunion reunion);
}
