import React, { Component } from 'react';
import './base/styles/common.scss';
import Booking from './components/booking';

class App extends Component {
  render() {
    return (
      <div className="main">
        <Booking />
      </div>
    );
  }
}

export default App;
