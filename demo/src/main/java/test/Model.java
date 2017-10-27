package test;

import cn.upenny.common.util.HttpClientUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 845477519@qq.com on 2017/10/17 0017.
 */
public class Model {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap();
        map.put("nid","1234567890");
        map.put("QIANHAICredooScore","1");
        map.put("ZHIMAZhimaScore","1");
        map.put("FRDDEVINFOCNTCMoblAddrAsHousHdAddrNum","1");
        map.put("FRDDEVINFOCNTCMoblAddrAsResidntAddrNum","1");
        map.put("QIANHAICredooCompNum","1");
        map.put("BLOCKApplicationAmount","1");
        map.put("POLICYAge","1");
        map.put("FRDDEVINFOContactX0","1");
        map.put("ZHIMAZhimaIvsScore","1");
        map.put("FRAUDADDRSameHousHdDistX0","1");
        map.put("FRAUDADDRSameHousHdDistX1","1");
        map.put("FRDDEVINFOCallX0","1");
        map.put("FRAUDADDRSameHousHdDistX3","1");
        map.put("FRDDEVINFOSMSX0","1");
        map.put("HISTSuccessLoanCnt","1");
        map.put("FRAUDADDRSameCompDistX0","1");
        map.put("FRDDEVINFOCallRecMoblAddrAsHousHdAddrNum","1");
        map.put("FRAUDADDRSameResidntDistX0","1");
        map.put("FRDDEVINFOCallRecMoblAddrAsResidntAddrNum","1");
        map.put("FRAUDADDRSameCompDistX1","1");
        map.put("FRAUDADDRSameResidntDistX1","1");
        map.put("FRAUDADDRSameCompDistX3","1");
        map.put("FRAUDADDRSameResidntDistX3","1");
        map.put("FRAUDADDRSameHousHdDistX4","1");
        map.put("HISTOverdueM1Days","1");
        map.put("FRAUDADDRSameResidntDistX4","1");
        map.put("FRAUDADDRSameHousHdDistX5","1");
        map.put("FRAUDADDRSameCompDistX4","1");
        map.put("FRAUDADDRSameCompDistX5","1");
        map.put("FRAUDADDRSameResidntDistX5","1");
        map.put("FRDDEVINFOContactX3","1");
        map.put("FRDDEVINFOCNTCCommSensitvWordNums","1");
        map.put("FRDDEVINFOSameIndustryCompNums","1");
        map.put("FRAUDLKMLinkmanX0","1");
        map.put("FRDDEVINFOCreditCardCenterNums","1");
        map.put("FRAUDADDRSameHousHdDistX6","1");
        map.put("FRDDEVINFOSMSCommSensitvWordNums","1");
        map.put("FRAUDADDRSameCompDistX6","1");
        map.put("FRAUDADDRSameResidntDistX6","1");
        map.put("FRAUDADDRSameResidntDistX2","1");
        map.put("FRAUDADDRSameHousHdDistX2","1");
        map.put("FRDDEVINFOContactX1","1");
        map.put("FRAUDADDRSameCompDistX2","-999");
        map.put("REQINFOOptionalInContactNum","1");
        map.put("FRDDEVINFOIsSexContactDiff","1");
        map.put("REQINFOIncome","1");
        map.put("BLOCKIsInvite","1");
        map.put("POLICYHighestEdu","1");
        map.put("REQINFOMobileOperators","1");
        String result = HttpClientUtils.doPost("http://192.168.1.19:5000/model13", map);
        System.out.println(result);
    }
}
