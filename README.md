# pasteBox
backend REST API сервис который позволяет заливать куски текста/кода ("пасту") и получать на них короткую ссылку которую можно отправить другим людям.
При загрузке "пасты" пользователь указывает текст(data) и время(expiration time) в течениие которого загруженный текст будет доступен:
                - day - 1 день;
                - week - 1 неделя;
                - month - 1 месяц;
                - allTime - постоянный доступ
после истечени срока, получить доступ к пасте нельзя.
Для загруженной пасты выделяется сслка вида:http://pasteBox/{какойто хэш}

  Пользователи могут получить информацию о:
  - 10 последних загруженных "пастах"   http://pasteBox/
  - определенной "пасте" по ее хэшу     http://pasteBox/{хэш пасты}
  - создать собственную "пасту" POST запроссом  с указанием парметров data и expirationTime   http://pasteBox/ 
  
                