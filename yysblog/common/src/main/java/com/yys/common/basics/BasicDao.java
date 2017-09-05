package com.yys.common.basics;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
/**
 * User: 杨永生
 * Date: 10:10 2017/9/4
 * Email: 1095737364@qq.com
 */
@Service
public abstract class BasicDao<T extends Serializable>{
    protected SqlSessionTemplate writeMapper;
    protected SqlSessionTemplate readMapper;

    @Resource(name = "sqlSessionMaster")
    private void setWriteMapper(SqlSessionTemplate sqlSession) {
        this.writeMapper = sqlSession;
    }
    @Resource(name = "sqlSessionSlave")
    private void setReadMapper(SqlSessionTemplate sqlSession) {
        this.readMapper = sqlSession;
    }

    public T selectOne(String statement,T t){
        return readMapper.selectOne(statement,t);
    }

    public <B,V> V selectOne(String statement,B b){
        return readMapper.selectOne(statement,b);
    }

    public List<T> selectList(String statement){
        return readMapper.selectList(statement);
    }

    public List<T> selectList(String statement,String t){
        return readMapper.selectList(statement,t);
    }

    public <B,V>  List<V> selectList(String statement,B b){
        return readMapper.selectList(statement,b);
    }

    public int save(String statement,T t) throws Exception{
        return writeMapper.insert(statement , t);
    }

    public <B> int save(String statement,B b) throws Exception{
        return writeMapper.insert(statement , b);
    }

    public int update(String statement,T t) throws Exception{
        return writeMapper.update(statement , t);
    }

    public <B> int update(String statement,B  b) throws Exception{
        return writeMapper.update(statement , b);
    }

}
