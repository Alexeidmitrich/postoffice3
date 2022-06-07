package postoffice;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCommandTool{
    private PostofficeRefactoring postofficeRefactoring;

    public NewCommandTool(){
        postofficeRefactoring = new PostofficeRefactoring();
    }
    public void parseCommand(String command) {
        final String addNumberPostoffice = "(addnumberpostoffice) ([a-zA-Z\\sа-яА-Я\\W$]+)";
        final String addClient = "(addclient) ([a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9]+)";
        final String addTypePostitem = "(addtypepostitem) ([a-zA-Zа-яА-Я]+)";
        final String addPostitem = "(addpostitem) ([0-9.-]+;[0-9.-]+;[0-9]+;[0-9]+;[0-9]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addTransport = "(addtransport) ([a-zA-Zа-яА-Я\\/-]+;[0-9]+)";
        final String addAddress = "(addaddress) ([a-zA-Zа-яА-Я-0-9]+;[a-zA-Z\\sа-яА-Я\\W$0-9]+;[0-9]+)";
        final String printAllItem = "(printallitem)";
        final String printInfoItem = "(printinfoitem) ([0-9]+)";
        final String printItemByName = "(printitembyname) ([a-zA-Z\\sа-яА-Я\\W$0-9]+;[a-zA-Z\\sа-яА-Я\\W$0-9]+)";
        Matcher  matcher = isPatternMatches(command, addNumberPostoffice);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] numberDate = data.split(";");
            postofficeRefactoring.addNumberPostoffice(numberDate[0]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addClient);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] clientDate = data.split(";");
            int postid = Integer.parseInt(clientDate[2]);
            postofficeRefactoring.addClient(clientDate[0], clientDate[1], postid);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addTypePostitem);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] typeDate = data.split(";");
            postofficeRefactoring.addTypePostitem(typeDate[0]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addPostitem);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] postitemDate = data.split(";");
            Date departureDate = Date.valueOf(postitemDate[0]);
            Date arrivalDate = Date.valueOf(postitemDate[1]);
            int weight = Integer.parseInt(postitemDate[2]);
            int price = Integer.parseInt(postitemDate[3]);
            int idRecipient = Integer.parseInt(postitemDate[4]);
            int idSender = Integer.parseInt(postitemDate[5]);
             String typePostitem = postitemDate[6];
            int postOffice_id = Integer.parseInt(postitemDate[7]);
            postofficeRefactoring.addPostitem(departureDate.toLocalDate(),arrivalDate.toLocalDate(),weight, price, idRecipient, idSender, typePostitem, postOffice_id);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addTransport);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] transportDate = data.split(";");
            int idPostitem = Integer.parseInt(transportDate[1]);
            postofficeRefactoring.addTransport(transportDate[0], idPostitem);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addAddress);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] addressDate = data.split(";");
            int idClient = Integer.parseInt(addressDate[6]);
            postofficeRefactoring.addAddress(addressDate[0], addressDate[1], addressDate[2], addressDate[3], addressDate[4],addressDate[5], idClient);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, printAllItem);
        if(matcher.find()){
            String data = matcher.group(1);
            System.out.println(data);
            postofficeRefactoring.printAllItem();
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printInfoItem);
        if(matcher.find()){
            String data = matcher.group(2);
            System.out.println(data);
            String[] infoData = data.split(";");
            int typePostitem_id = Integer.parseInt(infoData[0]);
            postofficeRefactoring.printInfoItem(typePostitem_id);
            System.out.println("OK");
        }
        matcher = isPatternMatches(command, printItemByName);
        if(matcher.find()){
            String data = matcher.group(2);
            System.out.println(data);
            String[] nameData = data.split(";");
            postofficeRefactoring.printItemByLastname(nameData[0],nameData[1]);
            System.out.println("OK");
        }
    }
    public Matcher isPatternMatches(String command, String regex){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(command);
        return matcher;
    }
    public static void main(String[] args) {
        NewCommandTool commandTool = new NewCommandTool();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please, type a command");
            String command = sc.nextLine();
            commandTool.parseCommand(command);
        }
    }
}
