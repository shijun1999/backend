package com.kootour.service.impl;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostLoginModel;
import com.kootour.service.LocalhostSignService;
import com.kootour.service4db.LocalhostService4DB;
import com.kootour.service4db.SequenceService4DB;
@Configuration
@Service
public class LocalhostSignServiceImpl implements LocalhostSignService {

	@Resource
	LocalhostService4DB localhostService4DB;

	@Resource
	SequenceService4DB sequenceService4DB;

	@Override
	public KootourMessage regWithEmail(Map<String, Object> paraMap) {

		LocalhostEntity inDbLocalhostEntity = new LocalhostEntity();

		LocalhostLoginModel inModel = (LocalhostLoginModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			inDbLocalhostEntity.setLoginType(KooConst.LT_LOGIN_TYPE_EMAIL);
			inDbLocalhostEntity.setLangId(inModel.getLangId());
			inDbLocalhostEntity.setFirstName(inModel.getFirstName());
			inDbLocalhostEntity.setLastName(inModel.getLastName());
			inDbLocalhostEntity.setEmail(inModel.getEmail());
			inDbLocalhostEntity.setLoginId(inModel.getLoginId());
			inDbLocalhostEntity.setPassword(inModel.getPassword());

			List<LocalhostEntity> outDbList = localhostService4DB.selectByCondition(inDbLocalhostEntity);
			if (outDbList != null && outDbList.size() > 0) {
				retMsg.setHasError(true);
				retMsg.setMessage("This email have already been registered.");
				return retMsg;
			}

			inDbLocalhostEntity.setLocalhostIdentiNo(sequenceService4DB.createSequence(KooConst.ST_LOCALHOST));
			inDbLocalhostEntity.setVendorIdentiNo(StringUtils.EMPTY);
			inDbLocalhostEntity.setFullName(inModel.getFirstName() + StringUtils.SPACE + inModel.getLastName());
			inDbLocalhostEntity.setShortName(StringUtils.EMPTY);
			inDbLocalhostEntity.setLoginId(inModel.getLoginId());
			inDbLocalhostEntity.setPostCode(StringUtils.EMPTY);
			inDbLocalhostEntity.setState(StringUtils.EMPTY);
			inDbLocalhostEntity.setAddr1(StringUtils.EMPTY);
			inDbLocalhostEntity.setAddr2(StringUtils.EMPTY);
			inDbLocalhostEntity.setAddr3(StringUtils.EMPTY);
			inDbLocalhostEntity.setTelCode(StringUtils.EMPTY);
			inDbLocalhostEntity.setTelNo(StringUtils.EMPTY);
			inDbLocalhostEntity.setPhoto("noimage.png");
			inDbLocalhostEntity.setOkFlg(KooConst.LT_OK_FLG_Y);
			inDbLocalhostEntity.setUseLangId(StringUtils.EMPTY);
			inDbLocalhostEntity.setMemo(StringUtils.EMPTY);
			inDbLocalhostEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			localhostService4DB.insertOne(inDbLocalhostEntity);

			List<LocalhostEntity> retList = localhostService4DB.selectByPK(inDbLocalhostEntity);

			if (retList != null && retList.size() == 1) {
				retMsg.setHasError(false);
				retMsg.setMessage("Success");
				retMsg.setData(retList.get(0));
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("Can not login with email.Please contract manager.<br>error code is: REGMAIL001");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage regWithFb(Map<String, Object> paraMap) {

		LocalhostEntity inDbLocalhostEntity = new LocalhostEntity();

		LocalhostLoginModel inModel = (LocalhostLoginModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			inDbLocalhostEntity.setLoginType(inModel.getLoginType());
			inDbLocalhostEntity.setLangId(inModel.getLangId());
			inDbLocalhostEntity.setFirstName(inModel.getFirstName());
			inDbLocalhostEntity.setLastName(inModel.getLastName());
			inDbLocalhostEntity.setEmail(inModel.getEmail());
			inDbLocalhostEntity.setLoginId(inModel.getEmail());
			inDbLocalhostEntity.setPassword(StringUtils.EMPTY);

			List<LocalhostEntity> outDbList = localhostService4DB.selectByCondition(inDbLocalhostEntity);
			if (outDbList != null && outDbList.size() > 0) {
				retMsg.setHasError(true);
				retMsg.setMessage("This email have already been registered.");
				return retMsg;
			}

			inDbLocalhostEntity.setLocalhostIdentiNo(sequenceService4DB.createSequence(KooConst.ST_LOCALHOST));
			inDbLocalhostEntity.setVendorIdentiNo(StringUtils.EMPTY);
			inDbLocalhostEntity.setFullName(inModel.getFirstName() + StringUtils.SPACE + inModel.getLastName());
			inDbLocalhostEntity.setShortName(StringUtils.EMPTY);
			inDbLocalhostEntity.setLoginId(inModel.getEmail());
			inDbLocalhostEntity.setPostCode(StringUtils.EMPTY);
			if (StringUtils.isEmpty(inModel.getLocation())) {
				inDbLocalhostEntity.setState(StringUtils.EMPTY);
				inDbLocalhostEntity.setAddr1(StringUtils.EMPTY);
			} else {
				inDbLocalhostEntity.setState(inModel.getLocation().split(",")[0]);
				inDbLocalhostEntity.setAddr1(inModel.getLocation().split(",")[1]);
			}

			inDbLocalhostEntity.setAddr2(StringUtils.EMPTY);
			inDbLocalhostEntity.setAddr3(StringUtils.EMPTY);
			inDbLocalhostEntity.setTelCode(StringUtils.EMPTY);
			inDbLocalhostEntity.setTelNo(StringUtils.EMPTY);
			inDbLocalhostEntity.setPhoto(inModel.getAvatar());
			inDbLocalhostEntity.setOkFlg(KooConst.LT_OK_FLG_Y);
			inDbLocalhostEntity.setUseLangId(StringUtils.EMPTY);
			inDbLocalhostEntity.setMemo(StringUtils.EMPTY);
			inDbLocalhostEntity.setDelFlg(KooConst.LT_DEL_FLG_N);
			localhostService4DB.insertOne(inDbLocalhostEntity);

			List<LocalhostEntity> retList = localhostService4DB.selectByPK(inDbLocalhostEntity);

			if (retList != null && retList.size() == 1) {
				retMsg.setHasError(false);
				retMsg.setMessage("Success");
				retMsg.setData(retList.get(0));
			} else {
				retMsg.setHasError(true);
				retMsg.setMessage("Can not login with facebook account.Please contract manager.<br>error code is: REGFB001");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

}
