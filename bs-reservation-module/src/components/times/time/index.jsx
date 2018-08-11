import React, { Component } from "react";
import PropTypes from 'prop-types';

class Time extends Component {
  render() {
    const timeFrom = this.props.timeFrom,
          timeTo = this.props.timeTo,
          time = this.props.time,
          activeTime = this.props.activeTime;

          // data-time-from={timeFrom + ':00'}
          // data-time-to={timeTo + ':00'}
    return(
      <div className={'times__item' + (activeTime ? '' : ' times__item--no-active')}
            onClick={() => this.props.changeTime(time)} >
        <span className='times__text times__text--form text-little'>{timeFrom}:00</span>
        <span className='times__text times__text--dash text-little'>–</span>
        <span className='times__text times__text--to text-little'>{timeTo}:00</span>
      </div>
    )
  }
};

Time.propTypes = {
  timeFrom: PropTypes.string,
  timeTo: PropTypes.string,
  time: PropTypes.string,
  activeTime: PropTypes.bool,
  changeTime: PropTypes.func
}

export default Time;
