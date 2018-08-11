import React, { Component } from "react";
import PropTypes from 'prop-types';
import Worker from './icons/worker.svg';
import Clock from './icons/clock.svg';
import Calendar from './icons/calendar.svg';

class Item extends Component {
  render() {
    const name = this.props.name,
          className = this.props.className;

    return(
      <div className={'switch__item' + className} onClick={() => this.props.changeOrders(name)}>
        { (name === 'calendar') && <Calendar width={20} height={20}/> }
        { (name === 'times') && <Clock width={20} height={20}/> }
        { (name === 'specialists') && <Worker width={20} height={20}/> }
      </div>
    )
  }
};

Item.propTypes = {
  name: PropTypes.string,
  className: PropTypes.string,
  changeOrders: PropTypes.func
}

export default Item;
