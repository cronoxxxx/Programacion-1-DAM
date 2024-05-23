package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Getter
@Setter
public class Pueblo implements Serializable {

   private String pueblos;

    public Pueblo(String pueblos) {
        this.pueblos = pueblos;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pueblo pueblo = (Pueblo) o;
        return Objects.equals(pueblos, pueblo.pueblos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pueblos);
    }

    @Override
    public String toString() {
        return pueblos;
    }


}
