import React, { Component } from "react";
import PropTypes from 'prop-types';
import Loading from '../loading';
import Time from './time';
import "./times.scss";

class Times extends Component {
  constructor(){
    super();
    this.state = {
      data: [],
      getFlag: false,
    }

    this.searchTime = this.searchTime.bind(this);
    this.getData = this.getData.bind(this);
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
  getData() {
    fetch(`https://5b7c5144b4516f0014878176.mockapi.io/booking/times${this.props.selOptions}`, {
      method: 'get',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })
    .then(response => response.ok ? response.json() : console.error('Error while fetching dates.'))
    .then(result => {
      console.log(result);
      result && this.setState({data: result});
      this.setState({getFlag: true});
    });
  }
  componentWillMount() {
    this.getData();
  }
  render() {
    const getFlag = this.state.getFlag,
          minTime = this.props.minTime,
          maxTime = this.props.maxTime;

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
        {(!getFlag) && <Loading />}
      </div>
    )
  }
};

Times.propTypes = {
  minTime: PropTypes.number,
  maxTime: PropTypes.number,
  changeBlocks: PropTypes.func,
  selOptions: PropTypes.string,
}

export default Times;
