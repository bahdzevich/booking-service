import React, { Component } from "react";
import PropTypes from 'prop-types';
import Time from './time';
import "./times.scss";

class Times extends Component {
  constructor(){
    super();
    this.state = {
      data: [],
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
  componentWillMount() {
    fetch('//5b7c5144b4516f0014878176.mockapi.io/booking/times', {
      method: 'get',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })
    .then(response => response.ok ? response.json() : console.error('Error while fetching deficit'))
    .then(authResult => {
      console.log(authResult);
      this.setState({data: authResult});
    });
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

      times.push(<Time timeFrom={timeFrom} timeTo={timeTo} time={time} activeTime={activeTime} key={`time-${i}`} changeBlocks={this.props.changeBlocks} />);
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
  changeBlocks: PropTypes.func
}

export default Times;
