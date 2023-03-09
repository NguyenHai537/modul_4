package com.codegym.bai_thi_modul4.controller;

import com.codegym.bai_thi_modul4.model.Branch;
import com.codegym.bai_thi_modul4.model.Employee;
import com.codegym.bai_thi_modul4.service.IBranchService;
import com.codegym.bai_thi_modul4.service.IEmpoyeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IBranchService iBranchService;

    @Autowired
    private IEmpoyeeService iEmpoyeeService;

    @ModelAttribute("branchs")
    public Iterable<Branch> provinces() {
        return iBranchService.findAll();
    }

    @GetMapping("/create-employee")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create-employee")
    public ModelAndView saveCustomer(@ModelAttribute("employee") Employee employee) {
        iEmpoyeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("message", "New employee created successfully");
        return modelAndView;
    }

    @GetMapping("/employees")
    public ModelAndView listCustomers() {
        ModelAndView modelAndView = new ModelAndView("/list-employees");
        Iterable<Employee> employees = iEmpoyeeService.findAll();
        modelAndView.addObject("employees",employees );
        return modelAndView;
    }

    @GetMapping("/edit-employee/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee = iEmpoyeeService.findById(id);
        if (employee.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("employee", employee.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/edit-employee")
    public ModelAndView updateCustomer(@ModelAttribute("employee") Employee employee) {
        iEmpoyeeService.save(employee);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", employee);
        modelAndView.addObject("message", "Employee updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-employee/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Employee> employees = iEmpoyeeService.findById(id);
        if (employees.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("employee", employees.get());
            return modelAndView;

        } else {
            return new ModelAndView("/error-404");
        }
    }

    @PostMapping("/delete-employee")
    public String deleteCustomer(@ModelAttribute("employee") Employee employee) {
        iEmpoyeeService.remove(employee.getEmployeeCode());
        return "redirect:employees";
    }

    @GetMapping("/view-employee/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Branch> branchOptional = iBranchService.findById(id);
        if (!branchOptional.isPresent()){
            return new ModelAndView("/error-404");
        }
        Iterable<Employee> employees = iEmpoyeeService.findAllByBranch(branchOptional.get());
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("branch",branchOptional.get());
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }


}
