import { Component, OnInit } from '@angular/core';
import { FormArray, FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClientService } from 'src/app/shared/http/http-client.service';
import { Client } from '../../client.model';
import { ClientService } from '../../client.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent implements OnInit {

  createClientForm: FormGroup
  genders=['Male', 'Female'];
  countries=['India','UK','US']
  private client:Client;

  constructor(public clientService: ClientService) { }

  ngOnInit(): void {
    this.createClientForm = new FormGroup({
      'clientData': new FormGroup({
        'firstName': new FormControl(null,Validators.required),
        'lastName': new FormControl(null,Validators.required),
        'emailAddr': new FormControl(null,[Validators.required,Validators.email]),
        'gender': new FormControl(null,Validators.required)
       }),
      'address': new FormControl(null,Validators.required),
      'country': new FormControl(null,Validators.required)
    });
    this.createClientForm.statusChanges.subscribe((status) => console.log(status));
  }


  onSubmit(){
    this.client = this.createClientForm.value;
    console.log(this.client.address);
    console.log(this.createClientForm.value);
    console.log(this.createClientForm.get('country').value);
    this.clientService.addClient(this.client);
  //  console.log(this.clientService.getClient().clientData.clientId);
   // this.createClientForm.reset();
  }

}
