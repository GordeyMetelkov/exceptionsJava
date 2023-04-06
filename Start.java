class Start {
    public Start() {
        CheckErrors checkErrors = new CheckErrors();
        Input input = new Input();
        CreateFile cf = new CreateFile();
        String [] person = input.inputData();
        String result = checkErrors.startAllCheck(person);
        if (result == "0"){
            cf.createNewFile(person);
        }
        else {
            System.out.println("\nОшибка!\n");;
            System.err.println(result);
        }
    }
}

