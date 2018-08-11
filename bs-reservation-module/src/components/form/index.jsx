import React, { Component } from "react";
import PropTypes from 'prop-types';
import "./form.scss";

class Form extends Component {
  render() {
    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Заполните форму</div>
        <div className='form'>
          <div className='form__item'>
            <div className='form__title h3'>Ваше имя</div>
            <input className='form__input' ref='resUserName' onChange={this.props.changeUserName} placeholder='Введите имя'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваша фамилия</div>
            <input className='form__input' ref='resUserSurname' onChange={this.props.changeUserSurname} placeholder='Введите фамилию'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваш Email</div>
            <input className='form__input' ref='resUserEmail' onChange={this.props.changeUserEmail} placeholder='Введите email'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваш телефон</div>
            <input className='form__input' ref='resUserPhone' onChange={this.props.changeUserPhone} placeholder='Введите телефон'/>
          </div>

          <div className='form__item'>
            <div className='form__title h3'>Ваше пожелание</div>
            <textarea className='form__textarea' ref='resUserText' onChange={this.props.changeUserText} placeholder='Введите дополнительный текст'></textarea>
          </div>

          <button className='form__btn' onClick={this.props.resBid}>⇨</button>
        </div>
      </div>
    )
  }
};

Form.propTypes = {
  changeUserName: PropTypes.func,
  changeUserSurname: PropTypes.func,
  changeUserEmail: PropTypes.func,
  changeUserPhone: PropTypes.func,
  changeUserText: PropTypes.func,
  resBid: PropTypes.func
}

export default Form;
