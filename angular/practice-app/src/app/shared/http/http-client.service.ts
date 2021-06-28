import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { AppConfig } from "../config/app-config";

@Injectable({providedIn:'root'})
export class HttpClientService {
    headers :HttpHeaders = new HttpHeaders({
        'Content-Type': 'application/json',
    });
    constructor(private httpClient: HttpClient, private appConfig:AppConfig) { }
     get<T>(url,data) {
        return  this.httpClient.get<T>(this.appConfig.getUrl()+url);
    }
    public put() {

    }
    public post<T>(url,data) {
        return this.httpClient.post<T>(this.appConfig.getUrl()+url, data);
    }
}