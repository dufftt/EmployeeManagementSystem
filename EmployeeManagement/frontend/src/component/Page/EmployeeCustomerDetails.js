import React, {Component} from 'react';
import TopNavEmployee from "../navigation/TopNavEmployee";
import Card from "../Utility/Card";
import {Field, Input, Label, Textarea} from "@zendeskgarden/react-forms";
import AccountInfo from "../Utility/AccountInfo";
import {Link, useParams} from "react-router-dom";
import AccountClient from "../../Client/AccountClient";
import CustomerClient from "../../Client/CustomerClient";
import { Button } from '@zendeskgarden/react-buttons';
import {Datepicker} from "@zendeskgarden/react-datepickers";


function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
}
class EmployeeCustomerDetails extends Component {
    state={
        user:null
    }
    componentDidMount() {
        console.log(this.props.user.authToken);
        console.log(this.props.params.account)
        CustomerClient.getcustomerdetails(this.props.user.authToken,this.props.params.account).then(r => {
            r.accounts=r.accounts.map(account=>{
                let newaccount={};
                newaccount.accountId=account.accountId;
                newaccount.currentBalance=account.currentBalance;
                newaccount.accountType=account.accountType
                return newaccount
            })
            r.dateOfBirth=new Date(r.dateOfBirth);
            console.log(r)
            this.setState({user:r})
        });
    }
    render() {
        if(this.state.user==null){
            return <div></div>
        }else{
            return (
                <div className="sm:ml-56">
                    <div className="fixed w-full pr-56"><TopNavEmployee setuser={this.props.setUser} user={this.props.user}/></div>
                    <div className="flex flex-wrap pt-20">
                        <div className="md:w-1/2 w-full p-5"><Card><p className="font-sans font-semibold">Profile</p>
                            <div className="flex flex-wrap">
                                <div className="p-5 w-1/2"><Field>
                                    <Label>Customer Id</Label>
                                    <Input value={this.state.user.userid} onChange={(event) => {
                                        let u = this.state.user;
                                        u.userid = event.target.value;
                                        this.setState({user: u})
                                    }}/>
                                </Field></div>
                                <div className="p-5 w-1/2"><Field>
                                    <Label>Customer Name</Label>
                                    <Input value={this.state.user.username} onChange={(event) => {
                                        let u = this.state.user;
                                        u.username = event.target.value;
                                        this.setState({user: u})
                                    }}/>
                                </Field></div>
                                <div className="p-5 w-1/2"><Field>
                                    <Label>Date of Birth</Label>
                                    <Datepicker value={this.state.user.dateOfBirth} onChange={(event) => {
                                        let u = this.state.user;
                                        u.dateOfBirth = event;
                                        this.setState({user: u})
                                    }}>
                                        <Input />
                                    </Datepicker>
                                </Field></div>
                                <div className="p-5 w-1/2"><Field>
                                    <Label>PAN</Label>
                                    <Input  value={this.state.user.pan} onChange={(event) => {
                                        let u = this.state.user;
                                        u.pan = event.target.value;
                                        this.setState({user: u})
                                    }}/>
                                </Field></div>
                                <div className="p-5 w-full"><Field>
                                    <Label>Address</Label>
                                    <Textarea value={this.state.user.address} onChange={(event) => {
                                        let u = this.state.user;
                                        u.address = event.target.value;
                                        this.setState({user: u})
                                    }}/>
                                </Field>
                                </div>
                                <div className="p-5 w-full">
                                    <Button isPrimary onClick={()=>{
                                        CustomerClient.updatecustomerclient(
                                            this.props.user.authToken,this.state.user);
                                    }}>Save</Button>
                                </div>
                            </div>
                        </Card>
                        </div>
                        <div className="md:w-1/2 w-full p-5">
                            <AccountInfo accounts={this.state.user.accounts}/>
                        </div>
                    </div>
                </div>
            );
        }
    }
}

export default withParams(EmployeeCustomerDetails);