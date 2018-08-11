import React, { Component } from "react";
import PropTypes from 'prop-types';
import Item from './item';
import "./info-box.scss";

class InfoBox extends Component {
  render() {
    const data = this.props.data,
          allRes = this.props.allRes;
    let info = [];

    data.forEach((item, i) => {
      if (item.info !== '') info.push(<Item name={item.name} info={item.info} key={`list-item-${i}`} />);
    });

    return(
      <div className={'info-box' + (((info.length === 0) || allRes) ? ' info-box--disabled' : '')}>
        <a className='info-box__icon text'>
          <span>i</span>
        </a>
        <div className='info-box__list-wrap'>
          <ul className='info-box__list'>
            {info}
          </ul>
        </div>
      </div>
    )
  }
};

InfoBox.propTypes = {
  data: PropTypes.array,
  allRes: PropTypes.bool,
}

export default InfoBox;
