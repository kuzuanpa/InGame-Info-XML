package com.github.lunatrius.ingameinfo.reference;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reference {

    public static final String MODID = "InGameInfoXML";
    public static final String NAME = "InGame Info XML";
    public static final String VERSION = "2.8.0";
    public static final String PROXY_SERVER = "com.github.lunatrius.ingameinfo.proxy.ServerProxy";
    public static final String PROXY_CLIENT = "com.github.lunatrius.ingameinfo.proxy.ClientProxy";
    public static final String GUI_FACTORY = "com.github.lunatrius.ingameinfo.client.gui.GuiFactory";

    public static Logger logger = LogManager.getLogger(Reference.MODID);
}
