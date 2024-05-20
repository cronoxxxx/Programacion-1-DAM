package org.example.common;

import org.example.domain.CentrosOcio;

import java.util.Comparator;

public class Comparators {

    public static class provinciaComparator implements Comparator<CentrosOcio> {
        public provinciaComparator() {
        }
        @Override
        public int compare(CentrosOcio o1, CentrosOcio o2) {
            return o1.getProvincia().compareTo(o2.getProvincia());
        }
    }


}
