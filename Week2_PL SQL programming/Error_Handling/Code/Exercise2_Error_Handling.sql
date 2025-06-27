CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id IN NUMBER,
    p_to_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_from_balance NUMBER;
    v_to_balance NUMBER;
    v_error_msg VARCHAR2(4000);
BEGIN
    SELECT Balance INTO v_from_balance FROM Accounts WHERE AccountID = p_from_account_id FOR UPDATE;
    IF v_from_balance < p_amount THEN
        v_error_msg := 'Insufficient funds in account ' || p_from_account_id;
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (Transactions_seq.NEXTVAL, p_from_account_id, SYSDATE, 0, 'Error');
        RAISE_APPLICATION_ERROR(-20001, v_error_msg);
    END IF;
    UPDATE Accounts SET Balance = Balance - p_amount, LastModified = SYSDATE WHERE AccountID = p_from_account_id;
    UPDATE Accounts SET Balance = Balance + p_amount, LastModified = SYSDATE WHERE AccountID = p_to_account_id;
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_from_account_id, SYSDATE, -p_amount, 'Transfer Out');
    INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (Transactions_seq.NEXTVAL, p_to_account_id, SYSDATE, p_amount, 'Transfer In');
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        v_error_msg := 'Error during fund transfer: ' || SQLERRM;
        INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
        VALUES (Transactions_seq.NEXTVAL, p_from_account_id, SYSDATE, 0, 'Error');
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE(v_error_msg);
END;
/

CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id IN NUMBER,
    p_percent IN NUMBER
) AS
    v_old_salary NUMBER;
    v_error_msg VARCHAR2(4000);
BEGIN
    SELECT Salary INTO v_old_salary FROM Employees WHERE EmployeeID = p_employee_id FOR UPDATE;
    UPDATE Employees SET Salary = Salary + (Salary * p_percent / 100), HireDate = HireDate WHERE EmployeeID = p_employee_id;
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        v_error_msg := 'Employee ID ' || p_employee_id || ' does not exist.';
        DBMS_OUTPUT.PUT_LINE(v_error_msg);
    WHEN OTHERS THEN
        v_error_msg := 'Error updating salary: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE(v_error_msg);
        ROLLBACK;
END;
/

CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id IN NUMBER,
    p_name IN VARCHAR2,
    p_dob IN DATE,
    p_balance IN NUMBER
) AS
    v_error_msg VARCHAR2(4000);
BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);
    COMMIT;
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        v_error_msg := 'Customer with ID ' || p_customer_id || ' already exists.';
        DBMS_OUTPUT.PUT_LINE(v_error_msg);
    WHEN OTHERS THEN
        v_error_msg := 'Error adding new customer: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE(v_error_msg);
        ROLLBACK;
END;
/