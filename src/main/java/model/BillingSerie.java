package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BillingSerie {
    @Id
    private String id;
    private String name;
    private int autoIncremental;
    private String prefix;
    private String suffix;
    private boolean hasYear;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAutoIncremental() {
        return autoIncremental;
    }

    public void setAutoIncremental(int autoIncremental) {
        this.autoIncremental = autoIncremental;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isHasYear() {
        return hasYear;
    }

    public void setHasYear(boolean hasYear) {
        this.hasYear = hasYear;
    }
}
