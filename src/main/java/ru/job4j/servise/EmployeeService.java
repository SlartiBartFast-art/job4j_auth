package ru.job4j.servise;

import org.springframework.stereotype.Service;
import ru.job4j.domain.Employee;
import ru.job4j.repository.EmployeeRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Класс Сервис по обращению с Работниками
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * метод получения всех сотрудников со всеми их аккаунтами
     * @return
     */
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    /**
     * добавление нового аккаунта
     * @param employee
     * @return
     */
    public Employee save(Employee employee) {
        employee.setHireDate(Timestamp.valueOf(LocalDateTime.now()));
        Employee employee1 = employeeRepository.save(employee);
        return employee1;
    }

    /**
     *удаление существующих аккаунтов.
     * @param employee
     */
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
