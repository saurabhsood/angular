import { ClientData } from "./clientdata.model";

export class Client
{
    public clientData: ClientData;
    public address: string;
    public country: string;

    public constructor(clientData: ClientData,address: string,country: string )
    {
        this.clientData = clientData;
        this.address =  address;
        this.country =  country;
    }

}