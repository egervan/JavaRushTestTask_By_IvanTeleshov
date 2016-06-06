# JavaRushTestTask_By_IvanTeleshov
Тестовое задание для участия в реальном проекте JavaRush

Для запуска необходимо
в Lifecycle запустить package.
Для запуска использовал Tomcat 7.0.69. При запуске в Tomcat из intellij IDEA, поле Application Context оставить пустым.
Если возникнут вопросы по запуску, здесь отличная статья по деплою из intellij idea: http://devcolibri.com/4249

Была проблема с кодировкой. Решил добавлением в conf/server.xml в Tomcat строки URIEncoding="UTF-8"
В итоге вот что получилось:

<Connector port="8080" 
           protocol="HTTP/1.1"
           connectionTimeout="20000"
           URIEncoding="UTF-8"
           redirectPort="8443"/>

Запускаться по умолчанию на: http://localhost:8080/
Скрип для создания БД и скрип для заполнения данными лежат в корне - файл user.sql 
user = password = root - как и просили.
Проблем возникнуть не должно - сам пробовал создать новый проект с github и 
в течение пары минут запустил.
Если возникнут проблемы - прошу сообщить ivant66@yandex.ru

Created by 'eger' Teleshov Ivan;
 
