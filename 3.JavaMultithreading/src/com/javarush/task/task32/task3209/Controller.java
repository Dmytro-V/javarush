package com.javarush.task.task32.task3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {

    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public void init() {
        createNewDocument();
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
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        HTMLFileFilter filter = new HTMLFileFilter();
        chooser.setFileFilter(filter);
        int choose = chooser.showOpenDialog(view);

        if (choose == chooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            resetDocument();
            view.setTitle(currentFile.getName());
            try {
                FileReader fileReader = new FileReader(currentFile);
                HTMLEditorKit editor = new HTMLEditorKit();

                editor.read(fileReader, document, 0);
                view.resetUndo();

                fileReader.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }


    }

    public void saveDocument() {
        view.selectHtmlTab();

        if (currentFile == null) {
            saveDocumentAs();
        } else {
            try {
                FileWriter writer = new FileWriter(currentFile);
                HTMLEditorKit editor = new HTMLEditorKit();

                editor.write(writer, document, 0, document.getLength());
                writer.close();

            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }

    public void saveDocumentAs() {
        view.selectHtmlTab();
        JFileChooser chooser = new JFileChooser();
        HTMLFileFilter filter = new HTMLFileFilter();
        chooser.setFileFilter(filter);
        int choose = chooser.showSaveDialog(view);
        if (choose == chooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());

            try {
                FileWriter writer = new FileWriter(currentFile);
                HTMLEditorKit editor = new HTMLEditorKit();

                editor.write(writer, document, 0, document.getLength());
                writer.close();

            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }

        }

    }
}
