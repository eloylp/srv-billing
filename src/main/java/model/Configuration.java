package model;

/**
 * Created by eloylp on 4/12/16.
 */
public class Configuration
{
    private boolean hddSave;
    private boolean htmlSave;
    private boolean dbSave;

    public boolean isHddSave() {
        return hddSave;
    }

    public void setHddSave(boolean hddSave) {
        this.hddSave = hddSave;
    }

    public boolean isHtmlSave() {
        return htmlSave;
    }

    public void setHtmlSave(boolean htmlSave) {
        this.htmlSave = htmlSave;
    }

    public boolean isDbSave() {
        return dbSave;
    }

    public void setDbSave(boolean dbSave) {
        this.dbSave = dbSave;
    }
}
