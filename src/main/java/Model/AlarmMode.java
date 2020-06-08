package Model;

public class AlarmMode {

    private Time[] alarm = new Time[4];
    private boolean alarmIndicator ;
    private int alarmState;
    private String[] displayAlarmTime = new String[3];

    public AlarmMode() {
        this.alarmIndicator = false;
        for(int i=0; i<alarm.length; i++) {
            alarm[i] = new Time();
        }
    }

    public int enterSetSection(int currentstate) {

        if (currentstate == 16) {
            return alarm[alarmState - 12].getHour();
        } else if (currentstate == 17) {
            return alarm[alarmState - 12].getMinute();
        }
        return 0;
    }


    public void changeValue(int currentstate, int button) {
        if (button == 1) { // B 버튼
            if (currentstate == 16) {
                if (alarm[alarmState - 12].getHour() == 24) alarm[alarmState - 12].setHour(1);
                else alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour() + 1);
            }
            else if(currentstate == 17) {
                if (alarm[alarmState - 12].getMinute() == 59) alarm[alarmState - 12].setMinute(0);
                else alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute() + 1);
            }
        } else if (button == 3) { // D 버튼
            if (currentstate == 16) {
                if (alarm[alarmState - 12].getHour() == 0) alarm[alarmState - 12].setHour(24);
                else alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour() - 1);
            }
            else if(currentstate == 17) {
                if (alarm[alarmState - 12].getMinute() == 0) alarm[alarmState - 12].setMinute(59);
                else alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute() - 1);
            }
        }
//        this.checkAlarmArray();
    }

    public void removeAlarmNum(int currentstate) {

        if( currentstate > 11 && currentstate < 16 ) {
            alarm[currentstate - 12].setHour(0);
            alarm[currentstate - 12].setMinute(0);
        }
//        this.checkAlarmArray();
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
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            if (alarm[i].getHour() != 0 || alarm[i].getMinute() != 0) {
                this.setAlarmIndicator(true);
            } else temp++;
        }
        this.setAlarmIndicator( (temp == 4)? false:true);
        return this.isAlarmIndicator();

    }

    public Time getAlarmTime(int state){
        if(state<16){
            alarmState = state;
            return alarm[state-12];
        } else return alarm[alarmState-12];
    }

    public String displayIndicator(){
        return (isAlarmIndicator() == true)? "ON":"OFF";
    }

}