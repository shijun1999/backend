package com.kootour.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostBankInformationModel;
import com.kootour.service.LocalhostBankInformationService;
import com.kootour.service4db.LocalhostService4DB;
@Configuration
@Service
public class LocalhostBankInformationServiceImpl implements LocalhostBankInformationService {

	@Resource
	LocalhostService4DB localhostService4DB;

	@Override
	public KootourMessage updateBankInformation(Map<String, Object> paraMap) {

		LocalhostBankInformationModel inModel = (LocalhostBankInformationModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			List<LocalhostEntity> outDbList = localhostService4DB.selectByPK(inModel.getLocalhostEntity());
			if (outDbList == null || outDbList.size() > 1) {
				retMsg.setHasError(true);
				retMsg.setMessage("No login user information.<br>Please re-login.");
			} else {
				LocalhostEntity outDbEntity = outDbList.get(0);
				outDbEntity.setBankAccountNo(inModel.getBankAccountNo());
				outDbEntity.setBankAccountOwner(inModel.getBankAccountOwner());
				outDbEntity.setBankAccountType(inModel.getBankAccountType());
				outDbEntity.setBankBranch(inModel.getBankBranch());
				outDbEntity.setBankName(inModel.getBankName());

				localhostService4DB.updateByPK(outDbEntity);

				retMsg.setHasError(true);
				retMsg.setMessage("Update bank information successfully");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
}
