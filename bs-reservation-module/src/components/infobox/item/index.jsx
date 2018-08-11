import React, { Component } from "react";
import PropTypes from 'prop-types';

class Item extends Component {
  render() {
    const name = this.props.name,
          info = this.props.info;

    return(
      <li className='info-box__list-item text-little'>{name}: {info}</li>
    )
  }
};

Item.propTypes = {
  name: PropTypes.string,
  info: PropTypes.string,
}

export default Item;
