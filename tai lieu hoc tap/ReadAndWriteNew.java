package ss16_IO_text.student_manager1.util;

import ss16_IO_text.student_manager1.model.Facility;
import ss16_IO_text.student_manager1.model.Student;
import ss16_IO_text.student_manager1.model.Teacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteNew {
    private static void writeListStringToCSV(List<String> stringList, String pathFile, boolean append){
        File file = new File(pathFile);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            // ghi một chuỗi vào file
            for ( String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeListStudentToCSV(List<Student> studentList, String pathFile, boolean append){
       List<String> stringList = new ArrayList<>();
       for (Student student: studentList){
           stringList.add(student.getInfoToCSV());
       }
       writeListStringToCSV(stringList,pathFile,append);
    }
    public static void writeListTeacherToCSV(List<Teacher> teacherList, String pathFile, boolean append){
        List<String> stringList = new ArrayList<>();
        for (Teacher teacher: teacherList){
            stringList.add(teacher.getInfoToCSV());
        }
        writeListStringToCSV(stringList,pathFile,append);
    }
    public static void writeListFacilityToCSV(Map<Facility,Integer> facilityIntegerMap, String pathFile, boolean append){
        List<String> stringList = new ArrayList<>();
        Set<Facility> facilities = facilityIntegerMap.keySet();
        for (Facility facility: facilities) {
            stringList.add(facility.getInfoToCSV()+","+facilityIntegerMap.get(facility));
        }
        writeListStringToCSV(stringList,pathFile,append);
    }

// file chung
private static List<String> readStringFileCSV(String pathFile) {
    List<String> stringList = new ArrayList<>();
    File file = new File(pathFile);
    FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    String line = "";
    try {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            stringList.add(line);
        }
        bufferedReader.close();

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
    }
    return stringList;
}
// file riêng
    public static List<Student> readStudentFileCSV(String pathFile){
        List<Student> studentList = new ArrayList<>();
        List<String> stringList = readStringFileCSV(pathFile);
        String[] array=null;
        for (String string: stringList) {
            array =string.split(",");
            Student student = new Student(Integer.parseInt(array[0]),array[1],array[2],
                    Integer.parseInt(array[3]));
            studentList.add(student);
        }
        return studentList;
}
}
