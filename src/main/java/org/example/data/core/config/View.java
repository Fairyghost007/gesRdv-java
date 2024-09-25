package org.example.data.core.config;



import java.util.List;

public interface View<T> {
     T saisie();
     void affiche(List<T> datas);
     void affiche(T data);
     
     void delete();
}
