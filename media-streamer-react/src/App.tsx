import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';

const App = () => {
  return (
    <div className='container'>
      <ul>
        <li>
          <Link to='/video/test'>Watch Now</Link>
        </li>
        <li>
          <Link to='/video/upload'>Upload</Link>
        </li>
      </ul>
    </div>
  )
}

export default App;
