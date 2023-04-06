class Start {
    public Start() {
        CheckErrors checkErrors = new CheckErrors();
        Input input = new Input();
        CreateFile cf = new CreateFile();
        String [] person = input.inputData();
        if (checkErrors.startAllCheck(person) == "0"){
            cf.createNewFile(person);
        }
        else {
            System.out.println("\nОшибка!\n");;
            System.err.println(checkErrors.startAllCheck(person));
        }
    }
}

