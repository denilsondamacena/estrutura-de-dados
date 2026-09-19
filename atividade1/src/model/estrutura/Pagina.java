package model.estrutura;

public class Pagina {
    private String script = "/umscript.py";
    private String input = "{}";
    private String id = "";

    public Pagina(String id) {
        this.id = id;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
