package com.godel.cecm.handler;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import com.godel.cecm.handler.command.IComputationCommand;
import org.springframework.beans.factory.annotation.Autowired;

public class ObjectFactory {

    @Autowired
    XMLParser xmlParser;
    private Dictionary<String, IComputationCommand> commands = new Hashtable<>();
    private Dictionary<String, ArrayList<String>> plugins =  new Hashtable<>();

    public ObjectFactory(String file) {
        xmlParser.parseDocument(file, plugins);
    }
    public IComputationCommand getInstance(String archetype) {
        ArrayList<String> list = plugins.get(archetype);
        if (list.isEmpty()) return null;
        String className = list.get(0);
        String mode = list.get(1);
        // if (mode != "singleton" && mode != "prototype") return null;
        if (className == null) return null;
        IComputationCommand cmd = commands.get(archetype);
        if (cmd != null) {
            try {
                return mode.equalsIgnoreCase("singleton") ? cmd : deepClone(cmd);
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            Class<?> clazz = Class.forName(className);
            if (clazz == null) return null;
            Constructor<?> ctor = clazz.getConstructor();
            cmd = (IComputationCommand) ctor.newInstance();
            commands.put(archetype, cmd);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return cmd;
    }

    public <T, SerializableClass> T deepClone(T obj) throws IOException, ClassNotFoundException {
        //Serialization of object
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(obj);

        //De-serialization of object
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        SerializableClass copied = (SerializableClass) in.readObject();

        return (T) copied;
    }
}
