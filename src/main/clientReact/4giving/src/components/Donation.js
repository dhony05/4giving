
import React, { Component } from 'react';

class Donation extends Component {
    state = { 
        isLoading : true,
        Donations: []
     }

     //sync . you send a request then you wait for the response..
     //async. you send a request then you don't have to wait...

     async componentDidMount(){
         const response = await fetch('/api/donations/');
         const body = await response.json();
         this.setState({Donations : body, isLoading:false});
     }
    render() { 
        const{Donations, isLoading} = this.state
        if(isLoading){
            return (<div>Loading...</div>)
        }


        return ( 
            <div>
                <h2>Donations</h2>
                {
                    Donations.map( donation =>
                        <div id= {donation.id}>
                            {donation.itemName},
                            {donation.photos}
                            {donation.donorFirstName},
                            {donation.itemQuantity},
                            {donation.email},
                            {donation.state},
                            {donation.city}
                            {donation.zipCode}

                            
                            
                          </div>  

                    )
                }

            </div>
         );
    }
}
 
export default Donation;