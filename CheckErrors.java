class CheckErrors {
    public CheckErrors() {
    }
    public Errors checkLength(String [] data) {
        if (data.length < 6) {
            return new Errors(false, -1, "Введены не все данные!");
        }
        if (data.length > 6) {
            return new Errors(false, -2, "Количество введенных данных больше необходимого!");
        }
        else return new Errors(true, 0, "");
    }
    public Errors checkFormatBDate(String [] data) {  
        String [] bday = data[3].split("\\.");
        try {
            for (String s : bday) {
                Integer.parseInt(s);
            }
        } catch (NumberFormatException ex) {
            new Errors(false, -7, "Дата должна состоять только из цифр!");
        }
        if (Integer.parseInt(bday[0]) <= 0 ||
            (Integer.parseInt(bday[1]) == 2 && Integer.parseInt(bday[0]) > 29) || 
            ((Integer.parseInt(bday[1]) == 1 ||
            Integer.parseInt(bday[1]) == 3 ||
            Integer.parseInt(bday[1]) == 5 || 
            Integer.parseInt(bday[1]) == 7 ||
            Integer.parseInt(bday[1]) == 8 ||
            Integer.parseInt(bday[1]) == 10 ||
            Integer.parseInt(bday[1]) == 12) && Integer.parseInt(bday[0]) > 31) || 
            ((Integer.parseInt(bday[1]) == 4 ||
            Integer.parseInt(bday[1]) == 6 ||
            Integer.parseInt(bday[1]) == 9 ||
            Integer.parseInt(bday[1]) == 11) && Integer.parseInt(bday[0]) > 30) || 
            Integer.parseInt(bday[1]) > 12 ||
            bday[2].length() != 4){
            return new Errors(false, -3, "Некорректная дата!");
        }
        else return new Errors(true, 0, "");
    }

    public Errors checkPhoneNum(String [] data) {  

        try {
            Long.parseLong(data[4]);
        } catch (NumberFormatException ex) {
            new Errors(false, -8, "Телефон должен состоять только из цифр!");
        }
        if (data[4].length() != 11) {
            return new Errors(false, -4, "Телефон введен неккоректно!");
        }
        return new Errors(true, 0, "");
    }

    public Errors checkFIO(String [] data) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < data[i].length(); j++) {
                // data[i] = data[i].toString();
                if (Character.isDigit(data[i].charAt(j))) {
                    return new Errors(false, -5, "Фамилия, Имя, Отчество должны состоять только из букв");
                }
            }
        }
        return new Errors(true, 0, "");
    }
    public Errors checkSex(String [] data) {
        if (data[5].length() != 1 || 
            (data[5].charAt(0) != 'm' && 
            data[5].charAt(0) != 'f')) {
            return new Errors(false, -6, "Пол должен быть указан одной буквой: m или f");
        }
        return new Errors(true, 0, "");
    }
    public String startAllCheck(String [] data){
        if (checkLength(data).code != 0) return checkLength(data).text + ". Code: " + checkLength(data).code;
        if (checkFIO(data).code != 0) return checkFIO(data).text + ". Code: " + checkFIO(data).code;
        if (checkFormatBDate(data).code != 0) return checkFormatBDate(data).text + 
            ". Code: " + checkFormatBDate(data).code;
        if (checkPhoneNum(data).code != 0) return checkPhoneNum(data).text + 
            ". Code: " + checkPhoneNum(data).code;
        if (checkSex(data).code != 0) return checkSex(data).text + ". Code: " + checkSex(data).code;         
        return "0";
    }
}
