package com.zjgeport.invoicing.api.controllers;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zjgeport.invoicing.api.utils.BeanUtils;
import com.zjgeport.invoicing.api.utils.FileBase64ConvertUitl;
import com.zjgeport.invoicing.api.utils.PathUtils;
import com.zjgeport.invoicing.domain.models.*;
import com.zjgeport.invoicing.domain.repositories.ReceiptSingleInfoRepository;
import com.zjgeport.invoicing.domain.repositories.WaybillCargoInfoRepository;
import com.zjgeport.invoicing.domain.repositories.WaybillContractInfoRepository;
import com.zjgeport.invoicing.domain.repositories.WaybillTransportInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping
public class WaybillController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BeanUtils beanUtils;

    @Autowired
    private PathUtils pathUtils;

    @Autowired
    private WaybillCargoInfoRepository waybillCargoInfoRepository;

    @Autowired
    private WaybillContractInfoRepository waybillContractInfoRepository;

    @Autowired
    private WaybillTransportInfoRepository waybillTransportInfoRepository;

    @Autowired
    private ReceiptSingleInfoRepository receiptSingleInfoRepository;

    private JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //运单新增1
    @RequestMapping("/waybill_add")
    @Transactional
    public HashMap<String, String> creatWaybill(HttpServletRequest request) {
        //返回值
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        if (StringUtils.isEmpty(request.getParameter("SEND_NAME"))
                || StringUtils.isEmpty(request.getParameter("SEND_CNTACTOR"))
                || StringUtils.isEmpty(request.getParameter("SEND_PHONE"))
                || StringUtils.isEmpty(request.getParameter("SEND_AREA"))
                || StringUtils.isEmpty(request.getParameter("SEND_ADDRESS"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_NAME"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_CONTACTOR"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_PHONE"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_AREA"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_ADDRESS"))
                || StringUtils.isEmpty(request.getParameter("TRANS_CONTRACT_NO"))
                || StringUtils.isEmpty(request.getParameter("CONTRACT_TOTAL"))
                || StringUtils.isEmpty(request.getParameter("INVOICED_AMOUNT"))
                || StringUtils.isEmpty(request.getParameter("CONTRACT_SIGN_DATE"))
                || StringUtils.isEmpty(request.getParameter("TRANSPORT_CONTRACT_IMG"))
                || StringUtils.isEmpty(request.getParameter("CONSIGNOR_NAME"))
                || StringUtils.isEmpty(request.getParameter("CARRIER_NAME"))
                || StringUtils.isEmpty(request.getParameter("CARRIER_PHONE"))
                || StringUtils.isEmpty(request.getParameter("PAY_METHOD"))
                || StringUtils.isEmpty(request.getParameter("PAY_CHANNEL"))
                || StringUtils.isEmpty(request.getParameter("TRANS_COMPLETE_DATE"))
                || StringUtils.isEmpty(request.getParameter("RECEIVE_CARD_NO"))
                || StringUtils.isEmpty(request.getParameter("BANK_VOUCHER_IMG"))) {
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,主表存在必填字段为空");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("运单新增,参数错误,主表存在必填字段为空");
            return stringStringHashMap;
        }
        String[] trans_details1 = null;
        String[] cargo_infos1 = null;

        try {
            trans_details1 = request.getParameterValues("TRANS_DETAIL");
            cargo_infos1 = request.getParameterValues("CARGO_INFO");
        } catch (Exception e) {
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,副表为必填");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.error("运单新增,参数错误,副表为必填");
            return stringStringHashMap;
        }


        if (trans_details1 == null || cargo_infos1 == null) {
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,副表为必填");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("运单新增,参数错误,副表为必填");
            return stringStringHashMap;
        } else {
            try {
                Map<String, String[]> parameterMap = request.getParameterMap();
                String TRANSPORT_CONTRACT_IMG="";
                String BANK_VOUCHER_IMG="";

                //保存base64文件并，替换base64为文件路径
                String[] transport_contract_imgs = parameterMap.get("TRANSPORT_CONTRACT_IMG");
                if(transport_contract_imgs.length>0){
                    String transport_contract_img = transport_contract_imgs[0];
                    String getpath = pathUtils.getpath();
                    String realpath = FileBase64ConvertUitl.decoderBase64File(transport_contract_img, getpath);
                    TRANSPORT_CONTRACT_IMG=realpath;
                }

                //保存base64文件并，替换base64为文件路径
                String[] bank_voucher_imgs = parameterMap.get("BANK_VOUCHER_IMG");
                if(bank_voucher_imgs.length>0){
                    String bank_voucher_img = bank_voucher_imgs[0];
                    String getpath2 = pathUtils.getpath();
                    String realpath2 = FileBase64ConvertUitl.decoderBase64File(bank_voucher_img, getpath2);
                    BANK_VOUCHER_IMG=realpath2;
                }

                Set<String> strings = parameterMap.keySet();
                JSONObject jsonObject = beanUtils.newJsonObject();
                for (String string : strings) {
                    if (!string.equals("TRANS_DETAIL") && !string.equals("CARGO_INFO")) {
                        jsonObject.put(string, parameterMap.get(string)[0]);
                    }
                }
                WaybillContractInfo waybillContractInfo = jsonObject.toJavaObject(WaybillContractInfo.class);
                waybillContractInfo.setId(UUID.randomUUID().toString());
                waybillContractInfo.setWaybillSource("3");
                waybillContractInfo.setState("1");
                waybillContractInfo.setBankVoucherImg(BANK_VOUCHER_IMG);
                waybillContractInfo.setTransportContractImg(TRANSPORT_CONTRACT_IMG);

                //暂时就这两
                waybillContractInfo.setCreateUser("API导入");
                waybillContractInfo.setCreateDate(new Date());
                waybillContractInfo.setCheckState("DSQ");

                //根据电话查询承运人ID
                QCarrierInfo carrierInfo = QCarrierInfo.carrierInfo;

                CarrierInfo carrierInfo1 = jpaQueryFactory.selectFrom(carrierInfo).where(carrierInfo.contactPhone.eq(waybillContractInfo.getCarrierPhone())).fetchOne();
                waybillContractInfo.setCarrierId(carrierInfo1.getId());

                waybillContractInfoRepository.save(waybillContractInfo);

                String[] trans_details = request.getParameterValues("TRANS_DETAIL");
                for (String trans_detail : trans_details) {
                    WaybillTransportInfo waybillTransportInfo = JSONObject.parseObject(trans_detail, WaybillTransportInfo.class);

                    //存在必填字段为空则终止循环并回滚整个事务
                    if (
                            StringUtils.isEmpty(waybillTransportInfo.getWaybillNo())
                                    || StringUtils.isEmpty(waybillTransportInfo.getCarNumber())
                                    || StringUtils.isEmpty(waybillTransportInfo.getReceiptPhotoImg())
                                    || StringUtils.isEmpty(waybillTransportInfo.getDriverName())
                                    || StringUtils.isEmpty(waybillTransportInfo.getCarNumber())
                                    || waybillTransportInfo.getSendDate() == null
                                    || waybillTransportInfo.getReceiveDate() == null

                        //|| StringUtils.isEmpty(waybillTransportInfo.getD())
                    ) {
                        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                        stringStringHashMap.put("resultCode", "400");
                        stringStringHashMap.put("errorMsg", "参数错误,副表缺少必填字段");
                        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                        logger.warn("运单新增,参数错误,副表缺少必填字段");
                        return stringStringHashMap;
                    }

                    String receiptPhotoImg = waybillTransportInfo.getReceiptPhotoImg();

                    //保存base64文件并，替换base64为文件路径
                    String getpath3 = pathUtils.getpath();
                    String realpath3 = FileBase64ConvertUitl.decoderBase64File(receiptPhotoImg, getpath3);
                    waybillTransportInfo.setReceiptPhotoImg(realpath3);

                    waybillTransportInfo.setId(UUID.randomUUID().toString());
                    waybillTransportInfo.setWaybillContractId(waybillContractInfo.getId());
                    waybillTransportInfoRepository.save(waybillTransportInfo);

                    String[] cargo_infos = request.getParameterValues("CARGO_INFO");
                    for (String cargo_info : cargo_infos) {
                        WaybillCargoInfo waybillCargoInfo = JSONObject.parseObject(cargo_info, WaybillCargoInfo.class);

                        //存在必填字段为空则终止循环并回滚整个事务
                        if (
                                StringUtils.isEmpty(waybillCargoInfo.getWaybillNo())//查询用
                                        || StringUtils.isEmpty(waybillCargoInfo.getCargoName())
                                        || StringUtils.isEmpty(waybillCargoInfo.getCargoType())
                                        || (waybillCargoInfo.getCargoWeight() == 0)
                                        || (waybillCargoInfo.getCargoAmount() == 0)
                                        || StringUtils.isEmpty(waybillCargoInfo.getCargoUnit())
                        ) {
                            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            stringStringHashMap.put("resultCode", "400");
                            stringStringHashMap.put("errorMsg", "参数错误,副表缺少必填字段");
                            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                            logger.warn("运单新增,参数错误,副表缺少必填字段");
                            return stringStringHashMap;
                        }
                        waybillCargoInfo.setId(UUID.randomUUID().toString());

                        //根据所传回的运单号查询运输ID
                        String waybillNo = waybillCargoInfo.getWaybillNo();
                        QWaybillTransportInfo waybillTransportInfo1 = QWaybillTransportInfo.waybillTransportInfo;
                        WaybillTransportInfo waybillTransportInfo2 = jpaQueryFactory.selectFrom(waybillTransportInfo1).where(waybillTransportInfo1.waybillNo.eq(waybillNo)).fetchOne();

                        waybillCargoInfo.setWaybillId(waybillTransportInfo2.getId());

                        waybillCargoInfoRepository.save(waybillCargoInfo);
                    }
                }
            } catch (Exception e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                stringStringHashMap.put("resultCode", "500");
                stringStringHashMap.put("errorMsg", "服务器内部错误");
                stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                logger.error("运单新增,服务器内部错误");
                return stringStringHashMap;
            }
        }

        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return stringStringHashMap;
    }


    //运单查询1
    @RequestMapping("/waybill_search")
    public HashMap<String, Object> searchWaybill(HttpServletRequest request) {
        HashMap<String, Object> stringStringHashMap = new HashMap<>();

        QWaybillContractInfo waybillContractInfo = QWaybillContractInfo.waybillContractInfo;
        QWaybillTransportInfo waybillTransportInfo = QWaybillTransportInfo.waybillTransportInfo;
        QReceiptSingleInfo receiptSingleInfo = QReceiptSingleInfo.receiptSingleInfo;
        QReceiptBatchInfo receiptBatchInfo = QReceiptBatchInfo.receiptBatchInfo;

        BooleanBuilder booleanBuilder = beanUtils.newBooleanBuilder();
        List<searchReturn> fetch = null;
        try {
            if (StringUtils.isNotEmpty(request.getParameter("WAYBILL_NO"))) {
                booleanBuilder.and(waybillTransportInfo.waybillNo.eq(request.getParameter("WAYBILL_NO")));
            }
            if (StringUtils.isNotEmpty(request.getParameter("BATCH_NO"))) {
                booleanBuilder.and(receiptSingleInfo.batchNo.eq(request.getParameter("BATCH_NO")));
            }

            fetch = jpaQueryFactory.select(Projections.bean(searchReturn.class, waybillTransportInfo.waybillNo, receiptBatchInfo.payState, receiptSingleInfo.invoiceState, receiptSingleInfo.writeOffSate, receiptSingleInfo.receiptSendState)).from(waybillTransportInfo).join(waybillContractInfo).on(waybillTransportInfo.waybillContractId.eq(waybillContractInfo.id))
                    .join(receiptSingleInfo).on(waybillContractInfo.receiptId.eq(receiptSingleInfo.id)).join(receiptBatchInfo).on(receiptSingleInfo.batchId.eq(receiptBatchInfo.id)).where(booleanBuilder).fetch();
        } catch (Exception e) {
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "服务器内部错误,");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.error("运单查询,服务器内部错误");
            return stringStringHashMap;
        }
        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        stringStringHashMap.put("batchNo", request.getParameter("BATCH_NO"));

        stringStringHashMap.put("wayBillNo", fetch);
        return stringStringHashMap;

    }

}





