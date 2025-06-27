BEGIN
  FOR rec IN (SELECT CustomerID, DOB FROM Customers) LOOP
    IF (MONTHS_BETWEEN(SYSDATE, rec.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

BEGIN
  FOR rec IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF rec.Balance > 10000 THEN
      UPDATE Customers
      SET Balance = rec.Balance, LastModified = SYSDATE
      WHERE CustomerID = rec.CustomerID;
    END IF;
  END LOOP;
  COMMIT;
END;
/

DECLARE
  v_due_date Loans.EndDate%TYPE;
  v_customer_id Loans.CustomerID%TYPE;
BEGIN
  FOR rec IN (
    SELECT CustomerID, EndDate
    FROM Loans
    WHERE EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.CustomerID ||
                         ' has a loan due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
