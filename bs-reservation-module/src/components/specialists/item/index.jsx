import React, { Component } from "react";
import PropTypes from 'prop-types';

class Item extends Component {
  render() {
    const { name, description } = this.props.data;

    return(
      <div className='specialists__item' onClick={() => this.props.changeBlocks('specialist', name)}>
        <div className='specialists__name text'>{name}</div>
        <p className='specialists__description text-little'>{description}</p>
      </div>
    )
  }
};

Item.propTypes = {
  data: PropTypes.shape({
    name: PropTypes.string,
    description: PropTypes.string
  }),
  changeBlocks: PropTypes.func
}

export default Item;
