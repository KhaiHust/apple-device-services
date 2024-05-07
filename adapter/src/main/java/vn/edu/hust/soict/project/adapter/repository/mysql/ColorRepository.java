package vn.edu.hust.soict.project.adapter.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.hust.soict.project.adapter.repository.mysql.model.ColorModel;

@Repository
public interface ColorRepository extends JpaRepository<ColorModel, Long> {
}
