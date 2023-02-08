package Algoritmos_Estrutura_De_Dados.exe_0;


public class Date {

    static int[] month_days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    static int getDaysOfYear(int __year) { return __year % 4 == 0 ? 366 : 365; }

    private int day, month, year;

    public String toString() { return month + "/" + day + "/" + year; }



    Date(String __month, String __day, String __year) 
        { this.day = Integer.parseInt(__day); this.month = Integer.parseInt(__month); this.year = Integer.parseInt(__year); }

    Date(int __month, int __day, int __year) { this.day = __day; this.month = __month; this.year = __year; }

    int day() { return day; } int month() { return month; } int year() { return year; }

    boolean before(Date __date) {

        if (year != __date.year) return year < __date.year;

        if (month != __date.month) return month < __date.month;

        return day < __date.day;

    }

    int daystoEndYear() { return getDaysOfYear(year) - dayssinceBeginYear(); }

    int dayssinceBeginYear() {

        int _days_since = 0;

        for (int _month = 0; _month < month - 1; _month++) _days_since += month_days[_month];

        _days_since += day;

        return _days_since;

    }

    int daysBetween(Date __date) {

        int _days_between = 0;

        if (year != __date.year) { 
            
            _days_between += daystoEndYear() + __date.dayssinceBeginYear(); 
            
            for (int _current_year = year + 1; _current_year < __date.year; _current_year++) _days_between += Date.getDaysOfYear(_current_year); 
        
        }

        else _days_between = __date.dayssinceBeginYear() - dayssinceBeginYear();
        

        return _days_between;

    }


    public static void main(String args[]) {

        Date _date = new Date(args[0], args[1], args[2]);

        System.out.println(_date);

    }
    
}
