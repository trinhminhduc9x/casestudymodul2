package ss16_io_text_file.practice;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ReadAndWriteFile {
    public static List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }
    public void writeFile(String filePath, int max){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Giá trị lớn nhất là: " + max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
//       System.out.println("Nhập đường dẫn file: ");
//        Scanner scanner = new Scanner(System.in);
        String path = "src/ss16_io_text_file/practice/test.txt";
//        String path2 = scanner.nextLine();
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
//        List<Integer> numbers = readAndWriteFile.readFile("numbers.txt");
        List<Integer> numbers = readAndWriteFile.readFile(path);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("result.txt", maxValue);
    }
}
