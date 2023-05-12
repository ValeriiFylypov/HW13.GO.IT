# HW13.GO.IT
Ready HomeWork for the Best IT school


Write a programme that will interact with the https://jsonplaceholder.typicode.com API.

You can use standard Java features (HttpURLConnection class) or use third-party solutions such as Apache Fluent API, Apache HTTPClient, Jsoup.

Task 1.
The program must contain methods to implement the following functionality:

create a new object in https://jsonplaceholder.typicode.com/users. You may not see the changes on the site immediately. The method works correctly if the same JSON is returned in response to the JSON with the object, but with an id value 1 greater than the largest id on the site.

update the object in https://jsonplaceholder.typicode.com/users. You may not see any changes on the site right away. We assume that the method is working correctly if you receive an updated JSON in response (it should be the same as the one you sent).

delete object from https://jsonplaceholder.typicode.com/users. Here, we will assume that the correct result is a response status from group 2xx (for example, 200).

getting information about all users https://jsonplaceholder.typicode.com/users

getting information about a user by id https://jsonplaceholder.typicode.com/users/{id}

getting information about the user by username - https://jsonplaceholder.typicode.com/users?username={username}

Task 2
Complete the programme with a method that will display all the comments to the last post of a certain user and write them to a file.

https://jsonplaceholder.typicode.com/users/1/posts The last post is the one with the largest id.

https://jsonplaceholder.typicode.com/posts/10/comments

The file should be named user-X-post-Y-comments.json, where X is the user id and Y is the post number.

Task 3
Add a method to the program that will print all open tasks for the user with the id X.

https://jsonplaceholder.typicode.com/users/1/todos.

All tasks with completed = false are considered open.


*************************************************************************************************************************************************

Schreiben Sie ein Programm, das mit der https://jsonplaceholder.typicode.com API interagiert.

Sie können Standard-Java-Funktionen (HttpURLConnection-Klasse) oder Lösungen von Drittanbietern wie Apache Fluent API, Apache HTTPClient, Jsoup verwenden.

Aufgabe 1.
Das Programm muss Methoden enthalten, um die folgenden Funktionen zu implementieren:

Erstellen Sie ein neues Objekt in https://jsonplaceholder.typicode.com/users. Es kann sein, dass Sie die Änderungen auf der Website nicht sofort sehen. Die Methode funktioniert korrekt, wenn als Antwort auf das JSON mit dem Objekt dasselbe JSON zurückgegeben wird, jedoch mit einem id-Wert, der um 1 größer ist als die größte id auf der Site.

Aktualisieren Sie das Objekt in https://jsonplaceholder.typicode.com/users. Möglicherweise sehen Sie auf der Website nicht sofort eine Änderung. Wir gehen davon aus, dass die Methode korrekt funktioniert, wenn Sie ein aktualisiertes JSON als Antwort erhalten (es sollte dasselbe sein wie das, das Sie gesendet haben).

Objekt von https://jsonplaceholder.typicode.com/users löschen. Hier gehen wir davon aus, dass das korrekte Ergebnis ein Antwortstatus der Gruppe 2xx ist (zum Beispiel 200).

Informationen über alle Benutzer abrufen https://jsonplaceholder.typicode.com/users

Abrufen von Informationen über einen Benutzer anhand der ID https://jsonplaceholder.typicode.com/users/{id}

Abrufen von Informationen über den Benutzer anhand des Benutzernamens - https://jsonplaceholder.typicode.com/users?username={Benutzername}

Aufgabe 2
Vervollständigen Sie das Programm mit einer Methode, die alle Kommentare zum letzten Beitrag eines bestimmten Benutzers anzeigt und in eine Datei schreibt.

https://jsonplaceholder.typicode.com/users/1/posts Der letzte Beitrag ist derjenige mit der größten id.

https://jsonplaceholder.typicode.com/posts/10/comments

Die Datei sollte user-X-post-Y-comments.json heißen, wobei X die Benutzerkennung und Y die Beitragsnummer ist.

Aufgabe 3
Füge dem Programm eine Methode hinzu, die alle offenen Aufgaben für den Benutzer mit der ID X ausgibt.

https://jsonplaceholder.typicode.com/users/1/todos.

Alle Aufgaben mit completed = false werden als offen betrachtet.
