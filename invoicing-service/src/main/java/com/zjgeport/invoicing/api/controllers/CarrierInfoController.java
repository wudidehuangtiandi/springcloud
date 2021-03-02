package com.zjgeport.invoicing.api.controllers;

import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zjgeport.invoicing.api.utils.BeanUtils;
import com.zjgeport.invoicing.api.utils.FileBase64ConvertUitl;
import com.zjgeport.invoicing.api.utils.PathUtils;
import com.zjgeport.invoicing.domain.models.CarrierInfo;
import com.zjgeport.invoicing.domain.models.ConsignorOpenbank;
import com.zjgeport.invoicing.domain.models.QCarrierInfo;
import com.zjgeport.invoicing.domain.repositories.CarrierInfoRepository;
import com.zjgeport.invoicing.domain.repositories.ConsignorOpenbankRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CarrierInfoController {

    @Autowired
    private CarrierInfoRepository carrierInfoRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BeanUtils beanUtils;

    @Autowired
    private ConsignorOpenbankRepository consignorOpenbankRepository;

    @Autowired
    private PathUtils pathUtils;

    private JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //承运人新增1
    @RequestMapping("/carrier_add")
    @Transactional
    public HashMap<String, String> creatCarrier(HttpServletRequest request) {
        //返回值
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        if (StringUtils.isEmpty(request.getParameter("CARRIER_TYPE"))) {
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,存在必填字段为空");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("承运人新增参数错误,存在必填字段为空");
            return stringStringHashMap;
        }

        if (StringUtils.isEmpty(request.getParameter("ENTERPRISE_NAME"))
                || StringUtils.isEmpty(request.getParameter("CONTACT_PHONE"))
                || StringUtils.isEmpty(request.getParameter("OPENING_NAME"))
                || StringUtils.isEmpty(request.getParameter("OPENING_BANK"))
                || StringUtils.isEmpty(request.getParameter("OPENING_ACCOUNT"))
                || (StringUtils.isEmpty(request.getParameter("CARRIER_ID_NUMBER")) && request.getParameter("CARRIER_TYPE").equals("GC"))
                || (StringUtils.isEmpty(request.getParameter("ID_CARD_OPPO_IMG")) && request.getParameter("CARRIER_TYPE").equals("GC"))
                || (StringUtils.isEmpty(request.getParameter("ID_CARD_BG_IMG")) && request.getParameter("CARRIER_TYPE").equals("GC"))
                || (StringUtils.isEmpty(request.getParameter("CONTACT")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("SOCIAL_CREDIT_CODE")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("LEGAL_PERSON")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("LOCATION")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("ADDRESS")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("BUSINESS_LICENSE_PERIOD_BEGIN")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("BUSINESS_LICENSE_IMG")) && request.getParameter("CARRIER_TYPE").equals("QC"))
                || (StringUtils.isEmpty(request.getParameter("TRANSPORT_PERMIT_NUMBER")) && request.getParameter("CARRIER_TYPE").equals("QC") && request.getParameter("TRANSPORT_TYPE").equals("汽运"))
                || (StringUtils.isEmpty(request.getParameter("TRANSPORT_PERMIT_PERIOD_BEGIN")) && request.getParameter("CARRIER_TYPE").equals("QC") && request.getParameter("TRANSPORT_TYPE").equals("汽运"))
                || (StringUtils.isEmpty(request.getParameter("TRANSPORT_PERMIT_PERIOD_END")) && request.getParameter("CARRIER_TYPE").equals("QC") && request.getParameter("TRANSPORT_TYPE").equals("汽运"))
                || (StringUtils.isEmpty(request.getParameter("TRANSPORT_PERMIT_NUMBER")) && request.getParameter("CARRIER_TYPE").equals("QC") && request.getParameter("TRANSPORT_TYPE").equals("汽运"))
                || (StringUtils.isEmpty(request.getParameter("TRANSPORT_PERMIT_IMG")) && request.getParameter("CARRIER_TYPE").equals("QC") && request.getParameter("TRANSPORT_TYPE").equals("汽运"))
        ) {
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,存在必填字段为空");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("承运人新增参数错误,存在必填字段为空");
            return stringStringHashMap;
        }

        JSONObject jsonObject = beanUtils.newJsonObject();

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            String ID_CARD_OPPO_IMG="";
            String ID_CARD_BG_IMG="";
            String BUSINESS_LICENSE_IMG="";
            String TRANSPORT_PERMIT_IMG="";

            //保存base64文件并，替换base64为文件路径
            String[] id_card_oppo_imgs = parameterMap.get("ID_CARD_OPPO_IMG");
            if(id_card_oppo_imgs!=null){
                String id_card_oppo_img = id_card_oppo_imgs[0];
                String getpath = pathUtils.getpath();
                String realpath = FileBase64ConvertUitl.decoderBase64File(id_card_oppo_img, getpath);
                ID_CARD_OPPO_IMG=realpath;
            }


            String[] id_card_bg_imgs = parameterMap.get("ID_CARD_BG_IMG");
            if(id_card_bg_imgs!=null){
                String id_card_bg_img = id_card_bg_imgs[0];
                String getpath1 = pathUtils.getpath();
                String realpath1 = FileBase64ConvertUitl.decoderBase64File(id_card_bg_img, getpath1);
                ID_CARD_BG_IMG=realpath1;

            }


            String[] business_license_imgs = parameterMap.get("BUSINESS_LICENSE_IMG");
            if(business_license_imgs!=null){
                String business_license_img = business_license_imgs[0];
                String getpath2 = pathUtils.getpath();
                String realpath2 = FileBase64ConvertUitl.decoderBase64File(business_license_img, getpath2);
                BUSINESS_LICENSE_IMG=realpath2;
            }


            String[] transport_permit_imgs = parameterMap.get("TRANSPORT_PERMIT_IMG");
            if(transport_permit_imgs!=null){
                String transport_permit_img = transport_permit_imgs[0];
                String getpath3 = pathUtils.getpath();
                String realpath3 = FileBase64ConvertUitl.decoderBase64File(transport_permit_img, getpath3);
                TRANSPORT_PERMIT_IMG=realpath3;
            }


            Set<String> strings = parameterMap.keySet();

            for (String string : strings) {
                if(!string.equals("OPEN_BANKS")){
                    jsonObject.put(string,parameterMap.get(string)[0]);
                }
            }
            CarrierInfo carrierInfo = jsonObject.toJavaObject(CarrierInfo.class);

            carrierInfo.setIdCardOppoImg(ID_CARD_OPPO_IMG);
            carrierInfo.setIdCardBgImg(ID_CARD_BG_IMG);
            carrierInfo.setBusinessLicenseImg(BUSINESS_LICENSE_IMG);
            carrierInfo.setTransportPermitImg(TRANSPORT_PERMIT_IMG);

            carrierInfo.setId(UUID.randomUUID().toString());
            carrierInfo.setState("0");

            //暂时就这两
            carrierInfo.setCreateUser("API导入");
            carrierInfo.setCreateDate(new Date());

            carrierInfoRepository.save(carrierInfo);

            if(request.getParameterValues("OPEN_BANKS").length>0){
                String[] open_banks = request.getParameterValues("OPEN_BANKS");
                for (String open_bank : open_banks) {

                    ConsignorOpenbank consignorOpenbank = JSONObject.parseObject(open_bank, ConsignorOpenbank.class);
                    consignorOpenbank.setId(UUID.randomUUID().toString());
                    consignorOpenbank.setParentId(carrierInfo.getId());
                    if(request.getParameter("CARRIER_TYPE").equals("GC")){consignorOpenbank.setRelations("GC");}

                    if(request.getParameter("CARRIER_TYPE").equals("QC")){consignorOpenbank.setRelations("QC");}
                    consignorOpenbank.setCreateDate(new Date());
                    consignorOpenbank.setCreateUser("API导入");

                    consignorOpenbankRepository.save(consignorOpenbank);
                }
            }

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "服务器内部错误");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.error("承运人新增,服务器内部错误");
            return stringStringHashMap;
        }

        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return stringStringHashMap;
    }


    //承运人查询1
    @RequestMapping("/carrier_search")
    public HashMap<String, String> searchCarrier(HttpServletRequest request) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        if(StringUtils.isEmpty(request.getParameter("ENTERPRISE_NAME"))&&StringUtils.isEmpty(request.getParameter("CONTACT_PHONE"))&&StringUtils.isEmpty(request.getParameter("CARRIER_ID_NUMBER"))&&StringUtils.isEmpty(request.getParameter("SOCIAL_CREDIT_CODE"))){
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "至少需要输入一条参数");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("承运人查询入参缺失");
            return stringStringHashMap;
        }

        CarrierInfo carrierInfo1 = null;
        String format = "";
        BooleanBuilder booleanBuilder = beanUtils.newBooleanBuilder();

        try {
            QCarrierInfo carrierInfo = QCarrierInfo.carrierInfo;
            if (StringUtils.isNotEmpty(request.getParameter("ENTERPRISE_NAME"))) {
                booleanBuilder.and(carrierInfo.enterpriseName.eq(request.getParameter("ENTERPRISE_NAME")));
            }

            if (StringUtils.isNotEmpty(request.getParameter("CONTACT_PHONE"))) {
                booleanBuilder.and(carrierInfo.contactPhone.eq(request.getParameter("CONTACT_PHONE")));
            }
            if (StringUtils.isNotEmpty(request.getParameter("CARRIER_ID_NUMBER"))) {
                booleanBuilder.and(carrierInfo.carrierIdNumber.eq(request.getParameter("CARRIER_ID_NUMBER")));
            }
            if (StringUtils.isNotEmpty(request.getParameter("SOCIAL_CREDIT_CODE"))) {
                booleanBuilder.and(carrierInfo.socialCreditCode.eq(request.getParameter("SOCIAL_CREDIT_CODE")));
            }

            carrierInfo1 = jpaQueryFactory.selectFrom(carrierInfo).where(booleanBuilder).fetchOne();
            Date checkDate = carrierInfo1.getCheckDate();
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkDate);


        } catch (Exception e) {
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "服务器内部错误,该条记录或未审核");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.error("承运人查询,服务器内部错误,该条记录或未审核");
            return stringStringHashMap;
        }

        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        stringStringHashMap.put("enterpriseName", carrierInfo1.getEnterpriseName());
        stringStringHashMap.put("carrierPhone", carrierInfo1.getContactPhone());
        stringStringHashMap.put("carrierIdNumber", carrierInfo1.getCarrierIdNumber());
        stringStringHashMap.put("socialCreditCode", carrierInfo1.getSocialCreditCode());
        stringStringHashMap.put("checkAdvice", carrierInfo1.getCheckAdvice());
        stringStringHashMap.put("checkDate", format);
        if(carrierInfo1.getState().equals("0")){stringStringHashMap.put("state","保存");}
        else if(carrierInfo1.getState().equals("1")){stringStringHashMap.put("state","提交待审");}
        else if(carrierInfo1.getState().equals("2")){stringStringHashMap.put("state","审核通过");}
        else if(carrierInfo1.getState().equals("3")){stringStringHashMap.put("state","审核未通过");}
        return stringStringHashMap;
    }

}
