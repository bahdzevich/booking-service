import React, { Component } from "react";
import PropTypes from 'prop-types';

class Item extends Component {
  render() {
    const name = this.props.name,
          info = this.props.info;

    return(
      <p className='success__info-item text'>{name}: {info}</p>
    )
  }
};

Item.propTypes = {
  number: PropTypes.string,
  dataDate: PropTypes.string,
}

export default Item;
