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
          name: 'date',
          flag: false,
          value: '',
        },
        {
          name: 'time',
          flag: false,
          value: '',
        },
        {
          name: 'specialist',
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
      selOptions: '',
      resUserName: '',
      resUserSurname: '',
      resUserEmail: '',
      resUserPhone: '',
      resUserText: '',
    }
    this.changeBlocks = this.changeBlocks.bind(this);
    this.changeOrders = this.changeOrders.bind(this);
    this.changeBack = this.changeBack.bind(this);
    this.translatName = this.translatName.bind(this);
    this.returnSelectedBlocks = this.returnSelectedBlocks.bind(this);
    this.setOptions = this.setOptions.bind(this);
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

    // console.log('resDate: ', this.state.resDate);
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
  changeBlocks(name, value) {
    const blocks = this.returnSelectedBlocks(name, value);

    this.setState({
      blocks: blocks,
    });
    this.setOptions();
  }
  translatName(name) {
    let nName = '';
    (name === 'date') && (nName = 'Дата');
    (name === 'time') && (nName = 'Время');
    (name === 'specialist') && (nName = 'Специалист');

    return nName;
  }
  setOptions() {
    let options = '';
    this.state.blocks.forEach((item) => {
      if (item.name !== 'success' && item.name !== 'form') {
        options += `?${item.name}`;
        options += `=${item.value}`;
      }
    });

    this.setState({selOptions: options});
  }
  render() {
    const blocks = this.state.blocks,
          selOptions = this.state.selOptions,
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
          { (activeBlock === 'date') && <Calendar changeBlocks={this.changeBlocks} selOptions={selOptions} /> }
          { (activeBlock === 'time') && <Times minTime={8} maxTime={22} changeBlocks={this.changeBlocks} selOptions={selOptions}/> }
          { (activeBlock === 'specialist') && <Specialists changeBlocks={this.changeBlocks} selOptions={selOptions} /> }
          { (activeBlock === 'form') &&
            <Form
              changeUserName={this.changeUserName} changeUserSurname={this.changeUserSurname}
              changeUserEmail={this.changeUserEmail} changeUserPhone={this.changeUserPhone}
              changeUserText={this.changeUserText}
              resBid={this.resBid}
              />
          }
          { (activeBlock === 'success') && <Success />}
          { (index !== 0 && index !== blocks.length - 1) && <Back changeBack={this.changeBack} />}
        </div>
        <Status blocks={blocks} />
      </div>
    );
  }
}

export default Booking;
