package com.example.demo.model.earhtquake;

import com.example.demo.model.earhtquake.EarthquakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface EarthquakeRespository extends JpaRepository<EarthquakeEntity, Integer> {
    /**
     * 接口中自定义查询方法，根据地点名字查找相关信息
     * @param location
     * @return
     */
    List<EarthquakeEntity> findByLocation(String location);

    List<EarthquakeEntity> findByTypeAndStatus(char type, char status);

    List<EarthquakeEntity> findByNoteContains(String note);

    /**
     * 自定义查询
     * @param len
     * @return
     */
    @Query("select e from EarthquakeEntity e where length(e.location) > ?1 ")
    List<EarthquakeEntity> findByJPQL(int len);

    /**
     * 根据id更新note
     * @param note
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update EarthquakeEntity e set e.note = ?1 where e.id = ?2")
    int updateByJPQL(String note, int id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Query("select e from EarthquakeEntity e where e.id = ?1")
    EarthquakeEntity findById(int id);
}
