package Classloaders_task;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Maxim on 12/18/2016.
 */

public class PluginLoader extends URLClassLoader {


    public PluginLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
            Class loadedClass = this.findClass(className);
            if (loadedClass == null)
                throw new ClassNotFoundException();
            return loadedClass;
    }

}
