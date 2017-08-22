package com.pm.common.base.utils.file;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {

    private static Log log = LogFactory.getLog(FileUtil.class);

    private String fileRootPath;

    private static FileUtil instance;

    public static FileUtil getInstance() {
        if (instance == null) {
            synchronized (FileUtil.class) {
                if (instance == null)
                    try {
                        instance = new FileUtil();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
        return instance;
    }

    private FileUtil() throws Exception {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getResourceAsStream("/control.properties"));
            for (Object key : prop.keySet()) {
                if (prop.getProperty((String) key) != null)
                    prop.setProperty((String) key, new String(prop.getProperty((String) key).getBytes("ISO-8859-1"), "utf-8"));
            }
        } catch (Exception e) {
            log.error("load property failed!", e);
            throw e;
        }
        this.fileRootPath = prop.getProperty("file.root.path");
    }

    public String getFileRootPath() {
        return this.fileRootPath;
    }

    public String getFileSuffix(String fileName) {
        try {
            if (fileName != null && fileName.indexOf('.') > 0) {
                return fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
            } else
                return "";
        } catch (Exception e) {
            return null;
        }
    }
}
