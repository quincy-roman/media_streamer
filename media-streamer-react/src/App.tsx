import React from 'react';
import { Link, Outlet } from 'react-router-dom';
import './App.css';
import Navbar from './components/nav';

const App = () => {
  return (
    <div className='container'>
      <Navbar/>
      <Outlet/>
    </div>
    
  )
}

export default App;
