import React, { useState } from 'react';
import { Button } from '@zendeskgarden/react-buttons';
import { Modal, Header,  Footer, FooterItem } from '@zendeskgarden/react-modals';
import { Row, Col } from '@zendeskgarden/react-grid';
import {Field, Input, Label} from "@zendeskgarden/react-forms";
import {Datepicker} from "@zendeskgarden/react-datepickers";
import CustomerClient from "../../../Client/CustomerClient";



const Customermodal = (props) => {
  const [visible, setVisible] = useState(false);
  const [userid,setuserid]=useState("");
  const [name,setName]=useState("");
  const [pan,setPan]=useState("");
  const [dateofbirth,setdob]=useState(new Date());
  const [address,setAddress]=useState("");
  const [password,setPassword]=useState("");
  return (
    <Row>
      <Col textAlign="center">
        <Button onClick={() => setVisible(true)}>Create Customer</Button>
        {visible && (
          <Modal onClose={() => setVisible(false)}>
            <Header>CUSTOMER DETAIL</Header>
              <Row justifyContent="center">
                  <Col sm={5}>
                      <Field>
                          <Label>User ID</Label>
                          <Input value={userid} onChange={event => setuserid(event.target.value)}/>
                      </Field>
                      <Field>
                          <Label>Customer Name</Label>
                          <Input value={name} onChange={event => setName(event.target.value)}/>
                      </Field>
                      <Field>
                          <Label>PAN NO.</Label>
                          <Input value={pan} onChange={event => setPan(event.target.value)}/>
                      </Field>
                      <Field>
                          <Label>Address</Label>
                          <Input value={address} onChange={event => setAddress(event.target.value)}/>
                      </Field>
                      <Field>
                          <Label>Date of Birth</Label>
                        <Datepicker value={dateofbirth} onChange={setdob}>
                          <Input />
                        </Datepicker>
                      </Field>
                      <Field>
                          <Label>Password</Label>
                          <Input value={password} onChange={event => setPassword(event.target.value)}/>
                      </Field>
                  </Col>
              </Row>
            <Footer>
              <FooterItem>
                <Button onClick={() => setVisible(false)} isBasic>
                  Cancel
                </Button>
              </FooterItem>
              <FooterItem>
                <Button isPrimary onClick={() =>{
                  setVisible(false)
                  CustomerClient.customerclient(props.user.authToken,userid,address,dateofbirth,pan,name,password)
                }}>
                Create Customer
                </Button>
              </FooterItem>
            </Footer>
          </Modal>
        )}
      </Col>
    </Row>
  );
};

export default Customermodal;