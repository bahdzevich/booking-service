import React, { Component } from "react";
import PropTypes from 'prop-types';
import Item from './item';
import "./switch.scss";

class Switch extends Component {
  render() {
    const blocks = this.props.blocks;

    let className = '',
        items = [],
        flag = false;

    blocks.forEach((item, i) => {
      className = '';
      if (i < blocks.length - 2) {
        if (!item.flag && !flag) {
          className = ' switch__item--active';
          flag = true;
        } else {
          className = '';
        }
        (item.flag) ? (className += ' switch__item--no-active') : (className += '');
        items.push(<Item name={item.name} className={className} changeOrders={this.props.changeOrders} key={`switch-${i}`} />);
      }
    });

    return(
      <div className='switch'>
        {items}
      </div>
    )
  }
};

Switch.propTypes = {
  blocks: PropTypes.array,
  changeOrders: PropTypes.func,
}

export default Switch;
