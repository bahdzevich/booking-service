import React, { Component } from "react";
import PropTypes from 'prop-types';
import Item from './item';
import "./success.scss";

class Success extends Component {
  render() {
    const data = this.props.data;
    let info = [];

    data.forEach((item, i) => {
      if (item.info !== '') info.push(<Item name={item.name} info={item.info} key={`info-item-${i}`} />);
    });

    return(
      <div className='booking__content'>
        <div className='success'>
          <div className='success__head'>
            <div className='success__title h1'>Спасибо</div>
            <div className='success__s-title h2'>Ваша заявка отправлена</div>
            <div className='success__t-title h3'>Вам придет смс</div>
          </div>

          <div className='success__info'>
            <div className='success__info-title h3'>Ваша заявка:</div>
            {info}
          </div>
        </div>
      </div>
    )
  }
};

Success.propTypes = {
  data: PropTypes.array,
}

export default Success;
