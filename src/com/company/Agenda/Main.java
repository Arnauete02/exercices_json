package com.company.Agenda;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    //public static Path json = Paths.get("/home/users/inf/wiam2/iam26067874/Documentos/M06/exercices_json/src/com/company/file.json");
    public static Path json = Paths.get("C:\\Users\\arnau\\Documents\\DAM\\M06\\exercices_json\\src\\com\\company\\Agenda\\file.json");
    public static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    static class Agenda{
        List<Contact> contactList = new ArrayList<>();
    }

    static class Contact{
        public String name;
        public String phone;
        public String mail;
    }

    /*
     * args[0] -> Program.java
     * args[1] -> funcion
     * args[2] -> contact_name
     * args[3] -> contact_phone
     * args[4] -> contact_mail
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);

        Contact contact = new Contact();
        contact.name = args[2];
        contact.phone = args[3];
        contact.mail = args[4];

        if (args[1].equals("add")){
            add(contact);
        } else if (args[1].equals("del")) {
            del(contact.name);
        } else if (args[1].equals("list")) {
            list();
        } else if (args[1].equals("find")) {
            find(contact.mail);
        }

    }

    public static void add(Contact contact) throws IOException {
        Agenda agenda;
        try { agenda = objectMapper.readValue(json.toFile(), Agenda.class); }
        catch (Exception error) { agenda = new Agenda(); }

        boolean isFound = false;

        for (Contact c : agenda.contactList){
            if (c.name.equals(contact.name)){
                c.phone = contact.phone;
                c.mail = contact.mail;
                isFound = true;
                break;
            }
        }

        if (!isFound){
            agenda.contactList.add(contact);
        }
        objectMapper.writeValue(json.toFile(), agenda);
    }

    public static void del(String name) throws IOException {
        Agenda agenda;
        try { agenda = objectMapper.readValue(json.toFile(), Agenda.class); }
        catch (Exception e) { agenda = new Agenda(); }

        for (Contact c : agenda.contactList) {
            if (c.name.equals(name)){
                agenda.contactList.remove(c);
                break;
            }
        }

        objectMapper.writeValue(json.toFile(), agenda);
    }

    public static void list(){
        Agenda agenda;
        try { agenda = objectMapper.readValue(json.toFile(), Agenda.class); }
        catch (Exception e) { agenda = new Agenda(); }

        for (Contact c : agenda.contactList) { System.out.println(c.toString()); }
    }

    public static void find(String mail){
        Agenda agenda;
        try { agenda = objectMapper.readValue(json.toFile(), Agenda.class); }
        catch (Exception e) { agenda = new Agenda(); }

        for (Contact c : agenda.contactList) {
            if (c.mail.equals(mail)){
                agenda.contactList.add(c);
            }
        }

        System.out.println(agenda.contactList.toString());
    }
}
