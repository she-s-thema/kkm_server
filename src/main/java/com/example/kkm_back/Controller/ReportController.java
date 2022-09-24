package com.example.kkm_back.Controller;

import com.example.kkm_back.DAO.ReportDAO;
import com.example.kkm_back.Domain.Report;
import com.example.kkm_back.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ReportController {
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private ReportDAO reportDAO;

    @ResponseBody
    @RequestMapping(value = "/report", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public long Report(@ModelAttribute Report report) throws Exception {
        reportDAO.reportInsert(report);
        return report.getReport_id();
    }
}
