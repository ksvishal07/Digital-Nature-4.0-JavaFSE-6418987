DECLARE
    CURSOR cur_customers IS
        SELECT CustomerID, Name FROM Customers;
    CURSOR cur_transactions(p_cust_id NUMBER) IS
        SELECT t.*
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE a.CustomerID = p_cust_id
          AND EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
    FOR cust_rec IN cur_customers LOOP
        DBMS_OUTPUT.PUT_LINE('Statement for Customer: ' || cust_rec.Name || ' (ID: ' || cust_rec.CustomerID || ')');
        FOR txn_rec IN cur_transactions(cust_rec.CustomerID) LOOP
            DBMS_OUTPUT.PUT_LINE('  TransactionID: ' || txn_rec.TransactionID || ', Date: ' || txn_rec.TransactionDate || ', Amount: ' || txn_rec.Amount || ', Type: ' || txn_rec.TransactionType);
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
    END LOOP;
END;
/

DECLARE
    CURSOR cur_accounts IS
        SELECT AccountID, Balance FROM Accounts;
    v_fee NUMBER := 100;
BEGIN
    FOR acc_rec IN cur_accounts LOOP
        UPDATE Accounts SET Balance = Balance - v_fee, LastModified = SYSDATE WHERE AccountID = acc_rec.AccountID;
        DBMS_OUTPUT.PUT_LINE('Annual fee applied to AccountID: ' || acc_rec.AccountID);
    END LOOP;
    COMMIT;
END;
/

DECLARE
    CURSOR cur_loans IS
        SELECT LoanID, InterestRate FROM Loans;
    v_new_rate NUMBER := 4.0;
BEGIN
    FOR loan_rec IN cur_loans LOOP
        UPDATE Loans SET InterestRate = v_new_rate WHERE LoanID = loan_rec.LoanID;
        DBMS_OUTPUT.PUT_LINE('Updated LoanID: ' || loan_rec.LoanID || ' to new Interest Rate: ' || v_new_rate);
    END LOOP;
    COMMIT;
END;
/