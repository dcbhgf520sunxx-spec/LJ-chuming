package com.hzchum.scim.plan.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.plan.core.api.pojo._do.TechDataLog;
import com.hzchum.scim.plan.core.api.pojo.dto.TechDataLogDTO;
import java.time.LocalDate;

public interface TechDataLogService extends IService<TechDataLog> {
   PageVO<TechDataLogDTO> listDataLogs(LocalDate startDate, LocalDate endDate, String userName, Integer operationType, Integer pageNumber, Integer pageSize);
}
