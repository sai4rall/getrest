package com.example.getrest;

import java.util.List;

public class MyMode {
    public MyMode() {
    }

    String id;
    String key;
    String name;
    String untranslatedName;
    boolean custom;
    boolean orderale;
    boolean navigable;
    boolean searchable;

    List<String> clausNames;
    Schema schema;
    static class Schema {
        String type;
        String custom;
        String customId;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCustom() {
            return custom;
        }

        public void setCustom(String custom) {
            this.custom = custom;
        }

        public String getCustomId() {
            return customId;
        }

        public void setCustomId(String customId) {
            this.customId = customId;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUntranslatedName() {
        return untranslatedName;
    }

    public void setUntranslatedName(String untranslatedName) {
        this.untranslatedName = untranslatedName;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public boolean isOrderale() {
        return orderale;
    }

    public void setOrderale(boolean orderale) {
        this.orderale = orderale;
    }

    public boolean isNavigable() {
        return navigable;
    }

    public void setNavigable(boolean navigable) {
        this.navigable = navigable;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }

    public List<String> getClausNames() {
        return clausNames;
    }

    public void setClausNames(List<String> clausNames) {
        this.clausNames = clausNames;
    }

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
    }

    public MyMode(String id, String key, String name, String untranslatedName, boolean custom, boolean orderale, boolean navigable, boolean searchable, List<String> clausNames, Schema schema) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.untranslatedName = untranslatedName;
        this.custom = custom;
        this.orderale = orderale;
        this.navigable = navigable;
        this.searchable = searchable;
        this.clausNames = clausNames;
        this.schema = schema;
    }
}
