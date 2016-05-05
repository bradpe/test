package com.company.lib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpeters on 5/4/16.
 */
public abstract class ConfigurableFactory
{
    private final List<ICallback> configChangeCallbacks;

    public ConfigurableFactory()
    {
        configChangeCallbacks = new ArrayList<>();
    }

    public void registerConfigChangeCallback(ICallback callback)
    {
        configChangeCallbacks.add(callback);
    }

    public void deregisterConfigCangeCallback(ICallback callback)
    {
        configChangeCallbacks.remove( callback );
    }

    public void onConfigChange()
    {
        configChangeCallbacks.forEach(ICallback::call);
    }
}

