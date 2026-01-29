
# Mutual Fund Management Backend 💰
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.1.0-green)
![MySQL](https://img.shields.io/badge/MySQL-8.0+-yellow)
![Maven](https://img.shields.io/badge/Maven-3.8.0-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/jasmine-1612/Mutual-Fund-Platform-backend)

---

## 📖 Overview  

The **Mutual Fund Management Backend** is a Spring Boot application providing **REST APIs** for managing mutual funds, investors, portfolios, stocks, and transactions.  
This backend powers the **Mutual Fund Frontend platform** and demonstrates a **full-stack Java web application** with database connectivity, secure authentication, and CRUD operations.

It is ideal for:
- 💡 Practicing Spring Boot and REST API development  
- 🏦 Financial project demos and learning  
- 📊 Handling relational data with MySQL  
- 🌐 Integrating with frontend applications  

---

## ✨ Features  

### 👩‍💻 Investor Features  
- 🔑 Investor Registration & Login  
- 📈 View Portfolio and Investment Details  
- 💵 Invest in Mutual Funds  
- 🔄 Redeem Investments  
- 📄 View Transaction History  
- 🔍 Search for Mutual Funds & Stocks  
- 📊 Generate Investment Reports  

### 🔐 Portfolio Manager Features  
- 🛡 Portfolio Manager Login  
- 🗂 Manage Mutual Funds (create, update, delete)  
- 🗂 Manage Stocks (add, update, delete stocks)  
- 📊 View Investor Portfolios and Transactions  
- 📊 Generate Portfolio Performance Reports  

### 📦 Stock & Fund Features  
- 📈 Track Stocks in Funds  
- 🔄 Update Stock Prices  
- 🏦 Assign Stocks to Mutual Funds  
- 💹 Monitor Fund Performance based on stocks  

### ⚙️ Technical Features  
- ✅ **Spring Boot MVC** for backend structure  
- ✅ **Spring Data JPA (Hibernate)** for database queries  
- ✅ **REST APIs** for frontend integration  
- ✅ **MySQL Database** for data storage  
- ✅ **Maven** for dependency management  
- ✅ **CORS Configuration** for cross-origin requests  
- ✅ Entity mapping for Investor, PortfolioManager, MutualFund, Investment, Stock, StocksInFund  

---

## 🏗️ Project Structure

Mutual_Fund_Project-master

├── **src/** – Source files  
│   └── **main/** – Main application files  
│       ├── **java/com/project/** – Java packages  
│       │   ├── **controller/** – REST API endpoints  
│       │   │   ├── InvestmentController.java – Handles investment-related requests  
│       │   │   ├── InvestorController.java – Handles investor-related requests  
│       │   │   ├── MutualFundController.java – Handles mutual fund CRUD  
│       │   │   ├── PortfolioManagerController.java – Handles portfolio manager actions  
│       │   │   ├── StockController.java – Handles stock data endpoints  
│       │   │   └── StocksInFundController.java – Handles stocks within mutual funds  
│       │   │  
│       │   ├── **service/** – Business logic for entities  
│       │   │   ├── InvestmentService.java – Investment logic  
│       │   │   ├── InvestorService.java – Investor operations  
│       │   │   ├── MutualFundService.java – Mutual fund operations  
│       │   │   ├── PortfolioManagerService.java – PM operations  
│       │   │   ├── StockService.java – Stock logic  
│       │   │   └── StocksInFundService.java – Stocks in fund management  
│       │   │  
│       │   ├── **repository/** – Database access layer (Spring Data JPA)  
│       │   │   ├── InvestmentRepository.java  
│       │   │   ├── InvestorRepository.java  
│       │   │   ├── MutualFundRepository.java  
│       │   │   ├── PortfolioManagerRepository.java  
│       │   │   ├── StockRepository.java  
│       │   │   └── StocksInFundRepsoitory.java  
│       │   │  
│       │   ├── CorsConfig.java – Cross-origin resource sharing configuration  
│       │   ├── Investment.java – Investment entity  
│       │   ├── Investor.java – Investor entity  
│       │   ├── MutualFund.java – Mutual fund entity  
│       │   ├── PortfolioManager.java – Portfolio manager entity  
│       │   ├── Stock.java – Stock entity  
│       │   ├── StockIdentifier.java – Unique stock identifiers  
│       │   └── StocksInFund.java – Stocks mapped to funds  
│       │  
│       └── MainApp.java – Spring Boot main application class  
│  
├── **resources/** – Configuration and properties  
│   └── application.properties – Database, server, and Spring configurations  
│  
├── **pom.xml** – Maven dependencies and build configuration  


---


## 🚀 Getting Started  

### 1️⃣ Clone the repository
git clone https://github.com/jasmine-1612/Mutual-Fund-Platform-backend.git
cd Mutual_Fund_Project-master

### 2️⃣ Configure the database in SQL Developer / MySQL
- Create a schema (database) named 'mutualfunddb'
- Update the database credentials in application.properties

echo "
spring.datasource.url=jdbc:mysql://localhost:3306/mutualfunddb
spring.datasource.username=your_sql_username
spring.datasource.password=your_sql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
" > src/main/resources/application.properties

### 3️⃣ Build and run the Spring Boot application
mvn spring-boot:run

### 4️⃣ Access the API
 Base URL: http://localhost:8080/

 ---

## 🌐 API Endpoints & Service Layer Overview

### Portfolio Manager Endpoints

| Method | Endpoint                                  | Description                        |
| ------ | ----------------------------------------- | ---------------------------------- |
| GET    | `/portfoliomanagers`                      | List all portfolio managers        |
| POST   | `/portfoliomanagers/add`                  | Add a new portfolio manager        |
| GET    | `/portfoliomanagers/getAllMF/{managerId}` | Get all mutual funds managed by PM |

PortfolioManagerService Methods:
- addPortfolioManager(PM) → Add a new PM
- getAllPortfolioManagers() → List all PMs
- getAllMutualFunds(managerId) → Funds managed by PM

### Investor Endpoints & Service

| Method | Endpoint                     | Description             |
| ------ | ---------------------------- | ----------------------- |
| POST   | `/investors`                 | Register a new investor |
| POST   | `/login`                     | Login an investor       |
| GET    | `/investors`                 | Get all investors       |
| GET    | `/investors/id/{investorId}` | Get investor info by ID |


InvestorService Methods:
- authenticate(email, password) → Validate and login investor
- getAllInvestors() → List all investors
- addInvestor(Investor) → Add new investor
- emailExists(email) → Check if email already exists
- getInvestorInfo(id) → Fetch investor details


### Investment Endpoints & Service

| Method | Endpoint                                      | Description                             |
| ------ | --------------------------------------------- | --------------------------------------- |
| GET    | `/investments`                                | List all investments                    |
| POST   | `/investments/add`                            | Record a new investment                 |
| GET    | `/investments/id/{investorId}`                | Get investor's portfolio                |
| GET    | `/investments/investmentid/{investmentId}`    | Get investment details by ID            |
| GET    | `/investments/getunits/{investorId}/{fundId}` | Get total units for investor for a fund |

InvestmentService Methods:
- getAllInvestments() → List all investments
- addAInvestment(Investment) → Add investment
- getInvestmentDetails(id) → Single investment
- getInvestmentsById(investorId) → Investments by investor
- getAllInvestmentsByInvestorForAFund(investorId, fundId) → Investments for a specific fund
- getTotalUnitsForInvestorForAFund(investorId, fundId) → Total units for a fund
- getDistinctFundIdsByInvestorId(investorId) → List distinct funds invested in


### Mutual Fund Endpoints & Service

| Method | Endpoint                             | Description                            |
| ------ | ------------------------------------ | -------------------------------------- |
| GET    | `/mutualfunds`                       | List all mutual funds                  |
| POST   | `/mutualfund/add`                    | Create a new mutual fund               |
| GET    | `/mutualfunds/id/{mfid}`             | Get mutual fund details                |
| GET    | `/mutualfund/getstockweights/{mfid}` | Get stock composition of fund          |
| GET    | `/investor/mfs/{investorId}`         | List mutual funds invested by investor |


MutualFundService Methods:
- getAllMutualFunds() → List all funds
- createMutualFund(MutualFund) → Add new fund
- getMutualFundInfo(fundId) → Fund details
- getStockComposition(fundId) → Stocks and weights
- getListOfInvestedMutualFundsByInvestor(investorId) → Funds an investor invested in

### Stock Endpoints & Service

| Method | Endpoint               | Description                          |
| ------ | ---------------------- | ------------------------------------ |
| GET    | `/stocks`              | List all stocks                      |
| GET    | `/stocks/byid`         | List all stocks (alternate endpoint) |
| POST   | `/stocks/add`          | Add a new stock                      |
| GET    | `/stocks/id/{stockId}` | Get stock info by ID                 |

StockService Methods:
- getAllStocks() → List all stocks
- addStocks(Stock) → Add a new stock
- getStockInfo(stockId) → Stock details
- getAllStocksBy1() → Custom query for stocks


### Stocks in Fund Endpoints & Service

| Method | Endpoint            | Description                           |
| ------ | ------------------- | ------------------------------------- |
| GET    | `/stocksinfund`     | List all stocks in all funds          |
| POST   | `/stocksinfund/add` | Add or update stock weights in a fund |


StocksInFundService Methods:
- getAllStocksInFund() → List stocks in all funds
- addStocksWeight(StocksInFund) → Update stock weights in a fund
 

---


## Service Layer Overview:

InvestorService:
- authenticate(email, password) -> Validate and login investor
- getAllInvestors() -> List all investors
- addInvestor(Investor) -> Add new investor
- emailExists(email) -> Check if email already exists
- getInvestorInfo(id) -> Fetch investor details

InvestmentService:
- getAllInvestments() -> List all investments
- addAInvestment(Investment) -> Add investment
- getInvestmentDetails(id) -> Single investment
- getInvestmentsById(investorId) -> Investments by investor
- getAllInvestmentsByInvestorForAFund(investorId, fundId)
- getTotalUnitsForInvestorForAFund(investorId, fundId)
- getDistinctFundIdsByInvestorId(investorId)

MutualFundService:
- getAllMutualFunds() -> List all funds
- createMutualFund(MutualFund) -> Add new fund
- getMutualFundInfo(fundId) -> Fund details
- getStockComposition(fundId) -> Stocks and weights
- getListOfInvestedMutualFundsByInvestor(investorId) -> Funds an investor invested in

PortfolioManagerService:
- addPortfolioManager(PM) -> Add a new PM
- getAllPortfolioManagers() -> List all PMs
- getAllMutualFunds(managerId) -> Funds managed by PM

StockService:
- getAllStocks() -> List all stocks
- addStocks(Stock) -> Add a new stock
- getStockInfo(stockId) -> Stock details
- getAllStocksBy1() -> Custom query for stocks

StocksInFundService:
- getAllStocksInFund() -> List stocks in all funds
- addStocksWeight(StocksInFund) -> Update stock weights in a fund
  

## 📐 System Architecture

### Class Diagram

```mermaid
classDiagram
    %% Entities
    class Investor {
        int investorId
        string name
        string email
        string password
    }
    class PortfolioManager {
        int managerId
        string name
        string email
    }
    class MutualFund {
        int mfId
        string fundName
        double currentNAV
        double expenseRatio
        double exitLoad
        double assetsUnderManagement
        int managerId
        date inceptionDate
    }
    class Investment {
        int investmentId
        int investorId
        int fundId
        double amount
        double units
        date investmentDate
    }
    class Stock {
        int stockId
        string stockTicker
        double closingPrice
    }
    class StocksInFund {
        int id
        int mfId
        int stockId
        double stockWeight
    }

    %% Repositories
    class InvestorRepository
    class InvestmentRepository
    class MutualFundRepository
    class PortfolioManagerRepository
    class StockRepository
    class StocksInFundRepository

    %% Services
    class InvestorService {
        +getAllInvestors()
        +addInvestor()
        +authenticate()
        +getInvestorInfo()
        +emailExists()
    }
    class InvestmentService {
        +getAllInvestments()
        +addAInvestment()
        +getInvestmentDetails()
        +getInvestmentsById()
        +getAllInvestmentsByInvestorForAFund()
        +getTotalUnitsForInvestorForAFund()
        +getDistinctFundIdsByInvestorId()
    }
    class MutualFundService {
        +getAllMutualFunds()
        +createMutualFund()
        +getMutualFundInfo()
        +getStockComposition()
        +getListOfInvestedMutualFundsByInvestor()
    }
    class PortfolioManagerService {
        +addPortfolioManager()
        +getAllPortfolioManagers()
        +getAllMutualFunds()
    }
    class StockService {
        +getAllStocks()
        +addStocks()
        +getStockInfo()
        +getAllStocksBy1()
    }
    class StocksInFundService {
        +getAllStocksInFund()
        +addStocksWeight()
    }

    %% Entity Relationships
    Investor "1" -- "0..*" Investment : makes
    PortfolioManager "1" -- "0..*" MutualFund : manages
    MutualFund "1" -- "0..*" StocksInFund : contains
    Stock "1" -- "0..*" StocksInFund : belongs_to
    Investment "1" -- "1" MutualFund : invests_in

    %% Service to Repository Relationships
    InvestorService --> InvestorRepository
    InvestmentService --> InvestmentRepository
    MutualFundService --> MutualFundRepository
    MutualFundService --> StockRepository
    MutualFundService --> StocksInFundRepository
    PortfolioManagerService --> PortfolioManagerRepository
    PortfolioManagerService --> MutualFundRepository
    StockService --> StockRepository
    StocksInFundService --> StocksInFundRepository

```

---

### 🧩 Entity Relationships

  
   ```mermaid
erDiagram
    %% Relationships
    INVESTOR ||--o{ INVESTMENT : makes
    PORTFOLIOMANAGER ||--o{ MUTUALFUND : manages
    MUTUALFUND ||--o{ INVESTMENT : has
    MUTUALFUND ||--o{ STOCKSINFUND : contains
    STOCK ||--o{ STOCKSINFUND : belongs_to

    %% Entities
    INVESTOR {
        int investorId
        string name
        string email
        string password
    }

    PORTFOLIOMANAGER {
        int managerId
        string name
        string email
    }

    MUTUALFUND {
        int mfId
        string fundName
        double currentNAV
        double expenseRatio
        double exitLoad
        double assetsUnderManagement
        int managerId
        date inceptionDate
    }

    INVESTMENT {
        int investmentId
        int investorId
        int fundId
        double amount
        double units
        date investmentDate
    }

    STOCK {
        int stockId
        string stockTicker
        double closingPrice
    }

    STOCKSINFUND {
        int id
        int mfId
        int stockId
        double stockWeight
    }


```

---


## 🌐 Controller Layer Diagram

```mermaid
classDiagram
    %% Controllers
    class InvestorController {
        +registerInvestor()
        +authenticateInvestor()
        +getInvestorById()
    }

    class InvestmentController {
        +addInvestment()
        +getAllInvestments()
        +getInvestmentsByInvestor()
    }

    class MutualFundController {
        +getAllFunds()
        +getFundById()
        +getStockComposition()
        +createFund()
    }

    class StockController {
        +getAllStocks()
        +addStock()
    }

    %% Services
    class InvestorService
    class InvestmentService
    class MutualFundService
    class StockService

    %% Relationships
    InvestorController --> InvestorService
    InvestmentController --> InvestmentService
    MutualFundController --> MutualFundService
    StockController --> StockService

```
---

## 🔄 Investment Flow (Sequence Diagram)

```mermaid
sequenceDiagram
    actor Investor
    participant Controller as InvestmentController
    participant Service as InvestmentService
    participant MFService as MutualFundService
    participant Repo as InvestmentRepository

    %% Investor sends a request to invest
    Investor ->> Controller: POST /investments/add (investorId, fundId, amount)

    %% Controller calls service layer
    Controller ->> Service: addAInvestment(investorId, fundId, amount)

    %% Service gets mutual fund details
    Service ->> MFService: getMutualFundInfo(fundId)
    MFService -->> Service: return fund NAV and details

    %% Service calculates units to assign
    Service ->> Service: calculate units (amount / NAV)

    %% Service saves investment in repository
    Service ->> Repo: save(Investment)
    Repo -->> Service: return saved investment

    %% Service returns response to controller
    Service -->> Controller: InvestmentResponse

    %% Controller returns success to investor
    Controller -->> Investor: 201 CREATED / Investment details


```
---


## 🛠️ Technologies Used

- **Java 17**
- **Spring Boot 3.1.0**
- **Spring Data JPA / Hibernate**
- **MySQL 8.0+**
- **Maven 3.8+**
- **REST APIs**
- **CORS Configuration**
- **GitHub for version control**

---


## 🔐 Security & Validation

- Authentication implemented using email & password verification
- Password validation handled in InvestorService
- Business logic isolated in Service layer
- Input validation performed before persistence
- Database access restricted via Repository layer
- Clear separation of concerns:
   - Controller → Request handling
   - Service → Business logic
   - Repository → Data persistence

---


## 🚀 Future Enhancements
- JWT authentication with role-based access
- Password encryption using BCrypt
- Pagination & sorting for large datasets
- Swagger / OpenAPI documentation
- Deployment using Docker & AWS

---

## ⚡ Notes & Additional Setup

- Ensure **Java 17** is installed and configured.  
- Ensure **SQL Developer** is running.  
- Update **application.properties** with correct credentials.  
- Use **Postman** or any REST client to test endpoints.  
- JWT authentication token should be included in headers if implemented.

---


## 📌 License

This project is **open source** under the [MIT License](LICENSE).  

---

## 🤝 Contributions

- Fork the repository  
- Create a new branch (`git checkout -b feature/YourFeature`)  
- Commit your changes (`git commit -m 'Add some feature'`)  
- Push to the branch (`git push origin feature/YourFeature`)  
- Open a Pull Request  

---
