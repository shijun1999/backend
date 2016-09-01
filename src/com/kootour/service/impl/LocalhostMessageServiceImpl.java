package com.kootour.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.kootour.common.KooConst;
import com.kootour.common.KootourMessage;
import com.kootour.mapper.entity.MessageEntity;
import com.kootour.mapper.entity.TouristEntity;
import com.kootour.model.LocalhostChatModel;
import com.kootour.model.LocalhostMessageModel;
import com.kootour.service.LocalhostMessageService;
import com.kootour.service4db.MessageService4DB;
import com.kootour.service4db.SequenceService4DB;
import com.kootour.service4db.TouristService4DB;
import com.kootour.transfer.ChatTransfer;
import com.kootour.transfer.MessageTransfer;
@Configuration
@Service
public class LocalhostMessageServiceImpl implements LocalhostMessageService {

	@Resource
	MessageService4DB messageService4DB;

	@Resource
	TouristService4DB touristService4DB;

	@Resource
	SequenceService4DB sequenceService4DB;

	@Override
	public KootourMessage load(Map<String, Object> paraMap) {
		TouristEntity touristEntity = new TouristEntity();
		LocalhostChatModel inModel = (LocalhostChatModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();

		try {
			touristEntity.setLangId(inModel.getLangId());
			touristEntity.setTouristIdentiNo(inModel.getTouristIdentiNo());

			TouristEntity outTouristEntity = touristService4DB.selectByPK(touristEntity);
			if (outTouristEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				LocalhostChatModel outModel = new LocalhostChatModel();
				outModel.setLoginType(outTouristEntity.getLoginType());
				outModel.setFirstName(outTouristEntity.getFirstName());
				outModel.setPicture(outTouristEntity.getPicture());
				outModel.setLocation(outTouristEntity.getLocation());

				Date createTimeDate = outTouristEntity.getCreateTime();
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				String createTimeStr = dateformat.format(createTimeDate);
				outModel.setCreateTime(createTimeStr);

				retMsg.setHasError(false);
				retMsg.setMessage("");
				retMsg.setData(outModel);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage fetchNotification(Map<String, Object> paraMap) {
		MessageEntity inDbMessageEntity = new MessageEntity();

		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			inDbMessageEntity.setLangId(inModel.getLangId());
			inDbMessageEntity.setLocalhostIdentiNo(inModel.getLocalhostEntity().getLocalhostIdentiNo());
			inDbMessageEntity.setReadFlg(KooConst.LT_READ_FLG_N);
			inDbMessageEntity.setMessageType(KooConst.LT_MESSAGE_TYPE_S);
			inDbMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<MessageEntity> retList = messageService4DB.selectByCondition(inDbMessageEntity);
			if (retList == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				retMsg.setHasError(false);
				retMsg.setMessage("");
				retMsg.setData(retList);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage fetchMessage(Map<String, Object> paraMap) {
		MessageEntity inDbMessageEntity = new MessageEntity();

		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			inDbMessageEntity.setLangId(inModel.getLangId());
			inDbMessageEntity.setLocalhostIdentiNo(inModel.getLocalhostEntity().getLocalhostIdentiNo());
			inDbMessageEntity.setReadFlg(KooConst.LT_READ_FLG_N);
			inDbMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<MessageEntity> outMessageEntity = messageService4DB.selectByConditionForChat(inDbMessageEntity);
			if (outMessageEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				Set<String> tempSet = new HashSet<String> ();
				List<MessageTransfer> retList = new ArrayList<MessageTransfer> ();
				for (MessageEntity messageEntity : outMessageEntity) {
					if (tempSet.contains(messageEntity.getTouristIdentiNo())) {
						continue;
					} else {
						tempSet.add(messageEntity.getTouristIdentiNo());
						TouristEntity touristEntity = new TouristEntity();
						touristEntity.setLangId(inModel.getLangId());
						touristEntity.setTouristIdentiNo(messageEntity.getTouristIdentiNo());

						TouristEntity outTouristEntity = touristService4DB.selectByPK(touristEntity);
						if (outTouristEntity == null) {
							continue;
						} else {
							MessageTransfer messageTransfer = new MessageTransfer();
							messageTransfer.setMessageEntity(messageEntity);
							messageTransfer.setTouristEntity(outTouristEntity);
							retList.add(messageTransfer);
						}
					}
				}
				retMsg.setHasError(false);
				retMsg.setMessage("");
				retMsg.setData(retList);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage fetchChat(Map<String, Object> paraMap) {
		MessageEntity inDbMessageEntity = new MessageEntity();

		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			TouristEntity touristEntity = new TouristEntity();
			touristEntity.setLangId(inModel.getLangId());
			touristEntity.setTouristIdentiNo(inModel.getTouristIdentiNo());

			TouristEntity outTouristEntity = touristService4DB.selectByPK(touristEntity);
			if (outTouristEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				inDbMessageEntity.setLangId(inModel.getLangId());
				inDbMessageEntity.setLocalhostIdentiNo(inModel.getLocalhostEntity().getLocalhostIdentiNo());
				inDbMessageEntity.setTouristIdentiNo(inModel.getTouristIdentiNo());
				inDbMessageEntity.setReadFlg(KooConst.LT_READ_FLG_N);
				inDbMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

				List<MessageEntity> outMessageEntity = messageService4DB.selectByConditionForChat(inDbMessageEntity);
				if (outMessageEntity == null || outMessageEntity.size() == 0) {
					inDbMessageEntity.setReadFlg(null);
					outMessageEntity = messageService4DB.selectByConditionForChat(inDbMessageEntity);
					if (outMessageEntity == null || outMessageEntity.size() == 0) {
						retMsg.setHasError(true);
						retMsg.setMessage("No Data");
					} else {
						int dataLength = outMessageEntity.size() >= 10 ? 10 : outMessageEntity.size();
						for (int i = 0; i <= dataLength; i ++) {
							Map<String, List<MessageEntity>> tempMap = new HashMap<String, List<MessageEntity>>();
							for (MessageEntity messageEntity : outMessageEntity) {
								Date messageTime = messageEntity.getMessageTime();
								SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
								String messageTimeStr = dateformat.format(messageTime);
								if (tempMap.containsKey(messageTimeStr)) {
									tempMap.get(messageTimeStr).add(messageEntity);
								} else {
									List<MessageEntity> tempList = new ArrayList<MessageEntity>();
									tempList.add(messageEntity);
									tempMap.put(messageTimeStr, tempList);
								}
								ChatTransfer chatTransfer = new ChatTransfer();
								chatTransfer.setMessageMap(tempMap);
								chatTransfer.setTouristEntity(outTouristEntity);
								retMsg.setHasError(false);
								retMsg.setMessage("");
								retMsg.setData(chatTransfer);
							}
						}
					}
				} else {
					Map<String, List<MessageEntity>> tempMap = new HashMap<String, List<MessageEntity>>();
					for (MessageEntity messageEntity : outMessageEntity) {
						Date messageTime = messageEntity.getMessageTime();
						SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
						String messageTimeStr = dateformat.format(messageTime);
						if (tempMap.containsKey(messageTimeStr)) {
							tempMap.get(messageTimeStr).add(messageEntity);
						} else {
							List<MessageEntity> tempList = new ArrayList<MessageEntity>();
							tempList.add(messageEntity);
							tempMap.put(messageTimeStr, tempList);
						}

						messageEntity.setReadFlg(KooConst.LT_READ_FLG_Y);
						messageService4DB.updateByPK(messageEntity);

						ChatTransfer chatTransfer = new ChatTransfer();
						chatTransfer.setMessageMap(tempMap);
						chatTransfer.setTouristEntity(outTouristEntity);
						retMsg.setHasError(false);
						retMsg.setMessage("");
						retMsg.setData(chatTransfer);
					}
				}
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage readNotification(Map<String, Object> paraMap) {
		MessageEntity inDbMessageEntity = new MessageEntity();

		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			inDbMessageEntity.setLangId(inModel.getLangId());
			inDbMessageEntity.setMessageIdentiNo(inModel.getMessageIdentiNo());;
			inDbMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<MessageEntity> retList = messageService4DB.selectByPK(inDbMessageEntity);
			if (retList == null || retList.size() != 1) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				MessageEntity outMessageEntity = retList.get(0);
				outMessageEntity.setReadFlg(KooConst.LT_READ_FLG_Y);
				messageService4DB.updateByPK(outMessageEntity);
				retMsg.setHasError(false);
				retMsg.setMessage("");
				retMsg.setData(retList);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage fetchSeeMore(Map<String, Object> paraMap) {
		MessageEntity inDbMessageEntity = new MessageEntity();

		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);

		KootourMessage retMsg = new KootourMessage();
		try {
			inDbMessageEntity.setLangId(inModel.getLangId());
			inDbMessageEntity.setLocalhostIdentiNo(inModel.getLocalhostEntity().getLocalhostIdentiNo());
			inDbMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			List<MessageEntity> outMessageEntity = messageService4DB.selectByConditionForChat(inDbMessageEntity);
			if (outMessageEntity == null) {
				retMsg.setHasError(true);
				retMsg.setMessage("No Data");
			} else {
				Set<String> tempSet = new HashSet<String> ();
				List<MessageTransfer> retList = new ArrayList<MessageTransfer> ();
				for (MessageEntity messageEntity : outMessageEntity) {
					if (tempSet.contains(messageEntity.getTouristIdentiNo())) {
						continue;
					} else {
						tempSet.add(messageEntity.getTouristIdentiNo());
						TouristEntity touristEntity = new TouristEntity();
						touristEntity.setLangId(inModel.getLangId());
						touristEntity.setTouristIdentiNo(messageEntity.getTouristIdentiNo());

						TouristEntity outTouristEntity = touristService4DB.selectByPK(touristEntity);
						if (outTouristEntity == null) {
							continue;
						} else {
							MessageTransfer messageTransfer = new MessageTransfer();
							messageTransfer.setMessageEntity(messageEntity);
							messageTransfer.setTouristEntity(outTouristEntity);
							retList.add(messageTransfer);
						}
					}
				}
				retMsg.setHasError(false);
				retMsg.setMessage("");
				retMsg.setData(retList);
			}
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}

	@Override
	public KootourMessage sendMessage(Map<String, Object> paraMap) {
		LocalhostMessageModel inModel = (LocalhostMessageModel) paraMap.get(KooConst.LT_IN_PARAM_MODEL_KEY);
		KootourMessage retMsg = new KootourMessage();

		MessageEntity inMessageEntity = new MessageEntity();
		try {
			inMessageEntity.setLangId(inModel.getLangId());
			inMessageEntity.setMessageIdentiNo(sequenceService4DB.createSequence(KooConst.ST_MESSAGE));
			inMessageEntity.setLocalhostIdentiNo(inModel.getLocalhostEntity().getLocalhostIdentiNo());
			inMessageEntity.setTouristIdentiNo(inModel.getTouristIdentiNo());
			inMessageEntity.setMessageType(KooConst.LT_MESSAGE_TYPE_L);
			inMessageEntity.setMessageText(inModel.getMessageText());
			inMessageEntity.setMessageTime(new Date());
			inMessageEntity.setMailFlg("0");
			inMessageEntity.setReadFlg(KooConst.LT_READ_FLG_N);
			inMessageEntity.setDelFlg(KooConst.LT_DEL_FLG_N);

			messageService4DB.insertOne(inMessageEntity);
			retMsg.setHasError(false);
			retMsg.setMessage("");
			retMsg.setData(null);
			return retMsg;
		} catch (Exception e) {
			retMsg.setHasError(true);
			retMsg.setMessage(this.getClass().getName() + ":<br>" + e.getMessage());
			return retMsg;
		}
	}
}
