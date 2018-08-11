import React, { Component } from "react";
import PropTypes from 'prop-types';

class Day extends Component {
  render() {
    const number = this.props.number,
          activeDay = this.props.activeDay,
          flagToday = this.props.flagToday,
          dataDate = this.props.dataDate;

    return(
      <div className={'calendar__day' + (flagToday ? ' calendar__day--today' : '') + (activeDay ? '' : ' calendar__day--no-active')}
            onClick={() => this.props.changeDay(dataDate)}>
        <span className='calendar__day-number text-little'>{number}</span>
      </div>
    )
  }
};

Day.propTypes = {
  number: PropTypes.number,
  dataDate: PropTypes.string,
  activeDay: PropTypes.bool,
  flagToday: PropTypes.bool,
  changeDay: PropTypes.func,
}

export default Day;
