package com.kootour.service.impl;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.LocalhostEntity;
import com.kootour.model.LocalhostAccountModel;
import com.kootour.model.UploadImageModel;
import com.kootour.service.LocalhostAccountService;
import com.kootour.service4db.LocalhostService4DB;
@Configuration
@Service
public class LocalhostAccountServiceImpl implements LocalhostAccountService {

	@Resource
	LocalhostService4DB localhostService4DB;

	@Override
	public KootourMessage updateAccount(Map<String, Object> paraMap) {

		LocalhostAccountModel inModel = (LocalhostAccountModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			List<LocalhostEntity> outDbList = localhostService4DB.selectByPK(inModel.getLocalhostEntity());
			if (outDbList == null || outDbList.size() > 1) {
				retMsg.setHasError(true);
				retMsg.setMessage("No login user information.<br>Please re-login.");
			} else {
				LocalhostEntity outDbEntity = outDbList.get(0);

				outDbEntity.setLastName(inModel.getLastName());
				outDbEntity.setFirstName(inModel.getFirstName());
				outDbEntity.setMemo(inModel.getMemo());
				outDbEntity.setAddr3(inModel.getLocation());

				localhostService4DB.updateByPK(outDbEntity);

				retMsg.setHasError(false);
				retMsg.setData(outDbEntity);
				retMsg.setMessage("Update account information successfully");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage uploadAvatar(Map<String, Object> paraMap) {
		UploadImageModel inModelEntity = (UploadImageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		File srcFile = inModelEntity.getFile();
		String srcFileName = inModelEntity.getFileFileName();
        String suffix = srcFileName.substring(srcFileName.lastIndexOf("."));
        String newName = Calendar.getInstance().getTimeInMillis() + suffix;
        String newPath = "/home/kootour_dev/webapps/upload/images/" + newName;
//        String newPath = "C:/upload/" + newName;
        File destFile = new File(newPath);
        KootourMessage retMsg = new KootourMessage();
		try {
			doCopy(srcFile, destFile);

			List<LocalhostEntity> outDbList = localhostService4DB.selectByPK(inModelEntity.getLocalhostEntity());
			if (outDbList == null || outDbList.size() > 1) {
				retMsg.setHasError(true);
				retMsg.setMessage("No login user information.<br>Please re-login.");
			} else {
				LocalhostEntity outDbEntity = outDbList.get(0);
				outDbEntity.setPhoto(newName);
				localhostService4DB.updateByPK(outDbEntity);

				retMsg.setHasError(false);
				retMsg.setData(newName);
				retMsg.setMessage("Upload avatar success.");
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	private void doCopy(File src, File dest) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        byte [] buf = new byte [2048];
        int len = -1;
        while((len = bis.read(buf)) != -1) {
            bos.write(buf);
        }
        bis.close();
        bos.close();
	}

	@Override
	public KootourMessage changePassword(Map<String, Object> paraMap) {
		LocalhostAccountModel inModel = (LocalhostAccountModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();
		try {
			List<LocalhostEntity> outDbList = localhostService4DB.selectByPK(inModel.getLocalhostEntity());
			if (outDbList == null || outDbList.size() > 1) {
				retMsg.setHasError(true);
				retMsg.setMessage("No login user information.<br>Please re-login.");
			} else {
				LocalhostEntity outDbEntity = outDbList.get(0);

				String oldPassword = outDbEntity.getPassword();
				String oldPassword2 = inModel.getOldPassword();

				if (oldPassword.equals(oldPassword2)) {
					outDbEntity.setPassword(inModel.getNewPassword());
					localhostService4DB.updateByPK(outDbEntity);

					retMsg.setHasError(false);
					retMsg.setData(outDbEntity);
					retMsg.setMessage("Change password successfully");
				} else {
					retMsg.setHasError(true);
					retMsg.setMessage("Old password is wrong");
				}
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
}
