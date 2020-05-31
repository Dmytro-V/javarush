package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client{

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. " +
                    "Понимаю команды: дата, день, месяц, год, " +
                    "время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String format = null;
            try {
                String[] text = message.split(": ");
                if (text[1].equals("дата")) {
                    format = "d.MM.YYYY";
                } else if (text[1].equals("день")) {
                    format = "d";
                } else if (text[1].equals("месяц")) {
                    format = "MMMM";
                } else if (text[1].equals("год")) {
                    format = "YYYY";
                } else if (text[1].equals("время")) {
                    format = "H:mm:ss";
                } else if (text[1].equals("час")) {
                    format = "H";
                } else if (text[1].equals("минуты")) {
                    format = "m";
                } else if (text[1].equals("секунды")) {
                    format = "s";
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                Date date = Calendar.getInstance().getTime();
                String answer = "Информация для " + text[0] + ": " + simpleDateFormat.format(date);
                sendTextMessage(answer);
            } catch (Exception e) {


            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {

        int x = (int)(Math.random() * 100);
        return "date_bot_" + x;
    }

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }
}
