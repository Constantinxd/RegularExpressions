import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionsTest {

    @Test
    void isIPv4() {
        assertAll(
                () -> assertTrue(RegularExpressions.isIPv4("0.0.0.0")),
                () -> assertTrue(RegularExpressions.isIPv4("255.255.255.255")),
                () -> assertTrue(RegularExpressions.isIPv4("127.0.0.1")),
                () -> assertTrue(RegularExpressions.isIPv4("1.2.3.4")),
                () -> assertTrue(RegularExpressions.isIPv4("1.1.1.1")),
                () -> assertTrue(RegularExpressions.isIPv4("123.252.57.99")),
                () -> assertTrue(RegularExpressions.isIPv4("100.100.100.100"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isIPv4("256.256.256.256")),
                () -> assertFalse(RegularExpressions.isIPv4("-1.255.255.255")),
                () -> assertFalse(RegularExpressions.isIPv4("255.-1.255.255")),
                () -> assertFalse(RegularExpressions.isIPv4("100.2133.56.23")),
                () -> assertFalse(RegularExpressions.isIPv4("abc.def.gha.bcd")),
                () -> assertFalse(RegularExpressions.isIPv4("1300.6.7.8")),
                () -> assertFalse(RegularExpressions.isIPv4("just text")),
                () -> assertFalse(RegularExpressions.isIPv4(""))
        );
    }

    @Test
    void isGUID() {
        assertAll(
                () -> assertTrue(RegularExpressions.isGUID("ac556b4a-cfd4-456c-ac35-a74e9f17e3e6")),
                () -> assertTrue(RegularExpressions.isGUID("ecd3a799-2c4f-4273-9ec4-7d36429743fa")),
                () -> assertTrue(RegularExpressions.isGUID("461e8cb5-2bbc-4e21-83ad-85a9eed9b08b")),
                () -> assertTrue(RegularExpressions.isGUID("[b711a2e7-4bfc-48ad-be7e-f9c32a5b6a45]")),
                () -> assertTrue(RegularExpressions.isGUID("(e36dc3e3-fa36-4453-8350-21b3c5de430a)")),
                () -> assertTrue(RegularExpressions.isGUID("{a6b0d1a5-ae13-4ec3-a367-a433bea67a32}")),
                () -> assertTrue(RegularExpressions.isGUID("b0047e12-b6a4-448d-b87d-cafd9b4f6e28")),
                () -> assertTrue(RegularExpressions.isGUID("d8aac6d3-7fb3-442d-9e97-0b1c62d32e52")),
                () -> assertTrue(RegularExpressions.isGUID("00000000-0000-0000-0000-000000000000"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isGUID("Gc556b4a-cfd4-456c-ac35-a74e9f17e3e6")),
                () -> assertFalse(RegularExpressions.isGUID("b711a2e7-48ad-be7e-f9c32a5b6a45")),
                () -> assertFalse(RegularExpressions.isGUID("b0047e12-b6a4_448d-b87d-cafd9bf6e28")),
                () -> assertFalse(RegularExpressions.isGUID("d8aac6d3-7fb3-442d-9e97-0b1c62d32e52 ")),
                () -> assertFalse(RegularExpressions.isGUID("2863338b-4c7 7-42e3-b41d-c2cbf81f43b0")),
                () -> assertFalse(RegularExpressions.isGUID("A5cd6caa5-0f9d-402a-9871-3d7c6a558ffc")),
                () -> assertFalse(RegularExpressions.isGUID("just text")),
                () -> assertFalse(RegularExpressions.isGUID(""))
        );
    }

    @Test
    void isURL() {
        assertAll(
                () -> assertTrue(RegularExpressions.isURL("yandex.ru")),
                () -> assertTrue(RegularExpressions.isURL("https://regexr.com")),
                () -> assertTrue(RegularExpressions.isURL("https://regexr.com/")),
                () -> assertTrue(RegularExpressions.isURL("https://REGEXR.com")),
                () -> assertTrue(RegularExpressions.isURL("https://www.gosuslugi.ru/")),
                () -> assertTrue(RegularExpressions.isURL("https://github.com/cyberspacedk/Git-commands")),
                () -> assertTrue(RegularExpressions.isURL("https://javarush.ru/quests/lectures/questsyntaxpro.level11.lecture02")),
                () -> assertTrue(RegularExpressions.isURL("https://ru.wikibooks.org/wiki/Регулярные_выражения")),
                () -> assertTrue(RegularExpressions.isURL("https://www.jetbrains.com/help/idea/junit.html")),
                () -> assertTrue(RegularExpressions.isURL("https://саперонлайн.рф")),
                () -> assertTrue(RegularExpressions.isURL("https://www.youtube.com/watch?v=dsmyXMwHNtg")),
                () -> assertTrue(RegularExpressions.isURL("http://www.example.com:8080/path/#anchor1")),
                () -> assertTrue(RegularExpressions.isURL("https://javarush.ru/groups/posts/709-mnozhestvennoe-nasledovanie-v-java--sravnenie-kompozicii-i-nasledovanija")),
                () -> assertTrue(RegularExpressions.isURL("http://ыы.рф/")),
                () -> assertTrue(RegularExpressions.isURL("https://docs.microsoft.com/ru-ru/dotnet/standard/exceptions/best-practices-for-exceptions")),
                () -> assertTrue(RegularExpressions.isURL("mail.cs.example.edu")),
                () -> assertTrue(RegularExpressions.isURL("https://yandex.ru/images/search?text=Карибское%20Море&nl=1&source=morda&pos=2&img_url=https%3A%2F%2Fsun9-54.userapi.com%2Fc639330%2Fv639330246%2F37720%2F_YVd35DfAHI.jpg&rpt=simage")),
                () -> assertTrue(RegularExpressions.isURL("https://translate.yandex.ru/?lang=en-ru&text=translate%20some%20text%20text%20text%20text%20text%20text")),
                () -> assertTrue(RegularExpressions.isURL("https://example.com:80/path/path/#an")),
                () -> assertTrue(RegularExpressions.isURL("https://auto.ru/?utm_source=main_stripe_big"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isURL("-yandex.ru")),
                () -> assertFalse(RegularExpressions.isURL("https://yandex-.ru/")),
                () -> assertFalse(RegularExpressions.isURL("yandex")),
                () -> assertFalse(RegularExpressions.isURL("янdex.ru")),
                () -> assertFalse(RegularExpressions.isURL("mail.c.example.edu")),
                () -> assertFalse(RegularExpressions.isURL("mail.c.example.edu")),
                () -> assertFalse(RegularExpressions.isURL("yandex.ru:222222")),
                () -> assertFalse(RegularExpressions.isURL("example.ру")),
                () -> assertFalse(RegularExpressions.isURL("екзампл.ru")),
                () -> assertFalse(RegularExpressions.isURL("http://a.com")),
                () -> assertFalse(RegularExpressions.isURL("http://aa.com.")),
                () -> assertFalse(RegularExpressions.isURL("https:/yandex.ru/")),
                () -> assertFalse(RegularExpressions.isURL("хттп:/yandex.ru/")),
                () -> assertFalse(RegularExpressions.isURL("https://yan_dex.ru/")),
                () -> assertFalse(RegularExpressions.isURL("https:/yan dex.ru/")),
                () -> assertFalse(RegularExpressions.isURL("хттп:/yandex.ru/")),
                () -> assertFalse(RegularExpressions.isURL("Just Text")),
                () -> assertFalse(RegularExpressions.isURL(""))
        );
    }

    @Test
    void isValidPassword() {
        assertAll(
                () -> assertTrue(RegularExpressions.isValidPassword("C00l_Password")),
                () -> assertTrue(RegularExpressions.isValidPassword("123456aA")),
                () -> assertTrue(RegularExpressions.isValidPassword("_____1bB")),
                () -> assertTrue(RegularExpressions.isValidPassword("just_texT1")),
                () -> assertTrue(RegularExpressions.isValidPassword("qwertyA2")),
                () -> assertTrue(RegularExpressions.isValidPassword("Illllll1")),
                () -> assertTrue(RegularExpressions.isValidPassword("asdjkhasdkjA2DJKJKWAD23D28JZSJKDADLIAUD2H2HAKD"))
        );

        assertAll(
                () -> assertFalse(RegularExpressions.isValidPassword("Pass1")),
                () -> assertFalse(RegularExpressions.isValidPassword("just_text")),
                () -> assertFalse(RegularExpressions.isValidPassword("Abcdefgh")),
                () -> assertFalse(RegularExpressions.isValidPassword("qwerty")),
                () -> assertFalse(RegularExpressions.isValidPassword("_word_")),
                () -> assertFalse(RegularExpressions.isValidPassword("aB2adw_")),
                () -> assertFalse(RegularExpressions.isValidPassword(".............")),
                () -> assertFalse(RegularExpressions.isValidPassword(""))
        );
    }
}