
class AccountClient {
    static url="http://localhost:8086/account-ms";

    static createaccount(token,customerid,balance,accounttype){
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJFTVBMT1lFRTEwMSIsImV4cCI6MTY2MDkzOTQ4OCwiaWF0IjoxNjYwNzU5NDg4fQ.qUktc8L_Q2WaqucUwZFEuMljTNqAyfo8zHbH8axSgPE");
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify({
            "accountType": accounttype,
            "currentBalance": balance,
            "customerId": customerid
        });

        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch(this.url+"/createAccount/"+customerid, requestOptions)
            .then(response => response.text())
    }
    static gettransactionbyid(token,accountid,from,to){
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+token);

        const requestOptions = {
            method: 'GET',
            headers: myHeaders,
            redirect: 'follow'
        };

        return fetch(this.url+"/getAccountStatement/"+accountid+"/"+this.formatDate(from)+"/"+this.formatDate(to), requestOptions)
            .then(response => response.json());
    }

    static padTo2Digits(num) {
        return num.toString().padStart(2, '0');
    }

    static formatDate(date) {
        return [
            date.getFullYear(),
            AccountClient.padTo2Digits(date.getMonth() + 1),
            AccountClient.padTo2Digits(date.getDate()),
        ].join('-');
    }

    static sendMoney(authtoken,accountid,targetid,amount,message){
        const myHeaders = new Headers();
        myHeaders.append("Authorization", "Bearer "+authtoken);
        myHeaders.append("Content-Type", "application/json");

        const raw = JSON.stringify({
            "sourceAccount": {
                "accountId": accountid,
                "amount": amount
            },
            "targetAccount": {
                "accountId": targetid,
                "amount": amount
            },
            "amount": amount,
            "reference": message
        });

        const requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: raw,
            redirect: 'follow'
        };

        fetch("http://localhost:8086/account-ms/transaction", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    }
}
export default AccountClient;