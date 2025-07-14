
SET SERVEROUTPUT ON;


BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE loans';
    EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/


CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    age NUMBER,
    balance NUMBER,
    IsVIP VARCHAR2(5)
);

CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER,
    due_date DATE,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);


INSERT INTO customers VALUES (1, 'John Doe', 65, 12000, 'FALSE');
INSERT INTO customers VALUES (2, 'Jane Smith', 45, 8000, 'FALSE');
INSERT INTO customers VALUES (3, 'Mohan Kumar', 70, 9500, 'FALSE');
INSERT INTO customers VALUES (4, 'Priya Iyer', 35, 15000, 'FALSE');

INSERT INTO loans VALUES (101, 1, 10, SYSDATE + 10);
INSERT INTO loans VALUES (102, 2, 12, SYSDATE + 35);
INSERT INTO loans VALUES (103, 3, 11, SYSDATE + 5);
INSERT INTO loans VALUES (104, 4, 9, SYSDATE + 25);

COMMIT;


BEGIN
    FOR cust_rec IN (
        SELECT l.loan_id, l.interest_rate
        FROM customers c
        JOIN loans l ON c.customer_id = l.customer_id
        WHERE c.age > 60
    ) LOOP
        UPDATE loans
        SET interest_rate = cust_rec.interest_rate - 1
        WHERE loan_id = cust_rec.loan_id;
    END LOOP;
    COMMIT;
END;
/


BEGIN
    FOR cust_rec IN (
        SELECT customer_id, balance
        FROM customers
    ) LOOP
        IF cust_rec.balance > 10000 THEN
            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = cust_rec.customer_id;
        END IF;
    END LOOP;
    COMMIT;
END;
/

BEGIN
    FOR loan_rec IN (
        SELECT l.loan_id, l.customer_id, c.name, l.due_date
        FROM loans l
        JOIN customers c ON l.customer_id = c.customer_id
        WHERE l.due_date <= SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ID ' || loan_rec.loan_id ||
                             ' for Customer ' || loan_rec.name ||
                             ' is due on ' || TO_CHAR(loan_rec.due_date, 'DD-MON-YYYY'));
    END LOOP;
END;
/
