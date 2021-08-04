package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
// Using Generic types for the client to choose
// Didn't implemented method for primitive types
public class App<T>
{
    public List<T[]> partition(List<T> liste, int taille) {
        if(liste == null) throw new IllegalArgumentException("liste cannot be null");
        if(taille < 0 || taille > liste.size()) throw new IllegalArgumentException("Arg taille must be between 0 and " +liste.size());
        List finalList = new ArrayList<List<T>>();
        int max = 0;
        while(max < liste.size()) {
            finalList.add(liste.stream()
                    .skip(max)
                    .limit(taille)
                    .collect(Collectors.toList()));
            max += taille;
        }
        return finalList;
    }
}
