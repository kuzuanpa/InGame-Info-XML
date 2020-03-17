package com.github.lunatrius.ingameinfo.tag.registry;

import com.github.lunatrius.ingameinfo.reference.Reference;
import com.github.lunatrius.ingameinfo.tag.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagRegistry {
    public static final TagRegistry INSTANCE = new TagRegistry();

    private final Map<String, Tag> stringTagMap = new HashMap<String, Tag>();

    private void register(String name, Tag tag) {
        if (this.stringTagMap.containsKey(name)) {
            Reference.logger.error("Duplicate tag key '" + name + "'!");
            return;
        }

        if (name == null) {
            Reference.logger.error("Tag name cannot be null!");
            return;
        }

        this.stringTagMap.put(name.toLowerCase(), tag);
    }

    public void register(Tag tag) {
        register(tag.getName(), tag);

        for (String name : tag.getAliases()) {
            register(name, tag);
        }
    }

    public String getValue(String name) {
        Tag tag = this.stringTagMap.get(name.toLowerCase());
        return tag != null ? tag.getValue() : null;
    }

    public List<Tag> getRegisteredTags() {
        List<Tag> tags = new ArrayList<Tag>();
        for (Map.Entry<String, Tag> entry : this.stringTagMap.entrySet()) {
            tags.add(entry.getValue());
        }
        return tags;
    }

    public void init() {
        TagFormatting.register();
        TagMisc.register();
        TagMouseOver.register();
        TagNearbyPlayer.register();
        TagPlayerEquipment.register();
        TagPlayerGeneral.register();
        TagPlayerPosition.register();
        TagPlayerPotion.register();
        TagRiding.register();
        TagTime.register();
        TagWorld.register();

        Reference.logger.info("Registered " + this.stringTagMap.size() + " tags.");
    }
}
