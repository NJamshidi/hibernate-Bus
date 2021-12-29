package ir.jamshidi.dto;

import ir.jamshidi.enums.BusType;
import ir.jamshidi.model.BaseModel;

import java.sql.Date;

public class BusScheduleSearchDTO extends BaseModel {
    private Date date;
    private Long fromPrice;
    private Long toPrice;
    private String companyName;
    private BusType busType;
    private String startPoint;
    private String destination;
    private Integer pageSize;
    private Integer offset;

    public BusScheduleSearchDTO() {
    }

    public BusScheduleSearchDTO(String startPoint, String destination, Integer pageSize) {
        this.startPoint = startPoint;
        this.destination = destination;
        this.pageSize = pageSize;
    }

    public BusScheduleSearchDTO(Date date, Long fromPrice, Long toPrice, String companyName, BusType busType, String startPoint, String destination, Integer pageSize, Integer offset) {
        this.date = date;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.companyName = companyName;
        this.busType = busType;
        this.startPoint = startPoint;
        this.destination = destination;
        this.pageSize = pageSize;
        this.offset = offset;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getFromPrice() {
        return fromPrice;
    }

    public void setFromPrice(Long fromPrice) {
        this.fromPrice = fromPrice;
    }

    public Long getToPrice() {
        return toPrice;
    }

    public void setToPrice(Long toPrice) {
        this.toPrice = toPrice;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public BusType getBusType() {
        return busType;
    }

    public void setBusType(BusType busType) {
        this.busType = busType;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
