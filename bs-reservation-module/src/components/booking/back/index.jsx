import React, { Component } from "react";
import PropTypes from 'prop-types';

class Back extends Component {
  render() {
    return(
      <div className='booking__back'>
        <a className='booking__back-btn' onClick={() => this.props.changeBack()}>⇦</a>
      </div>
    )
  }
};

Back.propTypes = {
  changeBack: PropTypes.func,
}

export default Back;
