package ru.uralsib.acceptance.rescontroller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.uralsib.acceptance.config.ApplicationProperties;
import ru.uralsib.acceptance.model.Customer;
import ru.uralsib.acceptance.model.Customers_init;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Опция @RequestMapping("/api") применяется в swagger ui для отображения документации сайта /swagger-ui.html
@RestController
@RequestMapping("api/v1")
public class ResControllerMF {

    private Customers_init customers_init = Customers_init.getInstance();

    public ConcurrentMap<String, Customer> customers = new ConcurrentHashMap<>();

    @Autowired
    ApplicationProperties applicationProperties;

    //включаем логирование
    Logger logger = LoggerFactory.getLogger(ResControllerMF.class);

    @GetMapping("/users")
    @ApiOperation(value = "Запрос выдачи всех сотрудников компании",
            notes = "Аналогично можно получить результат / и /customers",
            response = Customer.class)
    public List<Customer> getCustomers() {
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.info("Users :" + customers_init.getCustomers().values().toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Users :" + customers_init.getCustomers().values().toString());
        }
        return new ArrayList<Customer>(customers_init.getCustomers().values());
    }

    @GetMapping("/customers")
    @ApiOperation(value = "Запрос выдачи всех сотрудников компании",
            notes = "Аналогично можно получить результат / и /users",
            response = Customer.class)
    public List<Customer> getAllCustomers() {
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.info("Users :" + customers_init.getCustomers().values().toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Users :" + customers_init.getCustomers().values().toString());
        }
        return new ArrayList<Customer>(customers_init.getCustomers().values());
    }

    @GetMapping("/")
    @ApiOperation(value = "Запрос выдачи всех сотрудников компании",
            notes = "Аналогично можно получить результат /customers и /users",
            response = Customer.class)
    public List<Customer> get_Customers() {
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.info("Users :" + customers_init.getCustomers().values().toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Users :" + customers_init.getCustomers().values().toString());
        }
        return new ArrayList<Customer>(customers_init.getCustomers().values());
    }

    @GetMapping("/id/{id}")
    //Вставляем API описание
    @ApiOperation(value = "Поиск сотрудника по его ID",
            notes = "Подробное описание того что тут происходит при поиске контакта",
            response = Customer.class)
    public Customer getCustomer(@ApiParam(value = "Передаем id контакта", required = true)
                                @PathVariable String id) {
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.debug("Request id :" + id);
            logger.debug("Response :" + customers_init.getId(id).toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Request id :" + id);
            logger.trace("Response :" + customers_init.getId(id).toString());
        }
        return customers_init.getId(id);
    }

    @GetMapping("/get_id")
    //Вставляем API описание
    @ApiOperation(value = "Поиск сотрудника по его ID",
            notes = "Подробное описание того что тут происходит при поиске сотрудника по id",
            response = Customer.class)
    public Customer getCustomerID(@RequestParam(required = false) String id) {
        return customers_init.getId(id);
    }

    @GetMapping("/salary/{salary}")
    //Вставляем API описание
    @ApiOperation(value = "Поиск сотрудника по его зарплате",
            notes = "Подробное описание того что тут происходит при поиске записи сотрудника",
            response = Customer.class)
    public List<Customer> getCustomersJob(@ApiParam(value = "Передаем id контакта", required = true)
                                          @PathVariable int salary) {
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.debug("Request salary :" + salary);
            logger.debug("Response :" + customers_init.getCustomersJob(salary).toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Request salary :" + salary);
            logger.trace("Response :" + customers_init.getCustomersJob(salary).toString());
        }
        return new ArrayList<Customer>(customers_init.getCustomersJob(salary));
    }


    @PostMapping("/add")
    //Вставляем API описание
    @ApiOperation(value = "Добавление записи сотрудника",
            notes = "Запись будет добавлена",
            response = Customer.class)
    public Customer addCustomer(@RequestBody Customer customer) {
        customers_init.addCustomers(customer);
        //customers.put(Integer.toString(customers.size() + 1), customer);
        logger.info("Request post to add :" + customer.toString());
        if (applicationProperties.getLogLevel().equalsIgnoreCase("debug")) {
            logger.debug("Request customer :" + customer.toString());
            logger.debug("Response customer:" + customer.toString());
        }
        if (applicationProperties.getLogLevel().equalsIgnoreCase("trace")) {
            logger.trace("Request customer :" + customer.toString());
            logger.trace("Response customer:" + customer.toString());
        }
        return customer;
    }


    //Вставляем API описание
    @GetMapping("/del/{id}")
    @ApiOperation(value = "Удаление записи сотрудника по его ID",
            notes = "Запись будет удалена по введенному id в строке ../delete/{id}")
    public String deleteCustomer(@ApiParam(value = "Передаем id контакта", required = true)
                                 @PathVariable String id) {
        return "Запись была удалена :: " + customers_init.deleteCustomer(id).toString();
    }


}
