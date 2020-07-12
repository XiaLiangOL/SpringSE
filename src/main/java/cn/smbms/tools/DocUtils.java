/**
 * Copyright (c) 2013-2020, liang 梁越标 (2780613808@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.smbms.tools;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <b>DocUtils.java</b></br>
 * <pre></pre>
 *
 * @author liang 1044559878@qq.com 
 * @date 2020年07月06日 0:02:00
 * @since JDK 1.8
 */
public class DocUtils {


    public static void readAndWriterTest3(){
        File file = new File("e:\\xqy\\2020-07-01 活动商品数据库设计.doc");
        String str = "";
        try {
            FileInputStream fis = new FileInputStream(file);
            HWPFDocument doc = new HWPFDocument(fis);
            String doc1 = doc.getDocumentText();
            System.out.println(doc1);
            StringBuilder doc2 = doc.getText();
            System.out.println(doc2);
            Range rang = doc.getRange();
            String doc3 = rang.text();
            System.out.println(doc3);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDocContent(File docFile){
        FileInputStream docFis;
        String text = null;
        try {
            docFis = new FileInputStream(docFile);
            HWPFDocument doc = new HWPFDocument(docFis);
                        Range rang = doc.getRange();
            text = rang.text();
            docFis.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        File file = new File("e:\\xqy\\2020-07-01 活动商品数据库设计.doc");

        String docContent = getDocContent(file);
        System.out.println(docContent);
        readAndWriterTest3();
    }
}
