package org.example.data.core.config;

import java.util.List;

import org.example.data.entities.Medecin;



public interface  Service<T> {
      boolean save(T objet);
      List<T> show();
      T getBy(String value);
      int count();
}