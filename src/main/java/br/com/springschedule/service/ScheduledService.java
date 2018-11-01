package br.com.springschedule.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduledService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledService.class);

    private static final String FIVE_MINUTES_IN_MILLISECONDS = "300000";
    private static final String ONE_MINUTE_IN_MILLISECONDS = "60000";
    private static final String THIRTY_SECONDS_IN_MILLISECONDS = "30000";

    //this cron expression was made in http://www.cronmaker.com/
    @Scheduled(cron = "0 0/1 * 1/1 * ?")
    public void printsDateTimeEveryMinuteUsingCronExpression(){

        logger.info("Log every minute : " + LocalDateTime.now());
    }

    //this cron expression was made in http://www.cronmaker.com/
    @Scheduled(cron = "0 0 10 1/1 * ?")
    public void printsLogEveryDayAt10AM(){

        logger.info("Log every day at 10AM : " + LocalDateTime.now());
    }

    @Scheduled(fixedDelayString = ONE_MINUTE_IN_MILLISECONDS, initialDelayString = FIVE_MINUTES_IN_MILLISECONDS)
    public void logFiveMinutesAfterApplicationStatrsAndKeepPrintingEveryMinute(){

        logger.info("Log 5 minutes after application starts and keep loging every minute : " + LocalDateTime.now());
    }

    @Scheduled(fixedRateString = THIRTY_SECONDS_IN_MILLISECONDS)
    public void logWithAnInvertalOfThirthySeconds(){

        logger.info("Log with an interval of thirthy seconds : " + LocalDateTime.now());

    }


}
