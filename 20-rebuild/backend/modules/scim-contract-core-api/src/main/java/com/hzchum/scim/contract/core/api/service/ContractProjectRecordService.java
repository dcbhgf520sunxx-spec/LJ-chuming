package com.hzchum.scim.contract.core.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.scim.contract.core.api.enums.ChangeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectRecord;
import com.hzchum.scim.contract.core.api.pojo.dto.ChangeInfo;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectRecordDTO;
import java.time.LocalDate;
import java.util.List;

public interface ContractProjectRecordService extends IService<ContractProjectRecord> {
   void insert(Long projectId, Long userId, ChangeEnum changeEnum, List<ChangeInfo> changeInfos);

   void insert(Long projectId, Long userId, ChangeEnum changeEnum);

   PageVO<ProjectRecordDTO> listProjectRecord(
      Long projectId, Integer type, LocalDate startDate, LocalDate endDate, String operator, Integer pageNumber, Integer pageSize
   );
}
