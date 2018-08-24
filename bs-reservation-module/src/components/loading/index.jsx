import React, { Component } from "react";
import Load from './icons/load.svg';
import "./loading.scss";

class Loading extends Component {
  render() {
    return(
      <div className='loading'>
        <div className='loading__icon'>
          <Load width={20} height={20}/>
        </div>
      </div>
    )
  }
};

export default Loading;
