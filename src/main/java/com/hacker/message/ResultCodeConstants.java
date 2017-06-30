package com.hacker.message;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:结果状态码
 */
public class ResultCodeConstants {

    /**
     * 成功
     */
    public static final int SUCCESS = 200;
    /**
     * 请求参数解析失败
     */
    public static final int PARAM_PARSE_ERROR = 201;
    /**
     * 你没发现这个请求不合适么?
     */
    public static final int ERROR=202;

    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("= *(\\d+);");

        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/src/main/java/com/hacker/message/ResultCodeConstants.java");

        File out = new File(dir + "/src/main/resources/result/message.properties");
        BufferedWriter bw = new BufferedWriter(new FileWriter(out));

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {

            if (line.contains("/**")) {
                String msgLine = br.readLine();
                String msg = msgLine.replaceAll("\\*", "").trim();

                String nextLine = br.readLine();
                if (nextLine != null) {
                    nextLine = br.readLine();
                    if (nextLine != null) {

                        Matcher matcher = pattern.matcher(nextLine);
                        if (matcher.find()) {
                            String code = matcher.group(1);
                            String messageLine = code + "=" + msg + "\n";
                            bw.write(messageLine);
                            System.out.print(messageLine);
                        }
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
