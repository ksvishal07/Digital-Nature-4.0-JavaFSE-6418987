import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [currency, setCurrency] = useState('INR');
  const [amount, setAmount] = useState('');

  const handleSubmit = () => {
    const numAmount = parseFloat(amount);
    if (isNaN(numAmount)) {
      alert("Please enter a valid number.");
      return;
    }

    const conversionRate = 0.011;
    let result = 0;
    let message = "";

    if (currency === 'INR') {
      result = numAmount * conversionRate;
      message = `€${result.toFixed(2)} is equivalent to ₹${numAmount}`;
    } else {
      result = numAmount / conversionRate;
      message = `₹${result.toFixed(2)} is equivalent to €${numAmount}`;
    }

    alert(`Converted Amount: ${message}`);
  };

  return (
    <div style={{ marginTop: '40px' }}>
      <h2>Currency Convertor</h2>

      <label>
        Select Currency:
        <select
          value={currency}
          onChange={(e) => setCurrency(e.target.value)}
          style={{ marginLeft: '10px' }}
        >
          <option value="INR">INR to EUR</option>
          <option value="EUR">EUR to INR</option>
        </select>
      </label>

      <br /><br />

      <input
        type="text"
        placeholder={`Enter amount in ${currency}`}
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
      />

      <button onClick={handleSubmit} style={{ marginLeft: '10px' }}>
        Convert
      </button>
    </div>
  );
};

export default CurrencyConvertor;
