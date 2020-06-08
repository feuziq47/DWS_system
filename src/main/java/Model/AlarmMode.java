package Model;

public class AlarmMode {

    private Time[] alarm ;
    private boolean alarmIndicator = false;
    private int alarmState;
    private String[] displayAlarmTime = new String[3];

    public AlarmMode() {
        this.alarmState = 0;
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

        if (button == 1) {
            if (currentstate == 16) {
                alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour()+1);
            } else if(currentstate == 17){
                alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute()+1);
            }
        } else if (button == 3) { // D 버튼
            if (currentstate == 16) {
                alarm[alarmState - 12].setHour(alarm[alarmState - 12].getHour()-1);
            } else if(currentstate == 17){
                alarm[alarmState - 12].setMinute(alarm[alarmState - 12].getMinute()-1);
            }
        }

        this.checkAlarmArray();
    }

    public void removeAlarmNum(int currentstate) {

        if( currentstate > 11 && currentstate < 16 ) {
            alarm[currentstate - 12].setHour(0);
            alarm[currentstate - 12].setMinute(0);
            this.checkAlarmArray();
        }
    }

    public boolean isAlarmIndicator() {
        return alarmIndicator;
    }

    public int getAlarmIndex() {
        return alarmState;
    }

    public void setAlarmIndicator(boolean alarmIndicator) {
        this.alarmIndicator = alarmIndicator;
    }

    public boolean checkAlarmArray() {

        for (int i = 0; i < 4; i++) {
            if (alarm[i].getHour() != 0 || alarm[i].getMinute() != 0) {
                this.setAlarmIndicator(true);
            }
        }
        return this.isAlarmIndicator();

    }

    public Time getAlarmTime(int state){
        System.out.println("state : "+ state);
        alarmState = state+12;
        return alarm[state];
    }
    public String displayAlarmTime(){
        displayAlarmTime[0] = Integer.toString(alarmState-11);
        displayAlarmTime[1] = Integer.toString(alarm[alarmState-12].getHour());
        displayAlarmTime[2] = Integer.toString(alarm[alarmState-12].getMinute());
        return displayAlarmTime[0] + displayAlarmTime[1] + displayAlarmTime[2];
    }

}