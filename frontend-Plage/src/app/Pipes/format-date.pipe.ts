import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatDate'
})
export class FormatDatePipe implements PipeTransform {

  transform(value : any): string {

    const year = Number(value[0]);
    const month = Number(value[1])- 1;
    const day = Number(value[2]);

    let date = new Date(year, month, day);

    const options : Intl.DateTimeFormatOptions = { year: 'numeric', month: 'long', day: 'numeric' };
    return date.toLocaleDateString('fr-FR', options);
  }

}
