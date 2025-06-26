-- Create customers table
CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER,
    balance NUMBER,
    loan_interest_rate NUMBER,
    IsVIP VARCHAR2(5)
);

-- Create loans table
CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER REFERENCES customers(customer_id),
    due_date DATE
);

-- Insert sample data
BEGIN
  INSERT INTO customers VALUES (1, 'Alice', 65, 12000, 9.5, 'FALSE');
  INSERT INTO customers VALUES (2, 'Bob', 45, 8000, 10.0, 'FALSE');
  INSERT INTO customers VALUES (3, 'Charlie', 70, 15000, 8.5, 'FALSE');

  INSERT INTO loans VALUES (101, 1, SYSDATE + 10);
  INSERT INTO loans VALUES (102, 2, SYSDATE + 40);
  INSERT INTO loans VALUES (103, 3, SYSDATE + 5);
END;
/

-- Scenario 1: Apply 1% discount to customers above 60
BEGIN
  FOR cust_rec IN (
    SELECT customer_id FROM customers WHERE age > 60
  ) LOOP
    UPDATE customers
    SET loan_interest_rate = loan_interest_rate - 1
    WHERE customer_id = cust_rec.customer_id;

    DBMS_OUTPUT.PUT_LINE('1% discount applied for Customer ID: ' || cust_rec.customer_id);
  END LOOP;
END;
/

-- Scenario 2: Promote to VIP if balance > 10000
BEGIN
  FOR vip_rec IN (
    SELECT customer_id FROM customers WHERE balance > 10000
  ) LOOP
    UPDATE customers
    SET IsVIP = 'TRUE'
    WHERE customer_id = vip_rec.customer_id;

    DBMS_OUTPUT.PUT_LINE('Customer ID ' || vip_rec.customer_id || ' promoted to VIP.');
  END LOOP;
END;
/

-- Scenario 3: Loan due reminders
BEGIN
  FOR loan_rec IN (
    SELECT l.loan_id, c.name, l.due_date
    FROM loans l
    JOIN customers c ON l.customer_id = c.customer_id
    WHERE l.due_date BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.loan_id ||
                         ' for ' || loan_rec.name || 
                         ' is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
  END LOOP;
END;
/
