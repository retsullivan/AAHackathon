export class Duration {
    hours:number;
    minutes:number;

    get totalDuration(){
        let tDuration = this.hours*60+this.minutes;
        return tDuration;
    }
}