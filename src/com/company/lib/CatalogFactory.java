package com.company.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpeters on 5/4/16.
 */
public class CatalogFactory extends ConfigurableFactory {

    public CatalogFactory() {
        super();
    }

    public Catalog createCatalog()
    {
        Catalog c = new Catalog();

        List<TypeDef> types = new ArrayList<>();

        TypeDef t = new TypeDef();
        t.setName("Integer");
        t.setType(Integer.class);

        types.add(t);

        return c;
    }
}
