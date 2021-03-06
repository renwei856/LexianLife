package com.cqjtu.lexian.service;

import com.cqjtu.lexian.domain.*;
import com.cqjtu.lexian.exception.CustomerServiceException;

import java.util.Date;
import java.util.List;

/**
 * CustomerService 用户业务
 *
 * @author suwen
 */
public interface CustomerService {
  /**
   * 通过用户名获取用户
   *
   * @param username 用户名
   * @return 用户信息
   */
  Customer getCustomerByUsername(String username);
  /**
   * 用户注册
   *
   * @param customer 注册用户信息
   * @throws CustomerServiceException errorCode=0该邮箱已被注册,errorCode=1数据持久化错误
   */
  void register(Customer customer) throws CustomerServiceException;

  /**
   * 用户登录
   *
   * @param customer 用户登录信息
   * @return 持久化用户信息
   * @throws CustomerServiceException CustomerServiceException
   *     errorCode=0用户名不存在,errorCode=1密码错误,errorCode=2数据持久层访问错误
   */
  Customer login(Customer customer) throws CustomerServiceException;

  /**
   * 将顾客的密码发送至顾客的邮箱
   *
   * @param customer 顾客信息
   */
  void sendPasswordToEmail(Customer customer);
  /**
   * 用户信息修改
   *
   * @param customer 更新的用户信息
   * @throws CustomerServiceException errorCode=0用户不存在,errorCode=1数据持久化失败
   */
  void updateCustomer(Customer customer) throws CustomerServiceException;

  /**
   * 发送修改顾客密码验证邮件
   *
   * @param customer 顾客信息
   * @return 生成的验证码
   * @throws CustomerServiceException errorCode=0邮件不存在,errorCode=1发送邮件失败
   */
  String sendUpdatePswEmail(Customer customer) throws CustomerServiceException;

  /**
   * 发送修改顾客密码验证邮件
   *
   * @param customer 顾客信息
   * @return 生成的验证码
   * @throws CustomerServiceException errorCode=0邮件不存在,errorCode=1发送邮件失败
   */
  String sendUpdateEmailEmail(Customer customer) throws CustomerServiceException;

  /**
   * 获取顾客的收货人地址
   *
   * @param customer 顾客信息
   * @return 收货人地址列表
   * @throws CustomerServiceException errorCode=0数据访问错误
   */
  List<RecAddr> listRecAddr(Customer customer) throws CustomerServiceException;

  /**
   * 添加收货人地址
   *
   * @param recAddr 收货人地址信息
   * @throws CustomerServiceException errorCode=0顾客还未登录,errorCode=1数据持久化异常
   */
  void addRecAddress(RecAddr recAddr) throws CustomerServiceException;
  /**
   * 更新收货人信息
   *
   * @param recAddr 收货人地址信息
   * @throws CustomerServiceException errorCode=0数据持久化异常
   */
  void updateRecAddr(RecAddr recAddr) throws CustomerServiceException;
  /**
   * 删除收货人地址
   *
   * @param recAddr 收货人地址信息
   * @throws CustomerServiceException errorCode=0数据访问错误
   */
  void delRecAddr(RecAddr recAddr) throws CustomerServiceException;

  /**
   * 分页获取顾客关注
   *
   * @param pageIndex 分页数
   * @return 分页顾客关注
   */
  List<Attention> getAttentions(Customer customer, int pageIndex);

  /**
   * 顾客浏览商品
   *
   * @param customer 顾客信息
   * @param goods 商品信息
   */
  void browseGoods(Customer customer, Goods goods, Date time);

  /**
   * 评论商品
   *
   * @param comment 评论信息
   */
  void commentGoods(Comment comment);
  /**
   * 分布查询用户的浏览记录
   *
   * @param pageIndex 分页数
   * @param customer 顾客信息
   * @return 浏览记录列表
   */
  List<BrowseRecord> getBrowserRecords(int pageIndex, Customer customer);

  /**
   * 获取所有顾客信息
   *
   * @return 顾客信息列表
   */
  List<Customer> getAllCustomers();

  /**
   * 根据顾客编号获取顾客信息
   *
   * @param id 顾客编号
   * @return 顾客信息
   */
  Customer getCustomer(int id);

  /**
   * 根据顾客编号删除顾客信息
   *
   * @param id 顾客编号
   */
  void deleteCustomer(int id);

  /**
   * 根据顾客编号获取浏览记录
   *
   * @param id 顾客编号
   * @return 浏览记录列表
   */
  List<BrowseRecord> getBrowserRecordsByCustomerId(int id);
}
