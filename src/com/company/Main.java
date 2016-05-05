package com.company;

import com.company.lib.Catalog;
import com.company.lib.CatalogFactory;
import com.company.lib.TypeDef;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CatalogFactory cf = new CatalogFactory();


        final Catalog c;
        c = cf.createCatalog();

        cf.registerConfigChangeCallback(() -> {
            System.out.println("inside config change");
            c.setInvalidated(true);
        });

        List<TypeDef> t = c.getTypes();

        c.setTypes(t);

        System.out.println("Catalog is Invalidated = " + c.isInvalidated());

        cf.onConfigChange();

        System.out.println("Catalog is Invalidated = " + c.isInvalidated());

    }
}
