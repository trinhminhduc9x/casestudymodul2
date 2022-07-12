package ss16_IO_text.student_manager1.common;

public class CheckingValidate {
    public static boolean checkId(String id){
        String regexId = "^\\d+$";
        return id.matches(regexId);
    }
}
