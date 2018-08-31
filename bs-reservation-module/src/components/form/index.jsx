import React, { Component } from "react";
import PropTypes from 'prop-types';
import IMask from 'imask';
import "./form.scss";

class Form extends Component {
  constructor(){
    super();
    this.state = {
      userInfo: {
        name: '',
        surname: '',
        email: '',
        phone: '',
        text: '',
      },
    }
    this.changeInput = this.changeInput.bind(this);
    this.checkInput = this.checkInput.bind(this);
    this.sumbit = this.sumbit.bind(this);
  }
  changeInput(event, name) {
    let userInfo = this.state.userInfo;
    const val = event.target.value.trim();
    userInfo[name] = val;
    this.setState({userInfo: userInfo});
  }
  checkInput(val, el, type) {
    let flag = true;
    if (type === 'name' || type === 'surname') {
      if (val.length <= 2) {
        flag = false;
        el.classList.add('form__input--fail');
      } else {
        el.classList.remove('form__input--fail');
      }
    } else if (type === 'email') {
      if (val.indexOf('@') <= 0 || val.indexOf('.') <= 0){
        flag = false;
        el.classList.add('form__input--fail');
      } else {
        el.classList.remove('form__input--fail');
      }
    } else if (type === 'phone') {
      if (val.length < 17) {
        flag = false;
        el.classList.add('form__input--fail');
      } else {
        el.classList.remove('form__input--fail');
      }
    }

    return flag;
  }
  sumbit() {
    let flag = true;
    if (!this.checkInput(this.state.userInfo.name, this.name, 'name')) flag = false;
    if (!this.checkInput(this.state.userInfo.surname, this.surname, 'surname')) flag = false;
    if (!this.checkInput(this.state.userInfo.email, this.email, 'email')) flag = false;
    if (!this.checkInput(this.state.userInfo.phone, this.phone, 'phone')) flag = false;
    if (!this.checkInput(this.state.userInfo.text, this.text, 'text')) flag = false;

    if (flag) this.props.resBid(this.state.userInfo);
  }
  componentDidMount() {
    const maskOptions = {
      mask: '+{3}(375)00 000-00-00',
    };

    new IMask(this.phone, maskOptions);
  }
  render() {
    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Заполните форму</div>
        <div className='form'>
          <div className='form__item'>
            <div className='form__title h3'>Ваше имя</div>
            <input className='form__input'
                type='text'
                ref={(input) => this.name = input}
                onChange={(event) => this.changeInput(event, 'name')} placeholder='Введите имя'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваша фамилия</div>
            <input className='form__input'
                type='text'
                ref={(input) => this.surname = input}
                onChange={(event) => this.changeInput(event, 'surname')}
                placeholder='Введите фамилию'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваш Email</div>
            <input className='form__input'
                type='text'
                ref={(input) => this.email = input}
                onChange={(event) => this.changeInput(event, 'email')}
                placeholder='Введите email'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваш телефон</div>
            <input className='form__input'
                type='text'
                ref={(input) => this.phone = input}
                onChange={(event) => this.changeInput(event, 'phone')}
                placeholder='Введите телефон'
            />
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваше пожелание</div>
            <textarea className='form__input form__input--textarea'
                ref={(textarea) => this.text = textarea}
                onChange={(event) => this.changeInput(event, 'text')}
                placeholder='Введите дополнительный текст'></textarea>
          </div>

          <button className='form__btn' onClick={this.sumbit}>Забронировать ⇨</button>
        </div>
      </div>
    )
  }
};

Form.propTypes = {
  resBid: PropTypes.func
}

export default Form;
