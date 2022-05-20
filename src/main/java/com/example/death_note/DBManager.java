package com.example.death_note;

import com.example.death_note.elements.Killed;
import com.example.death_note.elements.Owner;
import com.example.death_note.elements.Shinigami;
import com.example.death_note.elements.User;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost/death_note";
    public static final String user = "adamauthor";
    public static final String password = "A05092003a";
    public static Connection connection;

    public static void connect() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("DB connected successful!");
        } catch (Exception e) {
            System.out.println("Error with connection!");
            e.printStackTrace();
        }
    }

    public static void kill(Killed killed) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.killed \n" +
                    "(name, surname, gender, nationality, age) \n" +
                    "VALUES (?, ?, ?, ?, ?)");

            statement.setString(1, killed.getName());
            statement.setString(2, killed.getSurname());
            statement.setString(3, killed.getGender());
            statement.setString(4, killed.getNationality());
            statement.setInt(5, killed.getAge());

            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resurrect(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM public.killed\n" +
                    "WHERE id = ?");

            statement.setLong(1, id);
            int rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Killed> read() {
        ArrayList<Killed> killeds = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.killed");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String gender = resultSet.getString("gender");
                String nationality = resultSet.getString("nationality");
                int age = resultSet.getInt("age");
                killeds.add(new Killed(id, name, surname, gender, nationality, age));
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return killeds;
    }

    public static ArrayList<User> signIn() {
        ArrayList<User> users = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.owwner");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String login = resultSet.getString("Login");
                String password = resultSet.getString("password");
                users.add(new Owner(login, password));
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.shinigami");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                users.add(new Shinigami(login, password));
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void addOwner(Owner owner) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO public.owwner \n" +
                    "(login, password, lefttolive) \n" +
                    "VALUES (?, ?, ?)");

            statement.setString(1, owner.getLogin());
            statement.setString(2, owner.getPassword());
            statement.setInt(3, owner.getLeftToLive());

            int rows = statement.executeUpdate();
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Owner> killOwner() {
        ArrayList<Owner> owners = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM public.owwner");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String login = resultSet.getString("login");
                String password1 = resultSet.getString("password");
                int leftToLive = resultSet.getInt("leftToLive");
                owners.add(new Owner(login, password1, leftToLive));
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return owners;
    }
}
