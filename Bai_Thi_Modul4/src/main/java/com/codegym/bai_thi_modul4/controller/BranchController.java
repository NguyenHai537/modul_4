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
public class BranchController {
    @Autowired
    IBranchService iBranchService;

    @Autowired
    IEmpoyeeService empoyeeService;

    @GetMapping("/view-branch/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Branch> branchOptional = iBranchService.findById(id);
        if (!branchOptional.isPresent()){
            return new ModelAndView("/error-404");
        }
        Iterable<Employee> employees = empoyeeService.findAllByBranch(branchOptional.get());
        ModelAndView modelAndView = new ModelAndView("/branch-view");
        modelAndView.addObject("province",branchOptional.get());
        modelAndView.addObject("customers", employees);
        return modelAndView;
    }


    @GetMapping("/branchs")
    public ModelAndView showListProvince(){
        Iterable<Branch> branchs = iBranchService.findAll();
        ModelAndView modelAndView = new ModelAndView("/branch-list");
        modelAndView.addObject("branchs" , branchs);
        return modelAndView;
    }

    @GetMapping("/create-branch")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/branch-create");
        modelAndView.addObject("branch", new Branch());
        return modelAndView;
    }

    @PostMapping("/create-branch")
    public ModelAndView saveProvince(@ModelAttribute("province") Branch branch){
        iBranchService.save(branch);

        ModelAndView modelAndView = new ModelAndView("/branch-create");
        modelAndView.addObject("branch",new Branch());
        modelAndView.addObject("message","New branch created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-branch/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Branch> branch = iBranchService.findById(id);
        if (branch.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/branch-edit");
            modelAndView.addObject("branch", branch.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-branch")
    public ModelAndView updateProvince(@ModelAttribute("province") Branch branch){
        iBranchService.save(branch);
        ModelAndView modelAndView = new ModelAndView("/branch-edit");
        modelAndView.addObject("branch",branch);
        modelAndView.addObject("message", "Branch updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-branch/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Branch> branch = iBranchService.findById(id);
        if (branch.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/branch-delete");
            modelAndView.addObject("branch" , branch.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error-404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-branch")
    public String deleteProvince(@ModelAttribute("province") Branch branch){
        iBranchService.remove(branch.getId());
        return "redirect:branchs";
    }
}
