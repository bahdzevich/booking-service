import React, { Component } from "react";
import PropTypes from 'prop-types';
import Time from './time';
import "./times.scss";

class Times extends Component {
  constructor(){
    super();
    this.state = {
      data: [
        {
          id: '0',
          time: '08:00-09:00'
        },
        {
          id: '1',
          time: '9:00-10:00'
        },
        {
          id: '2',
          time: '10:00-11:00'
        },
        {
          id: '3',
          time: '11:00-12:00'
        },
        {
          id: '4',
          time: '12:00-13:00'
        },
        {
          id: '5',
          time: '14:00-15:00'
        },
        {
          id: '6',
          time: '12:00-13:00'
        },
        {
          id: '7',
          time: '13:00-14:00'
        },
        {
          id: '8',
          time: '15:00-16:00'
        },
        {
          id: '9',
          time: '16:00-17:00'
        },
        {
          id: '10',
          time: '17:00-18:00'
        },
        {
          id: '11',
          time: '19:00-20:00'
        },
        {
          id: '12',
          time: '21:00-22:00'
        },
      ],
    }

    this.searchTime = this.searchTime.bind(this);
  }

  searchTime(search) {
    let i = this.state.data.length;
    while (i--) {
      if (this.state.data[i].time === search) {
       return true;
      }
    }
    return false;
  }

  render() {
    const minTime = this.props.minTime;
    const maxTime = this.props.maxTime;

    let times = [],
        timeTo,
        timeFrom,
        time,
        activeTime = false;
    for(let i = minTime; i < maxTime; i++) {
      timeFrom = ('0' + (i)).slice(-2);
      timeTo = ('0' + (i + 1)).slice(-2);
      time = `${timeFrom}:00-${timeTo}:00`;

      activeTime = this.searchTime(time);

      times.push(<Time timeFrom={timeFrom} timeTo={timeTo} time={time} activeTime={activeTime} key={`time-${i}`} changeTime={this.props.changeTime} />);
    }

    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Выберите время</div>
        <div className='times'>
          {times}
        </div>
      </div>
    )
  }
};

Times.propTypes = {
  minTime: PropTypes.number,
  maxTime: PropTypes.number,
  changeTime: PropTypes.func
}

export default Times;
