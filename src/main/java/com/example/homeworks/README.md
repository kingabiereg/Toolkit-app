Zadanie 4 - webowa skrzynka z narzędziami
Podobnie jak w przypadku zadania 3, Twoim zadaniem jest stworzenie prostej aplikacji obługującej skrzynkę z narzędziami. Masz już klasę Tool, a także metody odczytujące z i zapisujące do pliku JSON, które wykorzystasz w tym zadaniu. Jeżeli zaimplementowałeś ją poprawnie, to możesz wykorzystać całą klasę ToolkitController, tylko zmień jej nazwę na ToolkitRepository, żeby odpowiadała temu co faktycznie robi w tej wersji ;)

Aplikacja webowa
W podstawowej części zadania masz do wykonania aplikację wykorzystującą Springa i poznane dotychczas biblioteki, takie jak Thymeleaf. Funkcjonalność, jaką musisz zaimplementować, to wyświetlanie narzędzi oraz dodawanie nowego narzędzia do listy.

Co będzie oceniane:
konfiguracja Springa, użyte biblioteki i dane w pliku pom.xml,
klasa odpowiadająca za obsługę zapytań GET i POST,
klasa repozytorium trzymająca dane odnośnie narzędzi i odczytująca/zapisująca je z/do pliku,
szablony HTML (dla widoku listy i dodawania nowego narzędzia),
wykorzystanie mechanizmu wstrzykiwania zależności (DI) do utworzenia klasy repozytorium.
Nieoceniane:
to jak aplikacja wygląda, ma po prostu działać :)
Powodzenia!

Dla chętnych
Zaimplementuj pełną funkcjonalność CRUD, czyli dodaj opcję edycji narzędzi i usuwania ich z listy.
Dodaj opcję wyszukiwania narzędzi po nazwie tak jak w zadaniu 3.
Wykorzystaj Bootstrapa do poprawienia wyglądu Twojej aplikacji.