package com.example.demo.service.earthquake;

import com.example.demo.model.earhtquake.EarthquakeEntity;
import com.example.demo.model.earhtquake.EarthquakeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EarthquakeService {
    @Autowired
    private EarthquakeRespository earthquakeRespository;//自动注入对象到类中

    /**
     * 查询所有的书单列表
     * @return List列表
     */
    public List<EarthquakeEntity> findAll() {
        return earthquakeRespository.findAll();
    }

    /**
     * 保存一个上传数据
     * @param earthquakeEntity
     * @return
     */
    public EarthquakeEntity saveOne(EarthquakeEntity earthquakeEntity){
        return earthquakeRespository.save(earthquakeEntity);
    }

    /**
     * 根据id来查询一条记录
     * @param id
     * @return
     */
    public EarthquakeEntity findById(int id) {
        return earthquakeRespository.findById(id);
    }

    /**
     * 删除一个记录
     * @param id
     */
    public void deleteOne(int id) {
        earthquakeRespository.deleteById(id);
    }

    /**
     * 根据地点查询相关信息
     * @param location
     * @return
     */
    public List<EarthquakeEntity> findByLocation(String location) {
        return earthquakeRespository.findByLocation(location);
    }

    public List<EarthquakeEntity> findByNoteContains(String note) {
        return earthquakeRespository.findByNoteContains(note);
    }

    /**
     * 自定义查询
     * @param len
     * @return
     */
    public List<EarthquakeEntity> findByJPQl(int len) {
        return earthquakeRespository.findByJPQL(len);
    }

    /**
     * 自定义更新
     * @param
     *
     */

    @Transactional
    public int updateByJPQL(String note, int id) {
        return earthquakeRespository.updateByJPQL(note, id);
    }
}
