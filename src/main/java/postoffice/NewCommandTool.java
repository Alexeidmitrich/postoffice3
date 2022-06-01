package postoffice;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewCommandTool{
    private PostofficeRefactoring postofficeRefactoring;

    public void parseCommand(String command) {
        final String addPostoffice = "(addpostoffice)";
        final String addNumberPostoffice = "(addnumberpostoffice) ([0-9]+;[a-zA-Z\\sа-яА-Я\\W$]+)";
        final String addClient = "(addclient) ([a-zA-Zа-яА-Я\\/-]+;[a-zA-Zа-яА-Я\\/-]+;[0-9]+)";
        final String addPostitem = "(addpostitem) ([0-9.]+;[0-9.]+;[0-9]+;[0-9]+;[0-9]+;[0-9]+;[a-zA-Zа-яА-Я]+;[0-9]+)";
        final String addTransport = "(addtransport) ([0-9]+;[a-zA-Zа-яА-Я\\/-]+;[0-9]+)";
        Matcher  matcher = isPatternMatches(command, addPostoffice);
        if (matcher.find()) {
            String data = matcher.group(1);
            System.out.println(data);
            postofficeRefactoring = new PostofficeRefactoring();
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addNumberPostoffice);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] numberDate = data.split(";");
            int id = Integer.parseInt(numberDate[0]);
            postofficeRefactoring.addNumberPostoffice(id, numberDate[1]);
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
            int typePostitemId = Integer.parseInt(postitemDate[6]);
            int postOffice_id = Integer.parseInt(postitemDate[7]);
            postofficeRefactoring.addPostitem(departureDate,arrivalDate,weight, price, idRecipient, idSender, typePostitemId, postOffice_id);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addTransport);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] transportDate = data.split(";");
            int id = Integer.parseInt(transportDate[0]);
            int idPostitem = Integer.parseInt(transportDate[2]);
            postofficeRefactoring.addTransport(id, transportDate[1], idPostitem);
            System.out.println("Ok");
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
