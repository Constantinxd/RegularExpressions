import java.util.regex.*;

public class RegularExpressions {
    public static void main(String[] args) {
        System.out.println(isValidPassword("C00l_Pass"));
        System.out.println(isValidPassword("SupperPas1"));
        System.out.println(isValidPassword("SupperPas1."));
        System.out.println(isValidPassword("Pass2"));
        System.out.println(isValidPassword("wwwwsssss"));
        System.out.println(isValidPassword("wwwwssssS"));
        System.out.println(isValidPassword("just text"));
    }

    public static boolean isIPv4(String ip) {
        return Pattern.matches("^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9][\\d]|\\d)\\.){3}(25[0-5]|2[0-4][\\d]|1\\d{2}|[1-9][\\d]|\\d)$", ip);
    }

    public static boolean isGUID(String guid) {
        return Pattern.matches("^[({\\[]?[a-fA-F\\d]{8}-([a-fA-F\\d]{4}-){3}[a-fA-F\\d]{12}[)}\\]]?$", guid);
    }

    public static boolean isURL(String url) {
        String regex = "^(https?:\\/\\/)?" + //protocol
                "((([a-zA-Z\\d][a-zA-Z\\d\\-]{0,61}[a-zA-Z\\d]\\.)+([a-zA-Z]{2,11}))|" + //domain, sub-domain
                "(([а-яА-ЯеЁ\\d][а-яА-ЯеЁ\\d\\-]{0,61}[а-яА-ЯеЁ\\d]\\.)+([а-яА-ЯеЁ]{2,11})))" +
                "(:(\\d{1,4}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-6]))?" + //port
                "((\\/(\\.?[\\w\\-])+)|(\\/(\\.?[а-яА-ЯеЁ\\d\\_\\-])+))*" + //directory, file-name
                "\\/?(\\?(\\&?[\\w]+\\=[а-яА-ЯеЁ\\w\\-\\+\\%\\.\\:]+)+)?" + //GET-request
                "((#[\\w\\-]+)|(#[а-яА-ЯеЁ\\d\\_\\-]+))?$"; //anchor

        return Pattern.matches(regex, url);
    }

    public static boolean isValidPassword(String password) {
        return Pattern.matches("^(?=\\w*[a-z])(?=\\w*[A-Z])(?=\\w*\\d)\\w{8,}$", password);
    }
}

/*
 System.out.println(isIPv4("100.222.222.111"));
        System.out.println(isIPv4("127.0.0.1"));
        System.out.println(isIPv4("255.255.255.255"));
        System.out.println(isIPv4("0.0.0.0"));
        System.out.println(isIPv4("90.135.67.255"));
        System.out.println(isIPv4("1100.2.2.2"));
        System.out.println(isIPv4("0.0.0.256"));
        System.out.println(isIPv4("just text"));
        System.out.println(isIPv4("-1.0.0.22"));
        System.out.println(isIPv4("1.1.1.1.1"));
        System.out.println(isIPv4("173.44.572.22"));
        System.out.println(isIPv4("1.2.3.4."));
 */

/*
System.out.println(isGUID("ac556b4a-cfd4-456c-ac35-a74e9f17e3e6"));
        System.out.println(isGUID("ecd3a799-2c4f-4273-9ec4-7d36429743fa"));
        System.out.println(isGUID("461e8cb5-2bbc-4e21-83ad-85a9eed9b08b"));
        System.out.println(isGUID("b711a2e7-4bfc-48ad-be7e-f9c32a5b6a45"));
        System.out.println(isGUID("e36dc3e3-fa36-4453-8350-21b3c5de430a"));
        System.out.println(isGUID("a6b0d1a5-ae13-4ec3-a367-a433bea67a32"));
        System.out.println(isGUID("b0047e12-b6a4-448d-b87d-cafd9b4f6e28"));
        System.out.println(isGUID("d8aac6d3-7fb3-442d-9e97-0b1c62d32e52"));
        System.out.println(isGUID("2863338b-4c77-42e3-b41d-c2cbf81f43b0"));
        System.out.println(isGUID("5cd6caa5-0f9d-402a-9871-3d7c6a558ffc"));
        System.out.println(isGUID("00000000-0000-0000-0000-000000000000"));

        System.out.println(isGUID("G286338b-4c77-42e3-b41d-c2cbf81f43b0"));
        System.out.println(isGUID(".cd6caa5-0f9d-402a-9871-3d7c6a558ffc"));
        System.out.println(isGUID("2863338b-477-42e3-b41d-c2cbf81f43b0"));
        System.out.println(isGUID("5 cd6caa5-0f9d-402a-9871-3d7c6a558ffc"));
        System.out.println(isGUID("just text"));
 */

/*
System.out.println(isURL("https://www.youtube.com/watch?v=oHv6Wf4LmEY"));
        System.out.println(isURL("http://www.quizful.net/interview/java/passing-parameters-reference-value/"));
        System.out.println(isURL("https://www.youtube.com/watch?v=fp5-XQFr_nk"));
        System.out.println(isURL("https://www.youtube.com/watch?v=fp5-XQFr_nk"));
        System.out.println(isURL("https://www.youtube.com/watch/"));
        System.out.println(isURL("https://regexr.com/"));
        System.out.println(isURL("https://regexr.com"));
        System.out.println(isURL("https://metanit.com/java/tutorial/7wdwawd.awd4wd.php"));
        System.out.println(isURL("https://translate.yandex.ru/?lang=ru-en&text=метка%20тома"));
        System.out.println(isURL("https://javarush.ru/groups/posts/709-mnozhestvennoe-nasledovanie-v-java--sravnenie-kompozicii-i-nasledovanija"));
        System.out.println(isURL("http://mindhalls.ru/java-extends-implements-differences/"));
        System.out.println(isURL("https://yandex.ru/search/?text=throws+java+и+implements&lr=46&clid=2270455&win=444&src=suggest_Nin"));
        System.out.println(isURL("https://github.com/cyberspacedk/Git-commands"));
        System.out.println(isURL("https://yandex.ru/search/?text=типы+файлов+linux&lr=46&clid=2270455&win=444"));
        System.out.println(isURL("https://yandex.ru/search/xml?user=xml-search-user&key=03.44583456:c876e1b098gh65khg834ggg1jk4ll9j8&query=%3Ctable%3E&groupby=attr%3Dd.mode%3Ddeep.groups-on-page%3D5.docs-in-group%3D3&maxpassages=3&page=1"));
        System.out.println(isURL("https://javarush.ru/quests/lectures/questsyntaxpro.level11.lecture02"));
        System.out.println(isURL("https://ru.wikibooks.org/wiki/Регулярные_выражения"));
        System.out.println(isURL("https://www.gosuslugi.ru/"));
        System.out.println(isURL("https://zen.yandex.ru/media/id/592d68efe3cda8a0bf8d4d60/domeny-na-kirillice-stoit-li-5f9920bc73193b2ea3c301b0"));
        System.out.println(isURL("https://саперонлайн.рф"));
        System.out.println(isURL("http://ыы.рф/"));
        System.out.println(isURL("https://github.com/Constantinxd"));
        System.out.println(isURL("http://ru.battleship-game.org/id74705211"));
        System.out.println(isURL("http://www.iana.org/domains/root/db"));
        System.out.println(isURL("https://www.apple.com/ru/iphone-13-pro/"));
        System.out.println(isURL("https://www.jetbrains.com/help/idea/junit.html"));
        System.out.println(isURL("https://ravesli.com/tipy-fajlov-v-linux/"));
        System.out.println(isURL("yandex.ru"));
        System.out.println(isURL("https://www.ozon.ru/category/holodnyy-chay-9472/?from_global=true&text=lipton+ice+tea"));
        System.out.println(isURL("http://www.ru.example.com:8080/path/#anchor1"));
        System.out.println(isURL("https://support.apple.com:80/ru-ru"));
        System.out.println(isURL("https://support.apple.com:8022/ru-ru#саш1а"));
 */

/*
System.out.println(isValidPassword("C00l_Pass"));
        System.out.println(isValidPassword("SupperPas1"));
        System.out.println(isValidPassword("SupperPas1."));
        System.out.println(isValidPassword("Pass2"));
        System.out.println(isValidPassword("wwwwsssss"));
        System.out.println(isValidPassword("wwwwssssS"));
        System.out.println(isValidPassword("just text"));
 */