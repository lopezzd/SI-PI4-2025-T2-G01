package com.joaohenrique.ailinter.service;

import com.joaohenrique.ailinter.model.report.Report;
import com.joaohenrique.ailinter.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private AiService aiService;

    public Report uploadFile(MultipartFile file) throws IOException {
        String code = new String(file.getBytes());
        String analysis = String.valueOf(aiService.analyzeCode(code));

        Report report = new Report();
        report.setFilename(file.getOriginalFilename());
        report.setContent(code);
        report.setAnalysis(analysis);
        report.setCreatedAt(LocalDateTime.now());

        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(UUID id) {
        return reportRepository.findById(id).orElse(null);
    }
}
