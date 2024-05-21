package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetColorRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IColorPort {
    ColorEntity save(ColorEntity colorEntity);

    Pair<PageInfo, List<ColorEntity>> getAllColors(GetColorRequest filter);
}
