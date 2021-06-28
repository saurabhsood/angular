import { Injectable } from "@angular/core";
import { HttpClientService } from "../shared/http/http-client.service";
import { Client } from "./client.model";
import {map} from 'rxjs/operators';

@Injectable({providedIn:'root'})
export class ClientService{

    private client:Client;

    public constructor(public httpClient: HttpClientService){}

    public addClient(client: Client)
    {
        this.httpClient.post<Client>("/client/add",client).pipe(map(responseData => {
            console.log(responseData);
             this.client = responseData;
            return this.client;
         })).subscribe(responseData => {
            console.log(responseData);
             this.client = responseData;
             console.log('sssss'+this.client.clientData.clientId);
            return this.client;
         });
    }

    public getClient() : Client
    {
        return this.client;
    }

}