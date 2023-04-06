class Errors {
    boolean flag;
    int code;
    String text;
    public Errors(boolean flag, int code, String text) {
        this.flag = flag;
        this.code = code;
        this.text = text;
    }
    @Override
    public String toString() {
        return "NoRunTime, code: " + code;
    }
}