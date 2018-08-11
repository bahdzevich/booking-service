import React, { Component } from "react";
import PropTypes from 'prop-types';
import Item from './item';
import "./specialists.scss";

class Specialists extends Component {
  constructor(){
    super();
    this.state = {
      data: [
        {
          id: '0',
          name: 'Абрамов Владлен Романович',
          description: 'Стоматолог',
        },
        {
          id: '1',
          name: 'Белозёров Илларион Борисович',
          description: 'Терапевт',
        },
        {
          id: '3',
          name: 'Мишин Давид Сергеевич',
          description: 'Педиатр',
        },
        {
          id: '4',
          name: 'Рябов Игорь Львович',
          description: 'Рентгенолог',
        },
        {
          id: '5',
          name: 'Якушев Александр Максимович',
          description: 'Психиатр',
        },
        {
          id: '6',
          name: 'Хохлов Леон Дмитриевич',
          description: 'Врач функциональной диагностики',
        },
        {
          id: '7',
          name: 'Овчинников Александр Евгеньевич',
          description: 'Офтальмолог',
        },
      ],
    }
  }
  render() {
    const data = this.state.data;
    // console.log(data);

    return(
      <div className='booking__content'>
        <div className='booking__title h2'>Выберите специалиста</div>
        <div className='specialists'>
          {data.length > 0 &&
            data.map((item, i) => <Item data={item} key={`specialist-${i}`} changeName={this.props.changeName} />)
          }
          {data.length === 0 && 'нет специалистов' }
        </div>
      </div>
    )
  }
};

Specialists.propTypes = {
  changeName: PropTypes.func
}

export default Specialists;
