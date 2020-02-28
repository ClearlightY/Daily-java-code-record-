package top.clearlight.lucene;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;

public class LuceneManager {
    public IndexSearcher getIndexSearcher() throws Exception {
        // 第一步: 创建一个Directory对象, 也就是索引库存放的位置
        Directory directory = FSDirectory.open(new File("F:\\lucene\\index"));
        // 第二步: 创建一个IndexReader对象, 需要指定Directory对象.
        IndexReader indexReader = DirectoryReader.open(directory);
        // 第三步: 创建一个indexsearcher对象, 需要指定IndexReader对象
        return new IndexSearcher(indexReader);
    }

    // 执行查询的结果
    public void printResult(IndexSearcher indexSearcher, Query query) throws Exception {
        // 第五步: 执行查询
        TopDocs topDocs = indexSearcher.search(query, 10);
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
    }

    // 查询所有
    @Test
    public void testMatchAllDocsQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        Query query = new MatchAllDocsQuery();
        printResult(indexSearcher, query);

        // 关闭资源
        indexSearcher.getIndexReader().close();
    }

    // 根据数值范围查询
    @Test
    public void testNumericRangeQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        Query query = NumericRangeQuery.newLongRange("fileSize", 6944L, 200000L, true, true);
        printResult(indexSearcher, query);
        System.out.println(query);
        // 关闭资源
        indexSearcher.getIndexReader().close();

    }

    // 可以组合查询条件
    @Test
    public void testBooleanQuery() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        BooleanQuery booleanQuery = new BooleanQuery();
        Query query1 = new TermQuery(new Term("fileContent", "1"));
        Query query2 = new TermQuery(new Term("fileContent", "基础知识第10版"));
        booleanQuery.add(query1, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query2, BooleanClause.Occur.MUST);
        printResult(indexSearcher, query1);
        System.out.println(booleanQuery);
        // 关闭资源
        indexSearcher.getIndexReader().close();
    }

    // 条件解释的对象查询
    @Test
    public void testQueryParser() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();
        // 参数1: 默认查询的域
        // 参数2: 采用的分析器
        QueryParser qeuryParser = new QueryParser("fileName", new StandardAnalyzer());
        // *:* 域:值
        Query query = qeuryParser.parse("目 is txt");
        System.out.println(query);
        printResult(indexSearcher, query);

        // 关闭资源
        indexSearcher.getIndexReader().close();
    }

    // 条件解析的对象查询 多个默认域
    @Test
    public void testMultiFieldQueryParser() throws Exception {
        IndexSearcher indexSearcher = getIndexSearcher();

        String[] fields = {"fileName", "fileContent"};
        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, new StandardAnalyzer());
        // *:* 域:值
        Query query = queryParser.parse("fileName:J OR fileName:txt");

        printResult(indexSearcher, query);
        // 关闭资源
        indexSearcher.getIndexReader().close();
    }
}
