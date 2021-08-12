package ru.uralsib.acceptance.rescontroller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import com.martensigwart.fakeload.*;
import io.swagger.annotations.ApiOperation;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.uralsib.acceptance.config.ApplicationProperties;
import ru.uralsib.acceptance.model.Customer;
import ru.uralsib.acceptance.model.LogLevels;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/service")
@ApiOperation(value = "Системный контроллер", notes = "Контроллер для имитации системной ошибки и смены уровня логирования")
public class ServiceRestController {

    @Autowired
    ApplicationProperties applicationProperties;

    @Autowired
    private ApplicationContext context;

    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

    @GetMapping("/error")
    @ApiOperation(value = "Вызов системной ошибки", notes = "Для имитации обрушения сервиса")
    public void setSystemsErrors() {
        int exitCode = SpringApplication.exit(context, (ExitCodeGenerator) () -> 0);
        System.exit(exitCode);
    }

    @GetMapping("/setlog/{logLevel}")
    @ApiOperation(value = "Установка уровня логирования", notes = "Смена уровня логирования {INFO, WARN, DEBUG, TRACE}")
    public String setLogLevel(String logLevel) {
        if (logLevel.equalsIgnoreCase(LogLevels.warn.toString()) | logLevel.equalsIgnoreCase(LogLevels.debug.toString()) |
                logLevel.equalsIgnoreCase(LogLevels.info.toString()) | logLevel.equalsIgnoreCase(LogLevels.trace.toString())) {
            applicationProperties.setLogLevel(logLevel.trim().toUpperCase());
            loggerContext.getLogger("package where springboot main class resides").setLevel(Level.toLevel(logLevel.trim().toUpperCase()));
            return "Уровень логирования сменен на :" + logLevel.trim().toUpperCase();
        } else {
            return "Смена уровня логирования должна содержать только: {INFO, WARN, DEBUG, TRACE}" + " в любом регистре." + "\n" +
                    "Вы передали: " + logLevel + "\n" +
                    "уровень логирования в системе остался прежним :" + applicationProperties.getLogLevel();
        }
    }

    @GetMapping("/getlog")
    @ApiOperation(value = "Получение текущего уровня логирования", notes = "Текущий уровень {INFO, WARN, DEBUG, TRACE}")
    public String gettLogLevel(String logLevel) {
        return "Уровень логирования : " + applicationProperties.getLogLevel();
    }

    @GetMapping("/usage")
    //Вставляем API описание
    @ApiOperation(value = "Имитация загрузки системы (процессора и памяти) CPU, MEMORY",
            notes = "cpu=10..99 - диапазон, memory(MB)=1..999, также задаем период в котором проводим тест в сек. period = 1..600 (т.е. максимум 10 минут) Использована библиотека FakeLoad  сайта https://github.com/msigwart/fakeload"
    )
    public String setUsage(@RequestParam(required = false) int cpu,
                           @RequestParam(required = false) int memory,
                           @RequestParam(required = false) int period) throws ExecutionException, InterruptedException {
        //CPU приводим к нужному диапазону
        if (cpu < 10) {
            cpu = 10;
        }
        if (cpu > 99) {
            cpu = 99;
        }
        //Память приводим к нужному диапазону
        if (memory < 10) {
            memory = 10;
        }
        if (memory > 999) {
            memory = 999;
        }
        //Период приводим к нужному диапазону
        if (period < 1) {
            period = 1;
        }
        if (period > 600) {
            period = 600;
        }
        // Create FakeLoad
        FakeLoad fakeload = FakeLoads.create()
                .lasting(period, TimeUnit.SECONDS)
                .withCpu(cpu)
                .withMemory(memory, MemoryUnit.MB);
        // Execute FakeLoad synchronously
        FakeLoadExecutor executor = FakeLoadExecutors.newDefaultExecutor();
        // Execute FakeLoad asynchronously
        Future<Void> execution = executor.executeAsync(fakeload);
        execution.get(); // wait for completion
        execution.cancel(!execution.isCancelled());// cancel execution

        // Shutdown executor
        executor.shutdown();
        return "CPU = " + Integer.toString(cpu) + " MEMORY = " + Integer.toString(memory) + " PERIOD = " + Integer.toString(period);
    }

}
