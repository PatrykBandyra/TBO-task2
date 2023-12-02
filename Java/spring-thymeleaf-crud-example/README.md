### Zadanie 2

Jak uruchomiono?
```commandline
docker run -v C:\Users\patry\IdeaProjects\Java\TBO-task2:/path zricethezav/gitleaks:latest detect --source="/path" -v 
```

Co zostało wykryte?
![img.png](img.png)
Te 3 piki zawierają klucze prywatne, które nie powinny znaleźć się w repozytorium:
![img_1.png](img_1.png)

Propozycja naprawy problemu:

Można przenieść sekrety do Vaulta, który będzie przechowywał je bezpiecznie w chmurze lub na serwerach firmy on-site.
Dostęp do Vaulta i jego sekretów następuje z użyciem tokenu, który jest otrzymywany po wcześniejszym uwierzytelnieniu i autoryzacji
użytkownika.