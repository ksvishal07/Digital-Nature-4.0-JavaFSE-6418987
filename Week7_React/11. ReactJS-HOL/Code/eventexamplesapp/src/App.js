import React, { Component } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 0
    };
  }

  increment = () => {
    this.setState(prev => ({ counter: prev.counter + 1 }));
  };

  sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  };

  decrement = () => {
    this.setState(prev => ({ counter: prev.counter - 1 }));
  };

  sayWelcome = (msg) => {
    alert(`Message: ${msg}`);
  };

  handleClick = (event) => {
    console.log("Synthetic Event Triggered");
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>React Event Examples</h1>
        
        <h2>Counter: {this.state.counter}</h2>
        <button onClick={this.handleIncrement}>Increment</button>{' '}
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />
        <button onClick={() => this.sayWelcome("Welcome!")}>Say Welcome</button>

        <br /><br />
        <button onClick={this.handleClick}>Click On Me</button>

        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
