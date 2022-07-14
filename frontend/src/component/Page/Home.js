import React, {Component} from 'react';
import Card from "../Utility/Card";

class Home extends Component {
    render() {
        return (
            <div className="sm:ml-56 flex flex-wrap">
                <div className="lg:w-1/3 md:w-1/2 w-full p-5"><Card><p className="font-sans font-semibold">Hello world !!</p></Card></div>
                <div className="lg:w-1/3 md:w-1/2 w-full p-5"><Card/></div>
                <div className="lg:w-1/3 md:w-1/2 w-full p-5"><Card/></div>
            </div>
        );
    }
}

export default Home;