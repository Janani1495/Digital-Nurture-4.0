SET SERVEROUTPUT ON;


BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE savings_accounts';
    EXECUTE IMMEDIATE 'DROP TABLE employees';
    EXECUTE IMMEDIATE 'DROP TABLE accounts';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/



-- Table for Scenario 1
CREATE TABLE savings_accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

-- Table for Scenario 2
CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    department_id NUMBER,
    salary NUMBER
);

-- Table for Scenario 3
CREATE TABLE accounts (
    acc_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    balance NUMBER
);

-- Insert Data for Scenario 1
INSERT INTO savings_accounts VALUES (1, 101, 5000);
INSERT INTO savings_accounts VALUES (2, 102, 10000);
INSERT INTO savings_accounts VALUES (3, 103, 7500);

-- Insert Data for Scenario 2
INSERT INTO employees VALUES (1, 'Alice', 10, 50000);
INSERT INTO employees VALUES (2, 'Bob', 10, 60000);
INSERT INTO employees VALUES (3, 'Charlie', 20, 55000);

-- Insert Data for Scenario 3
INSERT INTO accounts VALUES (1001, 101, 7000);
INSERT INTO accounts VALUES (1002, 102, 3000);

COMMIT;


CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    FOR acc_rec IN (SELECT account_id, balance FROM savings_accounts) LOOP
        UPDATE savings_accounts
        SET balance = acc_rec.balance * 1.01
        WHERE account_id = acc_rec.account_id;

        DBMS_OUTPUT.PUT_LINE('Interest applied to Account ' || acc_rec.account_id ||
                             '. New Balance: ' || TO_CHAR(acc_rec.balance * 1.01));
    END LOOP;

    COMMIT;
END;
/


BEGIN
    ProcessMonthlyInterest;
END;
/


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_id IN NUMBER,
    bonus_pct IN NUMBER
) IS
BEGIN
    FOR emp_rec IN (SELECT emp_id, salary FROM employees WHERE department_id = dept_id) LOOP
        UPDATE employees
        SET salary = emp_rec.salary + (emp_rec.salary * bonus_pct / 100)
        WHERE emp_id = emp_rec.emp_id;

        DBMS_OUTPUT.PUT_LINE('Bonus applied to Emp ID ' || emp_rec.emp_id ||
                             '. New Salary: ' || TO_CHAR(emp_rec.salary + (emp_rec.salary * bonus_pct / 100)));
    END LOOP;

    COMMIT;
END;
/


BEGIN
    UpdateEmployeeBonus(10, 10);
END;
/


CREATE OR REPLACE PROCEDURE TransferFunds (
    from_acc_id IN NUMBER,
    to_acc_id IN NUMBER,
    amount IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    
    SELECT balance INTO v_balance FROM accounts WHERE acc_id = from_acc_id;

    IF v_balance < amount THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: Insufficient funds.');
    ELSE
        
        UPDATE accounts SET balance = balance - amount WHERE acc_id = from_acc_id;

        
        UPDATE accounts SET balance = balance + amount WHERE acc_id = to_acc_id;

        DBMS_OUTPUT.PUT_LINE('Transfer successful: ' || amount || 
                             ' transferred from Account ' || from_acc_id || 
                             ' to Account ' || to_acc_id);
    END IF;

    COMMIT;
END;
/


BEGIN
    TransferFunds(1001, 1002, 2000);
END;
/
