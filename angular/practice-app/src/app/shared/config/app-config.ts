import { Injectable } from "@angular/core";
@Injectable({
    providedIn: 'root'
})
export class AppConfig {

   
    private url: string = "http://localhost:8080";

    public getUrl(): string {
        return this.url;
    }

}