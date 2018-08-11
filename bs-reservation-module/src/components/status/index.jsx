import React, { Component } from "react";
import PropTypes from 'prop-types';
import "./status.scss";

class Status extends Component {
  render() {
    const blocks = this.props.blocks;
    let percent = 0,
        i = 0;

    blocks.forEach((item) => {
      if (item.flag) i++;
    });
    if (i !== 0) percent = (i / (blocks.length - 1)) * 100;

    return(
      <div className='status'>
        <div className='status__bar' style={{width: percent + '%'}}></div>
      </div>
    )
  }
};

Status.propTypes = {
  blocks: PropTypes.array,
}

export default Status;
