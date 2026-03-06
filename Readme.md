📝 To-Do List App
O aplicație Android modernă, intuitivă și eficientă pentru gestionarea sarcinilor zilnice (To-Do List). Acest proiect a fost dezvoltat ca o aplicație de portofoliu, demonstrând implementarea celor mai noi tehnologii și bune practici din ecosistemul Android recomandate de Google.

🚀 Funcționalități Principale (Features)
Vizualizarea Sarcinilor:O listă curată și interactivă unde sunt afișate toate task-urile. Sarcinile finalizate apar tăiate (strikethrough) pentru o vizualizare rapidă a progresului.
  Creare Sarcini Noi:Utilizatorii pot adăuga rapid task-uri noi completând următoarele detalii:
  Titlu și Descriere
  Prioritate:NONE, LOW, MEDIUM, HIGH, URGENT
  Categorie:General, Work, Personal, Shopping
  Gestionarea Stării:Task-urile pot fi marcate ca fiind completate direct din ecranul principal printr-un simplu Checkbox.
  Ștergere:Sarcinile de care nu mai este nevoie pot fi șterse individual.
  Sortare Inteligentă:Lista este ordonată automat în funcție de stadiul de finalizare și de nivelul de prioritate al fiecărui task.

🛠️ Tehnologii Utilizate
Aplicația este construită nativ pentru Android, punând accent pe scalabilitate și un cod ușor de întreținut:
  Limbaj:** Kotlin
  Interfață Grafică (UI):** Jetpack Compose (abordare complet declarativă)
  Arhitectură:MVVM (Model-View-ViewModel) integrată cu concepte de Clean Architecture (separare prin `UseCases` și `Repository`).
  Bază de Date Locală:** Room Database pentru stocarea și persistența sarcinilor offline.
  Dependency Injection:** Dagger Hilt pentru o decuplare eficientă a componentelor.
  Asincronism:Kotlin Coroutines și StateFlow pentru gestionarea operațiilor reactive și a stării UI-ului.
  Rețea: Retrofit & Gson (aplicația are setările de bază pregătite pentru comunicarea cu un API extern).

📂 Structura Arhitecturală
Presentation Layer:** Conține activitățile (`TaskListActivity`, `CreateTaskActivity`), componentele UI din Jetpack Compose și ViewModel-urile aferente.
Domain Layer:Conține logica de business pură, modelele de date (ex: `TaskPriority`) și Use Case-urile (`CreateTaskUseCase`, `GetAllTasksUseCase`).
Data Layer: Gestionează sursele de date (Room Database, SharedPreferences) și implementează contractele pentru Repository.
