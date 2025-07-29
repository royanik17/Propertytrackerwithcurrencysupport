# 🧪 Property Expense Tracker POC

## Introduction

Welcome to the **Property Expense Tracker** Proof of Concept (POC)!  
This project aims to provide a modern web application for tracking, managing, and analyzing property-related expenses across multiple properties, with built-in currency conversion and interactive dashboards. It is designed to help property owners and managers gain actionable insights into their expenses, regardless of location or currency.

---

## Features

- **🏘️ Multi-Property Support**
  - Manage up to 5 properties
  - Add details: property type, ownership, area, location

- **📂 Expense Categories**
  - 🔧 **Maintenance**: repairs, gardening, pest control, security
  - 💡 **Utilities**: electricity, water, gas, internet, DTH
  - 💰 **Financials**: tax, EMI, insurance
  - 👷‍♂️ **Staff**: caretaker, maid, driver, lift service
  - 📋 **Society & Legal**: society fees, legal charges
  - 🚪 **Rental**: agent commission, rent management
  - 💼 **Admin**: printing, emergency funds

- **📊 Expense Tracker**
  - Add and categorize expenses per property
  - Analyze expenses with monthly/yearly summaries

- **📈 Dashboard**
  - View total and category-wise expense breakdowns
  - Filter data by property, month, or year

- **💱 Currency Conversion**
  - Switch between currencies for global usability
  - Real-time or static exchange rate support
  - Dashboards auto-update with currency changes

---

## Tech Stack

- **Frontend:** [React](https://react.dev/)
- **Backend:** [Node.js](https://nodejs.org/)
- **Database:** [MongoDB](https://www.mongodb.com/)
- **Data Visualization:** [Chart.js](https://www.chartjs.org/)
- **Currency Conversion:** Integrated with exchange rate APIs

---

## Database Schema Overview

**User**
- Profile info
- Preferences (currency, timezone)
- Notification settings

**Property**
- Property details: type, ownership, area, location
- Purchase date
- Default currency

**Expense**
- Linked to property & category
- Recurring or custom expenses
- Description, amount, date

**ExpenseCategory**
- Logical groupings for analytics

**ExchangeRate**
- Stores live or static currency conversion rates

<details>
  <summary><strong>Sample MongoDB Document Structure</strong></summary>

```json
// User
{
  "_id": "ObjectId",
  "name": "John Doe",
  "email": "john@example.com",
  "currency": "USD",
  "timezone": "America/New_York",
  "notifications": { "email": true }
}

// Property
{
  "_id": "ObjectId",
  "type": "Apartment",
  "ownership": "Owned",
  "area": 1200,
  "location": "New York",
  "purchaseDate": "2022-05-15",
  "currency": "USD"
}

// Expense
{
  "_id": "ObjectId",
  "propertyId": "ObjectId",
  "categoryId": "ObjectId",
  "amount": 150,
  "currency": "USD",
  "description": "Gardening services",
  "date": "2025-07-01",
  "recurring": false
}

// ExpenseCategory
{
  "_id": "ObjectId",
  "name": "Maintenance",
  "description": "Repairs, gardening, pest control, security"
}

// ExchangeRate
{
  "_id": "ObjectId",
  "from": "USD",
  "to": "EUR",
  "rate": 0.92,
  "updatedAt": "2025-07-28T09:00:00Z"
}
```
</details>

---

## Getting Started

### Prerequisites

- Node.js (v18+)
- MongoDB (local or cloud)
- npm or yarn

### Installation

```bash
git clone https://github.com/yourusername/property-expense-tracker-poc.git
cd property-expense-tracker-poc
npm install
```

### Running Locally

1. **Set up MongoDB.**
   - Configure your connection string in `.env` (see `.env.example`).
2. **Start the backend server:**
   ```bash
   npm run server
   ```
3. **Start the frontend:**
   ```bash
   npm start
   ```

4. **Access the app:**  
   Open [http://localhost:3000](http://localhost:3000) in your browser.

---

## Future Scope

- 🔄 **Expand Property Limit:** Support more than 5 properties
- 🌐 **User Authentication:** Multi-user login and role management
- 📱 **Mobile App:** React Native/Flutter support
- 🔔 **Notifications:** Automated alerts for high expenses, recurring due dates
- 📅 **Calendar Integration:** Expense reminders and scheduling
- 🏦 **Bank Integration:** Auto-fetch property-related transactions
- 🧩 **Custom Analytics:** Advanced reporting, export to CSV/PDF

---

## License

This project is licensed under the [MIT License](LICENSE).

---

## Contact

For questions, feedback, or collaboration:

- **Author:** [Your Name]
- **Email:** your.email@example.com
- **GitHub:** [github.com/yourusername/property-expense-tracker-poc](https://github.com/yourusername/property-expense-tracker-poc)

---

> **POC Goal:**  
> Demonstrate end-to-end expense tracking, rich data visualization, and dynamic currency conversion for property management across the globe.
