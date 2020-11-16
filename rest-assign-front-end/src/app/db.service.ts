import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';



@Injectable({
  providedIn: 'root'
})
export class DbService {
  baseUrl: string="http://localhost:8080/SpringRest/";;

  constructor(private http:HttpClient) { }
  validate_user(data){
    // const headers = new HttpHeaders({
		// 	'Content-type':'application/json'
    // });
    let headers = new HttpHeaders().set('access-control-allow-origin',"http://localhost:8080/");
    const url = this.baseUrl +'assign/5';
    // ,{headers:headers}
		return this.http.post(url,data,{ headers, responseType: 'text'});
  }
}
