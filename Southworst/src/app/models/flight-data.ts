import {Locale} from "./locale";
import {Duration} from "./duration";

export class FlightData{
    FlightNumber:number
    Origin: Locale;
    Destination:Locale;
    Duration:Duration;
    DepartureTime: Date
    ArrivalTime: Date;
}