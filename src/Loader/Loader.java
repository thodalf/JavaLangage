package Loader;


import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Emile
 */
public class Loader {
    private static Loader instance;
    
    public static Loader getInstance() {
        if(instance == null) {
            instance = new Loader();
        }
        return instance;
    }
    
    private Loader() {
        
    }

    /**
     * Charge la class passée en paramètre
     * @param className Chemin vers la class
     * @return Class chargée
     */
    public Class loadClass(String className) {
        ClassLoader loader = Loader.class.getClassLoader();
        
        Class uneClass = null;
        try {
            uneClass = loader.loadClass(className);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return uneClass;
    }    
    
    /**
     * Recherche toutes les classes dans le package en paramètre
     * @param pkg Package à parcourir
     * @param contains Chaine devant se trouver dans le nom des classes à loader
     * @return Liste contenant le chemin vers chaque classe du package
     */
    public List<String> findClassInPackage(String pkg, String contains) {        
        File directory = null;
        String relPath = pkg.replace('.', '/');
        
        URL ressource = ClassLoader.getSystemClassLoader().getResource(relPath);
        
        try {
            directory = new File(ressource.toURI());
        } catch (URISyntaxException e) {
            
        } catch (IllegalArgumentException e) {
            
        }
        
        List<String> lesClass = new ArrayList();
        
        if(directory != null && directory.exists()) {
            File[] files = directory.listFiles();
            for(int i = 0; i < files.length; i++) {
                if(files[i].isDirectory() == true) {
                    try {
                        lesClass.addAll(findClassInPackage(pkg+"."+files[i].getName(), contains));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    if(files[i].getName().endsWith(".class") && files[i].getName().contains(contains)) {
                        String className = pkg+"."+files[i].getName().substring(0, files[i].getName().length() - 6);
                        lesClass.add(className);
                    }
                }
            }
        }
        return lesClass;
    }
}
