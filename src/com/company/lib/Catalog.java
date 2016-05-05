package com.company.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpeters on 5/4/16.
 */
public class Catalog
{
    private List<TypeDef> types;

    Catalog()
    {
        types = new ArrayList<>();
    }

    public List<TypeDef> getTypes() {

        return types;

    }

    public void setTypes(List<TypeDef> types) {
        this.types = types;
    }

}
