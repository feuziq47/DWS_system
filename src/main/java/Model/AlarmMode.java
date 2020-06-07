/* B : select alarm num = getAlarmTime
 * A : enterSetsection = 수정 모드
 *  + A : SET MINUTE or SET HOUR / + B or D : increase, decrease
 *  + C : SAVE ALARM
 */
package Model;

public class AlarmMode {

    private Time[] alarm = new Time[4];
    private boolean alarmIndicator = false;

    public int getAlarmIndex() {
        return alarmState;
    }

    private int alarmState; // 현재 알람의 인덱스 저장 : 12~15의 값 저장
    private String[] displayAlarmTime = new String[3];

    public AlarmMode() {
        this.alarmState = 0;
    }

    public int enterSetSection(int currentstate) {

        if (currentstate > 11 && currentstate < 18) {
            if (currentstate < 16) { // alarm 1~4 MODE
                return alarmState = currentstate;
            } else if (currentstate == 16) { // hour
                return alarm[alarmState - 12].getHour();
            } else if (currentstate == 17) { // minute
                return alarm[alarmState - 12].getMinute();
            }
        }
        return 0;
    }
    // alarmState : 최근 focus 된 alarm mode 저장

    public void changeValue(int currentstate, int button) {

        if (button == 1) { // B 버튼
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

    } // Turn ON/OFF alarm Indicator

    public String displayAlarmTime(){
        displayAlarmTime[0] = Integer.toString(alarmState-11); // 알람 순번
        displayAlarmTime[1] = Integer.toString(alarm[alarmState-12].getHour());
        displayAlarmTime[2] = Integer.toString(alarm[alarmState-12].getMinute());
        return displayAlarmTime[0] + displayAlarmTime[1] + displayAlarmTime[2];
    }

    public void showDefault() {
        // alarm default 화면
        displayAlarmTime();
    }
}