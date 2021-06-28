export class ClientData
{
    public clientId : number
    public firstName: string;
    public lastName : string;
    public emailAddr : string;
    public gender : string;

    constructor(clientId: number, firstName: string, lastName: string, emailAddr: string, gender: string) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddr = emailAddr;
        this.gender = gender;
  }



}