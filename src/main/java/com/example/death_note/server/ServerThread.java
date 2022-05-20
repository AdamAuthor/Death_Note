package com.example.death_note.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = (PackageData) inputStream.readObject();
            while (packageData != null) {

                if (packageData.getOperationType().equals("LOGIN")) {
                    try {
                        if (packageData.getLogin().equals("ryuk") && packageData.getPassword().equals("apple")) {
                            PackageData toClient = new PackageData("SHINIGAMI");
                            outputStream.writeObject(toClient);
                        } else if (packageData.getLogin().equals("kira") && packageData.getPassword().equals("god")) {
                            PackageData toClient = new PackageData("OWNER");
                            outputStream.writeObject(toClient);
                        } else {
                            PackageData toClient = new PackageData("");
                            outputStream.writeObject(toClient);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
//                else if (packageData.getOperationType().equals("FIND")) {
//                    String title = packageData.getPublicationName();
//                    for (Publication publicFind : publication) {
//                        if (publicFind.getTitle().equals(title)) {
//                            try {
//                                PackageData toClient = new PackageData(publicFind);
//                                outputStream.writeObject(toClient);
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//
//                        } else {
//                            try {
//                                outputStream.writeObject("");
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                } else if (packageData.getOperationType().equals("READER_ADD")) {
//                    try {
//                        reader.add(packageData.getReader());
//                        BufferedWriter appendWriter = new BufferedWriter(new FileWriter("readers.txt", true));
//                        Reader lastReader = reader.get(reader.size() - 1);
//                        String readS = lastReader.personInfo() + "\n";
//
//                        appendWriter.write(readS);
//                        appendWriter.close();
//
//                    } catch (Exception exception){
//                        exception.printStackTrace();
//                    }
//
//                } else if (packageData.getOperationType().equals("READER_DELETE")) {
//                    for (int i = 0; i < reader.size(); i++) {
//                        Reader readerDel = reader.get(i);
//                        if (readerDel.getPersonID() == packageData.getReaderID()) {
//                            reader.remove(i);
//                            try {
//                                BufferedWriter writerReader = new BufferedWriter(new FileWriter("readers.txt"));
//                                String readerStr = "";
//
//                                for (Reader readerr : reader) {
//                                    readerStr += readerr.personInfo() + "\n";
//                                }
//
//                                writerReader.write(readerStr);
//                                writerReader.close();
//
//                            } catch (Exception exception) {
//                                exception.printStackTrace();
//                            }
//                        }
//                    }
//
//                } else if (packageData.getOperationType().equals("READER_DISPLAY")) {
//                    try {
//                        PackageData toClient = new PackageData(reader, true);
//                        outputStream.writeObject(toClient);
//
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
            }
            outputStream.close();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
