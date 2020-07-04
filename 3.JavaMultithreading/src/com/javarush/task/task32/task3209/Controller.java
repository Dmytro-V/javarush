package com.javarush.task.task32.task3209;

import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {

    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();

    }

    public void resetDocument() {

        if (document != null) {
            document.removeUndoableEditListener(view.getUndoListener());
        }
        
        HTMLEditorKit editor = new HTMLEditorKit();
        document = (HTMLDocument) editor.createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text) {
        resetDocument();
        StringReader stringReader = new StringReader(text);
        HTMLEditorKit editor = new HTMLEditorKit();
        try {
            editor.read(stringReader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText() {
        StringWriter writer = new StringWriter();
        HTMLEditorKit editor = new HTMLEditorKit();
        try {
            editor.write(writer, document, 0, document.getLength());

        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return writer.toString();
    }

    public void createNewDocument() {

    }

    public void openDocument() {

    }

    public void saveDocument() {

    }

    public void saveDocumentAs() {

    }
}
