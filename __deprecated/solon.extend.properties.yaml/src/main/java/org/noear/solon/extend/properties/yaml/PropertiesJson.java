package org.noear.solon.extend.properties.yaml;

import org.noear.snack.ONode;

import java.io.IOException;
import java.util.Properties;

@Deprecated
public class PropertiesJson extends Properties {
    public synchronized void loadJson(String text) throws IOException {
        ONode.loadStr(text).bindTo(this);
    }
}
