package com.company.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpeters on 5/4/16.
 */
public abstract class ConfigurableProvider
{
    private final List<IChangeable> configChangeCallbacks;

    public ConfigurableProvider()
    {
        configChangeCallbacks = new ArrayList<>();
    }

    public void registerConfigChangeCallback(IChangeable callback)
    {
        configChangeCallbacks.add(callback);
    }

    public void deregisterConfigCangeCallback(IChangeable callback)
    {
        configChangeCallbacks.remove( callback );
    }

    public void onConfigChange()
    {
        configChangeCallbacks.forEach(IChangeable::changed);
    }
}

