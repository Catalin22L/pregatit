🇷🇴 Versiunea în Română
📝 To-Do List App
O aplicație Android modernă, intuitivă și eficientă pentru gestionarea sarcinilor zilnice (To-Do List). Acest proiect a fost dezvoltat ca o aplicație de portofoliu, demonstrând implementarea celor mai noi tehnologii și bune practici din ecosistemul Android recomandate de Google.

🚀 Funcționalități Principale
Vizualizarea Sarcinilor: O listă curată și interactivă unde sunt afișate toate task-urile. Sarcinile finalizate apar tăiate (strikethrough) pentru o vizualizare rapidă a progresului.

Creare Sarcini Noi: Utilizatorii pot adăuga rapid task-uri noi completând următoarele detalii:

Titlu și Descriere

Prioritate: NONE, LOW, MEDIUM, HIGH, URGENT

Categorie: General, Work, Personal, Shopping

Gestionarea Stării: Task-urile pot fi marcate ca fiind completate direct din ecranul principal printr-un simplu Checkbox.

Ștergere: Sarcinile de care nu mai este nevoie pot fi șterse individual.

Sortare Inteligentă: Lista este ordonată automat în funcție de stadiul de finalizare și de nivelul de prioritate al fiecărui task.

🛠️ Tehnologii Utilizate
Aplicația este construită nativ pentru Android, punând accent pe scalabilitate și un cod ușor de întreținut:

Limbaj: Kotlin

Interfață Grafică (UI): Jetpack Compose (abordare complet declarativă).

Arhitectură: MVVM (Model-View-ViewModel) integrată cu concepte de Clean Architecture (separare prin UseCases și Repository).

Bază de Date Locală: Room Database pentru stocarea și persistența sarcinilor offline.

Dependency Injection: Dagger Hilt pentru o decuplare eficientă a componentelor.

Asincronism: Kotlin Coroutines și StateFlow pentru gestionarea operațiilor reactive și a stării UI-ului.

Rețea: Retrofit & Gson (aplicația are setările de bază pregătite pentru comunicarea cu un API extern).

📂 Structura Arhitecturală
Presentation Layer: Conține activitățile (TaskListActivity, CreateTaskActivity), componentele UI din Jetpack Compose și ViewModel-urile aferente.

Domain Layer: Conține logica de business pură, modelele de date (ex: TaskPriority) și Use Case-urile (CreateTaskUseCase, GetAllTasksUseCase).

Data Layer: Gestionează sursele de date (Room Database, SharedPreferences) și implementează contractele pentru Repository.

🇬🇧 English Version
📝 To-Do List App
A modern, intuitive, and efficient Android application for managing daily tasks. This project was developed as a portfolio application, demonstrating the implementation of the latest technologies and best practices in the Android ecosystem recommended by Google.

🚀 Key Features
Task Visualization: A clean and interactive list displaying all tasks. Completed tasks appear struck through for a quick overview of your progress.

Create New Tasks: Users can quickly add new tasks by filling in the following details:

Title and Description

Priority: NONE, LOW, MEDIUM, HIGH, URGENT

Category: General, Work, Personal, Shopping

State Management: Tasks can be marked as completed directly from the main screen using a simple Checkbox.

Deletion: Tasks that are no longer needed can be deleted individually.

Smart Sorting: The list is automatically ordered based on the completion status and the priority level of each task.

🛠️ Technologies Used
The app is built natively for Android, focusing on scalability and maintainable code:

Language: Kotlin

User Interface (UI): Jetpack Compose (fully declarative approach).

Architecture: MVVM (Model-View-ViewModel) integrated with Clean Architecture concepts (separation via Use Cases and Repository).

Local Database: Room Database for offline task storage and persistence.

Dependency Injection: Dagger Hilt for efficient component decoupling.

Asynchrony: Kotlin Coroutines and StateFlow for managing reactive operations and UI state.

Networking: Retrofit & Gson (the application is pre-configured for communication with an external API).

📂 Architectural Structure
Presentation Layer: Contains the activities (TaskListActivity, CreateTaskActivity), Jetpack Compose UI components, and the associated ViewModels.

Domain Layer: Contains pure business logic, data models (e.g., TaskPriority), and Use Cases (CreateTaskUseCase, GetAllTasksUseCase).

Data Layer: Manages data sources (Room Database, SharedPreferences) and implements the Repository contracts.
