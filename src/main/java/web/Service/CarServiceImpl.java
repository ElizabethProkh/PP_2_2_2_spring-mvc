package web.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Dao.CarDao;
import web.Model.Car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;


    @Override
    public List<Car> getCars(Integer count) {
        List<Car> carList = carDao.getAllCars();
        if (carList == null || carList.isEmpty())
            return Collections.emptyList();
        if (count == null) {
            return carList;
        }
        if (count <= 0){
            return Collections.emptyList();
        }
        return carList.stream().limit(count).collect(Collectors.toList());

    }
}
