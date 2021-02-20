package com.javarush.task.task33.task3309;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringWriter;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, ParserConfigurationException, IOException, SAXException, TransformerException {

        //object to XML
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


        //XML to Document
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setCoalescing(true);
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc  = db.newDocument();

        marshaller.marshal(obj, doc);

        //edit document
        NodeList list = doc.getElementsByTagName(tagName);


        for (int i = 0; i < list.getLength(); i++) {
            Node commentNode = doc.createComment(comment);

            Node node = list.item(i);
            Node parentNode = node.getParentNode();

            parentNode.insertBefore(commentNode, node);
            node.getParentNode().insertBefore(doc.createTextNode("\n"), node);
        }

        //DOM to text
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

        DOMSource source = new DOMSource(doc);
        StringWriter writer = new StringWriter();
        transformer.transform(source, new StreamResult(writer));

        return writer.toString();
    }

    public static void main(String[] args) throws JAXBException, ParserConfigurationException, TransformerException, IOException, SAXException {
        System.out.println(Solution.toXmlWithComment(new First(), "second", "it's a comment"));
    }
}
