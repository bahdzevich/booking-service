import React, { Component } from "react";
import PropTypes from 'prop-types';

class Item extends Component {
  render() {
    const { name, description } = this.props.data;

    return(
      <div className='specialists__item' data-name={name} data-description={description} onClick={() => this.props.changeName(name, description)}>
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
  changeName: PropTypes.func
}

export default Item;
