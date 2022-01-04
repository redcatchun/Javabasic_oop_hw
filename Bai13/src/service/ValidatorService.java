package service;

import exception.*;

import java.time.LocalDate;

public class ValidatorService {
    //Check ngay sinh
    public static void birthdayCheck(LocalDate birthday) throws BirthDayException {
        if (birthday.isAfter(LocalDate.now())) throw new BirthDayException("Ngay sinh khong hop le");
        else if (LocalDate.now().getYear() - birthday.getYear() < 15)
            throw new BirthDayException("Chua du tuoi lam viec");
    }

    //Check SDT
    public static void phoneCheck(String phone) throws PhoneException {
        try {
            Long.parseUnsignedLong(phone);
        } catch (NumberFormatException e) {
            throw new PhoneException("So dien thoai khong hop le");
        }
        if (phone.length() < 9) throw new PhoneException("So dien thoai khong du ky tu");

    }

    //Check email
    public static void emailCheck(String email) throws EmailException {
        boolean ok = false;
        String editM = email.trim();
        int l = editM.length() - 1;
        if (l > 5) {
            boolean check1 = (editM.charAt(0) > 64 && editM.charAt(0) < 91) || (editM.charAt(0) > 96 && editM.charAt(0) < 123);
            boolean check2 = (editM.charAt(l) > 64 && editM.charAt(l) < 91) || (editM.charAt(l) > 96 && editM.charAt(l) < 123);
            if (check1 && check2) {
                String[] mailPart = email.split("@");
                if (mailPart.length == 2) {
                    String[] dotCom = mailPart[1].split("\\.");
                    if (dotCom.length > 1 && dotCom[0].length() > 0) ok = true;
                }
            }
        }
        if (!ok) throw new EmailException("Email khong hop le");
    }

    // Check ten
    public static void nameCheck(String name) throws FullNameException {
        String editN = name.trim().toLowerCase();
        if(editN.chars().anyMatch(ch->ch!=32&&(ch<97||ch>122))) throw new FullNameException("Ten chua ky tu khong hop le");
    }
}
