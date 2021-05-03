package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {

            Message receiveMessage;

            do {
                connection.send(new Message(MessageType.NAME_REQUEST));
                receiveMessage = connection.receive();
            } while (receiveMessage.getType() != MessageType.USER_NAME ||
                    receiveMessage.getData().isEmpty() ||
                    connectionMap.containsKey(receiveMessage.getData()));
            connectionMap.put(receiveMessage.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "name is accepted"));

            return receiveMessage.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String key : connectionMap.keySet()) {
                if (key.equals(userName)) {
                    continue;
                } else {
                    connection.send(new Message(MessageType.USER_ADDED, key));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                if (receiveMessage.getType() == MessageType.TEXT) {
                    String text = userName + ": " + receiveMessage.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, text));
                } else {
                    ConsoleHelper.writeMessage("ошибка");
                }
            }

        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("установлено соединение с сервером" + socket.getRemoteSocketAddress());
            String userName = null;
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("произошла ошибка при обмене данными с удаленным адресом");
            }

            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
        }
    }
    
    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("не смогли отправить сообщение");
            }
        }
    }

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())){
            ConsoleHelper.writeMessage("сервер запущен");

            while (true) {
                (new Handler(serverSocket.accept())).start();
            }


        } catch (Exception e) {
            System.out.println("ошибка");
        }


    }

}
