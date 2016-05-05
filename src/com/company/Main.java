package com.company;

import com.company.lib.Catalog;
import com.company.lib.CatalogProvider;

public class Main implements IChangeable
{
    private boolean changed = false;

    public static void main(String[] args) {

        CatalogProvider cf = new CatalogProvider();

        final Catalog c;
        c = cf.createCatalog();

        cf.registerConfigChangeCallback(this);

        System.out.println("This changed = " + changed);

        cf.onConfigChange();

        System.out.println("This changed = " + changed);

    }

    public void changed()
    {
        System.out.println("Provider changed setting flag");
        changed = true;
    }
}
