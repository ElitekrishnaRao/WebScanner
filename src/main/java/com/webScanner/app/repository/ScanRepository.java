package com.webScanner.app.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webScanner.app.dao.URLScanInfo;

@Repository
public interface ScanRepository extends JpaRepository<URLScanInfo, Integer> {
	List<URLScanInfo> findTop10ByOrderBySubmittedDateDesc();
	Page<URLScanInfo> findAll(Pageable pageable);
	Page<URLScanInfo> findBySubmittedDateBetween(@Param("from") Timestamp from, @Param("to") Timestamp to,Pageable pageable);
}
