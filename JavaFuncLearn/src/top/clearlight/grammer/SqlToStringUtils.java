package top.clearlight.grammer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * 寫好的 SQL要站到代碼中, 每行需要添加引號, 該類可以直接給每行開頭和末尾去除空白字符後添加引號, 處第一行開頭還會添加 + , 末尾添加 ; ,
 * 經過該類處理, 可以直接將生成的sql 粘貼到代碼中
 * 
 * 示例: 
 * with node as(
 *  select wage.Agent_Effective_Type(a.agentcode, f.ym) packagetype,
 * 
 * 處理後:
 * " with node as( "  
 * + "select wage.Agent_Effective_Type(a.agentcode, f.ym) as packagetype, " ; 
 * 
 * @Time 2020-12-29
 * @author xyLi
 *
 */
public class SqlToStringUtils {
	// 效率高
	public static void readTxtFile(String filePath) {
		try {
			File sqlFile = new File(filePath);
			String path = "E:\\SqlToStringUtil\\sqlToString.txt";
			File stringFile = new File(path);
			// 如果文件不存在, 則自動創建
			if (!stringFile.exists()) {
				stringFile.createNewFile();
			}
			FileOutputStream outputStream;
			outputStream = new FileOutputStream(stringFile);
			StringBuilder stringBuilder = new StringBuilder();
			if (sqlFile.isFile() && sqlFile.exists()) {
				InputStreamReader isr = new InputStreamReader(new FileInputStream(sqlFile), "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String lineTxt = null;
				int lineNum = 1;
				while ((lineTxt = br.readLine()) != null) {

					// 刪除每行的開始和結尾的空行
					lineTxt = lineTxt.trim();
					// 若該行為注釋, 則添加//
					if (lineTxt.startsWith("--")) {
						stringBuilder.append("// " + lineTxt + " " + " \n ");
					} else {
						// 該行若包含--,有注釋則在--之前 添加//提前注釋掉
						int charIndex = lineTxt.indexOf("--");
						if (charIndex == -1) { // 不含 --
							if (lineNum == 1) { // 首行的處理, 不添加 +
								stringBuilder.append(" \" " + lineTxt + " \" " + " \n ");
								lineNum = -1;
								continue;
							}
							System.out.println(lineTxt);
							stringBuilder.append("+ \"" + lineTxt + " \" " + " \n ");
						} else {
							if (lineNum == 1) {
								stringBuilder.append(" \" " + lineTxt.replace("--", " \" // --") + " \" " + " \n ");
								lineNum = -1;
								continue;
							}
							System.out.println(lineTxt);
							stringBuilder.append("+ \"" + lineTxt.replace("--", " \" // --") + " \" " + " \n ");
						}

					}
				}
				// 字符串結尾添加分號
				stringBuilder.append(";");
				// 將字符串寫入文件中
				String context = stringBuilder.toString();
				byte[] bytes = context.getBytes("UTF-8");
				outputStream.write(bytes);
				br.close();
				outputStream.close();
				System.out.println("文本轉換成功!");
			} else {
				System.out.println("文件不存在!");
			}
		} catch (Exception e) {
			System.out.println("文件读取错误!");
		}
	}

	public static void main(String[] args) {
		readTxtFile("E:\\SqlToStringUtil\\sheet1.txt");
	}

}
