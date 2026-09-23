package com.demo.studentmanagement.Service;

import com.demo.studentmanagement.Entity.Result;
import com.demo.studentmanagement.Repository.ResultData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultData resultData;

    public ResultService(ResultData resultData) {
        this.resultData = resultData;
    }

    public List<Result> getAllResults() {
        return resultData.findAll();
    }

    public Result addResult(Result result) {
        return resultData.save(result);
    }

    public Result getResultById(String id) {
        return resultData.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));
    }

    public List<Result> getResultsByStudentId(String studentId) {
        return resultData.findByStudentId(studentId);
    }

    public Result updateResult(String id, Result resultDetails) {

        Result result = resultData.findById(id)
                .orElseThrow(() -> new RuntimeException("Result not found"));

        result.setStudentId(resultDetails.getStudentId());
        result.setCourse(resultDetails.getCourse());
        result.setGrade(resultDetails.getGrade());

        return resultData.save(result);
    }

    public void deleteResult(String id) {
        resultData.deleteById(id);
    }
}