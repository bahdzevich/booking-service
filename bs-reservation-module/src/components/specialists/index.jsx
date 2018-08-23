import React, { Component } from "react";
import PropTypes from 'prop-types';
import Item from './item';
import "./specialists.scss";

class Specialists extends Component {
  constructor(){
    super();
    this.state = {
      data: [],
    }
  }
  componentWillMount() {
    fetch(`https://5b7c5144b4516f0014878176.mockapi.io/booking/specialists${this.props.selOptions}`, {
      method: 'get',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })
    .then(response => response.ok ? response.json() : console.error('Error while fetching specialists.'))
    .then(result => {
      console.log(result);
      result && this.setState({data: result});
    });
  }
  render() {
    const data = this.state.data;
    // console.log(data);

    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Выберите специалиста</div>
        <div className='specialists'>
          {data.length > 0 &&
            data.map((item, i) => <Item data={item} key={`specialist-${i}`} changeBlocks={this.props.changeBlocks} />)
          }
          {data.length === 0 && 'Нет специалистов.' }
        </div>
      </div>
    )
  }
};

Specialists.propTypes = {
  selOptions: PropTypes.string,
  changeBlocks: PropTypes.func
}

export default Specialists;
