package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Entity.Result;
import com.demo.studentmanagement.Service.ResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/admin/results")
    public List<Result> getAllResults() {
        return resultService.getAllResults();
    }

    @PostMapping("/admin/results")
    public Result addResult(@RequestBody Result result) {
        return resultService.addResult(result);
    }

    @PutMapping("/admin/results/{id}")
    public Result updateResult(
            @PathVariable String id,
            @RequestBody Result resultDetails) {

        return resultService.updateResult(id, resultDetails);
    }

    @DeleteMapping("/admin/results/{id}")
    public String deleteResult(@PathVariable String id) {

        resultService.deleteResult(id);

        return "Result deleted successfully";
    }


    @GetMapping("/student/results/{studentId}")
    public List<Result> getStudentResults(
            @PathVariable String studentId) {

        return resultService.getResultsByStudentId(studentId);
    }
}