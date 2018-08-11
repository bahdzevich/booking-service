import React, { Component } from "react";
import Switch from "../switch";
import InfoBox from "../infobox";
import Calendar from "../calendar";
import Times from "../times";
import Specialists from "../specialists";
import Back from "./back";
import Status from "../status";
import Form from "../form";
import Success from "../success";
import "./booking.scss";

class Booking extends Component {
  constructor() {
    super();
    this.state = {
      blocks: [
        {
          name: 'calendar',
          flag: false,
          value: '',
        },
        {
          name: 'times',
          flag: false,
          value: '',
        },
        {
          name: 'specialists',
          flag: false,
          value: '',
        },
        {
          name: 'form',
          flag: false,
          value: '',
        },
        {
          name: 'success',
          flag: false,
        },
      ],
      resUserName: '',
      resUserSurname: '',
      resUserEmail: '',
      resUserPhone: '',
      resUserText: '',
    }
    this.changeDay = this.changeDay.bind(this);
    this.changeTime = this.changeTime.bind(this);
    this.changeName = this.changeName.bind(this);
    this.changeOrders = this.changeOrders.bind(this);
    this.changeBack = this.changeBack.bind(this);
    this.translatName = this.translatName.bind(this);
    this.returnSelectedBlocks = this.returnSelectedBlocks.bind(this);
    this.changeUserName = this.changeUserName.bind(this);
    this.changeUserSurname = this.changeUserSurname.bind(this);
    this.changeUserEmail = this.changeUserEmail.bind(this);
    this.changeUserPhone = this.changeUserPhone.bind(this);
    this.changeUserText = this.changeUserText.bind(this);
    this.resBid = this.resBid.bind(this);
  }
  changeUserName(event) {
    event.preventDefault();
    this.setState({resUserName: event.target.value});

    (event.target.value === '') ? event.target.classList.add('form__input--fail') : event.target.classList.remove('form__input--fail');
  }
  changeUserSurname(event) {
    event.preventDefault();
    this.setState({resUserSurname: event.target.value});

    (event.target.value === '') ? event.target.classList.add('form__input--fail') : event.target.classList.remove('form__input--fail');
  }
  changeUserEmail(event) {
    event.preventDefault();
    this.setState({resUserEmail: event.target.value});

    (event.target.value === '') ? event.target.classList.add('form__input--fail') : event.target.classList.remove('form__input--fail');
  }
  changeUserPhone(event) {
    event.preventDefault();
    this.setState({resUserPhone: event.target.value});

    (event.target.value === '') ? event.target.classList.add('form__input--fail') : event.target.classList.remove('form__input--fail');
  }
  changeUserText(event) {
    event.preventDefault();
    this.setState({resUserText: event.target.value});
  }
  resBid(event) {
    const blocks = this.returnSelectedBlocks('form');

    this.setState({
      blocks: blocks,
    });

    console.log('resDate: ', this.state.resDate);
    console.log('resUserName: ', this.state.resUserName);
    console.log('resUserSurname: ', this.state.resUserSurname);
    console.log('resUserEmail: ', this.state.resUserEmail);
    console.log('resUserPhone: ', this.state.resUserPhone);
    console.log('resUserText: ', this.state.resUserText);
  }
  changeBack() {
    let nBlocks = this.state.blocks;
    let i = this.state.blocks.length;
    let flag = false;

    this.state.blocks.forEach((item, index) => {
      if (!item.flag && !flag) {
        i = index;
        flag = true;
      }
    });
    nBlocks[i - 1].flag = false;
    nBlocks[i - 1].value = '';

    this.setState({
      blocks: nBlocks,
    });
  }
  returnSelectedBlocks(name, value) {
    let nBlocks = this.state.blocks;
    let i = this.state.blocks.length;
    const block = {
      name: name,
      flag: true,
      value: value,
    };

    this.state.blocks.forEach((item, index) => {
      if (item.name === name) i = index;
    });
    nBlocks[i] = block;

    return nBlocks;
  }
  changeOrders(name) {
    let nBlocks = this.state.blocks;
    let aldI = this.state.blocks.length;
    let newI = this.state.blocks.length;
    let flag = false;

    this.state.blocks.forEach((item, index) => {
      if (item.name === name) aldI = index;
      if (!item.flag && !flag) {
        newI = index;
        flag = true;
      }
    });
    const aldBlock = nBlocks[aldI];
    const newBlock = nBlocks[newI];
    nBlocks[aldI] = newBlock;
    nBlocks[newI] = aldBlock;

    this.setState({
      blocks: nBlocks,
    });
  }
  changeDay(date) {
    const blocks = this.returnSelectedBlocks('calendar', date);

    this.setState({
      blocks: blocks,
      resDate: date,
    });
  }

  changeTime(time) {
    const blocks = this.returnSelectedBlocks('times', time);

    this.setState({
      blocks: blocks,
      resTime: time,
    });
  }
  changeName(name) {
    const blocks = this.returnSelectedBlocks('specialists', name);

    this.setState({
      blocks: blocks,
      resName: name,
    });
  }
  translatName(name) {
    let nName = '';
    (name === 'calendar') && (nName = 'Дата');
    (name === 'times') && (nName = 'Время');
    (name === 'specialists') && (nName = 'Специалист');

    return nName;
  }
  render() {
    const blocks = this.state.blocks,
          dataInfo = [
            {
              name: this.translatName(this.state.blocks[0].name),
              info: this.state.blocks[0].value,
            },
            {
              name: this.translatName(this.state.blocks[1].name),
              info: this.state.blocks[1].value,
            },
            {
              name: this.translatName(this.state.blocks[2].name),
              info: this.state.blocks[2].value,
            },
          ];

    let allRes = false,
        allEvents = false,
        index = 0;

    let activeBlock = 'success';
    for(let i = 0; i < blocks.length; i++) {
      if (blocks[i].flag === false) {
        activeBlock = blocks[i].name;
        index = i;
        break;
      }
    }

    if (activeBlock === 'form' || activeBlock === 'success') allEvents = true;
    if (activeBlock === 'success') allRes = true;

    return (
      <div className={'booking' + ((activeBlock === 'form') ? ' booking--form' : '')}>
        { (!allEvents) && <Switch blocks={blocks} changeOrders={this.changeOrders} /> }
        <div className='booking__content-wrap'>
          { <InfoBox data={dataInfo} allRes={allRes} /> }
          { (activeBlock === 'calendar') && <Calendar changeDay={this.changeDay} /> }
          { (activeBlock === 'times') && <Times minTime={8} maxTime={22} changeTime={this.changeTime} /> }
          { (activeBlock === 'specialists') && <Specialists changeName={this.changeName} /> }
          { (activeBlock === 'form') &&
            <Form
              changeUserName={this.changeUserName} changeUserSurname={this.changeUserSurname}
              changeUserEmail={this.changeUserEmail} changeUserPhone={this.changeUserPhone}
              changeUserText={this.changeUserText}
              resBid={this.resBid}
              />
          }
          { (activeBlock === 'success') && <Success data={dataInfo} />}
          { (index !== 0 && index !== blocks.length - 1) && <Back changeBack={this.changeBack} />}
        </div>
        <Status blocks={blocks} />
      </div>
    );
  }
}

export default Booking;
