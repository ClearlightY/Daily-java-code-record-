package top.clearlight.lucene;

import jdk.internal.org.objectweb.asm.tree.analysis.Analyzer;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

/**
 * Lucene 入门
 * 创建索引
 * 查询索引
 */
public class FirstLucene {

    /**
     * 创建索引
     */
    @Test
    public void testIndex() throws Exception {
        // 第一步: 创建一个java工程, 并导入jar包
        // 第二步: 创建一个indexwriter对象
        Directory directory = FSDirectory.open(new File("F:\\lucene\\index"));
        StandardAnalyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
        IndexWriter indexWriter = new IndexWriter(directory, config);
        //  1) 指定索引库的存放位置Directory对象
        //  2) 指定一个分析器, 对文档内容进行分析
        // 第三步: 创建document对象
        Document document = new Document();
        //        创建field对象, 将field添加到document对象中
        File f = new File("F:\\lucene\\source");
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            // 文件名称
            String file_name = file.getName();
            // Field fileNameField
            // 文件大小
            long file_size = FileUtils.sizeOf(file);
            // 文件路径
            String file_path = file.getPath();
            // 文件内容
            String file_content = FileUtils.readFileToString(file);
        }
        // 第四步: 使用indexwriter对象将document对象写入索引库, 此过程进行索引创建. 并将索引和document对象写入索引库

        // 第五步: 关闭IndexWriter对象
    }

    @Test
    public void test1() {
        ArrayList<Integer> list = new ArrayList<>();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            list.add(i);
        }
        long time1 = System.currentTimeMillis();
        System.out.println("所用时间为：" + (time1 - time));
    }

}
