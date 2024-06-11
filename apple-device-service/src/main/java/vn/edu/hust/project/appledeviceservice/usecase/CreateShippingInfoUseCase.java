package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateShippingInfoRequest;
import vn.edu.hust.project.appledeviceservice.exception.CreateShippingInfoException;
import vn.edu.hust.project.appledeviceservice.mapper.ShippingInfoResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IDistrictPort;
import vn.edu.hust.project.appledeviceservice.port.IProvincePort;
import vn.edu.hust.project.appledeviceservice.port.IShippingInfoPort;
import vn.edu.hust.project.appledeviceservice.port.IWardPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateShippingInfoUseCase {
    private final IShippingInfoPort shippingInfoPort;

    private final IProvincePort provincePort;

    private final IDistrictPort districtPort;

    private final IWardPort wardPort;

    public ShippingInfoEntity createShippingInfo(CreateShippingInfoRequest request){
        if(request.getProvince() == null || request.getDistrict() == null || request.getWard() == null){
            log.error("[CreateShippingInfoUseCase] province, district, ward must be not null");
            throw new CreateShippingInfoException();
        }
        var shippingInfo = ShippingInfoResourceMapper.INSTANCE.toEntityFromRequest(request);

        var province = provincePort.getProvinceByCode(request.getProvince().getCode());
        if (province == null){
            province = provincePort.save(ShippingInfoResourceMapper.INSTANCE.toEntityFromRequest(request.getProvince()));
        }
        shippingInfo.setProvince(province);

        var district = districtPort.getDistrictByCode(request.getDistrict().getCode());
        if (district == null){
            district = districtPort.save(ShippingInfoResourceMapper.INSTANCE.toEntityFromRequest(request.getDistrict()));
        }
        shippingInfo.setDistrict(district);

        var ward = wardPort.getWardByCode(request.getWard().getCode());
        if (ward == null){
            ward = wardPort.save(ShippingInfoResourceMapper.INSTANCE.toEntityFromRequest(request.getWard()));
        }
        shippingInfo.setWard(ward);


        shippingInfo = shippingInfoPort.save(shippingInfo);
        shippingInfo.setProvinceCode(province.getCode());
        shippingInfo.setDistrictCode(district.getCode());
        shippingInfo.setWardCode(ward.getCode());

        return shippingInfo;
    }



}
