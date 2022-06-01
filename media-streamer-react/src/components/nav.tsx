import React from "react";
import { Link } from "react-router-dom";

const Navbar = () => {
    return (
        <nav className="Nav">
          <div className="Nav__container">
            <Link to="/" className="Nav__brand">
              Home
            </Link>
            <div className="Nav__right">
              <ul className="Nav__item-wrapper">
                <li className="Nav__item">
                  <Link className="Nav__link" to="/video">All Videos</Link>
                </li>
                <li className="Nav__item">
                  <Link className="Nav__link" to="/video/upload">Upload</Link>
                </li>
              </ul>
            </div>
          </div>
        </nav>
      );
}

export default Navbar;