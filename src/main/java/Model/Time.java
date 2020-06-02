package Model;

import java.util.*;

/**
 *  Time 구조체
 */
public class Time {

    /**
     * Default constructor
     */
    public Time() {
    }

    private int hour=0;

    private int minute=0;

    private int second=0;

    public int getM_second() {
        return m_second;
    }

    public void setM_second(int m_second) {
        this.m_second = m_second;
    }

    private int m_second=0;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }







}