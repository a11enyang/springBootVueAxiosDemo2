package com.example.demo.controller.earthquake;

import com.example.demo.model.earhtquake.EarthquakeEntity;
import com.example.demo.service.earthquake.EarthquakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/earthquake")
public class EarthquakeRestController {
    @Autowired
    private EarthquakeService earthquakeService;

    /**
     * 获取地震清单列表
     * @return
     */
    @GetMapping("/list")
    public List<EarthquakeEntity> getAll() {

        return earthquakeService.findAll();
    }

    /**
     * 上传一个一条新的信息
     * @param earthquakeEntity
     * @return
     */
    @PostMapping("/newOne")
    public Boolean saveOne(@RequestBody EarthquakeEntity earthquakeEntity) {
        earthquakeService.saveOne(earthquakeEntity);
        return true;
    }

    /**
     * 根据id来查询信息
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    public EarthquakeEntity findOne(@PathVariable int id) {
        return earthquakeService.findById(id);
    }


    /**
     * 更新一条数据，记得要将id设置为参数
     * @param id
     * @param date
     * @param location
     * @param note
     * @param picture
     * @param reportingUnit
     * @param type
     * @param status
     * @return
     */
    @PutMapping("/list")
    public EarthquakeEntity update(@RequestParam int id, @RequestParam String date, @RequestParam String location,
                                   @RequestParam String note, @RequestParam String picture, @RequestParam String reportingUnit,
                                   @RequestParam char type, @RequestParam char status) {
        EarthquakeEntity earthquakeEntity  = new EarthquakeEntity();
        earthquakeEntity.setId(id);
        earthquakeEntity.setDate(date);
        earthquakeEntity.setLocation(location);
        earthquakeEntity.setNote(note);
        earthquakeEntity.setPicture(picture);
        earthquakeEntity.setReportingUnit(reportingUnit);
        earthquakeEntity.setType(type);
        earthquakeEntity.setStatus(status);
        return earthquakeService.saveOne(earthquakeEntity);
    }

    /**
     * 删除一个记录
     * @param id
     */
    @PostMapping("/list/{id}")
    public void delete(@PathVariable int id) {
        earthquakeService.deleteOne(id);
    }

    /**
     * 根据地点查询相关信息
     * @param location
     * @return
     */
    @PostMapping("/list/by")
    public List<EarthquakeEntity> findByLocation(@RequestParam String location) {
        return earthquakeService.findByLocation(location);
    }

    @PostMapping("/list/byNote")
    public List<EarthquakeEntity> findByNoteContains(@RequestParam String note) {
        return earthquakeService.findByNoteContains(note);
    }

    @PostMapping("/list/byLen")
    public List<EarthquakeEntity> findByJPQL(@RequestParam int len) {
        return earthquakeService.findByJPQl(len);
    }

    @PostMapping("/list/update")
    public EarthquakeEntity update(@RequestParam String note, @RequestParam int id) {
        earthquakeService.updateByJPQL(note, id);
        return findOne(id);
    }
}
