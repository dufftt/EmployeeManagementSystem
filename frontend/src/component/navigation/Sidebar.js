import React, {Component} from 'react';
import "./Sidebar.css"

class Sidebar extends Component {
    render() {
        return (
            <div className="sm:w-56 min-h-screen bgsidebar fixed hidden sm:block w-full ">
                <div className="h-20 font-serif lg:block font-bold">
                    <h1 className="text-center text-3xl p-5 text-white">
                        Cognizant
                    </h1>
                </div>
                <div className="text-gray-100 ">
                    <div className="p-3 h-12 z-20 text-lg">
                        <div className="float-left pl-3"><i className={"fas fa-home"+ " px-2"}
                                                            aria-hidden="true"/>Home</div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Sidebar;