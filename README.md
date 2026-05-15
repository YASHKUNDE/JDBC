# Java JDBC – PostgreSQL CRUD Operations

This was my first Java JDBC CRUD Operations project, completed in Eclipse in 2024.

A beginner-friendly Java project demonstrating how to connect to a **PostgreSQL** database and perform all four CRUD operations (Create, Read, Update, Delete) using **JDBC (Java Database Connectivity)**.

---

## 📁 Project Structure

```
JDBC/
├── src/
│   ├── Cspgconn.java   # Connect to DB + SELECT (Read)
│   ├── Pginsert.java   # INSERT a new record
│   ├── Pgupd.java      # UPDATE an existing record
│   └── Pgdel.java      # DELETE a record
├── bin/                # Compiled .class files
├── .classpath
└── .project
```

---

## ⚙️ Prerequisites

| Requirement | Version |
|---|---|
| Java (JDK) | 8 or above |
| PostgreSQL | Any recent version |
| PostgreSQL JDBC Driver | [Download from jdbc.postgresql.org](https://jdbc.postgresql.org/download/) |
| IDE (optional) | Eclipse / IntelliJ IDEA |

---

## 🗄️ Database Setup

Run the following SQL in your PostgreSQL shell (`psql`) to create the required database and table:

```sql
-- Create database
CREATE DATABASE login;

-- Connect to the database
\c login

-- Create the table
CREATE TABLE login (
    id     SERIAL PRIMARY KEY,
    users  VARCHAR(100),
    email  VARCHAR(100),
    mobile VARCHAR(15),
    pass   VARCHAR(100)
);
```

---

## 🔌 JDBC Connection Details

All four classes connect using the following settings. Update them to match your environment if needed.

| Parameter | Default Value |
|---|---|
| URL | `jdbc:postgresql://localhost:5432/login` |
| Username | `postgres` |
| Password | `123456` |

---

## 📄 Class Descriptions

### 1. `Cspgconn.java` — Connect & Select (Read)

Establishes a connection to the PostgreSQL database and fetches all rows from the `login` table using a `Statement`.

```java
Statement sment = con.createStatement();
ResultSet rs = sment.executeQuery("select * from login");
while (rs.next()) {
    System.out.println(rs.getString("users") + " " + rs.getString("mobile"));
}
```

**Output:**
```
Connected Successfully
Alice 9876543210
Bob   9123456789
```

---

### 2. `Pginsert.java` — Insert (Create)

Accepts user input via `Scanner` and inserts a new row into the `login` table using a `PreparedStatement`.

**Fields accepted:** Name, Email, Mobile, Password

```java
String sql = "INSERT INTO login (users, email, mobile, pass) VALUES (?, ?, ?, ?)";
PreparedStatement psment = con.prepareStatement(sql);
psment.setString(1, name);
psment.setString(2, email);
psment.setString(3, mobile);
psment.setString(4, pass);
int result = psment.executeUpdate();
```

**Sample Run:**
```
Connected Successfully!
Enter Name: Alice
Enter Email: alice@example.com
Enter Mobile: 9876543210
Enter Password: secret123
Insert Success
```

---

### 3. `Pgupd.java` — Update

Accepts new values via `Scanner` and updates the record with **id = 18** in the `login` table.

```java
String sql = "UPDATE login SET users = ?, email = ?, mobile = ?, pass = ? WHERE id = 18";
```

> ⚠️ **Note:** The `WHERE id = 18` is hardcoded. Change this value to the actual record ID you want to update.

**Sample Run:**
```
Connected Successfully.....!
Enter Name: Bob
Enter Email: bob@example.com
Enter Mobile: 9123456789
Enter Password: newpass456
Update Successful!
```

---

### 4. `Pgdel.java` — Delete

Deletes the record with **id = 19** from the `login` table using a `PreparedStatement`.

```java
psment = con.prepareStatement("delete from login where id=19");
int del = psment.executeUpdate();
```

> ⚠️ **Note:** The `WHERE id = 19` is hardcoded. Change this value to the actual record ID you want to delete.

**Sample Run:**
```
Connected Successfully.....!
Delete Success
```

---

## 🚀 How to Run

### Using Eclipse
1. Open Eclipse → **File → Import → Existing Projects into Workspace**
2. Browse to the `JDBC` folder and import the project.
3. Right-click the project → **Build Path → Add External JARs** → add the PostgreSQL JDBC `.jar` file.
4. Right-click any `.java` file → **Run As → Java Application**

### Using Command Line
```bash
# Step 1: Compile (replace path to your JDBC jar)
javac -cp .;postgresql-42.x.x.jar src/Pginsert.java -d bin/

# Step 2: Run
java -cp .;postgresql-42.x.x.jar;bin/ Pginsert
```
> On Linux/macOS, replace `;` with `:` in the classpath.

---

## 🔑 Key JDBC Concepts Used

| Concept | Used In |
|---|---|
| `DriverManager.getConnection()` | All classes – establishes DB connection |
| `Statement` | `Cspgconn` – simple SELECT query |
| `PreparedStatement` | `Pginsert`, `Pgupd`, `Pgdel` – parameterized queries |
| `ResultSet` | `Cspgconn` – iterates over SELECT results |
| `executeQuery()` | SELECT operations |
| `executeUpdate()` | INSERT / UPDATE / DELETE operations |
| Try-with-resources | `Pginsert`, `Pgupd` – auto-closes connections |

---

## 📦 Dependencies

Add the PostgreSQL JDBC driver JAR to your build path:

- **Maven:**
```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>
```

- **Manual:** Download `postgresql-42.x.x.jar` from [jdbc.postgresql.org](https://jdbc.postgresql.org/download/) and add it as an external JAR.

---

## ⚠️ Important Notes

- Never hardcode passwords in production code. Use environment variables or a config file.
- The `Pgupd` and `Pgdel` classes use hardcoded IDs (`18` and `19`). Make these dynamic for real-world use.
- Always close `Connection`, `Statement`, and `ResultSet` objects — the newer classes use try-with-resources for this automatically.

---

## 👨‍💻 Author

> This project was created as a learning exercise for Java JDBC with PostgreSQL.
