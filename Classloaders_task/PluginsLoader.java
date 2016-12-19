package Classloaders_task;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maxim on 12/18/2016.
 */
public class PluginsLoader {
    private final String path;
    private List<PluginLoader> loaders;

    public PluginsLoader(String path) {
        loaders = new ArrayList<>();
        this.path = path;
    }

    public Class loadPlugin(String className) {

        URL[] urlPath = new URL[1];
        try {
            urlPath[0] = new URL(path);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
        try (PluginLoader loader = new PluginLoader(urlPath)) {
            loaders.add(loader);
            Class loadedClass = loader.loadClass(className);
            return loadedClass;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
