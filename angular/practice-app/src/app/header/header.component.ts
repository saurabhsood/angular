import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";


@Component(
   {
        selector:'app-header',
        templateUrl:'./header.component.html'
   }
)
export class HeaderComponent implements OnInit{

    now = new Date();
    constructor( private router:Router){
    }
    ngOnInit(): void {
       setInterval(()=>{
           this.now = new Date();
       },100)
    }

}