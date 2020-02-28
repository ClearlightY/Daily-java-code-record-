package top.clearlight.lucene;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
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
        //        创建field对象, 将field添加到document对象中
        File f = new File("F:\\lucene\\source");
        File[] listFiles = f.listFiles();
        for (File file : listFiles) {
            // 第三步: 创建document对象
            Document document = new Document();
            // 文件名称
            String file_name = file.getName();
            Field fileNameField = new TextField("fileName", file_name, Field.Store.YES);
            // 文件大小
            long file_size = FileUtils.sizeOf(file);
            Field fileSizeField = new LongField("fileSize", file_size, Field.Store.YES);
            // 文件路径
            String file_path = file.getPath();
            Field filePathField = new StoredField("filePath", file_path);
            // 文件内容
            String file_content = FileUtils.readFileToString(file);
            Field fileContentField = new TextField("fileContent", file_content, Field.Store.NO);
            document.add(fileNameField);
            document.add(fileSizeField);
            document.add(filePathField);
            document.add(fileContentField);
            // 第四步: 使用indexwriter对象将document对象写入索引库, 此过程进行索引创建. 并将索引和document对象写入索引库
            indexWriter.addDocument(document);
        }
        // 第五步: 关闭IndexWriter对象
        indexWriter.close();
    }

    @Test
    public void testSearch() throws Exception {
        // 第一步: 创建一个Directory对象, 也就是索引库存放的位置
        Directory directory = FSDirectory.open(new File("F:\\lucene\\index"));
        // 第二步: 创建一个indexReader对象, 需要指定Directory对象
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步: 创建一个indexsearch对象, 需要指定IndexReader对象
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        // 第四步: 创建一个TermQuery对象, 指定查询的域和查询的关键词
        Query query = new TermQuery(new Term("fileName", "txt"));
        // 第五步: 执行查询
        TopDocs topDocs = indexSearcher.search(query, 2);
        // 第六步: 返回查询结果. 遍历查询结果并输出
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (ScoreDoc scoreDoc : scoreDocs) {
            int doc = scoreDoc.doc;
            Document document = indexSearcher.doc(doc);
            // 文件名称
            String fileName = document.get("fileName");
            System.out.println(fileName);
            // 文件内容
            String fileContent = document.get("fileContent");
            System.out.println(fileContent);
            // 文件大小
            String fileSize = document.get("fileSize");
            System.out.println(fileSize);
            // 文件路径
            String filePath = document.get("filePath");
            System.out.println(filePath);
            System.out.println("------------------");
        }
        // 第七步: 关闭IndexReader对象
        indexReader.close();
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
