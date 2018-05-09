package com.example.jdbc;


import utils.DateStyle;
import utils.DateUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by robin on 2016/5/23.
 *
 * @author robin
 */
public class InsertTableDemo {

    public static void main(String args[]) throws SQLException {
        Connection connection = null;
        List<Goods> dataList = getDataList(100000);
        long time = 0;
        try{
            connection = getConn();
            time=System.currentTimeMillis();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("insert into saas_goods (enterprise_id, chain_type,owner_id," +
                    "                    business_variety, category_id, code," +
                    "                    barcode, generic_name, name," +
                    "                    goods_attribute, prescription_drug, otc_type, force_register_flag,cosmetics," +
                    "                    pinyin_code,  mph_code," +
                    "                    old_code, national_standard_code, dosage_id," +
                    "                    dosage_name, specification, unit_id," +
                    "                    unit_name, domestic_import, manufacturer_id," +
                    "                    manufacturer, place, approval_number," +
                    "                    valid_until, management_scope_id, management_scope_name," +
                    "                    check_type_id, check_type_name, quality_period," +
                    "                    quality_period_unit, special_drug, spirit_drug_type,in_charge_drug," +
                    "                    limit_quantity, storage_temp," +
                    "                    storage_condition_name, registered_trademark," +
                    "                    brand, season, grade," +
                    "                    medical_insurance, medical_insurance_type," +
                    "                    medical_insurance_code, first, first_goods_code," +
                    "                    applicant_id, applicant_code, applicant_name," +
                    "                    application_time, application_opinion," +
                    "                    goods_nature, configuration_flag, distr_flag,status," +
                    "                    valid_flag, approve_status, picture_ids," +
                    "                    remark, creater_id, creater_code," +
                    "                    creater_name, create_time, modifier_id," +
                    "                    modifier_code, modifier_name, update_time" +
                    "            )" +
                    "            values(?, ?,?," +
                    "      ?, ?, ?, " +
                    "      ?, ?, ?, " +
                    "      ?, ?, ?,?," +
                    "      ?," +
                    "      ?,?," +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?,?," +
                    "      ?,?," +
                    "      ?,?, " +
                    "      ?,?,?, " +
                    "      ?,?, " +
                    "      ?, ?,?," +
                    "      ?,?,?, " +
                    "      ?,?," +
                    "      ?,?,?,?," +
                    "      ?,?,?," +
                    "      ?,?,?, " +
                    "      ?,?,?, " +
                    "      ?,?,?" +
                    "      ) ");

//
            int num = 0;
            for (int i = 0;i< dataList.size();i++){
                Goods goods = dataList.get(i);
                statement.setLong(1,61l);
                statement.setInt(2,goods.getChainType());
                statement.setLong(3,goods.getOwnerId());
                statement.setInt(4,goods.getBusinessVariety());
                statement.setLong(5,goods.getCategoryId());
                statement.setString(6,goods.getCode());
                statement.setString(7,goods.getBarcode());
                statement.setString(8,goods.getGenericName());
                statement.setString(9,goods.getName());
                statement.setInt(10,goods.getGoodsAttribute());
                statement.setInt(11,goods.getPrescriptionDrug());
                statement.setInt(12,goods.getOtcType());
                statement.setInt(13,goods.getForceRegisterFlag());
                statement.setInt(14,goods.getCosmetics());
                statement.setString(15,goods.getPinyinCode());
                statement.setString(16,goods.getMphCode());
                statement.setString(17,goods.getOldCode());
                statement.setString(18,goods.getNationalStandardCode());
                statement.setLong(19,goods.getDosageId());
                statement.setString(20,goods.getDosageName());
                statement.setString(21,goods.getSpecification());
                statement.setLong(22,goods.getUnitId());
                statement.setString(23,goods.getUnitName());
                statement.setInt(24,goods.getDomesticImport());
                statement.setLong(25,goods.getManufacturerId());
                statement.setString(26,goods.getManufacturer());
                statement.setString(27,goods.getPlace());
                statement.setString(28,goods.getApprovalNumber());
                statement.setString(29, DateUtils.DateToString(goods.getValidUntil(),DateStyle.YYYY_MM_DD));
                statement.setLong(30,goods.getManagementScopeId());
                statement.setString(31,goods.getManagementScopeName());
                statement.setLong(32,goods.getCheckTypeId());
                statement.setString(33,goods.getCheckTypeName());
                statement.setInt(34,goods.getQualityPeriod());
                statement.setInt(35,goods.getQualityPeriodUnit());
                statement.setInt(36,goods.getSpecialDrug());
                statement.setInt(37,goods.getSpiritDrugType());
                statement.setInt(38,goods.getInChargeDrug());
                statement.setBigDecimal(39,goods.getLimitQuantity());
                statement.setInt(40,goods.getStorageTemp());
                statement.setString(41,goods.getStorageConditionName());
                statement.setString(42,goods.getRegisteredTrademark());
                statement.setString(43,goods.getBrand());
                statement.setString(44,goods.getSeason());
                statement.setString(45,goods.getGrade());
                statement.setInt(46,goods.getMedicalInsurance());
                statement.setInt(47,goods.getMedicalInsuranceType());
                statement.setString(48,goods.getMedicalInsuranceCode());
                statement.setInt(49,goods.getFirst());
                statement.setString(50,goods.getFirstGoodsCode());
                statement.setLong(51,1l);
                statement.setString(52,"sds");
                statement.setString(53,"ssdssds");
                statement.setString(54,DateUtils.DateToString(goods.getApplicationTime(),DateStyle.YYYY_MM_DD));
                statement.setString(55,goods.getApplicationOpinion());
                statement.setInt(56,22);
                statement.setInt(57,22);
                statement.setInt(58,22);
                statement.setInt(59,222);
                statement.setInt(60,goods.getValidFlag());
                statement.setInt(61,2);
                statement.setString(62,goods.getPictureIds());
                statement.setString(63,goods.getRemark());
                statement.setLong(64,goods.getCreaterId());
                statement.setString(65,goods.getCreaterCode());
                statement.setString(66,goods.getCreaterName());
                statement.setString(67,DateUtils.DateToString(goods.getCreateTime(),DateStyle.YYYY_MM_DD));
                statement.setLong(68,goods.getModifierId());
                statement.setString(69,goods.getModifierCode());
                statement.setString(70,goods.getModifierName());
                statement.setString(71,DateUtils.DateToString(goods.getCreateTime(),DateStyle.YYYY_MM_DD));

                statement.addBatch();
                num++;
                if(num !=0 && num%1000 == 0){
                    statement.executeBatch();
                    connection.commit();
                    num = 0;
                }
            }
            statement.executeBatch();
            connection.commit();
        }catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        }finally {
            if(connection != null){
                connection.close();
            }
            long endTime=System.currentTimeMillis();
            System.out.println("方法执行时间："+(endTime-time)+"ms");
        }

    }

    public static Connection getConn(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://192.168.20.3:3306/feijiayun_chain_dev?useUnicode=true&characterEncoding=UTF8&autoReconnect=true&allowMultiQueries=true&zeroDateTimeBehavior=convertToNull"; //DMEO为数据库名
        String user = "root";
        String password = "devMysql&123";
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Goods> getDataList(int f){
        List<Goods> data = new ArrayList<>();
        for (int i =0;i<f;i++){
            Goods goods = new Goods();
            goods.setCode("test10w2"+i);
            goods.setName("testjdbcbatch导入" + i);
            goods.setGenericName("testjdbcbatch导入" + i);
            goods.setApprovalNumber("申请批号" + i);
            goods.setBarcode("条形码" + i);
            goods.setBusinessVariety(1);
            goods.setChainType(0);
            goods.setCheckTypeId(0l);
            goods.setCheckTypeName("验收项目");
            goods.setBrand("品牌");
            goods.setCategoryId(1l);
            goods.setCosmetics(1);
            goods.setDomesticImport(0);
            goods.setDosageId(0l);
            goods.setDosageName("dd");
            goods.setApplicationTime(new Date());
            goods.setApplicationOpinion("申请意见");
            goods.setEnterpriseId(61l);
            goods.setPinyinCode("dddddd" + i);
            goods.setOwnerId(61l);
            goods.setLimitQuantity(BigDecimal.ONE);
            goods.setFirstGoodsCode("dd");
            goods.setDistrFlag(1);
            goods.setInChargeDrug(2);
            goods.setCreaterId(1l);
            goods.setCreaterCode("333");
            goods.setCreaterName("dfdadf");
            goods.setCreateTime(new Date());
            goods.setModifierCode("dddd");
            goods.setModifierId(2l);
            goods.setModifierName("ddddd");
            goods.setFormulationType(1);
            goods.setValidFlag(1);
            goods.setOldCode("ddddfdd3");
            goods.setGoodsAttribute(1);
            goods.setPrescriptionDrug(1);
            goods.setOtcType(1);
            goods.setForceRegisterFlag(1);
            goods.setUnitId(0l);
            goods.setUnitName("dddd");
            goods.setManufacturerId(0l);
            goods.setManufacturer("ddfdff");
            goods.setManagementScopeId(0l);
            goods.setManagementScopeName("ddfdffaf");
            goods.setQualityPeriod(2);
            goods.setQualityPeriodUnit(1);
            goods.setSpecialDrug(1);
            goods.setSpiritDrugType(1);
            goods.setStorageTemp(1);

            goods.setMedicalInsurance(1);
            goods.setMedicalInsuranceType(1);
            goods.setFirst(1);
            goods.setFirstGoodsCode("2222");
            data.add(goods);
        }
        return data;
    }


}

