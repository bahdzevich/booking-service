import React, { Component } from "react";
import PropTypes from 'prop-types';
import Day from './day';
import "./calendar.scss";

class Calendar extends Component {
  constructor(){
    super();
    this.state = {
      data: [],
      nowDate: +new Date().setHours(0, 0, 0, 0),
      date: new Date(),
      monthA: 'январь,февраль,март,апрель,май,июнь,июль,август,сентябрь,октябрь,доябрь,декабрь'.split(','),
      monthName: '',
      maxDay: 0,
      taday: 0,
      prevDay: false
    }
    this.getNumberOfDays = this.getNumberOfDays.bind(this);
    this.switchPrevMonth = this.switchPrevMonth.bind(this);
    this.switchNextMonth = this.switchNextMonth.bind(this);
    this.searchDay = this.searchDay.bind(this);
    // this.compareDate = this.compareDate.bind(this);
  }
  getNumberOfDays(year, month) {
    const isLeap = ((year % 4) === 0 && ((year % 100) !== 0 || (year % 400) === 0));
    return [31, (isLeap ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][month];
  }
  switchPrevMonth() {
    const month = this.state.date.getMonth() - 1;
    const nDate = this.state.date.setMonth(month);

    this.setState({
      date: new Date(nDate),
    });
    this.updateMonth();
  }
  switchNextMonth() {
    const month = this.state.date.getMonth() + 1;
    const nDate = this.state.date.setMonth(month);

    this.setState({
      date: new Date(nDate),
    });
    this.updateMonth();
  }
  searchDay(search) {
    let i = this.state.data.length;
    while (i--) {
      if (this.state.data[i].date === search) {
       return true;
      }
    }
    return false;
  }
  updateMonth() {
    const nYear = new Date().getFullYear();
    const nMonth = new Date().getMonth();


    if (nMonth === this.state.date.getMonth() && nYear === this.state.date.getFullYear()) {
      this.setState({ today: this.state.date.getDate() });
    } else {
      this.setState({ today: -99 });
    }

    this.setState({
      maxDay: (this.getNumberOfDays(this.state.date.getFullYear(), this.state.date.getMonth())),
      monthName: this.state.monthA[this.state.date.getMonth()]
    });
  }
  componentWillMount() {
    fetch('//5b7c5144b4516f0014878176.mockapi.io/booking/date', {
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
    this.updateMonth();
  }
  render() {
    const monthName = this.state.monthName,
          month = this.state.date.getMonth(),
          year = this.state.date.getFullYear(),
          maxDay = this.state.maxDay,
          today = this.state.today;

    let days = [],
        activeDay = false,
        flagToday = false,
        dataDate = 0;
    for(let i = 0; i < maxDay; i++) {
      (today === i + 1) ? flagToday = true : flagToday = false;

      dataDate = ('0' + (i + 1)).slice(-2) + '.' + ('0' + (month + 1)).slice(-2) + '.' + year;
      activeDay = this.searchDay(dataDate);

      days.push(<Day number={i+1} dataDate={dataDate} flagToday={flagToday} activeDay={activeDay} key={`day-${i}`} changeBlocks={this.props.changeBlocks}/>);
    }

    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Выберите время</div>
        <div className='calendar'>
          <div className='calendar__nav'>
            <button className='calendar__nav-arrow calendar__nav-arrow--prev' onClick={this.switchPrevMonth}>⇦</button>
            <div className='calendar__nav-month h3'>{monthName}, {year}</div>
            <button className='calendar__nav-arrow calendar__nav-arrow--next' onClick={this.switchNextMonth}>⇨</button>
          </div>
          <div className='calendar__month'>{days}</div>
        </div>
      </div>
    )
  }
};

Calendar.propTypes = {
  changeBlocks: PropTypes.func
}

export default Calendar;
