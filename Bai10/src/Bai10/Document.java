package Bai10;


public class Document {
    private String text;// Luu doi tuong String nguyen thuy duoc truyen vao
    private String firstEditText;// Bien text duoc edit lan dau
    private String lastEditText;// Bien text dang cuoi cung
    private int numberOfWord;// So tu trong van ban

    public Document(String string) {
        this.text = string;
        numberOfWord = 0;
        this.firstEditText = string.trim();
        this.lastEditText = parseToWord(firstEditText);
    }

    /**
     * @description: Them moi mot chuoi vao doi tuong hien co
     * @param: String
     * @return: this
     */
    public Document addText(String string) {
        this.text += string;
        this.firstEditText = text.trim();
        this.lastEditText += " " + parseToWord(string.trim());
        return this;
    }

    /**
     * @description: Dem so ky tu xuat hien trong van ban ke ca chu hoa lan chu thuong
     * @param: String character
     * @return: Tra ve so luong ky tu xuat hien hoac tra ve -1 neu loi
     */
    public int countCharater(String character) {
        // Truong hop tham so dau vao la null hoac string co lenght bang 0
        if (character == null || character.length() == 0) return -1;
        // Lay ky tu can tim kiem, chuyen ve dang chu thuong
        char ch = character.toLowerCase().charAt(0);
        // chuyen String ve dang intStream thuc hien loc bang filter
        return (int) firstEditText.toLowerCase().chars().filter(c -> c == (int) ch).count();
    }

    /**
     * @description: phan tich chuoi thang tung tu luu lai ket qua vao lastEditText va numOfWord
     * @param:
     * @return:
     */
    public String parseToWord(String stringNeedParse) {
        if (stringNeedParse == null || stringNeedParse.length() == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder("");
        int cout = 0;
        for (String word : stringNeedParse.split(" ")) {
            if (word.length() > 0) {
                cout++;
                str.append(" " + word);
            }
        }
        numberOfWord += cout;
        str.deleteCharAt(0);
        return str.toString();
    }

    public String getRawText() {
        return text;
    }

    public String getLastEditText() {
        return lastEditText;
    }

    public int getNumberOfWord() {
        return numberOfWord;
    }


}
