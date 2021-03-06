package com.example.zhewang.daggermigratetest;

import dagger.ObjectGraph;

/**
 * Created by zhe.wang on 8/1/16.
 */
public class Services {
    private Services() {}

    /** internal reference of object graph generated via {@link #initialize(Object)}} **/
    private static ObjectGraph sObjectGraph;

    /**
     * initialize dagger with module-objects and saves object graph. This will overwrite existing intializations.
     * Please be aware that services already injected won't be affected by this change.
     * @param module instances of module-class (classes annotated with {@link dagger.Module})
     * @return generated object graph
     */
    public static synchronized ObjectGraph initialize(Object module) {
        sObjectGraph = ObjectGraph.create(module);
        return sObjectGraph;
    }

    /**
     * get dagger object graph
     * @return dagger object graph
     */
    public static ObjectGraph getGlobalGraph() {
        return sObjectGraph;
    }
}
