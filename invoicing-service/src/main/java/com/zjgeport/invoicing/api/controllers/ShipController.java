package com.zjgeport.invoicing.api.controllers;


import com.alibaba.fastjson.JSONObject;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.zjgeport.invoicing.api.utils.BeanUtils;
import com.zjgeport.invoicing.api.utils.FileBase64ConvertUitl;
import com.zjgeport.invoicing.api.utils.PathUtils;
import com.zjgeport.invoicing.domain.models.QShipInfo;
import com.zjgeport.invoicing.domain.models.ShipInfo;
import com.zjgeport.invoicing.domain.repositories.ShipInfoRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping
public class ShipController {

    @Autowired
    private ShipInfoRepository shipInfoRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private BeanUtils beanUtils;

    @Autowired
    private PathUtils pathUtils;

    private JPAQueryFactory jpaQueryFactory;

    @PostConstruct
    public void init() {
        jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    //船舶添加1
    @RequestMapping("/ship_add")
    @Transactional
    public HashMap<String, String> creatShip(HttpServletRequest request) {

        //返回值
        HashMap<String, String> stringStringHashMap = new HashMap<>();

        if(StringUtils.isEmpty(request.getParameter("SHIP_NAME_CNA"))||StringUtils.isEmpty(request.getParameter("SHIP_MMSI"))||StringUtils.isEmpty(request.getParameter("INSPECTION_CERT_IMG"))){
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,存在必填字段为空");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("船舶新增,参数错误,存在必填字段为空");
            return stringStringHashMap;
        }
        JSONObject jsonObject = beanUtils.newJsonObject();

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();

            String OPERATE_CERT_IMG="";
            String OWNERSHIP_CERT_IMG="";
            String INSPECTION_CERT_IMG="";

            //保存base64文件并，替换base64为文件路径
            String[] operate_cert_imgs = parameterMap.get("OPERATE_CERT_IMG");

            System.out.println(operate_cert_imgs);

            if(operate_cert_imgs!=null){
                String operate_cert_img = operate_cert_imgs[0];
                String getpath = pathUtils.getpath();
                String realpath = FileBase64ConvertUitl.decoderBase64File(operate_cert_img, getpath);
                OPERATE_CERT_IMG=realpath;
            }

            String[] ownership_cert_imgs = parameterMap.get("OWNERSHIP_CERT_IMG");
            if(ownership_cert_imgs!=null){
                String ownership_cert_img = ownership_cert_imgs[0];
                String getpath1 = pathUtils.getpath();
                String realpath1 = FileBase64ConvertUitl.decoderBase64File(ownership_cert_img, getpath1);
                OWNERSHIP_CERT_IMG=realpath1;
            }

            String[] inspection_cert_imgs = parameterMap.get("INSPECTION_CERT_IMG");
            if(inspection_cert_imgs!=null){
                String inspection_cert_img = inspection_cert_imgs[0];
                String getpath2 = pathUtils.getpath();
                String realpath2 = FileBase64ConvertUitl.decoderBase64File(inspection_cert_img, getpath2);
                INSPECTION_CERT_IMG=realpath2;
            }


            Set<String> strings = parameterMap.keySet();
            for (String string : strings) {
                jsonObject.put(string,parameterMap.get(string)[0]);
            }
            ShipInfo shipInfo = jsonObject.toJavaObject(ShipInfo.class);
            shipInfo.setState("0");
            shipInfo.setId(UUID.randomUUID().toString());

            shipInfo.setOperateCertImg(OPERATE_CERT_IMG);
            shipInfo.setOwnershipCertImg(OWNERSHIP_CERT_IMG);
            shipInfo.setInspectionCertImg(INSPECTION_CERT_IMG);

            //暂时就这两
            shipInfo.setCreateUser("API导入");
            shipInfo.setCreateDate(new Date());

            shipInfoRepository.save(shipInfo);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "服务器内部错误");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("船舶新增，服务器内部错误");
            return stringStringHashMap;
        }


        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return stringStringHashMap;
    }

    //船舶状态查询1
    @RequestMapping("/ship_search")
    public HashMap<String, String> searchShip(HttpServletRequest request) {

        HashMap<String, String> stringStringHashMap = new HashMap<>();

        ShipInfo shipInfo=null;
        String format ="";

        if(StringUtils.isEmpty(request.getParameter("SHIP_NO"))){
            stringStringHashMap.put("resultCode", "400");
            stringStringHashMap.put("errorMsg", "参数错误,存在必填字段为空");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.warn("船舶查询,参数错误,存在必填字段为空");
            return stringStringHashMap;
        }
        BooleanBuilder booleanBuilder = beanUtils.newBooleanBuilder();

        try {
            QShipInfo shipInfo1 = QShipInfo.shipInfo;
            booleanBuilder.and(shipInfo1.shipNo.eq(request.getParameter("SHIP_NO")));
            shipInfo = jpaQueryFactory.selectFrom(shipInfo1).where(booleanBuilder).fetchOne();
            Date checkDate = shipInfo.getCheckDate();
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(checkDate);
        } catch (Exception e) {
            stringStringHashMap.put("resultCode", "500");
            stringStringHashMap.put("errorMsg", "服务器内部错误，该条记录或未审核");
            stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            logger.error("船舶查询,服务器内部错误,该条记录或未审核");
            return stringStringHashMap;
        }
        stringStringHashMap.put("resultCode", "200");
        stringStringHashMap.put("returnDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        stringStringHashMap.put("checkAdvice",shipInfo.getCheckAdvice());
        stringStringHashMap.put("checkDate", format);
        if(shipInfo.getState().equals("0")){stringStringHashMap.put("state","保存");}
        else if(shipInfo.getState().equals("1")){stringStringHashMap.put("state","提交待审");}
        else if(shipInfo.getState().equals("2")){stringStringHashMap.put("state","审核通过");}
        else if(shipInfo.getState().equals("3")){stringStringHashMap.put("state","审核未通过");}
        return stringStringHashMap;
    }


}
