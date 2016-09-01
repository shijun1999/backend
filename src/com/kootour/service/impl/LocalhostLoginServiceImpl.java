package com.kootour.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostLoginService;
import com.kootour.service4db.LocalhostService4DB;
import com.kootour.service4db.SequenceService4DB;
@Configuration
@Service
public class LocalhostLoginServiceImpl implements LocalhostLoginService {

	@Resource
	LocalhostService4DB localhostService4DB;

	@Resource
	SequenceService4DB sequenceService4DB;

	@Override
	public KootourMessage loginWithEmail(Map<String, Object> paraMap) {

		LocalhostEntity inDbLocalhostEntity = new LocalhostEntity();

		LocalhostLoginModel inModel = (LocalhostLoginModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			inDbLocalhostEntity.setLangId(inModel.getLangId());
			inDbLocalhostEntity.setLoginType(KooConst.LT_LOGIN_TYPE_EMAIL);
			inDbLocalhostEntity.setLoginId(inModel.getLoginId());
			inDbLocalhostEntity.setPassword(inModel.getPassword());
			inDbLocalhostEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			inDbLocalhostEntity.setOkFlg(KooConst.LT_OK_FLG_Y);

			List<LocalhostEntity> retList = localhostService4DB.selectByCondition(inDbLocalhostEntity);

			if (retList != null && retList.size() == 1) {
				retMsg.setHasError(false);
				retMsg.setData(retList.get(0));
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("ID/PWD is wrong");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage loginWithFb(Map<String, Object> paraMap) {

		LocalhostEntity inDbLocalhostEntity = new LocalhostEntity();

		LocalhostLoginModel inModel = (LocalhostLoginModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			inDbLocalhostEntity.setLangId(inModel.getLangId());
			inDbLocalhostEntity.setLoginType(inModel.getLoginType());
			inDbLocalhostEntity.setLoginId(inModel.getLoginId());
			inDbLocalhostEntity.setPassword(StringUtils.EMPTY);
			inDbLocalhostEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			inDbLocalhostEntity.setOkFlg(KooConst.LT_OK_FLG_Y);

			List<LocalhostEntity> retList = localhostService4DB.selectByCondition(inDbLocalhostEntity);

			if (retList != null && retList.size() == 1) {
				retMsg.setHasError(false);
				retMsg.setData(retList.get(0));
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("Can not login with facebook.");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage checkUserExist(Map<String, Object> paraMap) {

		LocalhostEntity inDbLocalhostEntity = new LocalhostEntity();

		LocalhostLoginModel inModel = (LocalhostLoginModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			inDbLocalhostEntity.setLangId(inModel.getLangId());
			inDbLocalhostEntity.setLoginId(inModel.getLoginId());
			inDbLocalhostEntity.setLoginType(inModel.getLoginType());
			inDbLocalhostEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			inDbLocalhostEntity.setOkFlg(KooConst.LT_OK_FLG_Y);

			List<LocalhostEntity> retList = localhostService4DB.selectByCondition(inDbLocalhostEntity);

			if (retList != null && retList.size() == 1) {
				retMsg.setHasError(false);
				retMsg.setData("1");
			} else {
				retMsg.setHasError(false);
				retMsg.setData("0");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
}
