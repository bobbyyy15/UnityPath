# **UNITYPATH: Volunteer Matching System**

![UnityPath](https://github.com/user-attachments/assets/92426150-ecaf-4041-b648-cacc6d714d46)


## **📚 Title and Purpose**
**UNITYPATH** is a platform designed to connect volunteers with organizations working toward social good. The system facilitates the matching of volunteers to opportunities based on their skills, availability, and interests, allowing for more efficient collaboration and fostering unity in the community.

---

## **🎯 Objective**
The objective of **UNITYPATH** is to create a seamless volunteer matching platform that:
- Bridges the gap between organizations in need of volunteers and individuals who want to contribute.
- Enables efficient management of opportunities and volunteers.
- Promotes social change by supporting humanitarian, environmental, and community-building initiatives.

---

## **🛠 Key Features**
- **Volunteer Registration & Login:** Volunteers can register and create profiles with their skills and interests, allowing for easy application to suitable opportunities.
- **Organization Registration & Login:** Organizations can post opportunities, review applications, and manage volunteer participation.
- **Opportunity Management:** Volunteers can view, apply, and track opportunities based on their skills and availability.
- **Search & Filter Functionality:** Volunteers can search for opportunities by location, skills, and other criteria to find the best fit.
- **Clear, User-Friendly Interface:** The system is designed with an easy-to-navigate UI that simplifies the interaction between volunteers and organizations.
- **Exit Handling:** The system includes clear exit options that allow users to cancel actions easily.

---

## **📦 Core Classes**
- **`Volunteer`:** This class represents a volunteer with attributes like `id`, `name`, `password`, and `skills`. It extends the abstract class `User` and provides the `viewOpportunities()` method for displaying available opportunities.
- **`Organization`:** Represents an organization that can post volunteer opportunities. Includes methods for managing organizations and interacting with the volunteer database.
- **`Opportunity`:** Represents a volunteer opportunity with fields like `title`, `requiredSkills`, `location`, and dates. This class manages the details of each opportunity.
- **`User (Abstract)`:** This base class holds common attributes like `id`, `name`, and `email` for both volunteers and organizations. It defines the abstract method `viewOpportunities()` to be implemented by subclasses.
- **`TestConnection`:** A utility class used to test the connection to a MySQL database, ensuring the system can interact with a database properly.
- **`DesignUtils`:** A utility class for formatting output, clearing the screen, and printing styled headers and messages, helping improve user interaction.

---

## **🧑‍💻 Core Principles of OOP**
The system follows key **Object-Oriented Programming** principles, such as:

1. **Encapsulation:** 
   - Each class has its own attributes and methods, ensuring the internal workings of each object are hidden and only relevant data is exposed.
   - Example: The `Volunteer` class encapsulates details like `name` and `skills`, while the `Opportunity` class encapsulates opportunity-specific details.

2. **Inheritance:**
   - The `User` class is an abstract base class that defines common properties like `id`, `name`, and `email`. Both `Volunteer` and `Organization` classes inherit from `User`, making the system extensible for future types of users.

3. **Polymorphism:**
   - The abstract method `viewOpportunities()` in the `User` class allows different subclasses (e.g., `Volunteer`, `Organization`) to provide their specific implementations of how opportunities are viewed.

4. **Abstraction:**
   - Complex logic, such as database connections or console clearing, is abstracted into utility methods like those in the `DesignUtils` and `TestConnection` classes, simplifying the user-facing functionality.

---

## **🌍 SDG Alignment**
**UNITYPATH** aligns with the following **Sustainable Development Goals (SDGs):**

- **SDG 10: Reduced Inequality**  
   By connecting volunteers to community organizations, the platform helps in reducing inequality by fostering inclusion and support for marginalized groups.

- **SDG 16: Peace, Justice, and Strong Institutions**  
   The platform contributes to strengthening institutions by promoting collaboration between volunteers and organizations to address social challenges.

- **SDG 17: Partnerships for the Goals**  
   The platform serves as a catalyst for partnerships by linking volunteers to organizations, fostering cooperation to achieve common goals.

---

## **🌟 Benefits**
### **For Volunteers:**
- Find opportunities that match their skills and interests.
- Contribute meaningfully to causes they care about.
- Track and manage volunteer activities with ease.

### **For Organizations:**
- Manage volunteer applications efficiently.
- Access a pool of skilled volunteers who can contribute to various projects.
- Simplify the process of posting and managing opportunities.

### **For Communities:**
- Communities benefit from efficient matching of volunteers, helping organizations meet their needs and deliver services faster.

---

## **💻 How to Use**
1. **Clone the repository:**
   - Download or clone this repository to your local machine.

2. **Set up your database:**
   - Ensure that you have MySQL set up on your local or remote server.
   - Create a database and configure the connection in the `TestConnection` class to ensure the system can interact with it.

3. **Run the application:**
   - Execute the `Main` class in your IDE or from the command line. This will start the application, and you can navigate through the menu to create organizations, view opportunities, and register as a volunteer.

4. **Interact with the menu:**
   - Follow the prompts in the terminal to create and manage organizations, sign up as a volunteer, and apply for opportunities.

---

## **⚙ Feature Enhancements**

- **Social Media Integration:**  
   Allow volunteers to share opportunities and their experiences on social media, increasing engagement.

- **Advanced Search Filters:**  
   Improve the search functionality to allow filtering by multiple criteria (e.g., date range, specific skills, etc.).

- **Notification System:**  
   Implement notifications to alert volunteers about new opportunities, upcoming events, or status updates.

- **Rating System for Volunteers:**  
   Add a rating system for volunteers, where organizations can rate their performance and provide feedback.

- **Mobile App Version:**  
   Develop a mobile version of the platform for increased accessibility and reach.

---

## **💡 Contributing**
Feel free to contribute to **UNITYPATH**! If you have any ideas for improvements, fixes, or new features, please open an issue or submit a pull request.

---

## **📜 License**
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
