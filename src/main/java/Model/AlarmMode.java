package Model;



public class AlarmMode {

    private Time[] alarm = new Time[4];
    private boolean alarmIndicator ;
    private int alarmState;

    public AlarmMode() {
        this.alarmIndicator = false;
        for(int i=0; i<alarm.length; i++) {
            alarm[i] = new Time();
            alarm[i].setHour(-1);
            alarm[i].setMinute(-1);
        }
//         알람 ring 하는지 확인 코드
//        alarm[2].setHour(2);
//        alarm[2].setMinute(5);
    }

    public int enterSetSection(int currentstate) {

        if (currentstate == 16)
            return alarm[alarmState - 12].getHour();
        else if (currentstate == 17)
            return alarm[alarmState - 12].getMinute();
        return 0;
    }


    public void changeValue(int currentstate, int button) {
        if (button == 1) { // B 버튼
            if (currentstate == 16) {
                if (alarm[alarmState - 12].getHour() == 23) alarm[alarmState - 12].setHour(0);
                else alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour() + 1);

            }
            else if(currentstate == 17) {
                if (alarm[alarmState - 12].getMinute() == 59) alarm[alarmState - 12].setMinute(0);
                else alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute() + 1);
            }
        } else if (button == 3) { // D 버튼
            if (currentstate == 16) {
                if (alarm[alarmState - 12].getHour() <=-1) alarm[alarmState - 12].setHour(23);
                else alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour() - 1);
            }
            else if(currentstate == 17) {
                if (alarm[alarmState - 12].getMinute() <=-1) alarm[alarmState - 12].setMinute(59);
                else alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute() - 1);
            }
        }

    }

    public void removeAlarmNum(int currentstate) {

        if( currentstate > 11 && currentstate < 16 ) {
            alarm[currentstate - 12].setHour(-1);
            alarm[currentstate - 12].setMinute(-1);
        }
    }

    public boolean isAlarmIndicator() {
        return alarmIndicator;
    }

    public int getAlarmIndex() {
        return alarmState-12;
    }

    public void setAlarmIndicator(boolean alarmIndicator) {
        this.alarmIndicator = alarmIndicator;
    }

    public boolean checkAlarmArray() {

        for (int i = 0; i < 4; i++) {
            if (alarm[i].getHour() >= 0 || alarm[i].getMinute() >= 0) {

                this.setAlarmIndicator(true);
                break;
            }
            this.setAlarmIndicator(false);
        }
        return this.isAlarmIndicator();

    }

    public Time getAlarmTime(int state){
        if(state < 16){
            alarmState = state;
            if(alarm[state-12].getHour() == -1){
                Time tim = new Time();
                tim.setHour(-1);
                tim.setMinute(-1);
                return tim;
            }
            return alarm[state-12];
        } else return alarm[alarmState-12];
    }

    public String displayIndicator(){
        return (isAlarmIndicator() == true)? "ON":"OFF";
    }
    public Time getAlarm(int state){
        return this.alarm[state];
    }

}